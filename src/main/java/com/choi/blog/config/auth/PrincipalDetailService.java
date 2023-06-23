package com.choi.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.choi.blog.model.User;
import com.choi.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User principal = userRepository.findByEmail(email).orElseThrow(() -> {
			return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : " + email);
		});
		return new PrincipalDetail(principal); // 시큐리티 세션에 유저 정보 저장됨
	}
	
}
