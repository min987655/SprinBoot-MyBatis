package com.cos.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

//	응답을 데이터로 하기 위해서 @ResponseBody 작성
//	User user로는 키=밸뉴 만 받기 때문에(스프링 기본 전략은 form으로 데이터 주고받음) @RequestBody 붙여서 오브젝트 받음  
	@PostMapping("/auth/joinProc")
	public @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user) {
		userService.회원가입(user);
		return new CommonRespDto<String>(1, "회원가입 성공");
	}
	
	@PostMapping("/auth/loginProc")
	public @ResponseBody CommonRespDto<?> loginProc(@RequestBody User user, HttpSession session) {
		User persistUser = userService.로그인(user); // 실제 DB와 동기화된 오브젝트
		
		if(ObjectUtils.isEmpty(persistUser)) {
			return new CommonRespDto<String>(-1, "로그인 실패");
		} else {
			// 세션 확인해야 함
			session.setAttribute("principal", persistUser);
			return new CommonRespDto<String>(1, "로그인 성공");
		}
	}
}
