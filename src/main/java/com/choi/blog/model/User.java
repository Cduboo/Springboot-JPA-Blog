package com.choi.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @DynamicInsert // insert 시 null 인 필드 제외
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // 테이블 생성
public class User {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트 DB의 넘버링 전략을 사용
	private int id;
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50, unique = true)
	private String email;

	//@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@CreationTimestamp // 시간 자동 입력	
	private Timestamp createDate;	
}
