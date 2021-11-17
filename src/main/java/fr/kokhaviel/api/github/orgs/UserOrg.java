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

package fr.kokhaviel.api.github.orgs;

import com.google.gson.annotations.SerializedName;

public final class UserOrg {

	@SerializedName("login")
	String login;

	@SerializedName("id")
	long id;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("url")
	String apiUrl;

	@SerializedName("repos_url")
	String reposUrl;

	@SerializedName("events_url")
	String eventsUrl;

	@SerializedName("hooks_url")
	String hooksUrl;

	@SerializedName("issues_url")
	String issuesUrl;

	@SerializedName("members_url")
	String membersUrl;

	@SerializedName("public_members_url")
	String publicMembersUrl;

	@SerializedName("avatar_url")
	String avatarUrl;

	@SerializedName("description")
	String description;


	public String getLogin() {
		return login;
	}

	public long getId() {
		return id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public String getReposUrl() {
		return reposUrl;
	}

	public String getEventsUrl() {
		return eventsUrl;
	}

	public String getHooksUrl() {
		return hooksUrl;
	}

	public String getIssuesUrl() {
		return issuesUrl;
	}

	public String getMembersUrl() {
		return membersUrl;
	}

	public String getPublicMembersUrl() {
		return publicMembersUrl;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public String getDescription() {
		return description;
	}
}
