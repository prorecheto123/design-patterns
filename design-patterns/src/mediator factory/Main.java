package mediator_factory;

public class Main {

	public static void main(String[] args) {
		ChatRoomMediator mediator = new ChatRoomMediator();
		UserFactory userFactory = FactoryProducer.getUserFactory();

		User user1 = userFactory.CreateUser(mediator, "user1998");
		User user2 = userFactory.CreateUser(mediator, "new_user");
		User user3 = userFactory.CreateUser(mediator, "incognito");

		user1.send("what's up guys");
		user3.send("hello new user");

		user2.send("i love cats");

		user1.send("addBot");

		user3.send("love cats <3");
		user3.send("am i blocked?");
	}

}
