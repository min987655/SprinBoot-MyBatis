package com.cos.blog.config.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cos.blog.config.handler.exception.MyRoleException;
import com.cos.blog.config.handler.exception.MySessionException;
import com.cos.blog.model.User;

// 관점 지향 프로그람
// 인증 관리(메모리에 띄울 필요 없음, 내가 new 할거기 때문에)
// 다른곳에서 쓸 일이 없기 때문에 따로 IoC 등록 안하고 뉴해서 사용
public class RoleIntercepter extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute("principal");
		
		// 인증이 안되였을 시 Exception을 던짐
		if (principal==null) {
			System.out.println("RoleIntercepter : 인증이 안됨");
			throw new MySessionException();
		} else { 
			if (!principal.getRole().equals("ROLE_ADMIN")) { // 권한이 없을 시 익셉션 던짐
				System.out.println("RoleIntercepter : 권한이 없음");
				throw new MyRoleException();
			}
		}
		return true;
	}
}
