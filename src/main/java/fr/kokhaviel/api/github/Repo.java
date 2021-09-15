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

package fr.kokhaviel.api.github;

import com.google.gson.annotations.SerializedName;

public class Repo {

	@SerializedName("id")
	long id = 0;

	@SerializedName("node_id")
	String nodeId = "";

	@SerializedName("name")
	String name = "";

	@SerializedName("full_name")
	String fullName = "";

	@SerializedName("private")
	boolean _private = false;

	@SerializedName("owner")
	User owner = new User();

	@SerializedName("html_url")
	String url = "";

	@SerializedName("description")
	String description = "";

	@SerializedName("url")
	String apiUrl = "";

	@SerializedName("created_at")
	String creation = "";

	@SerializedName("updated_at")
	String update = "";

	@SerializedName("pushed_at")
	String lastPush = "";

	@SerializedName("git_url")
	String gitUrl = "";

	@SerializedName("ssh_url")
	String sshUrl = "";

	@SerializedName("language")
	String language = "";

	@SerializedName("stargazers_count")
	int stargazers = 0;

	@SerializedName("watchers_count")
	int watchers = 0;



	public long getId() {
		return id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getName() {
		return name;
	}

	public String getFullName() {
		return fullName;
	}

	public boolean isPrivate() {
		return _private;
	}

	public User getOwner() {
		return owner;
	}

	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public String getCreation() {
		return creation;
	}

	public String getUpdate() {
		return update;
	}

	public String getLastPush() {
		return lastPush;
	}

	public String getGitUrl() {
		return gitUrl;
	}

	public String getSshUrl() {
		return sshUrl;
	}

	public String getLanguage() {
		return language;
	}

	public int getStargazers() {
		return stargazers;
	}

	public int getWatchers() {
		return watchers;
	}
}
