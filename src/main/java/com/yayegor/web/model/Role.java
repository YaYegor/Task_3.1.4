package com.yayegor.web.model;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "role_id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return name;
    }

    public void setRoleName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }

    @Override
    public String toString() {
        return getRoleName();
    }
}
