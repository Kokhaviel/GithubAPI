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

package fr.kokhaviel.api.github.licenses;

import com.google.gson.annotations.SerializedName;

public final class RepoLicense {

	@SerializedName("name")
	String name;

	@SerializedName("path")
	String path;

	@SerializedName("sha")
	String sha;

	@SerializedName("size")
	long size;

	@SerializedName("url")
	String apiUrl;

	@SerializedName("html_url")
	String url;

	@SerializedName("git_url")
	String gitUrl;

	@SerializedName("download_url")
	String dlUrl;

	@SerializedName("type")
	String type;

	@SerializedName("content")
	String contents;

	@SerializedName("encoding")
	String encoding;

	@SerializedName("license")
	Licenses license = new Licenses();

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public String getSha() {
		return sha;
	}

	public long getSize() {
		return size;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public String getUrl() {
		return url;
	}

	public String getGitUrl() {
		return gitUrl;
	}

	public String getDlUrl() {
		return dlUrl;
	}

	public String getType() {
		return type;
	}

	public String getContents() {
		return contents;
	}

	public String getEncoding() {
		return encoding;
	}

	public Licenses getLicenses() {
		return license;
	}
}
