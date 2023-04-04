package com.re.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CoffeeDAO;
import vo.CoffeeVO;

//어노테이션
@Controller
public class CoffeeController {
	
	//root-context에서 생성한 coffee_dao불러오기
	CoffeeDAO coffee_dao;
	
	//기본생성자
	public CoffeeController(CoffeeDAO coffee_dao) {
		this.coffee_dao = coffee_dao;
	}
	
	//전체 목록을 조회하는 메서드 만들기 
	//컨트롤러가 서블릿의 역할을 대신함
	@RequestMapping( value= {"/","/list.do"})
	public String select(Model model) {
		//root-context 내부의 dao로 부터 검색결과 가져오기
		List<CoffeeVO> list = coffee_dao.selectList();
		
		//바인딩
		model.addAttribute("list",list);
		//포워딩
		return "/WEB-INF/views/coffee/coffee.jsp";
		
	}
	
	
	
	
	
}
