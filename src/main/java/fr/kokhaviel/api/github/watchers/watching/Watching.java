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

package fr.kokhaviel.api.github.watchers.watching;

import com.google.gson.JsonArray;
import fr.kokhaviel.api.github.repo.Repository;

import java.util.ArrayList;
import java.util.List;

import static fr.kokhaviel.api.github.GithubAPI.GSON;

public final class Watching {


	final JsonArray watchingArray;

	List<Repository> watching = new ArrayList<>();

	public Watching(JsonArray jsonArray) {
		this.watchingArray = jsonArray;

		watchingArray.forEach(jsonEvent -> watching.add(GSON.fromJson(jsonEvent, Repository.class)));
	}

	public List<Repository> getWatches() {
		return watching;
	}

	public Repository getWatch(int eventIndex) {
		return watching.get(eventIndex);
	}
}
