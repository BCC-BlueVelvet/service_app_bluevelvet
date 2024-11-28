package com.bcc.gestao.bluevelvet.model.vo;

import com.bcc.gestao.bluevelvet.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    private List<String> roles;

    public UserVO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.enabled = user.isEnabled();
    }

    public void addRoles(String roleName) {
        if(roles == null) {
            roles = new ArrayList<>();
        }
        roles.add(roleName);
    }
}