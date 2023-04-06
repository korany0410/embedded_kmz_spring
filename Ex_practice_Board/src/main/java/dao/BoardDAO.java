package dao;

import org.apache.ibatis.session.SqlSession;

public class BoardDAO {

	SqlSession sqlSession;

	// setter
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
