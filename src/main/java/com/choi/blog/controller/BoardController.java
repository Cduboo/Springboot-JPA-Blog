package com.choi.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.choi.blog.model.Board;
import com.choi.blog.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String index(Model model
			, @PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {
		Page<Board> pagingBoard = boardService.findAll(pageable);
		model.addAttribute("boards", pagingBoard);
		return "/index";
	}
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.findById(id));
		return "/board/detail";
	}
	
	@GetMapping("/board/saveForm")
	public String save() {
		return "/board/saveForm";
	}
}
