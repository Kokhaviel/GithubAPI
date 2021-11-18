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
import java.util.Arrays;

public class UserTests {

	public static void main(String[] args) {
		try {
			System.out.println(GithubAPI.getUser("Kokhaviel").getBio());

			Arrays.asList(GithubAPI.getFollowers("Kokhaviel")).forEach(follower -> System.out.println(follower.getLogin()));

			Arrays.asList(GithubAPI.getFollowing("Kokhaviel")).forEach(follower -> System.out.println(follower.getLogin()));

			Arrays.asList(GithubAPI.getUserSSHKeys("Kokhaviel")).forEach(sshKey -> System.out.println(sshKey.getKey()));

			Arrays.asList(GithubAPI.getUserGPGKeys("Kokhaviel")).forEach(gpgKey -> System.out.println(gpgKey.getPublicKey()));

		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot access data : " + e.getMessage());
		}
	}
}
