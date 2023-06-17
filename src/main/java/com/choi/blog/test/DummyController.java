package com.choi.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.choi.blog.model.RoleType;
import com.choi.blog.model.User;
import com.choi.blog.repository.UserRepository;


@RestController
public class DummyController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();
	}
	
	@GetMapping("/dummy/user")
	public List<User>pageList(@PageableDefault(size = 1, sort = "id", direction = Direction.DESC) Pageable pageable) {
		Page<User> paginUser = userRepository.findAll(pageable);
		List<User> users = paginUser.getContent();
		
		return users;
	}
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {

			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. " + id);
			}
		});
		
		// 통신 : java object를 변환 -> json
		// 스프링부트의 MessageConverter가 응답 시 자동 작동한다.
		// 만약, 자바 오브젝트를 리턴하면 MessageConverter가 Jackson 라이브러리로 
		// user 오브젝트를 json으로 변환하여 브라우저에게 응답해준다.
		return user;
	}
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		System.out.println(user.getRole());
		System.out.println(user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		
		return "회원가입이 완료되었습니다.";
	}
	
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("id " + id);
		System.out.println("password " + requestUser.getPassword());
		System.out.println("email " + requestUser.getEmail());
		
		// 영속화 시킨 후 
		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("수정이 실패하였습니다.");
		});
		// 값을 변경하면 @Transactional 변경을 감지하여 update 시킨다.
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		// userRepository.save(user);
		
		
		return null;
	}
	
	@DeleteMapping("/dummy/user/{id}")
	public String deleteUser(@PathVariable int id) {
		try {
			userRepository.deleteById(id);			
		} catch (EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다.";
		}
		
		return "삭제되었습니다. id : " + id;
	}
	
}
