package com.bcc.gestao.bluevelvet.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class CredentialVO {

    private String email;

    private String password;
}
