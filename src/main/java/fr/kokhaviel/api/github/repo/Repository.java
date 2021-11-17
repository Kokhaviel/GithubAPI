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

package fr.kokhaviel.api.github.repo;

import com.google.gson.annotations.SerializedName;
import fr.kokhaviel.api.github.user.User;

import java.util.List;

public final class Repository {

	@SerializedName("id")
	long id;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("name")
	String name;

	@SerializedName("full_name")
	String fullName;

	@SerializedName("owner")
	User owner;

	@SerializedName("private")
	boolean _private;

	@SerializedName("html_url")
	String url;

	@SerializedName("description")
	String description;

	@SerializedName("fork")
	boolean fork;

	@SerializedName("url")
	String apiUrl;

	@SerializedName("archive_url")
	String archiveUrl;

	@SerializedName("assignees_url")
	String assigneesUrl;

	@SerializedName("blobs_url")
	String blobsUrl;

	@SerializedName("branches_url")
	String branchesUrl;

	@SerializedName("collaborators_url")
	String collaboratorsUrl;

	@SerializedName("comments_url")
	String commentsUrl;

	@SerializedName("commits_url")
	String commitsUrl;

	@SerializedName("compare_url")
	String compareUrl;

	@SerializedName("contents_url")
	String contentsUrl;

	@SerializedName("contributors_url")
	String contributorsUrl;

	@SerializedName("deployments_url")
	String deploymentsUrl;

	@SerializedName("downloads_url")
	String downloadsUrl;

	@SerializedName("events_url")
	String eventsUrl;

	@SerializedName("forks_url")
	String forksUrl;

	@SerializedName("git_commits_url")
	String gitCommitsUrl;

	@SerializedName("git_refs_url")
	String gitRefsUrl;

	@SerializedName("git_tags_url")
	String gitTagsUrl;

	@SerializedName("git_url")
	String gitUrl;

	@SerializedName("issue_comment_url")
	String issuesCommentsUrl;

	@SerializedName("issue_events_url")
	String issuesEventsUrl;

	@SerializedName("issues_url")
	String issuesUrl;

	@SerializedName("keys_url")
	String keysUrl;

	@SerializedName("labels_url")
	String labelsUrl;

	@SerializedName("languages_url")
	String languagesUrl;

	@SerializedName("merges_url")
	String mergesUrl;

	@SerializedName("milestones_url")
	String milestonesUrl;

	@SerializedName("notifications_url")
	String notificationsUrl;

	@SerializedName("pulls_url")
	String pullsUrl;

	@SerializedName("releases_url")
	String releasesUrl;

	@SerializedName("ssh_url")
	String sshUrl;

	@SerializedName("stargazers_url")
	String stargazersUrl;

	@SerializedName("statuses_url")
	String statusesUrl;

	@SerializedName("subscribers_url")
	String subscribersUrl;

	@SerializedName("subscription_url")
	String subscriptionUrl;

	@SerializedName("tags_url")
	String tagsUrl;

	@SerializedName("teams_url")
	String teamsUrl;

	@SerializedName("trees_url")
	String treesUrl;

	@SerializedName("clone_url")
	String cloneUrl;

	@SerializedName("mirror_url")
	String mirrorUrl;

	@SerializedName("hooks_url")
	String hooksUrl;

	@SerializedName("svn_url")
	String svnUrl;

	@SerializedName("homepage")
	String homepage;

	@SerializedName("language")
	String language;

	@SerializedName("forks_count")
	int forksCount;

	@SerializedName("stargazers_count")
	int stargazers;

	@SerializedName("watchers_count")
	int watchers;

	@SerializedName("size")
	int size;

	@SerializedName("default_branch")
	String defaultBranch;

	@SerializedName("open_issues_count")
	int openIssues;

	@SerializedName("topics")
	List<String> topics;

	@SerializedName("has_issues")
	boolean hasIssues;

	@SerializedName("has_projects")
	boolean hasProjects;

	@SerializedName("has_wiki")
	boolean hasWiki;

	@SerializedName("has_pages")
	boolean hasPages;

	@SerializedName("has_downloads")
	boolean hasDownloads;

	@SerializedName("archived")
	boolean archived;

	@SerializedName("disabled")
	boolean disabled;

	@SerializedName("visibility")
	String visibility;

	@SerializedName("pushed_at")
	String push;

	@SerializedName("created_at")
	String creation;

	@SerializedName("updated_at")
	String update;


	public long getId() {
		return id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getName() {
		return name;
	}

	public String getFullName() {
		return fullName;
	}

	public User getOwner() {
		return owner;
	}

	public boolean isPrivate() {
		return _private;
	}

	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	public boolean isFork() {
		return fork;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public String getArchiveUrl() {
		return archiveUrl;
	}

	public String getAssigneesUrl() {
		return assigneesUrl;
	}

	public String getBlobsUrl() {
		return blobsUrl;
	}

	public String getBranchesUrl() {
		return branchesUrl;
	}

	public String getCollaboratorsUrl() {
		return collaboratorsUrl;
	}

	public String getCommentsUrl() {
		return commentsUrl;
	}

	public String getCommitsUrl() {
		return commitsUrl;
	}

	public String getCompareUrl() {
		return compareUrl;
	}

	public String getContentsUrl() {
		return contentsUrl;
	}

	public String getContributorsUrl() {
		return contributorsUrl;
	}

	public String getDeploymentsUrl() {
		return deploymentsUrl;
	}

	public String getDownloadsUrl() {
		return downloadsUrl;
	}

	public String getEventsUrl() {
		return eventsUrl;
	}

	public String getForksUrl() {
		return forksUrl;
	}

	public String getGitCommitsUrl() {
		return gitCommitsUrl;
	}

	public String getGitRefsUrl() {
		return gitRefsUrl;
	}

	public String getGitTagsUrl() {
		return gitTagsUrl;
	}

	public String getGitUrl() {
		return gitUrl;
	}

	public String getIssuesCommentsUrl() {
		return issuesCommentsUrl;
	}

	public String getIssuesEventsUrl() {
		return issuesEventsUrl;
	}

	public String getIssuesUrl() {
		return issuesUrl;
	}

	public String getKeysUrl() {
		return keysUrl;
	}

	public String getLabelsUrl() {
		return labelsUrl;
	}

	public String getLanguagesUrl() {
		return languagesUrl;
	}

	public String getMergesUrl() {
		return mergesUrl;
	}

	public String getMilestonesUrl() {
		return milestonesUrl;
	}

	public String getNotificationsUrl() {
		return notificationsUrl;
	}

	public String getPullsUrl() {
		return pullsUrl;
	}

	public String getReleasesUrl() {
		return releasesUrl;
	}

	public String getSshUrl() {
		return sshUrl;
	}

	public String getStargazersUrl() {
		return stargazersUrl;
	}

	public String getStatusesUrl() {
		return statusesUrl;
	}

	public String getSubscribersUrl() {
		return subscribersUrl;
	}

	public String getSubscriptionUrl() {
		return subscriptionUrl;
	}

	public String getTagsUrl() {
		return tagsUrl;
	}

	public String getTeamsUrl() {
		return teamsUrl;
	}

	public String getTreesUrl() {
		return treesUrl;
	}

	public String getCloneUrl() {
		return cloneUrl;
	}

	public String getMirrorUrl() {
		return mirrorUrl;
	}

	public String getHooksUrl() {
		return hooksUrl;
	}

	public String getSvnUrl() {
		return svnUrl;
	}

	public String getHomepage() {
		return homepage;
	}

	public String getLanguage() {
		return language;
	}

	public int getForksCount() {
		return forksCount;
	}

	public int getStargazers() {
		return stargazers;
	}

	public int getWatchers() {
		return watchers;
	}

	public int getSize() {
		return size;
	}

	public String getDefaultBranch() {
		return defaultBranch;
	}

	public int getOpenIssues() {
		return openIssues;
	}

	public List<String> getTopics() {
		return topics;
	}

	public boolean hasIssues() {
		return hasIssues;
	}

	public boolean hasProjects() {
		return hasProjects;
	}

	public boolean isHasWiki() {
		return hasWiki;
	}

	public boolean hasPages() {
		return hasPages;
	}

	public boolean hasDownloads() {
		return hasDownloads;
	}

	public boolean isArchived() {
		return archived;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public String getVisibility() {
		return visibility;
	}

	public String getPush() {
		return push;
	}

	public String getCreation() {
		return creation;
	}

	public String getUpdate() {
		return update;
	}
}
