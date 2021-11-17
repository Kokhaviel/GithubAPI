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
import fr.kokhaviel.api.github.issues.Comment;
import fr.kokhaviel.api.github.issues.Issue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IssuesTests {

	public static void main(String[] args) {

		final Issue[] issues = GithubAPI.getRepoIssues("torvalds", "linux");
		final List<Issue> issueList = new ArrayList<>(Arrays.asList(issues));
		issueList.forEach(issue -> System.out.println(issue.getNumber() + " : " + issue.getTitle() + "\n"));


		final Issue issue = GithubAPI.getIssue("torvalds", "linux", "805");
		System.out.println(issue.getState() + " : " + issue.getTitle() + "\n");


		final Comment[] comments = GithubAPI.getRepoComments("torvalds", "linux");
		List<Comment> commentsList = new ArrayList<>(Arrays.asList(comments));
		commentsList.forEach(comment -> System.out.println(comment.getIssueUrl() + " : " + comment.getBody()));

		final Comment comment = GithubAPI.getComment("torvalds", "linux", "2006786");
		System.out.println(comment.getAuthor().getLogin() + " : " + comment.getBody());
	}
}
