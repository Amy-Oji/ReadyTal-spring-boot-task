package com.devskiller.tasks.blog.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long id;

	private String content;

	private String author;

	private LocalDateTime creationDate;

	@ManyToOne
	@JoinColumn(name = "post_id",referencedColumnName = "id")
	private Post post;

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setContent(String comment) {
		this.content = comment;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
