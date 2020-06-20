package Company;

public class ObserverBoy implements Observer{

	private String name;
	private Observable employee;
	
	public ObserverBoy(String name) {
		this.name = name;
	}
	
	@Override
	public void update() {
		if(employee == null) {
			
			System.out.println("There is no shipment to take to the warehose!");
			return;
		}
		System.out.println(name+" is taking the shipment.");
	}

	@Override
	public void setEmployee(Observable employee) {
		this.employee = employee;
	}
}
