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

package fr.kokhaviel.api.github.actions.workflows;

import com.google.gson.annotations.SerializedName;

public class WorkFlow {

	@SerializedName("id")
	int id = 0;

	@SerializedName("node_id")
	String nodeId = "";

	@SerializedName("name")
	String name = "";

	@SerializedName("path")
	String path = "";

	@SerializedName("state")
	String state = "";

	@SerializedName("url")
	String apiUrl = "";

	@SerializedName("html_url")
	String url = "";

	@SerializedName("badge_url")
	String badgeUrl = "";

	@SerializedName("created_at")
	String creation = "";

	@SerializedName("updated_at")
	String update = "";



	public int getId() {
		return id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public String getState() {
		return state;
	}

	public String getUrl() {
		return url;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public String getBadgeUrl() {
		return badgeUrl;
	}

	public String getCreation() {
		return creation;
	}

	public String getUpdate() {
		return update;
	}
}
