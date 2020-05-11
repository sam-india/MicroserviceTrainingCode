package com.learn.react.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.react.model.Posts;
import com.sun.xml.internal.ws.dump.MessageDumping;

@RestController
public class PostController {
	
	@RequestMapping("/posts")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String savePost(@RequestBody Posts posts)
	{
		System.out.println(posts.getBody() +" "+ posts.getTitle() +" "+ posts.getUserId());
		return "Pass";
	}

}
