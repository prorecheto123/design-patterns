package mediator_factory;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomMediator implements Mediator {

	private List<User> users = new ArrayList<User>();
	private Bot bot;

	public ChatRoomMediator() {
	}

	@Override
	public void sendMessage(String message, User user) {
		if (!this.users.contains(user)) {
			System.out.println("User " + user.getName()
					+ " is not in the chat room. If they want to send and receive messages consider adding them.");
			return;
		}

		if (message.equals("addBot")) {
			System.out.println("User " + user.getName() + " created a bot.");
			message = "User " + user.getName() + " created a bot.";

			this.bot = bot.getBot();
		}

		if (bot != null && bot.detectForbiddenWord(message)) {
			this.removeUser(user);
			System.out.println("User " + user.getName() + "is removed from the cat for using the forbidden word.");
			this.bot.warnUsers(this.users);
			return;
		}

		for (User listUser : users) {
			if (user != listUser) {
				listUser.receive(message);
			}
		}

	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}

	@Override
	public void removeUser(User user) {
		this.users.remove(user);
	}

}
