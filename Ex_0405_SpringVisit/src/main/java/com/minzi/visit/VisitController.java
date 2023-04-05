package com.minzi.visit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDAO;
import util.MyCommon;
import vo.VisitVO;

@Controller
public class VisitController {

	// dao를 참조하려면 servlet-context name과 일치
	VisitDAO visit_dao;

	// setter injection
	public void setVisit_dao(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}

	// 방명록 전체 조회
	@RequestMapping(value = { "/", "/list.do" })
	// 컨트롤러에서 호출된 매핑을 통해 메서드 실행
	public String list(Model model) {
		List<VisitVO> list = visit_dao.selecList();
		// jsp에서 출력해줘
		model.addAttribute("list", list); // 바인딩

		return MyCommon.Visit.VIEW_PATH + "visit_list.jsp"; // 포워딩
	}

	// 새 글 추가 폼으로 화면 전환
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		// 스프링에서 ㄴjsp에서 jsp로 못넘어가기 때문에 반드시 컨트롤러를 거쳐서 가야한다!
		return MyCommon.Visit.VIEW_PATH + "visit_insert_form.jsp";
	}

	// 새 글 추가
	@RequestMapping("/insert.do")
	// HttpServletRequest request : ip구하는 객체
	public String insert(VisitVO vo, HttpServletRequest request) {
		// insert.do?name=고라니&content=내용&pwd=1111
		// 파라미터는 모두 vo가 가지고있음
		// vo파라미터를 통해 이름, 비밀번호, 내용 이미 받아온 상태

		String ip = request.getRemoteAddr();
		vo.setIp(ip);

		// insert메서드로 보내기
		visit_dao.insert(vo);

		// 다른 urlMapping으로 넘어가는 작업
		// sendRedirect("list.do")
		return "redirect:list.do"; // url매핑

	}

	// 글삭제
	@RequestMapping("/delete.do")
	@ResponseBody // Ajax로 요청된 메서드가 반드시 가지고 있어야 하는 어노테이션
	public String delete(int idx) {
		// delete.do?idx=2

		int res = visit_dao.delete(idx);

		String result = "no";
		if (res != 0) {
			result = "yes";
		}
		// @ResponseBody의 속성을 통해 반환된 result값이 자동으로 callback메서드로 전달된다!!
		return result;
	}

	// 글 수정
	@RequestMapping("/modify.do")
	public String modify(VisitVO vo) {

		int res = visit_dao.modify(vo);

		return "redirect:list.do";

	}

}
