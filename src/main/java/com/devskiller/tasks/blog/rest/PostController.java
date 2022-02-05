package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;
import com.devskiller.tasks.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.devskiller.tasks.blog.model.dto.PostDto;
import com.devskiller.tasks.blog.service.PostService;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RestController
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;
	private final CommentService commentService;


	public PostController(PostService postService, CommentService commentService) {
		this.postService = postService;
		this.commentService = commentService;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PostDto getPost(@PathVariable Long id) {
		return postService.getPost(id);
	}


	@PostMapping("/{postId}/comments")
	public ResponseEntity<Long> addComment(@PathVariable("postId") Long postId,
											      @RequestBody NewCommentDto newCommentDto) {
//		if (postId != newCommentDto.getPostId()) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "post id does not match");
//		}
		return new ResponseEntity<>(commentService.addComment(newCommentDto), HttpStatus.CREATED);
	}


	@GetMapping("/{postId}/comments")
	public ResponseEntity<List<CommentDto>> getAllComments(@PathVariable("postId") Long postId) {
		return  new ResponseEntity<>(commentService.getCommentsForPost(postId), HttpStatus.OK);
	}
}
