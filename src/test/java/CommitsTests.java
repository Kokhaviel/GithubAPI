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
import fr.kokhaviel.api.github.commits.Commit;

public class CommitsTests {

	public static void main(String[] args) {

		final Commit commit = GithubAPI.getCommit("Kokhaviel", "HypixelAPI", "0605a2752fe706c3cc9bd369135b6a234e00fcf4");
		System.out.println(commit.getAuthor().getName() + " : " + commit.getMessage());
		System.out.println(commit.getSha());


	}
}
