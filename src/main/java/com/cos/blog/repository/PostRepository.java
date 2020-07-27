package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.model.Post;

public interface PostRepository {
	public void save(Post post);
	public List<Post> findAll();
}
