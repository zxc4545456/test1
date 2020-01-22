package com.jt.Servcie;
//定义soa中立接口，完成业务调用

import java.util.List;

import com.jt.pojo.User;

public interface UserService {
	
	List<User> findAll();

	String saveUser(User user);

}
