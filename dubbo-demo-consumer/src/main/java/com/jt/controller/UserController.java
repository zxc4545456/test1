package com.jt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jt.Servcie.UserService;
import com.jt.pojo.User;

@RestController
public class UserController {
	//check = false消费者在启动时先查询有没有提供者，如果么有提供者，暂时忽略
	@Reference(timeout = 3000,check = false)//此处装配使用ali的框架
	UserService userservice;
	
	@RequestMapping("/findAll")
	private List<User> findAll(){
		return userservice.findAll();
	}
	//springmvc规定，如果前端传参，后端接收参数为杜希昂，则restful风格可以直接接收赋值
	//如果是string类型，那必须单个接收@pathValible
	@RequestMapping("/saveUser/{name}/{age}/{sex}")
	public String saveUser(User user) {
		return userservice.saveUser(user);
	}

}
