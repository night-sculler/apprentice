package com.night.sculler.mvc.controller.controlleradvice;

import lombok.Data;

/**
 * UserInfo
 *
 * @author houlongjie
 * @version 1.0.0
 * @date 2021/7/12
 */
@Data
public class UserInfo {
    /**
     * 用户Id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String userMobile;
    /**
     * 用户邮件
     */
    private String userEmail;
}
