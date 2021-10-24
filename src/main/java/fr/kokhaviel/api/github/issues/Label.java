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

public class Label {


	@SerializedName("id")
	long id;

	@SerializedName("node_id")
	String nodeId;

	@SerializedName("url")
	String url;

	@SerializedName("name")
	String name;

	@SerializedName("description")
	String description;

	@SerializedName("color")
	String color;

	@SerializedName("default")
	boolean _default;

	public long getId() {
		return id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getColor() {
		return color;
	}

	public boolean isDefault() {
		return _default;
	}
}
