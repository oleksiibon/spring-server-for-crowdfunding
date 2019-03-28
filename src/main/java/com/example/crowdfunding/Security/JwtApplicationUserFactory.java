package com.example.crowdfunding.Security;

import com.example.crowdfunding.Domain.ApplicationUser;
import com.example.crowdfunding.Security.model.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class JwtApplicationUserFactory {

    private JwtApplicationUserFactory() {
    }

    public static JwtApplicationUser create(ApplicationUser user) {
        return new JwtApplicationUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.getEmail()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }

}