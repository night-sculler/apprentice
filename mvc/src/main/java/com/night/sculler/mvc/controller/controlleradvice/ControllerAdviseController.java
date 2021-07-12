package com.night.sculler.mvc.controller.controlleradvice;

import com.alibaba.fastjson.JSON;
import com.night.sculler.mvc.controller.SessionContext;
import com.night.sculler.mvc.controller.SessionContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller advise controller
 *
 * @author houlongjie
 * @version 1.0.0
 * @date 2021/7/12
 */
@Controller
public class ControllerAdviseController {

    @ResponseBody
    @RequestMapping(value = "/testSessionContextHolder",method = RequestMethod.POST)
    public String testSessionContextHolder(@RequestBody UserInfo userInfo) {
        SessionContext sessionContext = SessionContextHolder.get();
        return JSON.toJSONString(sessionContext);
    }
}
