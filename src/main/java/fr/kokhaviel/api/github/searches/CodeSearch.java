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
import fr.kokhaviel.api.github.repo.Repository;

import java.util.List;

public final class CodeSearch {

	@SerializedName("total_count")
	int totalCodeResults;

	@SerializedName("incomplete_results")
	boolean incompleteResults;

	@SerializedName("items")
	List<CodeItem> items;

	public int getTotalCodeResults() {
		return totalCodeResults;
	}

	public boolean isIncompleteResults() {
		return incompleteResults;
	}

	public List<CodeItem> getItems() {
		return items;
	}

	public static final class CodeItem {

		@SerializedName("name")
		String name;

		@SerializedName("path")
		String path;

		@SerializedName("sha")
		String sha;

		@SerializedName("url")
		String apiUrl;

		@SerializedName("git_url")
		String gitUrl;

		@SerializedName("html_url")
		String url;

		@SerializedName("repository")
		Repository repository;

		@SerializedName("score")
		int searchScore;


		public String getName() {
			return name;
		}

		public String getPath() {
			return path;
		}

		public String getSha() {
			return sha;
		}

		public String getApiUrl() {
			return apiUrl;
		}

		public String getGitUrl() {
			return gitUrl;
		}

		public String getUrl() {
			return url;
		}

		public Repository getRepository() {
			return repository;
		}

		public int getSearchScore() {
			return searchScore;
		}
	}
}
