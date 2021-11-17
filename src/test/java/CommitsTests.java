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
import fr.kokhaviel.api.github.repo.Commit;

public class CommitsTests {

	public static void main(String[] args) {

		final Commit commit = GithubAPI.getCommit("torvalds", "linux", "05d5da3cb11c91c39e607066d3313a6ce621796a");
		System.out.println(commit.getCommitter().getLogin() + " : " + commit.getCommit().getMessage());
		System.out.println(commit.getSha());
	}
}
