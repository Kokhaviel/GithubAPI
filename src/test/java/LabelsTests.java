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
import fr.kokhaviel.api.github.issues.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LabelsTests {

	public static void main(String[] args) {
		final Label[] labels = GithubAPI.getIssueLabels("git", "git", "1120");
		final List<Label> labelsList = new ArrayList<>(Arrays.asList(labels));
		labelsList.forEach(label -> System.out.println("[" + label.getColor() + "] " + label.getName() + " : " + label.getDescription()));

		final Label[] repoLabels = GithubAPI.getRepoLabels("git", "git");
		final List<Label> repoLabelsList = new ArrayList<>(Arrays.asList(repoLabels));
		repoLabelsList.forEach(label -> System.out.println("[" + label.getColor() + "] " + label.getName() + " : " + label.getDescription()));

		final Label label = GithubAPI.getLabel("git", "git", "new%20user");
		System.out.println("[" + label.getColor() + "] " + label.getName() + " : " + label.getDescription());
	}
}
