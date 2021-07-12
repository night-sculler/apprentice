package com.night.sculler.shiro.chapter2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author night-sculler
 * @version 1.0.0.release
 * @date 2021/7/4
 */
public class LoginLogoutTest {
    @Test
    public void testHellWorld() {
        IniSecurityManagerFactory securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = securityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang", "234");
        try {
            subject.login(usernamePasswordToken);
            System.out.println("认证成功");
        } catch (AuthenticationException e) {
            System.out.println("认证失败");
        }

        boolean authenticated = subject.isAuthenticated();
        Assert.assertTrue(authenticated);

        subject.logout();
    }
}
