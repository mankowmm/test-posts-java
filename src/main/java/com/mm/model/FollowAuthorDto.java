package com.mm.model;

import javax.validation.constraints.NotNull;

public class FollowAuthorDto {

	@NotNull
	private String requestor;
	@NotNull
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
