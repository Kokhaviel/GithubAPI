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

package fr.kokhaviel.api.github.coc;

import com.google.gson.annotations.SerializedName;

public final class CodeOfConduct {

	@SerializedName("key")
	String key = "";

	@SerializedName("name")
	String name = "";

	@SerializedName("url")
	String apiUrl = "";

	@SerializedName("body")
	String body = "";

	@SerializedName("html_url")
	String url = "";



	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public String getBody() {
		return body;
	}

	public String getUrl() {
		return url;
	}
}
