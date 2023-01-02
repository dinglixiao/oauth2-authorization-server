package com.bsp.oauth2.authorization.server.service.impl;

import com.bsp.oauth2.authorization.server.mapper.UserPrincipalMapper;
import com.bsp.oauth2.authorization.server.entity.UserAuthority;
import com.bsp.oauth2.authorization.server.entity.UserPrincipal;
import com.bsp.oauth2.authorization.server.service.UserPrincipalService;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserPrincipalServiceImpl implements UserPrincipalService {

    @Autowired
    private UserPrincipalMapper userPrincipalMapper;

    @Override
    @Transactional
    public UserPrincipal loadUserByUsername(String username) {

        UserPrincipal principal = userPrincipalMapper.getByUsername(username);

        // make sure the authorities and password are loaded
        // principal.getAuthorities().size();
        // principal.getPassword();

        principal.setAuthorities(Sets.newHashSet(UserAuthority.builder().authority("ADMIN").build(), UserAuthority.builder().authority("USER").build()));
        return principal;
    }

}
