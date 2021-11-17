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
import fr.kokhaviel.api.github.user.User;
import fr.kokhaviel.api.github.util.IOUtils;
import fr.kokhaviel.api.github.util.exceptions.GithubAPIException;
import fr.kokhaviel.api.github.watchers.stargazers.Stargazers;
import fr.kokhaviel.api.github.watchers.staring.Stars;
import fr.kokhaviel.api.github.watchers.watching.Watchers;
import fr.kokhaviel.api.github.watchers.watching.Watching;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public final class GithubAPI {
//TODO : ALL toString() OVERRIDE
//TODO : UP per_page URL PARAM WHEN NEEDED

	public static final Gson GSON = new Gson();

	public static Events getAccountEvents(String accountName) {
		String githubUrl = format("https://api.github.com/users/%s/events", accountName);

		JsonArray githubEventsObject;
		try {
			githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();
		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Account Events : " + e.getMessage());
		}

		return new Events(githubEventsObject);
	}

	public static Events getRepoEvents(String account, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/events", account, repo);

		JsonArray githubEventsObject;
		try {
			githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();
		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Repo Events : " + e.getMessage());
		}

		return new Events(githubEventsObject);
	}

	public static Events getOrganisationEvents(String org) {
		String githubUrl = format("https://api.github.com/orgs/%s/events", org);

		JsonArray githubEventsObject;
		try {
			githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();
		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Organisation Events : " + e.getMessage());
		}

		return new Events(githubEventsObject);
	}

	public static Stargazers getRepoStargazers(String account, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/stargazers", account, repo);

		JsonArray githubEventsObject;
		try {
			githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();
		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Repo Stargazers : " + e.getMessage());
		}

		return new Stargazers(githubEventsObject);
	}

	public static Stars getRepoStarred(String account) {
		String githubUrl = format("https://api.github.com/users/%s/starred", account);

		JsonArray githubEventsObject;
		try {
			githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();
		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Repo Stars : " + e.getMessage());
		}

		return new Stars(githubEventsObject);
	}

	public static Watchers getRepoWatchers(String account, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/subscribers", account, repo);

		JsonArray githubEventsObject;
		try {
			githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();
		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Repo Watchers : " + e.getMessage());
		}

		return new Watchers(githubEventsObject);
	}

	public static Watching getWatchingRepo(String account) {
		String githubUrl = format("https://api.github.com/users/%s/subscriptions", account);

		JsonArray githubEventsObject;
		try {
			githubEventsObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();
		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Repo Watchers : " + e.getMessage());
		}

		return new Watching(githubEventsObject);
	}

	public static Artifacts getRepoArtifacts(String account, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/actions/artifacts", account, repo);

		Artifacts artifacts = new Artifacts();

		try {
			artifacts = GithubAPI.get(githubUrl, Artifacts.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return artifacts;
	}

	public static Artifact getRepoArtifact(String account, String repo, int artifactId) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/actions/artifacts/%s", account, repo, artifactId);

		Artifact artifact = new Artifact();

		try {
			artifact = GithubAPI.get(githubUrl, Artifact.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return artifact;
	}

	public static WorkFlows getRepoWorkFlows(String account, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/actions/workflows", account, repo);

		WorkFlows workFlows = new WorkFlows();

		try {
			workFlows = GithubAPI.get(githubUrl, WorkFlows.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return workFlows;
	}

	public static App getApp(String appName) {
		String githubUrl = format("https://api.github.com/apps/%s", appName);

		App app = new App();

		try {
			app = GithubAPI.get(githubUrl, App.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return app;
	}

	public static CodeOfConduct getCodeOfConduct(String account, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/community/code_of_conduct", account, repo);

		JsonObject githubObject = IOUtils.getPreviewGithubContent(githubUrl, 100000);

		return GSON.fromJson(githubObject, CodeOfConduct.class);
	}

	public static Emojis getEmojisData() {
		String githubUrl = "https://api.github.com/emojis";

		JsonObject emojisObject = new JsonObject();

		try {
			emojisObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonObject();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return new Emojis(emojisObject);
	}

	public static Gists getGists() {
		String githubUrl = "https://api.github.com/gists";

		JsonArray gists = new JsonArray();

		try {
			gists = IOUtils.readJson(new URL(githubUrl)).getAsJsonArray();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return new Gists(gists);
	}

	public static Gist getGist(String id) {
		String githubUrl = "https://api.github.com/gists/" + id;

		JsonObject gistObject = new JsonObject();

		try {
			gistObject = IOUtils.readJson(new URL(githubUrl)).getAsJsonObject();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return new Gist(gistObject);
	}

	public static Gitignore getGitignore(String language) {
		String githubUrl = format("https://api.github.com/gitignore/templates/%s", language);

		Gitignore gitignore = new Gitignore();

		try {
			gitignore = GithubAPI.get(githubUrl, Gitignore.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return gitignore;
	}

	public static Issue[] getRepoIssues(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/issues", owner, repo);

		Issue[] issues = new Issue[] {};

		try {
			issues = GithubAPI.getArray(githubUrl, Issue[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return issues;
	}

	public static Issue getIssue(String owner, String repo, String issueId) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/issues/%s", owner, repo, issueId);

		Issue issue = new Issue();

		try {
			issue = GithubAPI.get(githubUrl, Issue.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return issue;
	}

	public static Comment[] getRepoComments(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/issues/comments", owner, repo);

		Comment[] comments = new Comment[] {};

		try {
			comments = GithubAPI.getArray(githubUrl, Comment[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return comments;
	}

	public static Comment getComment(String owner, String repo, String commentId) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/issues/comments/%s", owner, repo, commentId);

		Comment comment = new Comment();

		try {
			comment = GithubAPI.get(githubUrl, Comment.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return comment;
	}

	public static Label[] getIssueLabels(String owner, String repo, String issueId) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/issues/%s/labels", owner, repo, issueId);

		Label[] labels = new Label[] {};

		try {
			labels = GithubAPI.getArray(githubUrl, Label[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return labels;
	}

	public static Label[] getRepoLabels(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/labels", owner, repo);

		Label[] labels = new Label[] {};

		try {
			labels = GithubAPI.getArray(githubUrl, Label[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return labels;
	}

	public static Label getLabel(String owner, String repo, String labelName) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/labels/%s", owner, repo, labelName);

		Label label = new Label();

		try {
			label = GithubAPI.get(githubUrl, Label.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return label;
	}

	public static Milestone[] getRepoMilestones(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/milestones", owner, repo);

		Milestone[] milestones = new Milestone[] {};

		try {
			milestones = GithubAPI.getArray(githubUrl, Milestone[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return milestones;
	}

	public static Milestone getMilestone(String owner, String repo, String milestoneId) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/milestones/%s", owner, repo, milestoneId);

		Milestone milestones = new Milestone();

		try {
			milestones = GithubAPI.get(githubUrl, Milestone.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return milestones;
	}

	public static Licenses[] getLicenses() {
		String githubUrl = "https://api.github.com/licenses";

		Licenses[] licenses = new Licenses[] {};

		try {
			licenses = GithubAPI.getArray(githubUrl, Licenses[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return licenses;
	}

	public static License getLicense(String licenseName) {
		String githubUrl = format("https://api.github.com/licenses/%s", licenseName);

		License license = new License();

		try {
			license = GithubAPI.get(githubUrl, License.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return license;
	}

	public static RepoLicense getRepoLicense(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/license", owner, repo);

		RepoLicense license = new RepoLicense();

		try {
			license = GithubAPI.get(githubUrl, RepoLicense.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return license;
	}

	public static APILinks getAPILinks() {
		String githubUrl = "https://api.github.com/";

		APILinks links = new APILinks();

		try {
			links = GithubAPI.get(githubUrl, APILinks.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return links;
	}

	public static ServerMeta getServerMeta() {
		String githubUrl = "https://api.github.com/meta";

		ServerMeta meta = new ServerMeta();

		try {
			meta = GithubAPI.get(githubUrl, ServerMeta.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return meta;
	}

	public static Organization getOrganization(String orgName) {
		String githubUrl = format("https://api.github.com/orgs/%s", orgName);

		Organization org = new Organization();

		try {
			org = GithubAPI.get(githubUrl, Organization.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return org;
	}

	public static UserOrg[] getUserOrgs(String user) {
		String githubUrl = format("https://api.github.com/users/%s/orgs", user);

		UserOrg[] orgs = new UserOrg[] {};

		try {
			orgs = GithubAPI.getArray(githubUrl, UserOrg[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return orgs;
	}

	public static User[] getOrgMembers(String orgName) {
		String githubUrl = format("https://api.github.com/orgs/%s/members", orgName);

		User[] users = new User[] {};

		try {
			users = GithubAPI.getArray(githubUrl, User[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public static PullRequest[] getRepoPulls(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/pulls", owner, repo);

		PullRequest[] requests = new PullRequest[] {};

		try {
			requests = GithubAPI.getArray(githubUrl, PullRequest[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return requests;
	}

	public static PullRequest getPullRequest(String owner, String repo, String pullId) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/pulls/%s", owner, repo, pullId);

		PullRequest request = new PullRequest();

		try {
			request = GithubAPI.get(githubUrl, PullRequest.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return request;
	}

	public static Commit[] getPullCommits(String owner, String repo, String pullId) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/pulls/%s/commits", owner, repo, pullId);

		Commit[] commits = new Commit[] {};

		try {
			commits = GithubAPI.getArray(githubUrl, Commit[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return commits;
	}

	public static File[] getPullFiles(String owner, String repo, String pullId) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/pulls/%s/files", owner, repo, pullId);

		File[] files = new File[] {};

		try {
			files = GithubAPI.getArray(githubUrl, File[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return files;
	}

	public static RateLimit getAPIRateLimit() {
		String githubUrl = "https://api.github.com/rate_limit";

		RateLimit limit = new RateLimit();

		try {
			limit = GithubAPI.get(githubUrl, RateLimit.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return limit;
	}


	public static Repository[] getOrgRepos(String org) {
		String githubUrl = format("https://api.github.com/orgs/%s/repos", org);

		Repository[] repos = new Repository[] {};

		try {
			repos = GithubAPI.getArray(githubUrl, Repository[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return repos;
	}

	public static Repository getRepo(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s", owner, repo);

		Repository repository = new Repository();

		try {
			repository = GithubAPI.get(githubUrl, Repository.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return repository;
	}

	public static Contributor[] getRepoContributors(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/contributors", owner, repo);

		Contributor[] contributors = new Contributor[] {};

		try {
			contributors = GithubAPI.getArray(githubUrl, Contributor[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return contributors;
	}

	public static Languages getRepoLanguages(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/languages", owner, repo);

		Languages languages = new Languages();

		try {
			languages = GithubAPI.get(githubUrl, Languages.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return languages;
	}

	public static Tag[] getRepoTags(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/tags", owner, repo);

		Tag[] tags = new Tag[] {};

		try {
			tags = GithubAPI.getArray(githubUrl, Tag[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return tags;
	}

	public static Topics getRepoTopics(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/topics", owner, repo);

		Topics topics = new Topics();

		try {
			topics = GithubAPI.get(githubUrl, Topics.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return topics;
	}

	public static Repository[] getUserRepos(String user) {
		String githubUrl = format("https://api.github.com/users/%s/repos", user);

		Repository[] repositories = new Repository[] {};

		try {
			repositories = GithubAPI.getArray(githubUrl, Repository[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return repositories;
	}

	public static BranchList[] getRepoBranches(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/branches", owner, repo);

		BranchList[] branches = new BranchList[] {};

		try {
			branches = GithubAPI.getArray(githubUrl, BranchList[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return branches;
	}

	public static fr.kokhaviel.api.github.repo.Commit[] getRepoCommits(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/commits", owner, repo);

		fr.kokhaviel.api.github.repo.Commit[] commits = new fr.kokhaviel.api.github.repo.Commit[] {};

		try {
			commits = GithubAPI.getArray(githubUrl, fr.kokhaviel.api.github.repo.Commit[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return commits;
	}

	public static Branch getBranch(String owner, String repo, String branchId) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/branches/%s", owner,repo, branchId);

		Branch branch = new Branch();
		try {
			branch = GithubAPI.get(githubUrl, Branch.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return branch;
	}

	public static fr.kokhaviel.api.github.repo.Commit getCommit(String owner, String repo, String sha) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/commits/%s", owner, repo, sha);

		fr.kokhaviel.api.github.repo.Commit commit = new fr.kokhaviel.api.github.repo.Commit();

		try {
			commit = GithubAPI.get(githubUrl, fr.kokhaviel.api.github.repo.Commit.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return commit;
	}

	public static Repository[] getForks(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/forks", owner, repo);

		Repository[] repositories = new Repository[]{};

		try {
			repositories = GithubAPI.getArray(githubUrl, Repository[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return repositories;
	}

	public static Release[] getReleases(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/releases", owner, repo);

		Release[] releases = new Release[]{};

		try {
			releases = GithubAPI.getArray(githubUrl, Release[].class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return releases;
	}

	public static Release getRelease(String owner, String repo, String name) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/releases/tags/%s", owner, repo, name);

		Release release = new Release();

		try {
			release = GithubAPI.get(githubUrl, Release.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return release;
	}

	public static Release getLastestRelease(String owner, String repo) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/releases/latest", owner, repo);

		Release release = new Release();

		try {
			release = GithubAPI.get(githubUrl, Release.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return release;
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
		return "GithubAPI by Kokhaviel{}";
	}
}
