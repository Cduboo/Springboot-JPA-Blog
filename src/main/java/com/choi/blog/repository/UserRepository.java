package com.choi.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.choi.blog.model.User;

// 자동으로 bean에 등록된다.
// @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
