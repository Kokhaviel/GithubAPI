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
import fr.kokhaviel.api.github.gists.Gist;
import fr.kokhaviel.api.github.util.exceptions.GithubAPIException;

import java.net.MalformedURLException;

public class GistsTests {

	public static void main(String[] args) {
		try {
		GithubAPI.getGists().getGists().forEach(gist -> {
			StringBuilder sb = new StringBuilder();
			sb.append(gist.getId()).append("   ").append(gist.getOwner().getLogin()).append("   ");
			gist.getFiles().getFiles().forEach(file -> sb.append(file.getName()));

			System.out.println(sb);
		});

		System.out.println();

		final Gist gist = GithubAPI.getGist("8ceebb5ff216d44c8493938bbc561c52");

		gist.getFiles().forEach(file -> System.out.println(file.getName() + " : " + file.getType()));
		System.out.println(gist.getGistData().getUrl());
		System.out.println(gist.getGistData().getOwner().getLogin());
		gist.getGistData().getCommits().forEach(commit -> System.out.println(commit.getUrl() + " : " + commit.getChanges().getTotal()));


		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Data : " + e.getMessage());
		}
	}
}
