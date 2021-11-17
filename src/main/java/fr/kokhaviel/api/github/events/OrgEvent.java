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

import com.google.gson.annotations.SerializedName;

public final class OrgEvent {

	@SerializedName("id")
	String id;

	@SerializedName("type")
	String type;

	@SerializedName("actor")
	Event.Author author;

	@SerializedName("repo")
	Event.Repo repo;

	@SerializedName("public")
	boolean _public;

	@SerializedName("created_at")
	String creation;

	@SerializedName("org")
	Event.Author organisation = new Event.Author();
	//Fields are same for Author Event and Org Event


	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public Event.Author getAuthor() {
		return author;
	}

	public Event.Repo getRepo() {
		return repo;
	}

	public boolean isPublic() {
		return _public;
	}

	public String getCreation() {
		return creation;
	}

	public Event.Author getOrganisation() {
		return organisation;
	}

}

