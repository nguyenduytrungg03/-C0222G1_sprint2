package com.demo.jwt;


import com.demo.model.user.AppUser;
import com.demo.model.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class  CustomUserDetail implements UserDetails {

    private AppUser appUser;

    public CustomUserDetail(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<UserRole> list = appUser.getUserRoles();
        System.out.println(list);
        List<GrantedAuthority>grantedAuthorityList = new ArrayList<>();

        for (UserRole temp: list) {
            GrantedAuthority authority = new SimpleGrantedAuthority(temp.getAppRole().getRoleName());
            grantedAuthorityList.add(authority);
        }
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}