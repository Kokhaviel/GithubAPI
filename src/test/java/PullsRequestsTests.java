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
import fr.kokhaviel.api.github.pulls.PullRequest;
import fr.kokhaviel.api.github.util.exceptions.GithubAPIException;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PullsRequestsTests {

	public static void main(String[] args) {
		try {
			final PullRequest[] repoPulls = GithubAPI.getRepoPulls("torvalds", "linux");
			final List<PullRequest> pullRequests = new ArrayList<>(Arrays.asList(repoPulls));
			pullRequests.forEach(pullRequest -> System.out.println(pullRequest.getCreation() + " : " + pullRequest.getTitle()));

		} catch(MalformedURLException e) {
			throw new GithubAPIException("Cannot Access Data : " + e.getMessage());
		}

	}
}
