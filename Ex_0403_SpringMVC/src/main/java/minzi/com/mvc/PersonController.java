package minzi.com.mvc;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.PersonDAO;
import vo.PersonVO;

@Controller //어노테이션 무조건!!
public class PersonController {
	
	//주소 경로를 수동으로 알려주기 views로 들어가서 person이라는 폴더 경로를 추가
	// 이렇게 만들면 폴더를 나눠서 관리할 수 있다!
	public static final String VIEW_PATH = "/WEB-INF/views/person/";
	
	//root-context에서 만든 dao불러오기
	PersonDAO person_dao;
	
	//기본 생성자
	public PersonController(PersonDAO person_dao) {
		System.out.println("--- PersonController()생성자 ---");
	
	this.person_dao = person_dao;
	}
	
	
	//전체목록 조회
	@RequestMapping( value = {"/", "/list.do"})
	//컨트롤러의 메서드가 서블릿의 역할을 대신한다
	//메서드 반환형은 무조건 스트링!
	public String select( Model model, HttpServletRequest request ) {
		// root-context 내부의 dao로 부터 검색결과 가져오기
		List<PersonVO> list = person_dao.selectList();
		
		//ip가져오기
		String ip = request.getRemoteAddr();
		
		//바인딩
		model.addAttribute("list", list);
		model.addAttribute("ip", ip);
		
		//requess로 바인딩 해도됨
		//request.setAttribute("list", list);
		
		//포워딩
		//servlet-context에서 설정을 변경해서 .jsp써줘야함
		//VIEW_PATH경로 안에  person.jsp파일로 포워딩!
		return VIEW_PATH + "person.jsp";
		
		
		
	}
	
}
