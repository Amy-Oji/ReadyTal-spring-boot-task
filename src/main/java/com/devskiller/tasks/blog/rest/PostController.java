package com.devskiller.tasks.blog.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devskiller.tasks.blog.model.dto.PostDto;
import com.devskiller.tasks.blog.service.PostService;

@Controller
@RestController
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;


	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PostDto getPost(@PathVariable Long id) {
		return postService.getPost(id);
	}


}
