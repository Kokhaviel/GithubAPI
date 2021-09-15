package fr.kokhaviel.api.github.events;

import com.google.gson.annotations.SerializedName;

public class Event {

	@SerializedName("id")
	String id;

	@SerializedName("type")
	String type;

	@SerializedName("actor")
	Author author;

	@SerializedName("repo")
	Repo repo;

	@SerializedName("public")
	boolean _public;

	@SerializedName("created_at")
	String creation;


	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public Author getAuthor() {
		return author;
	}

	public Repo getRepo() {
		return repo;
	}

	public boolean isPublic() {
		return _public;
	}

	public String getCreation() {
		return creation;
	}


	public static class Author {

		@SerializedName("id")
		String id = "";

		@SerializedName("login")
		String login = "";

		@SerializedName("display_login")
		String displayLogin = "";

		@SerializedName("avatar_url")
		String avatar = "";


		public String getId() {
			return id;
		}

		public String getLogin() {
			return login;
		}

		public String getDisplayLogin() {
			return displayLogin;
		}

		public String getAvatar() {
			return avatar;
		}
	}

	public static class Repo {

		@SerializedName("id")
		String id = "";

		@SerializedName("name")
		String name = "";

		@SerializedName("url")
		String url = "";


		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getUrl() {
			return url;
		}
	}
}
