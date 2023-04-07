package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.DeptVO;

@Repository("dept_dao") // 데이터 관리 어노테이션
public class DeptDAO {

	// 자동 연결을 통해서 setter, 생성자 injection 없이 SqlSession객체 생성
	SqlSession sqlSession; // dapbean을 따로 만들지 않고도 AutoWired를 이용해서 자동으로 만들어짐

	// @Component의 자식 클래스를 어노테이션으로 가지고있는 경우
	// servlet-context에서 auto-detecting (자동 생성이 가능해진다
	// @Component
//		ㄴ@Controller
//		ㄴ@Repository
//		ㄴ@Service

	// 생성자
	@Autowired
	public DeptDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;

		System.out.println("--deptDAO의 생성자가 만들어졌어요--");
	}
	
	//부서 목록 조회 메서드
	public List<DeptVO> selectList(){
		List<DeptVO> list = sqlSession.selectList("d.dept_list");
		return list;
	}
	
	
	
}
