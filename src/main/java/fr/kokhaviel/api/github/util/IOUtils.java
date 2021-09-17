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

package fr.kokhaviel.api.github.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IOUtils {

	public static JsonElement readJson(URL jsonURL) {

		try {

			return readJson(catchForbidden(jsonURL));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return JsonNull.INSTANCE;
	}

	public static JsonElement readJson(File file) {

		JsonElement element;
		String content = "";

		try {
			content = new String(Files.readAllBytes(Paths.get(file.getPath())));
		} catch(IOException e) {
			e.printStackTrace();
		}

		element = JsonParser.parseString(content);
		return element;
	}

	private static JsonElement readJson(InputStream inputStream) {

		JsonElement element = JsonNull.INSTANCE;
		try(InputStream stream = new BufferedInputStream(inputStream)) {

			final Reader reader = new BufferedReader(new InputStreamReader(stream));
			final StringBuilder sb = new StringBuilder();

			int character;
			while((character = reader.read()) != -1) sb.append((char) character);

			element = JsonParser.parseString(sb.toString());
		} catch(IOException e) {

			e.printStackTrace();
		}

		return element;
	}

	public static JsonObject getPreviewGithubContent(String url, int timeout) {
		HttpURLConnection c = null;
		try {
			URL u = new URL(url);
			c = (HttpURLConnection) u.openConnection();
			c.setRequestMethod("GET");
			c.setRequestProperty("Content-length", "0");
			c.setRequestProperty("Accept", "application/vnd.github.scarlet-witch-preview+json");
			c.setUseCaches(false);
			c.setAllowUserInteraction(false);
			c.setConnectTimeout(timeout);
			c.setReadTimeout(timeout);
			c.connect();
			int status = c.getResponseCode();

			switch(status) {
				case 200:
				case 201:
					BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
					StringBuilder sb = new StringBuilder();
					String line;
					while((line = br.readLine()) != null) {
						sb.append(line).append("\n");
					}
					br.close();
					return JsonParser.parseString(sb.toString()).getAsJsonObject();
			}

		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if(c != null) {
				try {
					c.disconnect();
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return new JsonObject();
	}


	private static InputStream catchForbidden(URL url) throws IOException {

		final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.addRequestProperty("User-Agent", "Mozilla/5.0 AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.124 Safari/537.36");
		connection.setInstanceFollowRedirects(true);
		return connection.getInputStream();
	}
}
