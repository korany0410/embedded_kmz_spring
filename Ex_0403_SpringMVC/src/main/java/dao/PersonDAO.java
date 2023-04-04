package dao;

import java.util.ArrayList;
import java.util.List;

import vo.PersonVO;

public class PersonDAO {
	
	//기본 생성자
	public PersonDAO() {
		System.out.println("---PersonDAO()의 생성자---");
	}
	
	//회원목록 조회
	public List<PersonVO> selectList(){
		
		List<PersonVO> list = new ArrayList<PersonVO>();
		PersonVO p1 = new PersonVO("홍길동", "010-1111-1111", 31);
		PersonVO p2 = new PersonVO("김길동", "010-2222-2222", 32);
		PersonVO p3 = new PersonVO("박길동", "010-3333-3333", 33);
		PersonVO p4 = new PersonVO("최길동", "010-4444-4444", 34);
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		return list;
	}
	
	
	
}
