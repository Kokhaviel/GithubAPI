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

import fr.kokhaviel.api.github.GithubAPI;
import fr.kokhaviel.api.github.issues.IssueStatus;
import fr.kokhaviel.api.github.util.exceptions.GithubAPIException;

import java.net.MalformedURLException;

public class SearchesTests {

	public static void main(String[] args) {
		try {

			GithubAPI.searchCode("api", "java", "Kokhaviel", "HypixelAPI").getItems()
					.forEach(codeItem -> System.out.println(codeItem.getPath()));

			GithubAPI.searchCommit("Add", "Kokhaviel", "HypixelAPI").getItems()
					.forEach(commitItem -> System.out.println(commitItem.getCommit().getMessage()));

			GithubAPI.searchIssue("fix", "c", "torvalds", "linux", IssueStatus.OPENED).getItems()
					.forEach(issueItem -> System.out.println(issueItem.getTitle()));

			GithubAPI.searchRepos("linux", "c").getItems()
					.forEach(repoItem -> System.out.println(repoItem.getFullName()));

			GithubAPI.searchUser("torvalds", 0, 0).getItems()
					.forEach(user -> System.out.println(user.getLogin()));

		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Data : " + e.getMessage());
		}
	}
}
