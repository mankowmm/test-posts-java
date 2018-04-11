package com.mm.storage;

public class PostDao {
   
    private String message;
    private String author;
    
    public PostDao() {
    }

    public PostDao(String message, String author) {
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
