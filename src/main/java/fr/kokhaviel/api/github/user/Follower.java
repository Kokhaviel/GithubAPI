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

package fr.kokhaviel.api.github.user;

import com.google.gson.annotations.SerializedName;

public class Follower {

	@SerializedName("login")
	String login;

	@SerializedName("id")
	String id;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("avatar_url")
	String avatarUrl;

	@SerializedName("url")
	String apiUrl;

	@SerializedName("html_url")
	String url;

	@SerializedName("followers_url")
	String followersUrl;

	@SerializedName("following_url")
	String followingUrl;

	@SerializedName("gists_url")
	String gistsUrl;

	@SerializedName("starred_url")
	String starredUrl;

	@SerializedName("subscriptions_url")
	String subscriptionsUrl;

	@SerializedName("organizations_url")
	String organizationsUrl;

	@SerializedName("repos_url")
	String reposUrl;

	@SerializedName("events_url")
	String eventsUrl;

	@SerializedName("received_events_url")
	String receivedEventsUrl;

	@SerializedName("type")
	String type;

	@SerializedName("site_admin")
	boolean siteAdmin;



	public String getLogin() {
		return login;
	}

	public String getId() {
		return id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public String getUrl() {
		return url;
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

	public String getStarredUrl() {
		return starredUrl;
	}

	public String getSubscriptionsUrl() {
		return subscriptionsUrl;
	}

	public String getOrganizationsUrl() {
		return organizationsUrl;
	}

	public String getReposUrl() {
		return reposUrl;
	}

	public String getEventsUrl() {
		return eventsUrl;
	}

	public String getReceivedEventsUrl() {
		return receivedEventsUrl;
	}

	public String getType() {
		return type;
	}

	public boolean isSiteAdmin() {
		return siteAdmin;
	}
}