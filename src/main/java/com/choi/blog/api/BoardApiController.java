package com.choi.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.choi.blog.config.auth.PrincipalDetail;
import com.choi.blog.dto.ReplySaveRequestDto;
import com.choi.blog.dto.ResponseDto;
import com.choi.blog.model.Board;
import com.choi.blog.model.Reply;
import com.choi.blog.service.BoardService;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> createBoard(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		boardService.createBoard(board, principalDetail.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteBoardById(@PathVariable int id) {
		boardService.deleteBoardById(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> updateBoardById(@PathVariable int id, @RequestBody Board board) {
		boardService.updateBoardById(board, id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PostMapping("/api/board/{boardId}/reply")
	public ResponseDto<Integer> createReplyForBoard(@RequestBody ReplySaveRequestDto replySaveRequestDto) {
		boardService.createReplyForBoard(replySaveRequestDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/board/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> deleteReply(@PathVariable int replyId) {
		boardService.deleteReply(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	
}
