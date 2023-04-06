package com.practice.board;

import org.springframework.stereotype.Controller;

import dao.UserDAO;

@Controller
public class UserController {
	UserDAO user_dao;

	public UserController(UserDAO user_dao) {
		// TODO Auto-generated constructor stub
		this.user_dao = user_dao;
	}
}
