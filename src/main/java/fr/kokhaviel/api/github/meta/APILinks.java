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

package fr.kokhaviel.api.github.meta;

import com.google.gson.annotations.SerializedName;

public class APILinks {


	@SerializedName("current_user_url")
	String currentUserUrl;

	@SerializedName("current_user_authorizations_html_url")
	String currentUserAuthorizationsHtmlUrl;

	@SerializedName("authorizations_url")
	String authorizationsUrl;

	@SerializedName("code_search_url")
	String codeSearchUrl;

	@SerializedName("commit_search_url")
	String commitSearchUrl;

	@SerializedName("emails_url")
	String emailsUrl;

	@SerializedName("emojis_url")
	String emojisUrl;

	@SerializedName("events_url")
	String eventsUrl;

	@SerializedName("feeds_url")
	String feedsUrl;

	@SerializedName("followers_url")
	String followersUrl;

	@SerializedName("following_url")
	String followingUrl;

	@SerializedName("gists_url")
	String gistsUrl;

	@SerializedName("hub_url")
	String hubUrl;

	@SerializedName("issue_search_url")
	String issueSearchUrl;

	@SerializedName("issues_url")
	String issuesUrl;

	@SerializedName("keys_url")
	String keysUrl;

	@SerializedName("label_search_url")
	String labelSearchUrl;

	@SerializedName("notifications_url")
	String notificationsUrl;

	@SerializedName("organization_url")
	String organizationUrl;

	@SerializedName("organization_repositories_url")
	String organizationRepositoriesUrl;

	@SerializedName("organization_teams_url")
	String organizationTeamsUrl;

	@SerializedName("public_gists_url")
	String publicGistsUrl;

	@SerializedName("rate_limit_url")
	String rateLimitUrl;

	@SerializedName("repository_url")
	String repositoryUrl;

	@SerializedName("repository_search_url")
	String repositorySearchUrl;

	@SerializedName("current_user_repositories_url")
	String currentUserRepositoriesUrl;

	@SerializedName("starred_url")
	String starredUrl;

	@SerializedName("starred_gists_url")
	String starredGistsUrl;

	@SerializedName("topic_search_url")
	String topicSearchUrl;

	@SerializedName("user_url")
	String userUrl;

	@SerializedName("user_organizations_url")
	String userOrganizationsUrl;

	@SerializedName("user_repositories_url")
	String userRepositoriesUrl;

	@SerializedName("user_search_url")
	String userSearchUrl;


	public String getCurrentUserUrl() {
		return currentUserUrl;
	}

	public String getCurrentUserAuthorizationsHtmlUrl() {
		return currentUserAuthorizationsHtmlUrl;
	}

	public String getAuthorizationsUrl() {
		return authorizationsUrl;
	}

	public String getCodeSearchUrl() {
		return codeSearchUrl;
	}

	public String getCommitSearchUrl() {
		return commitSearchUrl;
	}

	public String getEmailsUrl() {
		return emailsUrl;
	}

	public String getEmojisUrl() {
		return emojisUrl;
	}

	public String getEventsUrl() {
		return eventsUrl;
	}

	public String getFeedsUrl() {
		return feedsUrl;
	}

	public String getFollowersUrl() {
		return followersUrl;
	}

	public String getFollowingUrl() {
		return followingUrl;
	}

	public String getGistsUrl() {
		return gistsUrl;
	}

	public String getHubUrl() {
		return hubUrl;
	}

	public String getIssueSearchUrl() {
		return issueSearchUrl;
	}

	public String getIssuesUrl() {
		return issuesUrl;
	}

	public String getKeysUrl() {
		return keysUrl;
	}

	public String getLabelSearchUrl() {
		return labelSearchUrl;
	}

	public String getNotificationsUrl() {
		return notificationsUrl;
	}

	public String getOrganizationUrl() {
		return organizationUrl;
	}

	public String getOrganizationRepositoriesUrl() {
		return organizationRepositoriesUrl;
	}

	public String getOrganizationTeamsUrl() {
		return organizationTeamsUrl;
	}

	public String getPublicGistsUrl() {
		return publicGistsUrl;
	}

	public String getRateLimitUrl() {
		return rateLimitUrl;
	}

	public String getRepositoryUrl() {
		return repositoryUrl;
	}

	public String getRepositorySearchUrl() {
		return repositorySearchUrl;
	}

	public String getCurrentUserRepositoriesUrl() {
		return currentUserRepositoriesUrl;
	}

	public String getStarredUrl() {
		return starredUrl;
	}

	public String getStarredGistsUrl() {
		return starredGistsUrl;
	}

	public String getTopicSearchUrl() {
		return topicSearchUrl;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public String getUserOrganizationsUrl() {
		return userOrganizationsUrl;
	}

	public String getUserRepositoriesUrl() {
		return userRepositoriesUrl;
	}

	public String getUserSearchUrl() {
		return userSearchUrl;
	}
}
