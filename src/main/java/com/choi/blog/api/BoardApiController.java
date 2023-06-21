package com.choi.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.choi.blog.config.auth.PrincipalDetail;
import com.choi.blog.dto.ResponseDto;
import com.choi.blog.model.Board;
import com.choi.blog.service.BoardService;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		boardService.save(board, principalDetail.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
