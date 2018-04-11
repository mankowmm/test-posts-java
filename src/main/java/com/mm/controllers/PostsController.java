package com.mm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mm.model.FollowAuthorDto;
import com.mm.model.PostDto;
import com.mm.service.PostsService;

@RestController
public class PostsController {

	@Autowired
	private PostsService postDaoService;

	@RequestMapping(value = "/getAuthorPosts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PostDto> getAuthorPosts(@RequestParam(name = "author", required = true) String author) {
		List<PostDto> posts = postDaoService.getAuthorPost(author);
		return posts;
	}
	
	@RequestMapping(value = "/getAllPosts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PostDto> getAllPosts(@RequestParam(name = "author", required = true) String author) {
		List<PostDto> posts = postDaoService.getAllPosts(author);
		return posts;
	}

	@RequestMapping(value = "/sendPost", method = RequestMethod.POST)
	public void submitPost(@RequestBody PostDto post) {
		postDaoService.create(post);
	}
	
	@RequestMapping(value = "/followAuthor", method = RequestMethod.POST)
	public void submitPost(@RequestBody FollowAuthorDto folowAuthor) {
		postDaoService.followAuthor(folowAuthor.getRequestor(), folowAuthor.getAuthorToFollow());

	}

}
