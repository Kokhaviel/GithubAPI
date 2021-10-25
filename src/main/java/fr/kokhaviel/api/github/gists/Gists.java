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

package fr.kokhaviel.api.github.gists;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import fr.kokhaviel.api.github.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static fr.kokhaviel.api.github.GithubAPI.GSON;

public class Gists {

	final JsonArray gistsArray;

	List<Gist> gists = new ArrayList<>();

	public Gists(JsonArray jsonArray) {
		this.gistsArray = jsonArray;

		gistsArray.forEach(jsonEvent -> gists.add(GSON.fromJson(jsonEvent, Gist.class)));

	}

	public List<Gist> getGists() {
		return gists;
	}

	public Gist getGist(int eventIndex) {
		return gists.get(eventIndex);
	}

	public static class Gist {

		final String apiUrl;
		final String id;
		final String nodeId;
		final String url;
		final JsonObject files;
		final boolean _public;
		final String creation;
		final String update;
		final String description;
		final int comments;
		final JsonObject owner;

		public Gist(JsonObject gistObject) {
			this.apiUrl = gistObject.get("url").getAsString();
			this.id = gistObject.get("id").getAsString();
			this.nodeId = gistObject.get("node_id").getAsString();
			this.url = gistObject.get("html_url").getAsString();
			this.files = gistObject.get("files").getAsJsonObject();
			this._public = gistObject.get("public").getAsBoolean();
			this.creation = gistObject.get("created_at").getAsString();
			this.update = gistObject.get("updated_at").getAsString();
			this.description = gistObject.get("description").getAsString();
			this.comments = gistObject.get("comments").getAsInt();
			this.owner = gistObject.get("owner").getAsJsonObject();
		}

		public String getApiUrl() {
			return apiUrl;
		}

		public String getId() {
			return id;
		}

		public String getNodeId() {
			return nodeId;
		}

		public String getUrl() {
			return url;
		}

		public Files getFiles() {
			return new Files(files);
		}

		public boolean isPublic() {
			return _public;
		}

		public String getCreation() {
			return creation;
		}

		public String getUpdate() {
			return update;
		}

		public String getDescription() {
			return description;
		}

		public int getComments() {
			return comments;
		}

		public User getOwner() {
			return GSON.fromJson(owner, User.class);
		}

		public static class Files {

			List<String> keys;

			List<File> files = new ArrayList<>();

			public Files(JsonObject filesObject) {
				keys = filesObject.entrySet()
						.stream()
						.map(Map.Entry::getKey)
						.collect(Collectors.toCollection(ArrayList::new));

				keys.forEach(key -> files.add(GSON.fromJson(filesObject.get(key).getAsJsonObject(), File.class)));
			}

			public List<File> getFiles() {
				return files;
			}
		}

		public static class File {

			@SerializedName("filename")
			String name = "";

			@SerializedName("type")
			String type = "";

			@SerializedName("language")
			String language = "";

			@SerializedName("raw_url")
			String url = "";

			@SerializedName("size")
			long size = 0;



			public String getName() {
				return name;
			}

			public String getType() {
				return type;
			}

			public String getLanguage() {
				return language;
			}

			public String getUrl() {
				return url;
			}

			public long getSize() {
				return size;
			}
		}
	}

}
