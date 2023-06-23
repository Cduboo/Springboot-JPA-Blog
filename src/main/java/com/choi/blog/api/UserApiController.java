package com.choi.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.choi.blog.dto.ResponseDto;
import com.choi.blog.model.RoleType;
import com.choi.blog.model.User;
import com.choi.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> joinProc(@RequestBody User user) {
		if(userService.joinProc(user) == null) {
			return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), 1);
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/api/user")
	public ResponseDto<Integer> update(@RequestBody User user) {
		userService.update(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
