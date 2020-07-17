package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.model.Account;

// CRUD 필요한것만 두고, 조합한게 service임.
public interface AccountRepository {

	public void update(Account account); 
	public List<Account> findAll(); 
	public Account findByAccountNumber(String accountNumber);
}
