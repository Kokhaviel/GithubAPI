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

import java.util.ArrayList;
import java.util.List;

public class License {


	@SerializedName("key")
	String key;

	@SerializedName("name")
	String name;

	@SerializedName("spdx_id")
	String id;

	@SerializedName("url")
	String apiUrl;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("html_url")
	String url;

	@SerializedName("description")
	String description;

	@SerializedName("implementation")
	String implementation;

	@SerializedName("permissions")
	List<String> permissions = new ArrayList<>();

	@SerializedName("conditions")
	List<String> conditions = new ArrayList<>();

	@SerializedName("limitations")
	List<String> limitations = new ArrayList<>();

	@SerializedName("body")
	String body;


	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	public String getImplementation() {
		return implementation;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public List<String> getConditions() {
		return conditions;
	}

	public List<String> getLimitations() {
		return limitations;
	}

	public String getBody() {
		return body;
	}
}
