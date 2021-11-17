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

package fr.kokhaviel.api.github.meta;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class ServerMeta {

	@SerializedName("verifiable_password_authentication")
	boolean verifiablePasswordAuthentication;

	@SerializedName("ssh_key_fingerprints")
	FingerPrints prints;

	@SerializedName("hooks")
	List<String> hooks;

	@SerializedName("web")
	List<String> web;

	@SerializedName("api")
	List<String> api;

	@SerializedName("git")
	List<String> git;

	@SerializedName("packages")
	List<String> packages;

	@SerializedName("pages")
	List<String> pages;

	@SerializedName("importer")
	List<String> importer;

	@SerializedName("actions")
	List<String> actions;

	@SerializedName("dependabot")
	List<String> dependabot;

	public boolean isVerifiablePasswordAuthentication() {
		return verifiablePasswordAuthentication;
	}

	public FingerPrints getPrints() {
		return prints;
	}

	public List<String> getHooks() {
		return hooks;
	}

	public List<String> getWeb() {
		return web;
	}

	public List<String> getApi() {
		return api;
	}

	public List<String> getGit() {
		return git;
	}

	public List<String> getPackages() {
		return packages;
	}

	public List<String> getPages() {
		return pages;
	}

	public List<String> getImporter() {
		return importer;
	}

	public List<String> getActions() {
		return actions;
	}

	public List<String> getDependabot() {
		return dependabot;
	}

	public static final class FingerPrints {

		@SerializedName("SHA256_RSA")
		String sha256RSA;

		@SerializedName("SHA256_DSA")
		String sha256DSA;

		@SerializedName("SHA256_ECDSA")
		String sha256ECDSA;

		@SerializedName("SHA256_ED25519")
		String sha256ED25519;

		public String getSha256RSA() {
			return sha256RSA;
		}

		public String getSha256DSA() {
			return sha256DSA;
		}

		public String getSha256ECDSA() {
			return sha256ECDSA;
		}

		public String getSha256ED25519() {
			return sha256ED25519;
		}
	}
}
