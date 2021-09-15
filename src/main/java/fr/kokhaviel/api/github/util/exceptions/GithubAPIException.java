package fr.kokhaviel.api.github.util.exceptions;

public class GithubAPIException extends IllegalStateException {

	public GithubAPIException() {
		super("Github API Illegal JSON Request");
	}

	public GithubAPIException(String message) {
		super(message);
	}
}
