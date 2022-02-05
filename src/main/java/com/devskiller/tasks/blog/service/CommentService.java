package com.devskiller.tasks.blog.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.devskiller.tasks.blog.model.Comment;
import com.devskiller.tasks.blog.repository.CommentRepository;
import com.devskiller.tasks.blog.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CommentService {

	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
	}

	/**
	 * Returns a list of all comments for a blog post with passed id.
	 *
	 * @param postId id of the post
	 * @return list of comments sorted by creation date descending - most recent first
	 */
	public List<CommentDto> getCommentsForPost(Long postId) {
		var optPost = postRepository.findById(postId);
		if (optPost.isPresent()){
			var commentList =  commentRepository.findAllByPost_Id(postId);

			return commentList.stream().map(comment -> new CommentDto(comment.getId(), comment.getContent(),
				comment.getAuthor(), comment.getCreationDate())).collect(Collectors.toList());

		}
		throw new UnsupportedOperationException();
	}

	/**
	 * Creates a new comment
	 *
	 * @param newCommentDto data of new comment
	 * @return id of the created comment
	 *
	 * @throws IllegalArgumentException if there is no blog post for passed newCommentDto.postId
	 */
	public Long addComment(NewCommentDto newCommentDto) {
		var postId = newCommentDto.getPostId();
		var post = postRepository.findById(postId);
		if (post.isPresent()){
			Comment newComment = new Comment();
			newComment.setContent(newCommentDto.getContent());
			newComment.setAuthor(newCommentDto.getAuthor());
			newComment.setPost(post.get());
			newComment.setCreationDate(LocalDateTime.now());
			commentRepository.save(newComment);

			return commentRepository.save(newComment).getId();
		}
		throw new ResponseStatusException(HttpStatus.valueOf(404));
	}
}
