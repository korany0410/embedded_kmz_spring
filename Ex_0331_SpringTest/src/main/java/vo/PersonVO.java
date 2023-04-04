package vo;

public class PersonVO {
	private String name;
	private int age;
	private String tel;
	
	// 기본생성자
	public PersonVO() {
		System.out.println("---PersonVO의 기본 생성자---");
	}
	
	// 오버로딩생성자
	public PersonVO(String name, int age, String tel) {
		System.out.println("---PersonVO의 오버로딩 생성자---");
		this.name = name;
		this.age = age;
		this.tel = tel;
	}
	
	
	//setter&getter-------------------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("이름 세팅됨 : " + name);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	
	
}
