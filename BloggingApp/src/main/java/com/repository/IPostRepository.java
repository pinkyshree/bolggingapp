package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Blogger;
import com.entity.Post;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer>
{
	@Query(value="SELECT p FROM Post p ORDER BY id")
	List<Post> getPostByBlogger(Blogger blogger);
	

}
