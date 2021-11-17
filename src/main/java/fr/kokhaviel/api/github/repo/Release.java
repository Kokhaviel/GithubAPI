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

public final class Release {

	@SerializedName("url")
	String apiUrl;

	@SerializedName("assets_url")
	String assetsUrl;

	@SerializedName("upload_url")
	String uploadUrl;

	@SerializedName("html_url")
	String url;

	@SerializedName("id")
	long id;

	@SerializedName("author")
	User author;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("tag_name")
	String tagName;

	@SerializedName("target_commitish")
	String targetCommitish;

	@SerializedName("name")
	String name;

	@SerializedName("draft")
	boolean draft;

	@SerializedName("prerelease")
	boolean preRelease;

	@SerializedName("created_at")
	String creation;

	@SerializedName("published_at")
	String publication;

	@SerializedName("assets")
	List<Asset> assets;

	@SerializedName("tarball_url")
	String tarballUrl;

	@SerializedName("zipball_url")
	String zipballUrl;

	@SerializedName("body")
	String body;


	public String getApiUrl() {
		return apiUrl;
	}

	public String getAssetsUrl() {
		return assetsUrl;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public String getUrl() {
		return url;
	}

	public long getId() {
		return id;
	}

	public User getAuthor() {
		return author;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getTagName() {
		return tagName;
	}

	public String getTargetCommitish() {
		return targetCommitish;
	}

	public String getName() {
		return name;
	}

	public boolean isDraft() {
		return draft;
	}

	public boolean isPreRelease() {
		return preRelease;
	}

	public String getCreation() {
		return creation;
	}

	public String getPublication() {
		return publication;
	}

	public List<Asset> getAssets() {
		return assets;
	}

	public String getTarballUrl() {
		return tarballUrl;
	}

	public String getZipballUrl() {
		return zipballUrl;
	}

	public String getBody() {
		return body;
	}

	public static final class Asset {

		@SerializedName("url")
		String apiUrl;

		@SerializedName("id")
		long id;

		@SerializedName("node_id")
		String nodeId;

		@SerializedName("name")
		String name;

		@SerializedName("uploader")
		User uploader;

		@SerializedName("content_type")
		String contentType;

		@SerializedName("state")
		String state;

		@SerializedName("size")
		long size;

		@SerializedName("download_count")
		long downloadCount;

		@SerializedName("created_at")
		String creation;

		@SerializedName("updated_at")
		String update;

		@SerializedName("browser_download_url")
		String downloadUrl;

		public String getApiUrl() {
			return apiUrl;
		}

		public long getId() {
			return id;
		}

		public String getNodeId() {
			return nodeId;
		}

		public String getName() {
			return name;
		}

		public User getUploader() {
			return uploader;
		}

		public String getContentType() {
			return contentType;
		}

		public String getState() {
			return state;
		}

		public long getSize() {
			return size;
		}

		public long getDownloadCount() {
			return downloadCount;
		}

		public String getCreation() {
			return creation;
		}

		public String getUpdate() {
			return update;
		}

		public String getDownloadUrl() {
			return downloadUrl;
		}
	}
}
