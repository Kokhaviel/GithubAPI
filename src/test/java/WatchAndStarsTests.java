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
import fr.kokhaviel.api.github.util.exceptions.GithubAPIException;

import java.net.MalformedURLException;

public class WatchAndStarsTests {

	public static void main(String[] args) {

		try {

			GithubAPI.getRepoStargazers("Kokhaviel", "Mee7").getStargazers().forEach(stargazer -> System.out.println(stargazer.getLogin()));

			GithubAPI.getRepoStarred("Kokhaviel").getStars().forEach(star -> System.out.println(star.getFullName()));

			GithubAPI.getRepoWatchers("torvalds", "linux").getWatchers().forEach(watcher -> System.out.println(watcher.getLogin()));

			GithubAPI.getWatchingRepo("Kokhaviel").getWatches().forEach(watch -> System.out.println(watch.getFullName()));


		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Data : " + e.getMessage());
		}
	}
}
