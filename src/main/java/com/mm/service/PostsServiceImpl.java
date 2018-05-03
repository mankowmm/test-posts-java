package com.mm.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mm.model.PostDto;
import com.mm.storage.AppRepository;
import com.mm.storage.PostDao;

@Component
public class PostsServiceImpl implements PostsService {
	
	@Autowired
	private AppRepository appRepository;

	public void create(PostDto post) {
		PostDao postDao = new PostDao(post.getMessage(), post.getAuthor());
		appRepository.putPost(postDao);
	}
	
	public List<PostDto> getAuthorPosts(String author) {
		List<PostDao> postsDao = appRepository.getAuthorPosts(author);
		List<PostDto> postsDto = new ArrayList<PostDto>();
		for(PostDao postDao : postsDao) {
			PostDto postDto = new PostDto(postDao.getMessage(), postDao.getAuthor());
			postsDto.add(postDto);
		}
		Collections.reverse(postsDto);
		return postsDto;
	}
	
	public List<PostDto> getAllPosts(String author) {
		List<PostDto> allPosts = new ArrayList<PostDto>();
		List<PostDto> authorPosts = this.getAuthorPosts(author);
		allPosts.addAll(authorPosts);
		List<String> followedAuthors = appRepository.getFollowedAuthors(author);
		for(String followedAuthor: followedAuthors) {
			List<PostDto> followedAuthorPosts = this.getAuthorPosts(followedAuthor);
			allPosts.addAll(followedAuthorPosts);
		}
		return allPosts;
	}
	
	
	
	public void followAuthor(String requestor, String authorToFollow) {
		appRepository.followAuthor(requestor, authorToFollow);
	}
}
