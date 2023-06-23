package com.choi.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.choi.blog.model.User;

// 자동으로 bean에 등록된다.
// @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {
	
	// SELECT * FROM user WHERE username = 1?;
	Optional<User> findByEmail(String email);
}
