package com.minzi.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.PersonVO;

@Controller
public class ParamController {

	public static final String VIEW_PATH = "/WEB-INF/views/";
	
	@RequestMapping(value = {"/","/insert_form.do"})
	public String insert_form() {
		//포워딩
		return VIEW_PATH + "insert_form.jsp";
	}
	
	
	//send1()에 대한 처리
	@RequestMapping("/insert1.do")
	public String insert1( Model model, String name, int age, String tel ) {
		//insert1.do?name=홍길동&age=25&tel=01011112222
		
		//request.getparameter를 하지 않아도 자동을 형변환해서 들어온다. 대신 파라미터명을 맞춰줘야한다.
		//name,age,tel이 파라미터로 자동으로 넘어온다
		//int타입의 경우 자동으로 형변환까지 처리
	
		//넘겨받은 세개의 파라미터를 vo로 묶어서 담아서 바인딩
		PersonVO vo = new PersonVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setTel(tel);
		
		//바인딩
		model.addAttribute("vo", vo);
		
		//포워딩
		return VIEW_PATH + "insert_result.jsp";
	

	
	}
	
	//send2()에 대한 처리
	@RequestMapping("/insert2.do")
	// 파라미터가 VO변수의 이름과 정확하게 일치할 경우
	// 애초에 PersonVO타입으로 받을 수 있다!
	//	위에서 처럼 각각의 파라미터를 다시 vo로 묶어 담아서 바인딩 하지 않아도 된다!
	public String insert2(Model model, PersonVO vo) {
		
		//이미 vo로 묶여있어서 바로 바인딩 작업 가능
		model.addAttribute("vo", vo);
		
		//포워딩
		return VIEW_PATH + "insert_result.jsp";
		
		//예외상황은
		//insert2(Model model, PersonVO vo, String name){ }
		//위와같이 vo에 이미 존재하는 변수를 파라미터로 또 받게되면 실행시 오류 발생
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
