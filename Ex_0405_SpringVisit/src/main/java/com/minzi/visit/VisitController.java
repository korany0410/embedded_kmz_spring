package com.minzi.visit;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import util.MyCommon;
import vo.VisitVO;

@Controller
public class VisitController {
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	ServletContext app;
	
	
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
		// 스프링에서 jsp에서 jsp로 못넘어가기 때문에 반드시 컨트롤러를 거쳐서 가야한다!
		return MyCommon.Visit.VIEW_PATH + "visit_insert_form.jsp";
	}

	// 새 글 추가
	@RequestMapping("/insert.do")
	// HttpServletRequest request : ip구하는 객체
	public String insert(VisitVO vo) {
		// insert.do?name=고라니&content=내용&pwd=1111
		// 파라미터는 모두 vo가 가지고있음
		// vo파라미터를 통해 이름, 비밀번호, 내용 이미 받아온 상태

		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		//이미지가 저장될 절대경로 
		String webPath = "/resources/upload/";
		String savePath = app.getRealPath(webPath);
		System.out.println("절대경로 : " +savePath );
		
		//업로드된 파일 정보
		MultipartFile photo = vo.getPhoto();
		
		String filename = "no_file";
		if(!photo.isEmpty()) {
			//db에 추가할 실제 파일의 이름
			filename = photo.getOriginalFilename();
			
			//파일을 저장할 절대경로
			File saveFile = new File(savePath, filename);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();//절대경로에 upload라는 이름의 폴더를 생성한다
			}else {
				//동일 파일일 경우 이름변경 현재 업로드 시간을 붙여서 이름변경
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
				
			}
			
			//
			try {
				//업로드를 요청한 파일은 MultipartResolver클래스가 임시 저장소에 보관한다!!
				//임시 저장소에 보관된 파일은 일정시간이 지나면 사라지므로, 절대경로 위치에 
				//이미지를 물리적으로 복사해 넣어야한다!!!(아래)
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//vo에 파일명 세팅해서 같이 insert시키기
		vo.setFilename(filename);
		// insert메서드로 보내기
		visit_dao.insert(vo);

		// 다른 urlMapping으로 넘어가는 작업
		// sendRedirect("list.do")
		return "redirect:list.do"; // url매핑

	}

	// 글삭제
	@RequestMapping(value="/delete.do" , produces="application/json;charset=UTF-8")
	@ResponseBody // Ajax로 요청된 메서드가 반드시 가지고 있어야 하는 어노테이션
	public String delete(int idx) {
		// delete.do?idx=2

		int res = visit_dao.delete(idx);

		String result = "수정실패";
		if (res != 0) {
			result = "수정성공";
		}
		// @ResponseBody의 속성을 통해 반환된 result값이 자동으로 callback메서드로 전달된다!!
		// return된 데이터에 한글이 포함되어있다면 깨져서 넘어간다.
		// 이를 해결하기 위해 @RequestMapping부분에 produces를 추가해줘야한다!
		return result;
	}

	// 글 수정
	@RequestMapping("/modify.do")
	public String modify(VisitVO vo) {

		int res = visit_dao.modify(vo);

		return "redirect:list.do";

	}

}
