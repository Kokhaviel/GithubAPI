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

package fr.kokhaviel.api.github.commits;

import com.google.gson.annotations.SerializedName;
import fr.kokhaviel.api.github.files.File;

import java.util.ArrayList;
import java.util.List;

public final class Commit {

	@SerializedName("sha")
	String sha;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("url")
	String apiUrl;

	@SerializedName("html_url")
	String url;

	@SerializedName("author")
	Author author;

	@SerializedName("committer")
	Author committer;

	@SerializedName("tree")
	Tree tree;

	@SerializedName("message")
	String message;

	@SerializedName("parents")
	List<Parent> parents;

	@SerializedName("verification")
	Verification verif;

	//Only for GithubAPI#getCommit(String, String, String)
	@SerializedName("changes")
	Commit.Changes changes = new Changes();

	@SerializedName("files")
	List<File> files = new ArrayList<>();

	public String getSha() {
		return sha;
	}

	public String getNodeId() {
		return nodeId;
	}



	public String getApiUrl() {
		return apiUrl;
	}

	public String getUrl() {
		return url;
	}

	public Author getAuthor() {
		return author;
	}

	public Author getCommitter() {
		return committer;
	}

	public Tree getTree() {
		return tree;
	}

	public String getMessage() {
		return message;
	}

	public List<Parent> getParents() {
		return parents;
	}

	public Verification getVerif() {
		return verif;
	}

	public Changes getChanges() {
		return changes;
	}

	public List<File> getFiles() {
		return files;
	}

	public static final class Author {

		@SerializedName("name")
		String name;

		@SerializedName("email")
		String email;

		@SerializedName("date")
		String date;

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}

		public String getDate() {
			return date;
		}
	}

	public static final class Tree {

		@SerializedName("sha")
		String sha;

		@SerializedName("url")
		String url;

		public String getSha() {
			return sha;
		}

		public String getUrl() {
			return url;
		}
	}

	public static final class Parent {

		@SerializedName("sha")
		String sha;

		@SerializedName("url")
		String apiUrl;

		@SerializedName("html_url")
		String url;

		public String getSha() {
			return sha;
		}

		public String getApiUrl() {
			return apiUrl;
		}

		public String getUrl() {
			return url;
		}
	}

	public static final class Verification {

		@SerializedName("verified")
		boolean verified;

		@SerializedName("reason")
		String reason;

		public boolean isVerified() {
			return verified;
		}

		public String getReason() {
			return reason;
		}
	}

	public static final class Changes {

		@SerializedName("total")
		int total;

		@SerializedName("additions")
		int additions;

		@SerializedName("deletions")
		int deletions;

		public int getTotal() {
			return total;
		}

		public int getAdditions() {
			return additions;
		}

		public int getDeletions() {
			return deletions;
		}
	}
}
