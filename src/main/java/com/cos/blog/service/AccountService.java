package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.dto.SendRequestDto;
import com.cos.blog.dto.WithDrawRequestDto;
import com.cos.blog.model.Account;
import com.cos.blog.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	public void 송금(SendRequestDto dto) {
		// 보내는 사람 업데이트(-)
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getSenderAccountNumber());
		홍길동.setMoney(홍길동.getMoney()-dto.getMoney());
		accountRepository.update(홍길동);
		
		// 받는 사람 업데이트(+)
		Account 장보고 = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		장보고.setMoney(장보고.getMoney() + dto.getMoney());
		accountRepository.update(장보고);	
	}
	
	@Transactional
	public void 인출(WithDrawRequestDto dto) {
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getAccountNumber());
		홍길동.setMoney(홍길동.getMoney() - dto.getMoney());
		accountRepository.update(홍길동);
	}
	
	@Transactional(readOnly = true) // 고립성 (데이터의 정합성때문)
	public List<Account> 계좌정보보기() {
		return accountRepository.findAll();
	}
}
