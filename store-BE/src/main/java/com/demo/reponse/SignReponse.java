package com.demo.reponse;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SignReponse {
    private String token;
    private String name;
    private Collection<? extends GrantedAuthority> roles;

    public SignReponse() {
    }

    public SignReponse(String token, String name, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.name = name;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
