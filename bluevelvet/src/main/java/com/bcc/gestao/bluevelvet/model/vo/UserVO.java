package com.bcc.gestao.bluevelvet.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UserVO {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private boolean enabled;
}