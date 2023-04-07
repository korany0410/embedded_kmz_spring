package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DeptDAO;
import vo.DeptVO;

@Service
public class TotalService {

	DeptDAO dept_dao;
	// DeptDAO에서의 @Repository("dept_dao") 의 별칭과
	// 이름을 똑같이 지어준다!!!!

	// injection없이 작동이 된다

	@Autowired
	public TotalService(DeptDAO dept_dao) {
		this.dept_dao = dept_dao;
		System.out.println("--totalService가 생성됨--");
	}
	
	public List<DeptVO> selectList(){
		List<DeptVO> list = dept_dao.selectList();
		return list;
		
	}
	
}
