package com.las.lasbackenduser.controller;

import com.las.lasbackenduser.model.User;
import com.las.lasbackenduser.service.api.impl.GetLoginStateServiceImpl;
import com.las.lasbackenduser.service.api.impl.GetUserLoginCatchValueImpl;
import com.las.lasbackenduser.service.db.impl.UserServiceImpl;
import com.las.lasbackenduser.utils.ip.GetIp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * api控制器
 * @author sunyinuo
 */
@RestController
@RequestMapping("/usersignin/api")
@Component
@Slf4j
public class ApiController {

    private final GetLoginStateServiceImpl getLoginStateService;
    private final GetUserLoginCatchValueImpl getUserLoginCatchValue;
    private final UserServiceImpl userService;
    private final RedisTemplate<Object, Object> redisTemplate;

    public ApiController(GetLoginStateServiceImpl getLoginStateService, GetUserLoginCatchValueImpl getUserLoginCatchValue, UserServiceImpl userService, RedisTemplate<Object, Object> redisTemplate) {
        this.getLoginStateService = getLoginStateService;
        this.getUserLoginCatchValue = getUserLoginCatchValue;
        this.userService = userService;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/getLoginState")
    public boolean getLoginState(HttpServletRequest request) {
        String ip = GetIp.getIpAddress(request);
        log.info("ip:{}", ip);
        return getLoginStateService.getLoginState(ip);
    }

    @PostMapping("service/getUserLoginCatchValue/")
    public String getUserLoginCatchValue(String ip) {
        return getUserLoginCatchValue.getUserLoginCatchValue(ip);
    }

    @PostMapping("service/deleteUserByName")
    public Integer deleteUserByName(String name) {
        return userService.deleteUserByName(name);
    }

    @PostMapping("service/deleteLoginCacheByIp")
    public Boolean deleteLoginCacheByIp(String key) {
        return redisTemplate.delete(key);
    }

    @PostMapping("service/updateUserDataBaseUserName")
    public Integer updateUserDataBaseUserName(String userName,String newUserName){
        User user = userService.getUserByName(userName);
        user.setUserName(newUserName);
        return userService.update(user);
    }

    @PostMapping("service/updateUserDataBaseUserSignature")
    public Integer updateUserDataBaseUserSignature(String userName,String newUserSignature){
        User user = userService.getUserByName(userName);
        user.setUserSignature(newUserSignature);
        return userService.update(user);
    }
}

