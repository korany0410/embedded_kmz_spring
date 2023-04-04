package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// @ : 어노테이션(프로그래밍 주석)
//		-> 어노테이션은 @Override처럼 컴파일러에게 오버라이딩 메서드임을 빠르게 캐치하게 하는 용도
// 		-> @Controller처럼 어노테이션을 통해 특수한 기능을 사용할 수 있도록 동작하게 하는 용도(너는 컨트롤러야)
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardServiceImp;
@Controller //컨트롤러에 반드시 필요한 어노테이션
public class BoardController {
	//service받기 : dao와 그 내부의 메서드를 사용할 수 있어서
	BoardServiceImp service;
	
	public BoardController(BoardServiceImp service) {
		System.out.println("---나는 컨트롤러의 생성자---");
		this.service = service;
	}
	
	//setService메서드 생성
	public void setService(BoardServiceImp service) {
		//setter injection을 통해서 service객체를 Controller로 불러온다.
		this.service = service;
	}
	
	//(value = {"/", "/list.do"}) 
	//	ㄴ 처음 실행될때 기본으로 /를 /list.do로 치환하겠다!
	@RequestMapping(value = {"/", "/list.do"})
	public String list( Model model ) {
		//list.do가 호출됐을때 실행되는 메서드
		//매핑을 받아서 호출됐을떄 메서드의 반환형은 거의 String
		List<String> list = service.selectList();
	 	
		//list를 모델객체에 저장(바인딩)
		model.addAttribute("list", list);
		
		//포워딩
		return "board_list";
	}
	
	
	
	
	
	
	
}
