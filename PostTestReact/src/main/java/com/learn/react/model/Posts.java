package com.learn.react.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Posts {
	
	private String userId;
	private String title;
	private String body;
	
	public Posts() {

	}

	public Posts(String userId, String title, String body) {
		super();
		this.userId = userId;
		this.title = title;
		this.body = body;
	}
}
