package com.night.sculler.mvc.controller;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

/**
 * session context
 *
 * @author houlongjie
 * @version 1.0.0
 * @date 2021/7/12
 */
@Data
public class SessionContext {
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

    /**
     * 请求参数
     */
    private HttpServletRequest request;
}
