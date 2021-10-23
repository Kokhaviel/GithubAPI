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
import fr.kokhaviel.api.github.gists.Gist;
import fr.kokhaviel.api.github.gists.Gists;
import fr.kokhaviel.api.github.gitignore.Gitignore;
import fr.kokhaviel.api.github.util.IOUtils;
import fr.kokhaviel.api.github.util.exceptions.GithubAPIException;
import fr.kokhaviel.api.github.watchers.stargazers.Stargazers;
import fr.kokhaviel.api.github.watchers.staring.Stars;
import fr.kokhaviel.api.github.watchers.watching.Watchers;
import fr.kokhaviel.api.github.watchers.watching.Watching;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public class GithubAPI {
//TODO : ALL toString() OVERRIDE
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

	public static Commit getCommit(String owner, String repo, String sha) {
		String githubUrl = format("https://api.github.com/repos/%s/%s/git/commits/%s", owner, repo, sha);


		Commit commit = new Commit();

		try {
			commit = GithubAPI.get(githubUrl, Commit.class);
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		return commit;
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

	private static <T> T get(String url, Class<T> classOfT) throws IllegalStateException, MalformedURLException {
		JsonObject githubObject = IOUtils.readJson(new URL(url)).getAsJsonObject();
		return GSON.fromJson(githubObject, classOfT);
	}

	@Override
	public String toString() {
		return "GithubAPI by Kokhaviel{}";
	}
}
