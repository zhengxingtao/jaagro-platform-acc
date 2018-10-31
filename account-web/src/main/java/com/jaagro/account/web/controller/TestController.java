package com.jaagro.account.web.controller;

import com.alibaba.fastjson.JSON;
import com.jaagro.account.api.service.UserClientService;
import com.jaagro.account.biz.service.impl.CurrentUserService;
import com.jaagro.account.web.vo.AccountVo;
import com.jaagro.constant.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tony
 */
@RestController
public class TestController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    UserClientService userClientService;
    @Autowired
    CurrentUserService currentUserService;

    @GetMapping("/test")
    public UserInfo getToken(){
        String token = request.getHeader("token");
        return userClientService.getUserByToken(token);
    }
    @GetMapping("/test2")
    public UserInfo test(){

        AccountVo  vo = new AccountVo();
        return currentUserService.getCurrentUser();
    }
    public static void main (String[] args){
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        System.out.println(JSON.toJSONString(integerList));
    }
}
