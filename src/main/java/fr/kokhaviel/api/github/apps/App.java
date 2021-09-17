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
import fr.kokhaviel.api.github.User;

public class App {

	@SerializedName("id")
	int id = 0;

	@SerializedName("slug")
	String slug = "";

	@SerializedName("node_id")
	String nodeId = "";

	@SerializedName("owner")
	User owner = new User();

	@SerializedName("name")
	String name = "";

	@SerializedName("description")
	String description = "";

	@SerializedName("external_url")
	String externalurl = "";

	@SerializedName("html_url")
	String url = "";

	@SerializedName("created_at")
	String creation = "";

	@SerializedName("updated_at")
	String update = "";

	@SerializedName("permissions")
	Permissions permissions = new Permissions();



	public int getId() {
		return id;
	}

	public String getSlug() {
		return slug;
	}

	public String getNodeId() {
		return nodeId;
	}

	public User getOwner() {
		return owner;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getExternalurl() {
		return externalurl;
	}

	public String getUrl() {
		return url;
	}

	public String getCreation() {
		return creation;
	}

	public String getUpdate() {
		return update;
	}

	public Permissions getPermissions() {
		return permissions;
	}
}
