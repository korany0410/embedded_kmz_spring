package dao;

import java.util.ArrayList;
import java.util.List;

import vo.CoffeeVO;

public class CoffeeDAO {
	
	
	//기본 생성자
	public CoffeeDAO() {
		System.out.println("---CoffeeDAO---");
	}
	
	
	//커피매장 정보 조회
	public List<CoffeeVO> selectList(){
		
		List<CoffeeVO> list = new ArrayList<CoffeeVO>();
		CoffeeVO c1 = new CoffeeVO("브레드 읍읍", "서울시 용산구 도원동", "02-7124-5487", "3,000,000","10,500,000");
		CoffeeVO c2 = new CoffeeVO("뚜스뚜스", "서울시 영등포구 양평동", "02-3124-5557", "30,000,000","27,500,000");
		CoffeeVO c3 = new CoffeeVO("벨런티", "서울시 송파구 석촌동 ", "02-1361-6773", "30,600,000","37,500,000");
		CoffeeVO c4 = new CoffeeVO("런던베이글뮤지엄", "서울시 강남구 신사동", "02-1274-5587", "50,000,000","52,000,000");
		CoffeeVO c5 = new CoffeeVO("아키비스트", "서울시 종로구 효자동", "02-6124-9827", "26,000,000","19,500,000");
		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}
