package ru.vosmfc.mfcstorage.security.configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.vosmfc.mfcstorage.security.domain.User;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean isActive;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static CustomUserDetails fromUserToCustomUserDetails(User user) {
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.userName = user.getUserName();
        customUserDetails.password = user.getPassword();
        customUserDetails.isActive = user.isActive();
        customUserDetails.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getUserRole().getRoleName()));

        return customUserDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

}
