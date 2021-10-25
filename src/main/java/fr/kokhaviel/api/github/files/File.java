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

package fr.kokhaviel.api.github.files;

import com.google.gson.annotations.SerializedName;

public class File {

	@SerializedName("sha")
	String sha;

	@SerializedName("filename")
	String name;

	@SerializedName("status")
	String status;

	@SerializedName("additions")
	long additions;

	@SerializedName("deletions")
	long deletions;

	@SerializedName("changes")
	long changes;

	@SerializedName("blob_url")
	String blobUrl;

	@SerializedName("raw_url")
	String rawUrl;

	@SerializedName("contents_url")
	String contentsUrl;

	@SerializedName("patch")
	String patch;


	public String getSha() {
		return sha;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public long getAdditions() {
		return additions;
	}

	public long getDeletions() {
		return deletions;
	}

	public long getChanges() {
		return changes;
	}

	public String getBlobUrl() {
		return blobUrl;
	}

	public String getRawUrl() {
		return rawUrl;
	}

	public String getContentsUrl() {
		return contentsUrl;
	}

	public String getPatch() {
		return patch;
	}
}
