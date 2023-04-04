package com.minzi.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MyuserDAO;
import vo.MyuserVO;

@Controller
public class MyuserController {
	// dao의 정보를 알아와서 메서드를 호출해서 mapper로 들어가기

	public static final String VIEW_PATH = "/WEB-INF/views/myuser/";

	MyuserDAO myuser_dao;

	public MyuserController(MyuserDAO myuser_dao) {
		this.myuser_dao = myuser_dao;

	}

	// 전체 목록 조회
	@RequestMapping(value = { "/", "/list.do" })
	public String list(Model model) {

		// myuser_dao로 부터 전체목록을 가져온다
		List<MyuserVO> list = myuser_dao.selectList();

		// 바인딩
		model.addAttribute("list", list);

		// 포워딩
		return VIEW_PATH + "myuser_list.jsp";

	}

	// 목록 추가하기 화면으로 가기
	@RequestMapping("/add.do")
	public String add() {
		return VIEW_PATH + "myuser_add.jsp";
	}

	// 데이터베이스에 목록 추가하기
	@RequestMapping("/insert.do")
	public String insert(Model model, MyuserVO vo) {

		System.out.println(vo.getName());
		// dao로 접근
		int result = myuser_dao.insert(vo);
		System.out.println(result);

		return "redirect:list.do";

	}

}
