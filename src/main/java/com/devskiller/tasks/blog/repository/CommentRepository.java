package com.devskiller.tasks.blog.repository;

import com.devskiller.tasks.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findAllByPost_Id(Long postId);
}
