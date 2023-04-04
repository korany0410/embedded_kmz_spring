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
	
	//목록을 추가
	public int insert(MyuserVO vo) {
		
		int result = sqlSession.insert("m.myuser_insert", vo);
		
		return result;
	}
	
	//목록을 수정하는 메서드
	public int update(MyuserVO vo) {
	    int result = sqlSession.update("m.myuser_update", vo);
	    return result;
	}
	
	//목록을 삭제
	public int delete(MyuserVO vo) {
		int result = sqlSession.delete("m.myuser_delete", vo);
		return result;
	}
	
	

	
	
}
