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

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import fr.kokhaviel.api.github.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static fr.kokhaviel.api.github.GithubAPI.GSON;

public final class Gist {

	List<File> files = new ArrayList<>();
	GistData gist;
	JsonObject object;

	public Gist(JsonObject object) {
		this.object = object;
		this.gist = GSON.fromJson(object.getAsJsonObject(), GistData.class);
		addFiles();
	}

	void addFiles() {

		ArrayList<String> tmpFiles = object.getAsJsonObject("files").entrySet()
				.stream()
				.map(Map.Entry::getKey)
				.collect(Collectors.toCollection(ArrayList::new));

		tmpFiles.forEach(file -> {
			final File files = GSON.fromJson(object.getAsJsonObject("files").getAsJsonObject(file), File.class);
			this.files.add(files);
		});
	}

	public List<File> getFiles() {
		return files;
	}

	public GistData getGistData() {
		return gist;
	}

	public static final class GistData {

		@SerializedName("url")
		String apiUrl;

		@SerializedName("forks_url")
		String forksUrl;

		@SerializedName("commits_url")
		String commitsUrl;

		@SerializedName("id")
		String id;

		@SerializedName("node_id")
		String nodeId;

		@SerializedName("git_pull_url")
		String pull;

		@SerializedName("git_push_url")
		String push;

		@SerializedName("html_url")
		String url;

		@SerializedName("public")
		boolean _public;

		@SerializedName("created_at")
		String creation;

		@SerializedName("updated_at")
		String update;

		@SerializedName("description")
		String description;

		@SerializedName("comments")
		int comments;

		@SerializedName("comments_url")
		String commentsUrl;

		@SerializedName("owner")
		User owner;

		@SerializedName("fork_of")
		GistData fork;

		@SerializedName("forks")
		List<GistData> forks;

		@SerializedName("history")
		List<Commit> commits;



		public String getApiUrl() {
			return apiUrl;
		}

		public String getForksUrl() {
			return forksUrl;
		}

		public String getCommitsUrl() {
			return commitsUrl;
		}

		public String getId() {
			return id;
		}

		public String getNodeId() {
			return nodeId;
		}

		public String getPull() {
			return pull;
		}

		public String getPush() {
			return push;
		}

		public String getUrl() {
			return url;
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

		public String getCommentsUrl() {
			return commentsUrl;
		}

		public User getOwner() {
			return owner;
		}

		public GistData getFork() {
			return fork;
		}

		public List<GistData> getForks() {
			return forks;
		}

		public List<Commit> getCommits() {
			return commits;
		}
	}

	public static final class File {

		@SerializedName("filename")
		String name;

		@SerializedName("type")
		String type;

		@SerializedName("language")
		String lang;

		@SerializedName("raw_url")
		String url;

		@SerializedName("size")
		String size;

		@SerializedName("content")
		String content;


		public String getName() {
			return name;
		}

		public String getType() {
			return type;
		}

		public String getLang() {
			return lang;
		}

		public String getUrl() {
			return url;
		}

		public String getSize() {
			return size;
		}

		public String getContent() {
			return content;
		}
	}

	public static final class Commit {

		@SerializedName("user")
		User user;

		@SerializedName("version")
		String version;

		@SerializedName("committed_at")
		String committed;

		@SerializedName("change_status")
		fr.kokhaviel.api.github.commits.Commit.Changes changes;

		@SerializedName("url")
		String url;

		public User getUser() {
			return user;
		}

		public String getVersion() {
			return version;
		}

		public String getCommitted() {
			return committed;
		}

		public fr.kokhaviel.api.github.commits.Commit.Changes getChanges() {
			return changes;
		}

		public String getUrl() {
			return url;
		}
	}
}
