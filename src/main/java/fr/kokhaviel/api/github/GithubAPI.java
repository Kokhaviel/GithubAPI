package fr.kokhaviel.api.github;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.kokhaviel.api.github.events.Events;
import fr.kokhaviel.api.github.util.IOUtils;
import fr.kokhaviel.api.github.util.exceptions.GithubAPIException;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public class GithubAPI {

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


	private <T> T get(String url, Class<T> classOfT) throws IllegalStateException, MalformedURLException {
		JsonObject githubObject = IOUtils.readJson(new URL(url)).getAsJsonObject();
		return GSON.fromJson(githubObject, classOfT);
	}

	@Override
	public String toString() {
		return "GithubAPI by Kokhaviel{}";
	}
}
