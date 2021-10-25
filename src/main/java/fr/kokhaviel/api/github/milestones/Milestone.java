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

package fr.kokhaviel.api.github.milestones;

import com.google.gson.annotations.SerializedName;
import fr.kokhaviel.api.github.user.User;

public class Milestone {


	@SerializedName("url")
	String apiUrl;

	@SerializedName("html_url")
	String url;

	@SerializedName("labels_url")
	String labelsUrl;

	@SerializedName("id")
	long id;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("number")
	int number;

	@SerializedName("state")
	String state;

	@SerializedName("title")
	String title;

	@SerializedName("description")
	String description;

	@SerializedName("creator")
	User creator;

	@SerializedName("open_issues")
	int openedIssues;

	@SerializedName("closed_issues")
	int closedIssues;

	@SerializedName("created_at")
	String creation;

	@SerializedName("updated_at")
	String update;

	@SerializedName("closed_at")
	String close;

	@SerializedName("due_on")
	String due;


	public String getApiUrl() {
		return apiUrl;
	}

	public String getUrl() {
		return url;
	}

	public String getLabelsUrl() {
		return labelsUrl;
	}

	public long getId() {
		return id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public int getNumber() {
		return number;
	}

	public String getState() {
		return state;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public User getCreator() {
		return creator;
	}

	public int getOpenedIssues() {
		return openedIssues;
	}

	public int getClosedIssues() {
		return closedIssues;
	}

	public String getCreation() {
		return creation;
	}

	public String getUpdate() {
		return update;
	}

	public String getClose() {
		return close;
	}

	public String getDue() {
		return due;
	}
}
