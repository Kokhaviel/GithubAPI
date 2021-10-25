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

package fr.kokhaviel.api.github.rate;

import com.google.gson.annotations.SerializedName;

public class RateLimit {

	@SerializedName("resources")
	Resources resources;

	public Resources getResources() {
		return resources;
	}

	public static class Resources {

		@SerializedName("core")
		ResourceAPI core;

		@SerializedName("search")
		ResourceAPI search;

		@SerializedName("graphql")
		ResourceAPI graphQL;

		@SerializedName("integration_manifest")
		ResourceAPI manifest;

		@SerializedName("code_scanning_upload")
		ResourceAPI codeScanning;

		public ResourceAPI getCore() {
			return core;
		}

		public ResourceAPI getSearch() {
			return search;
		}

		public ResourceAPI getGraphQL() {
			return graphQL;
		}

		public ResourceAPI getManifest() {
			return manifest;
		}

		public ResourceAPI getCodeScanning() {
			return codeScanning;
		}
	}

	public static class ResourceAPI {

		@SerializedName("limit")
		int limit;

		@SerializedName("remaining")
		int remaining;

		@SerializedName("reset")
		long reset;

		@SerializedName("used")
		int used;

		public int getLimit() {
			return limit;
		}

		public int getRemaining() {
			return remaining;
		}

		public long getReset() {
			return reset;
		}

		public int getUsed() {
			return used;
		}
	}
}
