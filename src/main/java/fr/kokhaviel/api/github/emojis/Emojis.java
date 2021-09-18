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

package fr.kokhaviel.api.github.emojis;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Emojis {

	List<String> keys;
	List<JsonElement> jsonElementValues;

	List<String> values;

	Map<String, String> emojis;

	public Emojis(JsonObject emojisObject) {

		keys = emojisObject.entrySet()
				.stream()
				.map(Map.Entry::getKey)
				.collect(Collectors.toCollection(ArrayList::new));

		jsonElementValues = emojisObject.entrySet()
				.stream()
				.map(Map.Entry::getValue)
				.collect(Collectors.toCollection(ArrayList::new));

		jsonElementValues.forEach(value -> values.add(value.getAsString()));

		for(int i = 0; i < keys.size(); i++) {
			emojis.put(keys.get(i), values.get(i));
		}
	}

	public Map<String, String> getEmojis() {
		return emojis;
	}
}
