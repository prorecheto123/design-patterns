package Company;

public class PreparationState implements State{

	public void doAction(Context context) { 
		
		System.out.println("Shipment is in preparation state.");
		context.setState(this);	
	}

	public String toString() {
		return "Preparation state";
	}
}
