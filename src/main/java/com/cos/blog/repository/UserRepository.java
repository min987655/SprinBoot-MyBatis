package com.cos.blog.repository;

import com.cos.blog.model.User;

// 인터페이스로 생성하는 이유 : 매퍼가 임시로 오브젝트로 만들어 메모리에 띄워주기 때문에.
// 인터페이스는 오브젝트를 가지고 있을 수 없음. 스프링 내부적으로 오브젝트를 구현하고 있음
public interface UserRepository {
	public void save(User user);
	public User login(User user);
}
