package com.mm.storage;

import java.util.List;

public interface AppRepository {

	public List<PostDao> getAuthorPosts(String author);
	public void putPost(PostDao post);
	public List<String> getFollowedAuthors(String author);
	public void followAuthor(String requestor, String authorToFollow);
}
