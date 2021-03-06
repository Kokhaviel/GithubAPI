/*
 * Copyright (c) 2021 Kokhaviel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.kokhaviel.api.github.events;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import static fr.kokhaviel.api.github.GithubAPI.GSON;

public final class Events {

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
