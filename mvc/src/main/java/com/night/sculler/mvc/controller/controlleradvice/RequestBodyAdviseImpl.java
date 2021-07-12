package com.night.sculler.mvc.controller.controlleradvice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.night.sculler.mvc.controller.SessionContext;
import com.night.sculler.mvc.controller.SessionContextHolder;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * RequestBodyAdviseImpl
 *
 * @author houlongjie
 * @version 1.0.0
 * @date 2021/7/12
 */
@ControllerAdvice("com.night.sculler.mvc.controller")
public class RequestBodyAdviseImpl implements RequestBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        Class<?> parameterType = parameter.getParameterType();
        if (parameterType.equals(UserInfo.class)) {
            String result = IOUtils.toString(inputMessage.getBody(), "UTF-8");
            UserInfo userInfo = JSONObject.parseObject(result, UserInfo.class);
            userInfo.setUserMobile("12345678900");
            userInfo.setUserEmail("233334");
            SessionContext sessionContext = new SessionContext();
            sessionContext.setUserId(userInfo.getUserId());
            sessionContext.setUserName(userInfo.getUserName());
            sessionContext.setUserMobile(userInfo.getUserMobile());
            sessionContext.setUserEmail(userInfo.getUserEmail());
            SessionContextHolder.set(sessionContext);

            return new HttpInputMessage() {
                @Override
                public HttpHeaders getHeaders() {
                    return inputMessage.getHeaders();
                }
                @Override
                public InputStream getBody() throws IOException {
                    return IOUtils.toInputStream(JSON.toJSONString(userInfo));
                }
            };
        }
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        parameter.getMember();
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}
