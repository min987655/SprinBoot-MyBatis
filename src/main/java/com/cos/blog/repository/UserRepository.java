package com.cos.blog.repository;

import com.cos.blog.model.User;

// 인터페이스로 생성하는 이유 : 매퍼가 임시로 오브젝트로 만들어 메모리에 띄워주기 때문에. 
public interface UserRepository {
	public void save(User user);
}
