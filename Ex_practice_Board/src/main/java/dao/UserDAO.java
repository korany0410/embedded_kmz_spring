package dao;

import org.apache.ibatis.session.SqlSession;

public class UserDAO {

	SqlSession sqlSession;

	// setter
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
