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

package fr.kokhaviel.api.github.issues;

import com.google.gson.annotations.SerializedName;
import fr.kokhaviel.api.github.user.User;

import java.util.List;

public class Issue {

	@SerializedName("url")
	String apiUrl;

	@SerializedName("repository_url")
	String repoUrl;

	@SerializedName("labels_url")
	String labelsUrl;

	@SerializedName("comments_url")
	String commentsUrl;

	@SerializedName("events_url")
	String eventsUrl;

	@SerializedName("html_url")
	String url;

	@SerializedName("id")
	long id;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("number")
	int number;

	@SerializedName("title")
	String title;

	@SerializedName("user")
	User author;

	@SerializedName("labels")
	List<String> labels;

	@SerializedName("state")
	String state;

	@SerializedName("locked")
	boolean locked;

	@SerializedName("comments")
	int comments;

	@SerializedName("created_at")
	String creation;

	@SerializedName("updated_at")
	String update;

	@SerializedName("closed_at")
	String close;

	@SerializedName("body")
	String body;

	@SerializedName("timeline_url")
	String timeline;

	@SerializedName("reactions")
	Reactions reactions = new Reactions();


	public String getApiUrl() {
		return apiUrl;
	}

	public String getRepoUrl() {
		return repoUrl;
	}

	public String getLabelsUrl() {
		return labelsUrl;
	}

	public String getCommentsUrl() {
		return commentsUrl;
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

	public int getNumber() {
		return number;
	}

	public String getTitle() {
		return title;
	}

	public User getAuthor() {
		return author;
	}

	public List<String> getLabels() {
		return labels;
	}

	public String getState() {
		return state;
	}

	public boolean isLocked() {
		return locked;
	}

	public int getComments() {
		return comments;
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

	public String getBody() {
		return body;
	}

	public String getTimeline() {
		return timeline;
	}

	public Reactions getReactions() {
		return reactions;
	}

	public static class Reactions {

		@SerializedName("url")
		String url;

		@SerializedName("total_count")
		int total;

		@SerializedName("+1")
		int more;

		@SerializedName("-1")
		int less;

		@SerializedName("laugh")
		int laugh;

		@SerializedName("hooray")
		int hooray;

		@SerializedName("confused")
		int confused;

		@SerializedName("heart")
		int heart;

		@SerializedName("rocket")
		int rocket;

		@SerializedName("eyes")
		int eyes;

		public String getUrl() {
			return url;
		}

		public int getTotal() {
			return total;
		}

		public int getMore() {
			return more;
		}

		public int getLess() {
			return less;
		}

		public int getLaugh() {
			return laugh;
		}

		public int getHooray() {
			return hooray;
		}

		public int getConfused() {
			return confused;
		}

		public int getHeart() {
			return heart;
		}

		public int getRocket() {
			return rocket;
		}

		public int getEyes() {
			return eyes;
		}
	}
}
