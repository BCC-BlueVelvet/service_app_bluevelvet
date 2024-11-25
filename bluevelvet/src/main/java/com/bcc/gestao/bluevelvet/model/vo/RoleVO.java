package com.bcc.gestao.bluevelvet.model.vo;

import com.bcc.gestao.bluevelvet.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class RoleVO {

    private int id;

    private String name;

    private String description;

    public RoleVO(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.description = role.getDescription();
    }
}
