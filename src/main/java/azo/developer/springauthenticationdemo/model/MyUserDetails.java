package azo.developer.springauthenticationdemo.model;

import azo.developer.springauthenticationdemo.entity.AuthoritiesEntity;
import azo.developer.springauthenticationdemo.entity.UsersEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private UsersEntity usersEntity;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    public MyUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grants = new ArrayList<>();
        List<AuthoritiesEntity> authorities = usersEntity.getAuthorities();

        for(AuthoritiesEntity authority : authorities) {
            grants.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return grants;
    }

    @Override
    public String getPassword() {
        return usersEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return usersEntity.getUsername();
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
        return usersEntity.getEnabled() == 1;
    }
}
