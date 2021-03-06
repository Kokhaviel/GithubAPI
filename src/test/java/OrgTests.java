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
import fr.kokhaviel.api.github.orgs.Organization;
import fr.kokhaviel.api.github.orgs.UserOrg;
import fr.kokhaviel.api.github.user.User;
import fr.kokhaviel.api.github.util.exceptions.GithubAPIException;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

public class OrgTests {

	public static void main(String[] args) {

		try {
			final Organization org = GithubAPI.getOrganization("Paladium-Developpement");
			System.out.println(org.getName() + " : " + org.getBlog());

			final UserOrg[] user = GithubAPI.getUserOrgs("Chaika9");
			List<UserOrg> userOrgs = Arrays.asList(user);
			userOrgs.forEach(userOrg -> System.out.println(userOrg.getLogin() + " : " + userOrg.getApiUrl()));

			final User[] users = GithubAPI.getOrgMembers("Paladium-Developpement");
			List<User> userList = Arrays.asList(users);
			userList.forEach(user1 -> System.out.println(user1.getLogin() + " : " + user1.getUrl()));

		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Data : " + e.getMessage());
		}
	}
}
