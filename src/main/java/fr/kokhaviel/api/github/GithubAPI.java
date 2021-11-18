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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.kokhaviel.api.github.actions.artifacts.Artifact;
import fr.kokhaviel.api.github.actions.artifacts.Artifacts;
import fr.kokhaviel.api.github.actions.workflows.WorkFlows;
import fr.kokhaviel.api.github.apps.App;
import fr.kokhaviel.api.github.coc.CodeOfConduct;
import fr.kokhaviel.api.github.commits.Commit;
import fr.kokhaviel.api.github.emojis.Emojis;
import fr.kokhaviel.api.github.events.Events;
import fr.kokhaviel.api.github.files.File;
import fr.kokhaviel.api.github.gists.Gist;
import fr.kokhaviel.api.github.gists.Gists;
import fr.kokhaviel.api.github.gitignore.Gitignore;
import fr.kokhaviel.api.github.issues.Comment;
import fr.kokhaviel.api.github.issues.Issue;
import fr.kokhaviel.api.github.issues.IssueStatus;
import fr.kokhaviel.api.github.issues.Label;
import fr.kokhaviel.api.github.licenses.License;
import fr.kokhaviel.api.github.licenses.Licenses;
import fr.kokhaviel.api.github.licenses.RepoLicense;
import fr.kokhaviel.api.github.meta.APILinks;
import fr.kokhaviel.api.github.meta.ServerMeta;
import fr.kokhaviel.api.github.milestones.Milestone;
import fr.kokhaviel.api.github.orgs.Organization;
import fr.kokhaviel.api.github.orgs.UserOrg;
import fr.kokhaviel.api.github.pulls.PullRequest;
import fr.kokhaviel.api.github.rate.RateLimit;
import fr.kokhaviel.api.github.repo.*;
import fr.kokhaviel.api.github.searches.*;
import fr.kokhaviel.api.github.user.Follower;
import fr.kokhaviel.api.github.user.GPGKey;
import fr.kokhaviel.api.github.user.SSHKey;
import fr.kokhaviel.api.github.user.User;
import fr.kokhaviel.api.github.util.IOUtils;
import fr.kokhaviel.api.github.watchers.stargazers.Stargazers;
import fr.kokhaviel.api.github.watchers.staring.Stars;
import fr.kokhaviel.api.github.watchers.watching.Watchers;
import fr.kokhaviel.api.github.watchers.watching.Watching;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public final class GithubAPI {

	//TODO : ALL toString() OVERRIDE
	//TODO : Make Documentation

	public static final Gson GSON = new Gson();

	public static Events getAccountEvents(String accountName) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/users/%s/events?per_page=100", accountName);

		JsonArray githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();

		return new Events(githubEventsObject);
	}

	public static Events getRepoEvents(String account, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/events?per_page=100", account, repo);

		JsonArray githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();

		return new Events(githubEventsObject);
	}

	public static Events getOrganisationEvents(String org) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/orgs/%s/events?per_page=100", org);

		JsonArray githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();

		return new Events(githubEventsObject);
	}

	public static Stargazers getRepoStargazers(String account, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/stargazers?per_page=100", account, repo);

		JsonArray githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();

		return new Stargazers(githubEventsObject);
	}

	public static Stars getRepoStarred(String account) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/users/%s/starred?per_page=100", account);

		JsonArray githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();

		return new Stars(githubEventsObject);
	}

	public static Watchers getRepoWatchers(String account, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/subscribers?per_page=100", account, repo);

		JsonArray githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();

		return new Watchers(githubEventsObject);
	}

	public static Watching getWatchingRepo(String account) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/users/%s/subscriptions?per_page=100", account);

		JsonArray githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();

		return new Watching(githubEventsObject);
	}

	public static Artifacts getRepoArtifacts(String account, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/actions/artifacts?per_page=100", account, repo);

		return GithubAPI.get(githubUrl, Artifacts.class);
	}

	public static Artifact getRepoArtifact(String account, String repo, int artifactId) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/actions/artifacts/%s", account, repo, artifactId);

		return GithubAPI.get(githubUrl, Artifact.class);
	}

	public static WorkFlows getRepoWorkFlows(String account, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/actions/workflows?per_page=100", account, repo);

		return GithubAPI.get(githubUrl, WorkFlows.class);
	}

	public static App getApp(String appName) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/apps/%s", appName);

		return GithubAPI.get(githubUrl, App.class);
	}

	public static CodeOfConduct getCodeOfConduct(String account, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/community/code_of_conduct", account, repo);

		JsonObject githubObject = IOUtils.getPreviewGithubContent(githubUrl, 100000);

		return GSON.fromJson(githubObject, CodeOfConduct.class);
	}

	public static Emojis getEmojisData() throws MalformedURLException {
		String githubUrl = "https://api.github.com/emojis";

		JsonObject emojisObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonObject();

		return new Emojis(emojisObject);
	}

	public static Gists getGists() throws MalformedURLException {
		String githubUrl = "https://api.github.com/gists?per_page=100";

		JsonArray gists = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();

		return new Gists(gists);
	}

	public static Gist getGist(String id) throws MalformedURLException {
		String githubUrl = "https://api.github.com/gists/" + id;

		JsonObject gistObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonObject();

		return new Gist(gistObject);
	}

	public static Gitignore getGitignore(String language) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/gitignore/templates/%s", language);

		return GithubAPI.get(githubUrl, Gitignore.class);
	}

	public static Issue[] getRepoIssues(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/issues?per_page=100", owner, repo);

		return GithubAPI.getArray(githubUrl, Issue[].class);
	}

	public static Issue getIssue(String owner, String repo, String issueId) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/issues/%s", owner, repo, issueId);

		return GithubAPI.get(githubUrl, Issue.class);
	}

	public static Comment[] getRepoComments(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/issues/comments?per_page=100", owner, repo);

		return GithubAPI.getArray(githubUrl, Comment[].class);
	}

	public static Comment getComment(String owner, String repo, String commentId) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/issues/comments/%s", owner, repo, commentId);

		return GithubAPI.get(githubUrl, Comment.class);
	}

	public static Label[] getIssueLabels(String owner, String repo, String issueId) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/issues/%s/labels?per_page=100", owner, repo, issueId);

		return GithubAPI.getArray(githubUrl, Label[].class);
	}

	public static Label[] getRepoLabels(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/labels?per_page=100", owner, repo);

		return GithubAPI.getArray(githubUrl, Label[].class);
	}

	public static Label getLabel(String owner, String repo, String labelName) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/labels/%s", owner, repo, labelName);

		return GithubAPI.get(githubUrl, Label.class);
	}

	public static Milestone[] getRepoMilestones(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/milestones?per_page=100", owner, repo);

		return GithubAPI.getArray(githubUrl, Milestone[].class);
	}

	public static Milestone getMilestone(String owner, String repo, String milestoneId) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/milestones/%s", owner, repo, milestoneId);

		return GithubAPI.get(githubUrl, Milestone.class);
	}

	public static Licenses[] getLicenses() throws MalformedURLException {
		String githubUrl = "https://api.github.com/licenses";

		return GithubAPI.getArray(githubUrl, Licenses[].class);
	}

	public static License getLicense(String licenseName) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/licenses/%s", licenseName);

		return GithubAPI.get(githubUrl, License.class);
	}

	public static RepoLicense getRepoLicense(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/license", owner, repo);

		return GithubAPI.get(githubUrl, RepoLicense.class);
	}

	public static APILinks getAPILinks() throws MalformedURLException {
		String githubUrl = "https://api.github.com/";

		return GithubAPI.get(githubUrl, APILinks.class);
	}

	public static ServerMeta getServerMeta() throws MalformedURLException {
		String githubUrl = "https://api.github.com/meta";

		return GithubAPI.get(githubUrl, ServerMeta.class);
	}

	public static Organization getOrganization(String orgName) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/orgs/%s", orgName);

		return GithubAPI.get(githubUrl, Organization.class);
	}

	public static UserOrg[] getUserOrgs(String user) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/users/%s/orgs?per_page=100", user);

		return GithubAPI.getArray(githubUrl, UserOrg[].class);
	}

	public static User[] getOrgMembers(String orgName) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/orgs/%s/members?per_page=100", orgName);

		return GithubAPI.getArray(githubUrl, User[].class);
	}

	public static PullRequest[] getRepoPulls(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/pulls?per_page=100", owner, repo);

		return GithubAPI.getArray(githubUrl, PullRequest[].class);
	}

	public static PullRequest getPullRequest(String owner, String repo, String pullId) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/pulls/%s", owner, repo, pullId);

		return GithubAPI.get(githubUrl, PullRequest.class);
	}

	public static Commit[] getPullCommits(String owner, String repo, String pullId) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/pulls/%s/commits?per_page=100", owner, repo, pullId);

		return GithubAPI.getArray(githubUrl, Commit[].class);
	}

	public static File[] getPullFiles(String owner, String repo, String pullId) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/pulls/%s/files?per_page=100", owner, repo, pullId);

		return GithubAPI.getArray(githubUrl, File[].class);
	}

	public static RateLimit getAPIRateLimit() throws MalformedURLException {
		String githubUrl = "https://api.github.com/rate_limit";

		return GithubAPI.get(githubUrl, RateLimit.class);
	}


	public static Repository[] getOrgRepos(String org) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/orgs/%s/repos?per_page=100", org);

		return GithubAPI.getArray(githubUrl, Repository[].class);
	}

	public static Repository getRepo(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s", owner, repo);

		return GithubAPI.get(githubUrl, Repository.class);
	}

	public static Contributor[] getRepoContributors(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/contributors?per_page=100", owner, repo);

		return GithubAPI.getArray(githubUrl, Contributor[].class);
	}

	public static Languages getRepoLanguages(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/languages", owner, repo);

		return GithubAPI.get(githubUrl, Languages.class);
	}

	public static Tag[] getRepoTags(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/tags?per_page=100", owner, repo);

		return GithubAPI.getArray(githubUrl, Tag[].class);
	}

	public static Topics getRepoTopics(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/topics", owner, repo);

		return GithubAPI.get(githubUrl, Topics.class);
	}

	public static Repository[] getUserRepos(String user) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/users/%s/repos?per_page=100", user);

		return GithubAPI.getArray(githubUrl, Repository[].class);
	}

	public static BranchList[] getRepoBranches(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/branches?per_page=100", owner, repo);

		return GithubAPI.getArray(githubUrl, BranchList[].class);
	}

	public static fr.kokhaviel.api.github.repo.Commit[] getRepoCommits(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/commits?per_page=100", owner, repo);

		return GithubAPI.getArray(githubUrl, fr.kokhaviel.api.github.repo.Commit[].class);
	}

	public static Branch getBranch(String owner, String repo, String branchId) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/branches/%s", owner, repo, branchId);

		return GithubAPI.get(githubUrl, Branch.class);
	}

	public static fr.kokhaviel.api.github.repo.Commit getCommit(String owner, String repo, String sha) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/commits/%s", owner, repo, sha);

		return GithubAPI.get(githubUrl, fr.kokhaviel.api.github.repo.Commit.class);
	}

	public static Repository[] getForks(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/forks?per_page=100", owner, repo);

		return GithubAPI.getArray(githubUrl, Repository[].class);
	}

	public static Release[] getReleases(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/releases?per_page=100", owner, repo);

		return GithubAPI.getArray(githubUrl, Release[].class);
	}

	public static Release getRelease(String owner, String repo, String name) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/releases/tags/%s", owner, repo, name);

		return GithubAPI.get(githubUrl, Release.class);
	}

	public static Release getLatestRelease(String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/repos/%s/%s/releases/latest", owner, repo);

		return GithubAPI.get(githubUrl, Release.class);
	}

	public static CodeSearch searchCode(String search, String lang, String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/search/code?q=%s+in:file+language:%s+repo:%s/%s&per_page=100",
				search.replace(" ", "%20"),
				lang.replace(" ", "%20"), owner, repo);

		return GithubAPI.get(githubUrl, CodeSearch.class);
	}

	public static CommitSearch searchCommit(String search, String owner, String repo) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/search/commits?q=repo:%s/%s+%s&per_page=100",
				owner, repo, search.replace(" ", "%20"));

		return GithubAPI.get(githubUrl, CommitSearch.class);
	}

	public static IssueSearch searchIssue(String search, String lang,
										  String owner, String repo, IssueStatus status) throws MalformedURLException {

		StringBuilder githubUrl = new StringBuilder("https://api.github.com/search/issues?q=");
		githubUrl.append(search).append("+language:").append(lang);
		githubUrl.append(format("+repo:%s/%s", owner,repo));
		switch(status) {
			case OPENED:
				githubUrl.append("+state:open");
				break;
			case CLOSED:
				githubUrl.append("+state:closed");
				break;
		}
		githubUrl.append("&sort=created&order=asc");
		githubUrl.append("&per_page=100");

		return GithubAPI.get(githubUrl.toString(), IssueSearch.class);
	}

	public static ReposSearch searchRepos(String repo, String lang) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/search/repositories?q=%s+language:%s&sort=stars&order=desc&per_page=100", repo, lang);

		return GithubAPI.get(githubUrl, ReposSearch.class);
	}

	public static UserSearch searchUser(String user, int minimumRepos, int minimumFollowers) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/search/users?q=%s+repos:%s+followers:%s&sort=desc&per_page=100",
				user, "%3E" + minimumRepos, "%3E" + minimumFollowers);

		return GithubAPI.get(githubUrl, UserSearch.class);
	}

	public static User[] getUsers() throws MalformedURLException {
		String githubUrl = "https://api.github.com/users?sort=desc&per_page=100";

		return GithubAPI.getArray(githubUrl, User[].class);
	}

	public static User getUser(String username) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/users/%s", username);

		return GithubAPI.get(githubUrl, User.class);
	}

	public static Follower[] getFollowers(String username) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/users/%s/followers?per_page=100", username);

		return GithubAPI.getArray(githubUrl, Follower[].class);
	}

	public static Follower[] getFollowing(String username) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/users/%s/following?per_page=100", username);

		return GithubAPI.getArray(githubUrl, Follower[].class);
	}

	public static SSHKey[] getUserSSHKeys(String username) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/users/%s/keys?per_page=100", username);

		return GithubAPI.getArray(githubUrl, SSHKey[].class);
	}

	public static GPGKey[] getUserGPGKeys(String username) throws MalformedURLException {
		String githubUrl = format("https://api.github.com/users/%s/gpg_keys?per_page=100", username);

		return GithubAPI.getArray(githubUrl, GPGKey[].class);
	}

	private static <T> T get(String url, Class<T> classOfT) throws IllegalStateException, MalformedURLException {
		JsonObject githubObject = IOUtils.readJson(new URL(url)).getAsJsonObject();
		return GSON.fromJson(githubObject, classOfT);
	}

	private static <T> T[] getArray(String url, Class<T[]> classOfT) throws IllegalStateException, MalformedURLException {
		JsonArray githubObject = IOUtils.readJson(new URL(url)).getAsJsonArray();
		return GSON.fromJson(githubObject, classOfT);
	}

	@Override
	public String toString() {
		return "GithubAPI {\n" +
				"Author : Kokhaviel\n" +
				"Discord : Kokhaviel.java#2192" +
 				"Github : github.com/Kokhaviel\n" +
				"License : Apache 2.0\n" +
				"Libraries : Gson" +
				"}";
	}
}
