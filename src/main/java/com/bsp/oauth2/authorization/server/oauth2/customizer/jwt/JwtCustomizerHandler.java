package com.bsp.oauth2.authorization.server.oauth2.customizer.jwt;

import com.bsp.oauth2.authorization.server.oauth2.customizer.jwt.impl.DefaultJwtCustomizerHandler;
import com.bsp.oauth2.authorization.server.oauth2.customizer.jwt.impl.OAuth2AuthenticationTokenJwtCustomizerHandler;
import com.bsp.oauth2.authorization.server.oauth2.customizer.jwt.impl.UsernamePasswordAuthenticationTokenJwtCustomizerHandler;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;

public interface JwtCustomizerHandler {

    void customize(JwtEncodingContext jwtEncodingContext);

    static JwtCustomizerHandler getJwtCustomizerHandler() {

        JwtCustomizerHandler defaultJwtCustomizerHandler = new DefaultJwtCustomizerHandler();
        JwtCustomizerHandler oauth2AuthenticationTokenJwtCustomizerHandler = new OAuth2AuthenticationTokenJwtCustomizerHandler(defaultJwtCustomizerHandler);
        JwtCustomizerHandler usernamePasswordAuthenticationTokenJwtCustomizerHandler = new UsernamePasswordAuthenticationTokenJwtCustomizerHandler(oauth2AuthenticationTokenJwtCustomizerHandler);
        return usernamePasswordAuthenticationTokenJwtCustomizerHandler;


    }

}
