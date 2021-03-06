package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	// / 로 들어오면 무조건 posts로 리다이렉션 됨
	@GetMapping({"","/"})
	public String index() {
		return "redirect:/posts";
	}
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/"; // redirect 걸면 밖으로 한번 빠져나와서 다시 요청(주소요청으로 변경됨)
	}
}
