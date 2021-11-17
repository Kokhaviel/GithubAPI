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

public final class Artifact {

	@SerializedName("id")
	int id = 0;

	@SerializedName("node_id")
	String nodeId = "";

	@SerializedName("name")
	String name = "";

	@SerializedName("url")
	String url = "";

	@SerializedName("archive_download_url")
	String archiveUrl = "";

	@SerializedName("created_at")
	String creation = "";

	@SerializedName("updated_at")
	String update = "";

	@SerializedName("expires_at")
	String expires = "";



	public int getId() {
		return id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public String getArchiveUrl() {
		return archiveUrl;
	}

	public String getCreation() {
		return creation;
	}

	public String getUpdate() {
		return update;
	}

	public String getExpires() {
		return expires;
	}
}
