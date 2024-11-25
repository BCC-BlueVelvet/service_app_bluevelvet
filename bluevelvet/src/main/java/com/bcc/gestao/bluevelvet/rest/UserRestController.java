package com.bcc.gestao.bluevelvet.rest;

import com.bcc.gestao.bluevelvet.model.entity.User;
import com.bcc.gestao.bluevelvet.model.vo.UserVO;
import com.bcc.gestao.bluevelvet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> save(@RequestBody UserVO userVO) {
        User user = userService.save(userVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
