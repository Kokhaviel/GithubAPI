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
import fr.kokhaviel.api.github.licenses.License;
import fr.kokhaviel.api.github.licenses.Licenses;
import fr.kokhaviel.api.github.licenses.RepoLicense;
import fr.kokhaviel.api.github.util.exceptions.GithubAPIException;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LicensesTests {

	public static void main(String[] args) {
		try {
			final Licenses[] licenses = GithubAPI.getLicenses();
			List<Licenses> licensesList = new ArrayList<>(Arrays.asList(licenses));
			licensesList.forEach(license -> System.out.println(license.getName() + " : " + license.getUrl() + "\n"));


			final License license = GithubAPI.getLicense("apache-2.0");
			System.out.println(license.getName() + " : " + license.getBody() + "\n");

			RepoLicense repoLicense = GithubAPI.getRepoLicense("Kokhaviel", "HypixelAPI");
			System.out.println(repoLicense.getName() + " : " + repoLicense.getUrl());

		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Data : " + e.getMessage());
		}
	}
}
