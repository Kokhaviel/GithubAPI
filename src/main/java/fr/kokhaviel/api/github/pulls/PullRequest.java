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

package fr.kokhaviel.api.github.pulls;

import com.google.gson.annotations.SerializedName;
import fr.kokhaviel.api.github.issues.Label;
import fr.kokhaviel.api.github.milestones.Milestone;
import fr.kokhaviel.api.github.repo.Branch;
import fr.kokhaviel.api.github.user.User;

import java.util.List;

public class PullRequest {

	@SerializedName("url")
	String apiUrl;

	@SerializedName("id")
	long id;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("html_url")
	String url;

	@SerializedName("diff_url")
	String diffUrl;

	@SerializedName("patch_url")
	String patchUrl;

	@SerializedName("issue_url")
	String issueUrl;

	@SerializedName("commits_url")
	String commitsUrl;

	@SerializedName("statuses_url")
	String statusesUrl;

	@SerializedName("number")
	int number;

	@SerializedName("state")
	String state;

	@SerializedName("locked")
	boolean locked;

	@SerializedName("title")
	String title;

	@SerializedName("user")
	User author;

	@SerializedName("body")
	String body;

	@SerializedName("labels")
	List<Label> labels;

	@SerializedName("milestone")
	Milestone milestone;

	@SerializedName("active_lock_reason")
	String lockReason;

	@SerializedName("created_at")
	String creation;

	@SerializedName("updated_at")
	String update;

	@SerializedName("closed_at")
	String close;

	@SerializedName("merged_at")
	String merge;

	@SerializedName("merge_commit_sha")
	String mergeSHA;

	@SerializedName("assignee")
	User assignee;

	@SerializedName("assignees")
	List<User> assignees;

	@SerializedName("head")
	Branch head;

	@SerializedName("base")
	Branch base;

	@SerializedName("draft")
	boolean draft;

	@SerializedName("merged")
	boolean merged;

	@SerializedName("mergeable")
	boolean mergeable;

	@SerializedName("rebaseable")
	boolean rebaseable;

	@SerializedName("mergeable_state")
	String mergeableState;

	@SerializedName("merged_by")
	User mergedBy;

	@SerializedName("comments")
	int comment;

	@SerializedName("commits")
	int commits;

	@SerializedName("additions")
	long additions;

	@SerializedName("deletions")
	long deletions;

	@SerializedName("changed_files")
	int changedFiles;


	public String getApiUrl() {
		return apiUrl;
	}

	public long getId() {
		return id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getUrl() {
		return url;
	}

	public String getDiffUrl() {
		return diffUrl;
	}

	public String getPatchUrl() {
		return patchUrl;
	}

	public String getIssueUrl() {
		return issueUrl;
	}

	public String getCommitsUrl() {
		return commitsUrl;
	}

	public String getStatuesUrl() {
		return statusesUrl;
	}

	public int getNumber() {
		return number;
	}

	public String getState() {
		return state;
	}

	public boolean isLocked() {
		return locked;
	}

	public String getTitle() {
		return title;
	}

	public User getAuthor() {
		return author;
	}

	public String getBody() {
		return body;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public Milestone getMilestone() {
		return milestone;
	}

	public String getLockReason() {
		return lockReason;
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

	public String getMerge() {
		return merge;
	}

	public String getMergeSHA() {
		return mergeSHA;
	}

	public User getAssignee() {
		return assignee;
	}

	public List<User> getAssignees() {
		return assignees;
	}

	public Branch getHead() {
		return head;
	}

	public Branch getBase() {
		return base;
	}

	public boolean isDraft() {
		return draft;
	}

	public boolean isMerged() {
		return merged;
	}

	public boolean isMergeable() {
		return mergeable;
	}

	public boolean isRebaseable() {
		return rebaseable;
	}

	public String getMergeableState() {
		return mergeableState;
	}

	public User getMergedBy() {
		return mergedBy;
	}

	public int getComment() {
		return comment;
	}

	public int getCommits() {
		return commits;
	}

	public long getAdditions() {
		return additions;
	}

	public long getDeletions() {
		return deletions;
	}

	public int getChangedFiles() {
		return changedFiles;
	}
}
