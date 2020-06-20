package Company;

import java.util.ArrayList;
import java.util.List;

public class CityEmployee extends Employee{

	private List<Observer> observers = new ArrayList<Observer>();
	
	public CityEmployee() {
		this.level = Employee.CITY;
	}
	
	@Override
	protected void logMessage(String message) {
		
	      System.out.println("Client has entered the office to send city shimpent." + message);
		
		  Context context = new Context();

	      PreparationState preparationState = new PreparationState();
	      preparationState.doAction(context);

	      System.out.println(context.getState().toString());
	      
	      notifyObservers();

	      System.out.println("City employee is waiting for the next client.");
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
