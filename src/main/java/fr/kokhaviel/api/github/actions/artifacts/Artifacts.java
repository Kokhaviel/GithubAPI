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

package fr.kokhaviel.api.github.actions.artifacts;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Artifacts {

	@SerializedName("total_count")
	int totalArtifacts = 0;

	@SerializedName("artifacts")
	List<Artifact> artifacts = new ArrayList<>();



	public int getTotalArtifacts() {
		return totalArtifacts;
	}

	public List<Artifact> getArtifacts() {
		return artifacts;
	}
}
