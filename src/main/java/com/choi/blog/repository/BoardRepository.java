package com.choi.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choi.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	
}
