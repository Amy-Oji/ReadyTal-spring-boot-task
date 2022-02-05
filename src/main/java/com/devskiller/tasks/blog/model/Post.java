package com.devskiller.tasks.blog.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@Column(length = 4096)
	private String content;

	private LocalDateTime creationDate;
//	@OneToMany
//	private List<Comment> comment;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

//	public List<Comment> getComment() {
//		return comment;
//	}
//
//	public void setComment(List<Comment> comment) {
//		this.comment = comment;
//	}
}
