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

package fr.kokhaviel.api.github.watchers.staring;

import com.google.gson.JsonArray;
import fr.kokhaviel.api.github.Repo;

import java.util.ArrayList;
import java.util.List;

import static fr.kokhaviel.api.github.GithubAPI.GSON;

public class Stars {

	final JsonArray starsArray;

	List<Repo> stars = new ArrayList<>();

	public Stars(JsonArray jsonArray) {
		this.starsArray = jsonArray;

		starsArray.forEach(jsonEvent -> stars.add(GSON.fromJson(jsonEvent, Repo.class)));
	}

	public List<Repo> getStars() {
		return stars;
	}

	public Repo getStar(int eventIndex) {
		return stars.get(eventIndex);
	}

}
