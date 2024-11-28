package com.bcc.gestao.bluevelvet.service;

import com.bcc.gestao.bluevelvet.exception.UserNotFoundException;
import com.bcc.gestao.bluevelvet.model.entity.User;
import com.bcc.gestao.bluevelvet.exception.RoleNotFoundException;
import com.bcc.gestao.bluevelvet.model.entity.Role;
import com.bcc.gestao.bluevelvet.model.vo.UserVO;
import com.bcc.gestao.bluevelvet.repository.RoleRepository;
import com.bcc.gestao.bluevelvet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
  
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserVO update(int id, UserVO userVO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        user.setFirstName(userVO.getFirstName());
        user.setLastName(userVO.getLastName());
        user.setEmail(userVO.getEmail());
        user.setPassword(userVO.getPassword());
        user.setEnabled(userVO.isEnabled());

        user.getRoles().clear();
        for (String roleName : userVO.getRoles()) {
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RoleNotFoundException("Role not exists."));
            user.addRoles(role);
        }

        User updatedUser = userRepository.save(user);

        UserVO updatedUserVO = new UserVO(updatedUser);
        updatedUser.getRoles().forEach(role -> updatedUserVO.addRoles(role.getName()));

        return updatedUserVO;
    }

    public UserVO save(UserVO userVO) {
        userVO.setId(0);
        User user = new User(userVO);
        for(String roleName : userVO.getRoles()) {
            Optional<Role> optionalRole = roleRepository.findByName(roleName);
            if(optionalRole.isEmpty()) {
                throw new RoleNotFoundException("Role not exists.");
            }
            user.addRoles(optionalRole.get());
        }
        User dbUser = userRepository.save(user);
        UserVO dbUserVO = new UserVO(dbUser);
        for(Role dbRole : dbUser.getRoles()) {
            dbUserVO.addRoles(dbRole.getName());
        }
        return dbUserVO;
    }

    public List<UserVO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserVO> dbUsersVO = new ArrayList<>();
        for(User user : users) {
            List<Role> roles = user.getRoles();
            List<String> rolesName = roles.stream()
                    .map(Role::getName)
                    .collect(Collectors.toList());
            UserVO dbUserVO = new UserVO(user);
            for(String roleName : rolesName) {
                dbUserVO.addRoles(roleName);
            }
            dbUsersVO.add(dbUserVO);
        }
        return dbUsersVO;
    }

    public UserVO findById(int id) {
        Optional<User> dbUser = userRepository.findById(id);
        if(dbUser.isEmpty()) {
            throw new UserNotFoundException("User not exists.");
        }
        UserVO dbUserVO = new UserVO(dbUser.get());
        for (Role role : dbUser.get().getRoles()) {
            dbUserVO.addRoles(role.getName());
        }
        return dbUserVO;
    }
  
    public void delete(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found.");
        }
        userRepository.deleteById(id);
    }
}
