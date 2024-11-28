package com.bcc.gestao.bluevelvet.service;

import com.bcc.gestao.bluevelvet.exception.RoleNotFoundException;
import com.bcc.gestao.bluevelvet.model.entity.Role;
import com.bcc.gestao.bluevelvet.model.entity.User;
import com.bcc.gestao.bluevelvet.model.vo.UserVO;
import com.bcc.gestao.bluevelvet.repository.RoleRepository;
import com.bcc.gestao.bluevelvet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
}
