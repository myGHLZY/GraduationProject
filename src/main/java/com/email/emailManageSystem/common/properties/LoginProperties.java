package com.email.emailManageSystem.common.properties;

import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author userlzy
 * @version 1.0
 * @description: TODO
 * @date 2025/3/22 14:28
 */

@Component
@ConfigurationProperties(prefix = "email.login")
@Data
public class LoginProperties {

    private String adminAuth;
    private String userAuth;

    private Integer userExpire;
    private Integer adminExpire;

}