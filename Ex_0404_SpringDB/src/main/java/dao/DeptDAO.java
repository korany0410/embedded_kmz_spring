package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

public class DeptDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		
	}
	
	//전체 목록을 조회하는 메서드
	public List<DeptVO> selectList(){
		
		List<DeptVO> list = sqlSession.selectList("d.dept_list");
		//openSession, close 자동 
		return list;
	}
	
	// 추가 하기
	
	
	
}
















