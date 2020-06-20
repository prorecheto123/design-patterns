package Company;

public class MainClass {
	private static Employee getChain() {
		
		Observer obs1 = new ObserverBoy("Jim");
		
		Employee cityEmployee = new CityEmployee();
		Employee countryEmployee = new CountryEmployee();
		Employee abroadEmployee = new AbroadEmployee();
		cityEmployee.setNextEmployee(countryEmployee);
		countryEmployee.setNextEmployee(abroadEmployee);
		abroadEmployee.setNextEmployee(cityEmployee);
		cityEmployee.subscribe(obs1);
		countryEmployee.subscribe(obs1);
		abroadEmployee.subscribe(obs1);
		
		return abroadEmployee;
	}
	
	public static void main(String[] args) {
		
		Employee chain = getChain();
		chain.handleMessage(" City employee accepts shipment.", 3);
		chain.handleMessage(" Contry employee accepts shipment.", 2);
		chain.handleMessage(" Abroad employee accepts shipment.", 1);
	}

}
