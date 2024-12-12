package com.bcc.gestao.bluevelvet.rest;

import com.bcc.gestao.bluevelvet.model.vo.CredentialVO;
import com.bcc.gestao.bluevelvet.model.vo.UserVO;
import com.bcc.gestao.bluevelvet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/credentials")
public class CredentialRestController {

    private final UserService userService;

    @Autowired
    public CredentialRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserVO userVO) {
        UserVO savedUser = userService.save(userVO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    ResponseEntity<List<String>> login(@RequestBody CredentialVO credentialVO) {
        List<String> roles = userService.login(credentialVO);
        return ResponseEntity.status(HttpStatus.OK).body(roles);
    }
}
