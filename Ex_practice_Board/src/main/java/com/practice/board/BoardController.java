package com.practice.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BoardDAO;
import dao.CommentDAO;
import util.MyCommon;
import vo.BoardVO;

@Controller
public class BoardController {
	BoardDAO board_dao;
	CommentDAO comment_dao;

	public BoardController(BoardDAO board_dao, CommentDAO comment_dao) {
		// TODO Auto-generated constructor stub
		this.board_dao = board_dao;
		this.comment_dao = comment_dao;
	}
	
	@RequestMapping(value= {"/", "main_list.do"})
	public String list(Model model) {
		
		List<BoardVO> list = board_dao.selectList();
		model.addAttribute("list", list);
		return MyCommon.Board.VIEW_PATH + "main_list.jsp";
	}
	
	
	
}
