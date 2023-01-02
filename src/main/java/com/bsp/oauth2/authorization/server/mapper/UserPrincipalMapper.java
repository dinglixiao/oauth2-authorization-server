package com.bsp.oauth2.authorization.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bsp.oauth2.authorization.server.entity.UserPrincipal;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrincipalMapper extends BaseMapper<UserPrincipal> {

    @Select("select * from user_principal where username=#{username}")
    UserPrincipal getByUsername(String username);
}
