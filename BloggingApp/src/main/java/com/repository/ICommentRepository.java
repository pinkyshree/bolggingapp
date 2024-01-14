package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.entity.Comment;
import com.entity.Post;


@Repository
public interface ICommentRepository extends JpaRepository<Comment, Integer>
{

	@Query(value="SELECT c FROM Comment c ORDER BY commentId ")
	List<Comment> listAllCommentsByPost(String comment);
}
