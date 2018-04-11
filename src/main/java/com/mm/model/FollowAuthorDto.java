package com.mm.model;

public class FollowAuthorDto {

	private String requestor;
	private String authorToFollow;
	
	public FollowAuthorDto() {
		
	}
	
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	
	public String getRequestor() {
		return this.requestor;
	}
	
	public void setAuthorToFollow(String authorToFollow) {
		this.authorToFollow = authorToFollow;
	}
	
	public String getAuthorToFollow() {
		return this.authorToFollow;
	}
	
}
