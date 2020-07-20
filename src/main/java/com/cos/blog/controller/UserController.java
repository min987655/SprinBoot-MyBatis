package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.model.User;

@Controller
public class UserController {

//	응답을 데이터로 하기 위해서 @ResponseBody 작성
//	User user로는 키=밸뉴 만 받기 때문에(스프링 기본 전략은 form으로 데이터 주고받음) @RequestBody 붙여서 오브젝트 받음  
	@PostMapping("/auth/joinProc")
	public @ResponseBody User joinProc(@RequestBody User user) {
		return user;
	}
}
