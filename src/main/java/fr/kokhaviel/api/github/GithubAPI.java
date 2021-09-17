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
import fr.kokhaviel.api.github.events.Events;
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

	public static final Gson GSON = new Gson();

	//--- Events Data Fetch ---

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

	//--- END Events Data Fetch ---


	//--- Watchers and Stargazers Data Fetch ---

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
	//--- END Watchers an Stargazers Data Fetch

	//--- Repository Actions Data Fetch

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

	//--- END Repository Actions Data Fetch

	//--- GitHub Apps Data Fetch

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


	//--- END GitHub Apps Data Fetch

	private static <T> T get(String url, Class<T> classOfT) throws IllegalStateException, MalformedURLException {
		JsonObject githubObject = IOUtils.readJson(new URL(url)).getAsJsonObject();
		return GSON.fromJson(githubObject, classOfT);
	}

	@Override
	public String toString() {
		return "GithubAPI by Kokhaviel{}";
	}
}
