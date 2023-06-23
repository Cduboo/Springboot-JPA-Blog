package com.choi.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choi.blog.model.RoleType;
import com.choi.blog.model.User;
import com.choi.blog.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public User joinProc(User user) {
		if(!userRepository.findByEmail(user.getEmail()).isEmpty()) return null;
		
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		
		return userRepository.save(user);
	}

	@Transactional
	public void update(User requestUser) {
		User user = userRepository.findById(requestUser.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("회원 찾기 실패");
		});
		
		String rawPassword = requestUser.getPassword();
		String encPassword = encoder.encode(rawPassword);
		
		user.setPassword(encPassword);
		user.setEmail(requestUser.getEmail());
	}

}
