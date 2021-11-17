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

package fr.kokhaviel.api.github.repo;

import com.google.gson.annotations.SerializedName;
import fr.kokhaviel.api.github.commits.Commit.Parent;
import fr.kokhaviel.api.github.user.User;

import java.util.ArrayList;
import java.util.List;

public final class Commit {

	@SerializedName("sha")
	String sha;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("commit")
	fr.kokhaviel.api.github.commits.Commit commit = new fr.kokhaviel.api.github.commits.Commit();

	@SerializedName("url")
	String apiUrl;

	@SerializedName("html_url")
	String url;

	@SerializedName("comments_url")
	String commentsUrl;

	@SerializedName("author")
	User author;

	@SerializedName("committer")
	User committer;

	@SerializedName("parents")
	List<Parent> parents = new ArrayList<>();


	public String getSha() {
		return sha;
	}

	public String getNodeId() {
		return nodeId;
	}

	public fr.kokhaviel.api.github.commits.Commit getCommit() {
		return commit;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public String getUrl() {
		return url;
	}

	public String getCommentsUrl() {
		return commentsUrl;
	}

	public User getAuthor() {
		return author;
	}

	public User getCommitter() {
		return committer;
	}

	public List<Parent> getParents() {
		return parents;
	}
}
