package com.bcc.gestao.bluevelvet.rest;

import com.bcc.gestao.bluevelvet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bcc.gestao.bluevelvet.model.vo.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserVO> save(@RequestBody UserVO userVO) {
        UserVO dbUserVO = userService.save(userVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dbUserVO);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserVO> updateUser(@PathVariable int id, @RequestBody UserVO userVO) {
        UserVO updatedUser = userService.update(id, userVO);
        return ResponseEntity.ok(updatedUser);
    }
  
    @GetMapping("/users")
    public ResponseEntity<List<UserVO>> findAll() {
        List<UserVO> dbUserVO = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dbUserVO);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserVO> findById(@PathVariable int id) {
        UserVO dbUserVO = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dbUserVO);
    }
  
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
