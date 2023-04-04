package vo;

public class CoffeeVO {
	private String name, address, tel, mon_rental, labor_cost ;
	
	//기본 생성자
	public CoffeeVO(String name, String address, String tel, String mon_rental, String labor_cost ) {
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.mon_rental = mon_rental;
		this.labor_cost = labor_cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMon_rental() {
		return mon_rental;
	}

	public void setMon_rental(String mon_rental) {
		this.mon_rental = mon_rental;
	}

	public String getLabor_cost() {
		return labor_cost;
	}

	public void setLabor_cost(String labor_cost) {
		this.labor_cost = labor_cost;
	}

	
	
}
