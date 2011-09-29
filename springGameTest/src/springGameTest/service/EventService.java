package springGameTest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import springGameTest.model.Event;
import springGameTest.model.User;

public class EventService {

	public static Collection<Event> getEventList(User user, long amount, long minimum) {
		List<Event> list = new ArrayList<Event>();
		List<Event> userEvents = user.getEventList();
		
		ListIterator<Event> it = userEvents.listIterator(userEvents.size());
		long i = 0;
		while (i <amount && it.hasPrevious()) {
			i++;
			list.add(it.previous());
		}
		while (i <minimum) {
			i++;
			list.add(new Event("", false));
		}
		return list;
	}

	public static void addEventToUser(User user, String message) {
		addEventToUser(user, new Event(message));
	}

	public static void addEventToUser(User user, Event event) {
		user.getEventList().add(event);
	}
}
