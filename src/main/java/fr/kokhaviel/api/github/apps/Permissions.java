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

package fr.kokhaviel.api.github.apps;

import com.google.gson.annotations.SerializedName;

public class Permissions {


	@SerializedName("metadata")
	String meta = "";

	@SerializedName("contents")
	String contents = "";

	@SerializedName("issues")
	String issues = "";

	@SerializedName("single_file")
	String singleFile = "";


	public String getMeta() {
		return meta;
	}

	public String getContents() {
		return contents;
	}

	public String getIssues() {
		return issues;
	}

	public String getSingleFile() {
		return singleFile;
	}
}
