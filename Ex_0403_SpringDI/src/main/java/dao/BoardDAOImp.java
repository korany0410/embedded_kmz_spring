package dao;

import java.util.ArrayList;
import java.util.List;

//구현 
public class BoardDAOImp implements BoardDAO{

	@Override
	public int insert(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	// 원래라면 servlet으로 보냈겠지만 spring에서는 service를 거쳐서 만든다
	public List<String> selectList() {
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("수박");
		list.add("참외");
		list.add("복숭아");
		return list;
	}

	@Override
	public int update(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
