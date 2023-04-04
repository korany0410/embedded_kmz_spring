package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MyuserVO;

public class MyuserDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//전체 목록을 조회하는 메서드
	public List<MyuserVO> selectList(){
		
		List<MyuserVO> list = sqlSession.selectList("m.myuser_list");
		//openSession, close 자동
		return list;
	}
	
	public int insert(MyuserVO vo) {
		
		int result = sqlSession.insert("m.myuser_insert", vo);
		
		return result;
	}
	
	
	
	
}
