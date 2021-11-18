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

package fr.kokhaviel.api.github.searches;

import com.google.gson.annotations.SerializedName;
import fr.kokhaviel.api.github.commits.Commit;
import fr.kokhaviel.api.github.repo.Repository;
import fr.kokhaviel.api.github.user.User;

import java.util.List;

public final class CommitSearch {

	@SerializedName("total_count")
	int totalCommits;

	@SerializedName("incomplete_results")
	boolean incompleteSearch;

	@SerializedName("items")
	List<CommitItem> items;

	public int getTotalCommits() {
		return totalCommits;
	}

	public boolean isIncompleteSearch() {
		return incompleteSearch;
	}

	public List<CommitItem> getItems() {
		return items;
	}

	public static final class CommitItem {

		@SerializedName("url")
		String apiUrl;

		@SerializedName("sha")
		String sha;

		@SerializedName("node_id")
		String nodeId;

		@SerializedName("html_url")
		String url;

		@SerializedName("comments_url")
		String commentsUrl;

		@SerializedName("commit")
		Commit commit;

		@SerializedName("author")
		User author;

		@SerializedName("committer")
		User committer;

		@SerializedName("parents")
		List<Commit.Parent> parents;

		@SerializedName("repository")
		Repository repository;

		@SerializedName("score")
		int searchScore;


		public String getApiUrl() {
			return apiUrl;
		}

		public String getSha() {
			return sha;
		}

		public String getNodeId() {
			return nodeId;
		}

		public String getUrl() {
			return url;
		}

		public String getCommentsUrl() {
			return commentsUrl;
		}

		public Commit getCommit() {
			return commit;
		}

		public User getAuthor() {
			return author;
		}

		public User getCommitter() {
			return committer;
		}

		public List<Commit.Parent> getParents() {
			return parents;
		}

		public Repository getRepository() {
			return repository;
		}

		public int getSearchScore() {
			return searchScore;
		}
	}

}
