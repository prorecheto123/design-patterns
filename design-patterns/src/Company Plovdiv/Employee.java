package Company;


public abstract class Employee implements Observable{
	public static int ABROAD = 1;
	public static int COUNTRY = 2;
	public static int CITY = 3;
	
	protected int level;
	
	protected Employee nextEmployee;
	
	public void setNextEmployee(Employee nextEmployee) {
		this.nextEmployee = nextEmployee;
	}
	
	public void handleMessage(String message, int level) {
		if(this.level == level) {
			this.logMessage(message);
			return;
		}
		if(this.nextEmployee != null) {
			this.nextEmployee.handleMessage(message, level);
		}
	}
	abstract protected void logMessage(String message);

}
