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

package fr.kokhaviel.api.github.searches;

import com.google.gson.annotations.SerializedName;
import fr.kokhaviel.api.github.issues.Issue;
import fr.kokhaviel.api.github.issues.Label;
import fr.kokhaviel.api.github.milestones.Milestone;
import fr.kokhaviel.api.github.user.User;

import java.util.List;

public final class IssueSearch {

	@SerializedName("total_count")
	int totalIssues;

	@SerializedName("incomplete_results")
	boolean incompleteResults;

	@SerializedName("items")
	List<IssueItem> items;

	public int getTotalIssues() {
		return totalIssues;
	}

	public boolean isIncompleteResults() {
		return incompleteResults;
	}

	public List<IssueItem> getItems() {
		return items;
	}

	public static final class IssueItem {

		@SerializedName("url")
		String apiUrl;

		@SerializedName("repository_url")
		String repoUrl;

		@SerializedName("labels_url")
		String labelsUrl;

		@SerializedName("comments_url")
		String commentUrl;

		@SerializedName("events_url")
		String eventsUrl;

		@SerializedName("html_url")
		String url;

		@SerializedName("id")
		long id;

		@SerializedName("node_id")
		String nodeId;

		@SerializedName("number")
		long number;

		@SerializedName("title")
		String title;

		@SerializedName("user")
		User user;

		@SerializedName("labels")
		List<Label> labels;

		@SerializedName("locked")
		boolean locked;

		@SerializedName("assignee")
		User assignee;

		@SerializedName("assignees")
		List<User> assignees;

		@SerializedName("milestone")
		Milestone milestone;

		@SerializedName("comments")
		int commentCount;

		@SerializedName("created_at")
		String creation;

		@SerializedName("updated_at")
		String update;

		@SerializedName("closed_at")
		String closed;

		@SerializedName("author_association")
		String authorAssociation;

		@SerializedName("body")
		String body;

		@SerializedName("reactions")
		Issue.Reactions reactions;

		@SerializedName("timeline_url")
		String timelineUrl;

		@SerializedName("score")
		int searchScore;


		public String getApiUrl() {
			return apiUrl;
		}

		public String getRepoUrl() {
			return repoUrl;
		}

		public String getLabelsUrl() {
			return labelsUrl;
		}

		public String getCommentUrl() {
			return commentUrl;
		}

		public String getEventsUrl() {
			return eventsUrl;
		}

		public String getUrl() {
			return url;
		}

		public long getId() {
			return id;
		}

		public String getNodeId() {
			return nodeId;
		}

		public long getNumber() {
			return number;
		}

		public String getTitle() {
			return title;
		}

		public User getUser() {
			return user;
		}

		public List<Label> getLabels() {
			return labels;
		}

		public boolean isLocked() {
			return locked;
		}

		public User getAssignee() {
			return assignee;
		}

		public List<User> getAssignees() {
			return assignees;
		}

		public Milestone getMilestone() {
			return milestone;
		}

		public int getCommentCount() {
			return commentCount;
		}

		public String getCreation() {
			return creation;
		}

		public String getUpdate() {
			return update;
		}

		public String getClosed() {
			return closed;
		}

		public String getAuthorAssociation() {
			return authorAssociation;
		}

		public String getBody() {
			return body;
		}

		public Issue.Reactions getReactions() {
			return reactions;
		}

		public String getTimelineUrl() {
			return timelineUrl;
		}

		public int getSearchScore() {
			return searchScore;
		}
	}

}
