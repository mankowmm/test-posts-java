package com.mm.service;

import java.util.List;

import com.mm.model.PostDto;

public interface PostsService {

	public void create(PostDto post);
	public List<PostDto> getAuthorPosts(String author);
	public List<PostDto> getAllPosts(String author);
	public void followAuthor(String requestor, String authorToFollow);
	
}
