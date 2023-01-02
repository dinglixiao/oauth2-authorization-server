package com.bsp.oauth2.authorization.server.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * The UserAuthority class is simple: It's just an embeddable POJO that implements GrantedAuthority.
 */
@Data
@Builder
public class UserAuthority implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String authority;
}
