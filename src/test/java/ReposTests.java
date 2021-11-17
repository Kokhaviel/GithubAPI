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
import fr.kokhaviel.api.github.repo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReposTests {

	public static void main(String[] args) {
		final Repository[] orgRepos = GithubAPI.getOrgRepos("Paladium-Developpement");
		final List<Repository> repositories = new ArrayList<>(Arrays.asList(orgRepos));
		repositories.forEach(repository -> System.out.println(repository.getName() + " : " + repository.getDescription()));

		Repository repo = GithubAPI.getRepo("Kokhaviel", "HypixelAPI");
		System.out.print(repo.getName() + " : ");
		repo.getTopics().forEach(topic -> System.out.print(topic + ", "));

		Contributor[] contributors = GithubAPI.getRepoContributors("git", "git");
		final List<Contributor> contributorsList = new ArrayList<>(Arrays.asList(contributors));
		contributorsList.forEach(contributor -> System.out.println(contributor.getLogin() + " : " + contributor.getContributions()));

		Languages languages = GithubAPI.getRepoLanguages("torvalds", "linux");
		System.out.println("Assembly : " + languages.getAsm());

		List<Tag> tags = new ArrayList<>(Arrays.asList(GithubAPI.getRepoTags("torvalds", "linux")));
		tags.forEach(tag -> System.out.println(tag.getName() + " : " + tag.getTarBall()));

		final Topics repoTopics = GithubAPI.getRepoTopics("Kokhaviel", "HypixelAPI");
		repoTopics.getTopics().forEach(System.out::println);

		List<Repository> repositoriesList = new ArrayList<>(Arrays.asList(GithubAPI.getUserRepos("Kokhaviel")));
		repositoriesList.forEach(repository -> System.out.println(repository.getName() + " : " + repository.getDescription()));

		List<BranchList> branches = Arrays.asList(GithubAPI.getRepoBranches("Kokhaviel", "HypixelAPI"));
		branches.forEach(branch -> System.out.println(branch.getName() + " : " + branch.getCommit().getUrl()));

		Branch branch = GithubAPI.getBranch("Kokhaviel", "HypixelAPI", "4.3");
		System.out.println(branch.getAuthor().getLogin() + " : " + branch.getCommit().getMessage());

		List<Repository> forks = Arrays.asList(GithubAPI.getForks("torvalds", "linux"));
		forks.forEach(repository -> System.out.println(repository.getFullName() + " : " + repository.getOwner().getLogin()));

		List<Release> releases = Arrays.asList(GithubAPI.getReleases("Kokhaviel", "HypixelAPI"));
		releases.forEach(release -> System.out.println(release.getName()));
	}
}
