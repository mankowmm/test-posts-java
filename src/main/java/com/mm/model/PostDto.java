package com.mm.model;

import javax.validation.constraints.NotNull;

public class PostDto {
	@NotNull
	private String message;
	@NotNull
	private String author;
	
	public PostDto() {
		
	}
	public PostDto(String message, String author) {
		this.message = message;
		this.author = author;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return this.author;
	}

}
