package com.bsp.oauth2.authorization.server.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class UserPrincipal implements UserDetails, CredentialsContainer, Cloneable {

    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;

    private String username;

    private String password;

    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonLocked = true;

    private Set<UserAuthority> authorities = new HashSet<>();

    @Override
    public void eraseCredentials() {

    }
}
