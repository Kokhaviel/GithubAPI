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

package fr.kokhaviel.api.github.issues;

import com.google.gson.annotations.SerializedName;
import fr.kokhaviel.api.github.user.User;

public final class Comment {

	@SerializedName("url")
	String apiUrl;

	@SerializedName("html_url")
	String url;

	@SerializedName("issue_url")
	String issueUrl;

	@SerializedName("id")
	long id;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("user")
	User author;

	@SerializedName("created_at")
	String creation;

	@SerializedName("updated_at")
	String update;

	@SerializedName("body")
	String body;

	@SerializedName("reactions")
	Issue.Reactions reactions;


	public String getApiUrl() {
		return apiUrl;
	}

	public String getUrl() {
		return url;
	}

	public String getIssueUrl() {
		return issueUrl;
	}

	public long getId() {
		return id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public User getAuthor() {
		return author;
	}

	public String getCreation() {
		return creation;
	}

	public String getUpdate() {
		return update;
	}

	public String getBody() {
		return body;
	}

	public Issue.Reactions getReactions() {
		return reactions;
	}
}
