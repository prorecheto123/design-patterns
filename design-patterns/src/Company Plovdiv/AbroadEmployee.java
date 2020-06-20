package Company;

import java.util.ArrayList;
import java.util.List;

public class AbroadEmployee extends Employee{

	private List<Observer> observers = new ArrayList<Observer>();
	public String shipmentId;
	
	public AbroadEmployee() {
		this.level = Employee.ABROAD;
	}
	
	@Override
	protected void logMessage(String message) {
		
	      System.out.println("Client has entered the office to send abroad shimpent." + message);
	
		  Context context = new Context();

	      PreparationState preparationState = new PreparationState();
	      preparationState.doAction(context);

	      System.out.println(context.getState().toString());
	      notifyObservers();
	      System.out.println("Aroad employee is waiting for the next client.");
	}
	
	@Override
	public void subscribe(Observer observer) {
		this.observers.add(observer);
		observer.setEmployee(this);
		
	}
	@Override
	public void unsubscribe(Observer observer) {
		this.observers.remove(observer);		
	}
	@Override
	public void notifyObservers() {
		for(Observer observer: this.observers) {
			observer.update();
		}
	}
}
