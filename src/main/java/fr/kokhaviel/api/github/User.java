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

public class User {
	@SerializedName("login")
	String login = "";

	@SerializedName("id")
	long id = 0;

	@SerializedName("node_id")
	String nodeId = "";

	@SerializedName("avatar_url")
	String avatar = "";

	@SerializedName("url")
	String apiUrl = "";

	@SerializedName("html_url")
	String url = "";

	@SerializedName("type")
	String accountType = "";

	@SerializedName("repos_url")
	String reposUrl = "";



	public String getLogin() {
		return login;
	}

	public long getId() {
		return id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public String getUrl() {
		return url;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getReposUrl() {
		return reposUrl;
	}
}
