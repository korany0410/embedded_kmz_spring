package service;

import java.util.List;

import dao.BoardDAOImp;

//구현
public class BoardServiceImp implements BoardService{

	BoardDAOImp dao;

	public BoardServiceImp(BoardDAOImp dao) {
		// 나중에 ServiceImp 가 생성될떄 dao객체를 생성자로 받을 예정
		this.dao = dao;
	}
	
	
	@Override
	public List<String> selectList() {
		return dao.selectList();
	}
}
