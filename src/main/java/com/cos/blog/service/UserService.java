package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

// 스프링이 싱글톤으로 메모리에 띄우는 어노테이션들(Controller 외에는 서버 시작시 메모리에 뜸)
// Controller(디스패쳐서블릿이 요청시 띄움) - 뷰리졸브 관여(@ResponseBody 사용하여 데이터 리턴하기), Repository(MyBatis에서 해줘서 생략 가능), Configuration(설정파일에 붙임), Service, Component
// RestController - 데이터만 리턴 함, Bean

@Service // IoC
public class UserService {
	
	@Autowired
	private UserRepository userRepository; // DI

	// 커밋이 필요하기 때문에 트랜잭션 타야 함
	@Transactional
	public void 회원가입(User user){
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true)
	public User 로그인(User user){
		return userRepository.login(user);
	}

}
