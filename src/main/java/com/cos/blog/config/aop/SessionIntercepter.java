package com.cos.blog.config.aop;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cos.blog.model.User;

// 인증 관리(메모리에 띄울 필요 없음, 내가 new 할거기 때문에)
// 다른곳에서 쓸 일이 없기 때문에 따로 IoC 등록 안하고 뉴해서 사용
public class SessionIntercepter extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute("principal");
		if (principal ==null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인이 필요합니다.');");
			out.print("location.href='/auth/loginForm';");
			out.print("</script>");
			return false; // true 되면 응답을 두번하기 때문에 오류 남 // 더이상 진입 안됨 바로 response 됨.
		}
		return true;
	}
}
