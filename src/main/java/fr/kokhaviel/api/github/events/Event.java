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

public final class Event {

	@SerializedName("id")
	String id;

	@SerializedName("type")
	String type;

	@SerializedName("actor")
	Author author;

	@SerializedName("repo")
	Repo repo;

	@SerializedName("public")
	boolean _public;

	@SerializedName("created_at")
	String creation;


	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public Author getAuthor() {
		return author;
	}

	public Repo getRepo() {
		return repo;
	}

	public boolean isPublic() {
		return _public;
	}

	public String getCreation() {
		return creation;
	}


	public static final class Author {

		@SerializedName("id")
		String id = "";

		@SerializedName("login")
		String login = "";

		@SerializedName("display_login")
		String displayLogin = "";

		@SerializedName("avatar_url")
		String avatar = "";


		public String getId() {
			return id;
		}

		public String getLogin() {
			return login;
		}

		public String getDisplayLogin() {
			return displayLogin;
		}

		public String getAvatar() {
			return avatar;
		}
	}

	public static final class Repo {

		@SerializedName("id")
		String id = "";

		@SerializedName("name")
		String name = "";

		@SerializedName("url")
		String url = "";


		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getUrl() {
			return url;
		}
	}
}
