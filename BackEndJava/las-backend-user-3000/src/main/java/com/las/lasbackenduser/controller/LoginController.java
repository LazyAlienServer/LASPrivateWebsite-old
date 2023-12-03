package com.las.lasbackenduser.controller;

import com.alibaba.fastjson.JSONObject;
import com.las.lasbackenduser.service.impl.LoginServiceImpl;
import com.las.lasbackenduser.utils.ip.GetIp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆/注册控制器
 * @author sunyinuo
 */
@RestController
@RequestMapping("/usersignin/")
@Component
@Slf4j
public class LoginController {

    private final LoginServiceImpl loginService;

    public LoginController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    /**
     * 登陆方法
     * @param jsonParam 前端参数
     * @return code
     */
    @PostMapping("/login")
    public Result login(@RequestBody JSONObject jsonParam, HttpServletRequest request){
        String userName = (String) jsonParam.get("username");
        String userPassword = (String) jsonParam.get("password");
        String ip = GetIp.getIpAddress(request);
        log.info("ip:{}", ip);

        return loginService.login(userName,userPassword,ip);
    }
}
