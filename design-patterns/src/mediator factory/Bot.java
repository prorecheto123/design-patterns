package mediator_factory;

import java.util.List;

public class Bot {

	private static Bot bot;

	private Bot() {

	}

	public static Bot getBot() {
		if (bot == null) {
			bot = new Bot();
		}

		return bot;
	}

	public boolean detectForbiddenWord(String message) {
		if (message.contains("cat")) {
			return true;
		}

		return false;
	}

	public void warnUsers(List<User> users) {
		for (User user : users) {
			user.receive("Please avoid using the word cat. It is forbidden!");
		}
	}
}
