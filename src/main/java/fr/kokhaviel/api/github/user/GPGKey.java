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

package fr.kokhaviel.api.github.user;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GPGKey {

	@SerializedName("id")
	long id;

	@SerializedName("key_id")
	String keyId;

	@SerializedName("raw_key")
	String rawKey;

	@SerializedName("public_key")
	String publicKey;

	@SerializedName("emails")
	List<Email> emails;

	@SerializedName("subkeys")
	List<GPGKey> subkeys;

	@SerializedName("can_sign")
	boolean canSign;

	@SerializedName("can_encrypt_comms")
	boolean canEncryptComms;

	@SerializedName("can_encrypt_storage")
	boolean canEncryptStorage;

	@SerializedName("can_certify")
	boolean canCertify;

	@SerializedName("created_at")
	String creation;

	@SerializedName("expires_at")
	String expiration;

	public long getId() {
		return id;
	}

	public String getKeyId() {
		return keyId;
	}

	public String getRawKey() {
		return rawKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public List<GPGKey> getSubkeys() {
		return subkeys;
	}

	public boolean canSign() {
		return canSign;
	}

	public boolean canEcryptComms() {
		return canEncryptComms;
	}

	public boolean canEncryptStorage() {
		return canEncryptStorage;
	}

	public boolean canCertify() {
		return canCertify;
	}

	public String getCreation() {
		return creation;
	}

	public String getExpiration() {
		return expiration;
	}

	public static class Email {

		@SerializedName("email")
		String email;

		@SerializedName("verified")
		boolean verified;

		public String getEmail() {
			return email;
		}

		public boolean isVerified() {
			return verified;
		}
	}
}
