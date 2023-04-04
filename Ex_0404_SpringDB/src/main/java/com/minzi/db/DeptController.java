package com.minzi.db;

import org.springframework.stereotype.Controller;

import dao.DeptDAO;

@Controller
public class DeptController {
	//dao의 정보를 알아와 메서드를 호출해서 mapper로 들어가기
	
	DeptDAO dept_dao;
	
	public DeptController(DeptDAO dept_dao) {
		this.dept_dao = dept_dao;
		
		System.out.println("Dept컨트롤러 생성자 : " + dept_dao);
	}
	
}
