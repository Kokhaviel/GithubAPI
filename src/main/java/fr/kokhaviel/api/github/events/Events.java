package fr.kokhaviel.api.github.events;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import static fr.kokhaviel.api.github.GithubAPI.GSON;

public class Events {

	final JsonArray eventsArray;

	List<Event> events = new ArrayList<>();

	public Events(JsonArray jsonArray) {
		this.eventsArray = jsonArray;

		eventsArray.forEach(jsonEvent -> events.add(GSON.fromJson(jsonEvent, Event.class)));
	}

	public List<Event> getEvents() {
		return events;
	}

	public Event getEvent(int eventIndex) {
		return events.get(eventIndex);
	}
}
