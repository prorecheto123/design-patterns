package mediator_factory;

public class UserFactory {

	public User CreateUser(ChatRoomMediator mediator, String name) {
		return new ChatRoomUser(mediator, name);
	}
}
