package com.bcc.gestao.bluevelvet.service;

import com.bcc.gestao.bluevelvet.model.entity.User;
import com.bcc.gestao.bluevelvet.model.vo.UserVO;
import com.bcc.gestao.bluevelvet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserVO userVO) {
        userVO.setId(0);
        User user = new User(userVO);
        return userRepository.save(user);
    }
}
