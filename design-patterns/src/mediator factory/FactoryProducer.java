package mediator_factory;

public class FactoryProducer {
	public static UserFactory getUserFactory() {
		return new UserFactory();
	}
}
