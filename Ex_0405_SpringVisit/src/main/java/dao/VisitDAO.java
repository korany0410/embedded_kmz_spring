package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {
	
	SqlSession sqlSession;
	//setter
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		
	}
	
	//방명록 전체 조회 메서드 (반환형은 리스트)
	public List<VisitVO> selecList(){
		List<VisitVO> list = sqlSession.selectList("v.visit_list");
		return list;
	}
	
	// 새 글 추가
	public int insert(VisitVO vo) {
		//mapper로 정보 보내기
		int res = sqlSession.insert("v.visit_insert",vo);
		return res;
	}
	
}
