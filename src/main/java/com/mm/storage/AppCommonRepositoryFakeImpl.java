package com.mm.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
public class AppCommonRepositoryFakeImpl implements AppRepository {
	
	private Map<String, List<PostDao>> postsMap = new HashMap<String, List<PostDao>>();
	private Map<String, List<String>> followedAuthorsMap = new HashMap<String, List<String>>();
	
	public List<PostDao> getAuthorPosts(String author) {
		List<PostDao> posts = this.postsMap.get(author);
		if(CollectionUtils.isEmpty(posts)) {
			posts = new ArrayList<PostDao>();
			this.postsMap.put(author, posts);
		}
		return posts;
	}
	
	public void putPost(PostDao post) {
		List<PostDao> posts = this.getAuthorPosts(post.getAuthor());
		posts.add(post);
	}
	
	public List<String> getFollowedAuthors(String author) {
		List<String> followedAuthors = this.followedAuthorsMap.get(author);
		if(CollectionUtils.isEmpty(followedAuthors)) {
			followedAuthors = new ArrayList<String>();
			this.followedAuthorsMap.put(author, followedAuthors);
		}
		return followedAuthors;
	}
	
	public void followAuthor(String requestor, String authorToFollow) {
		List<String> followedAuthors = this.getFollowedAuthors(requestor);
		followedAuthors.add(authorToFollow);
	}
	

}
