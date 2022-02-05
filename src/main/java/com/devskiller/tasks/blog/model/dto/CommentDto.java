package com.devskiller.tasks.blog.model.dto;

import java.time.LocalDateTime;

public class CommentDto {

	private Long id;

	private String comment;

	private String author;

	private LocalDateTime creationDate;

	public CommentDto(Long id, String comment, String author, LocalDateTime creationDate) {
		this.id = id;
		this.comment = comment;
		this.author = author;
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public String getAuthor() {
		return author;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}
}
