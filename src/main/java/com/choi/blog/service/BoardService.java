package com.choi.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choi.blog.dto.ReplySaveRequestDto;
import com.choi.blog.model.Board;
import com.choi.blog.model.Reply;
import com.choi.blog.model.User;
import com.choi.blog.repository.BoardRepository;
import com.choi.blog.repository.ReplyRepository;
import com.choi.blog.repository.UserRepository;

@Service
public class BoardService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	ReplyRepository replyRepository;
	
	@Transactional
	public void createBoard(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}

	public Page<Board> findAll(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	public Board findById(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글 상세보기 실패");
		});
	}

	@Transactional
	public void deleteBoardById(int id) {
		boardRepository.deleteById(id);
	}

	@Transactional
	public void updateBoardById(Board requestBoard, int id) {		
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글 상세보기 실패");
		});
		
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
	}

	@Transactional
	public void createReplyForBoard(ReplySaveRequestDto replySaveRequestDto) {
		replyRepository.replySave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
	}

	@Transactional
	public void deleteReply(int replyId) {
		replyRepository.deleteById(replyId);
	}
}
