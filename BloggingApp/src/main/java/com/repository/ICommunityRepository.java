package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Blogger;
import com.entity.Community;

@Repository
public interface ICommunityRepository extends JpaRepository<Community, Integer>
{
	@Query(value = "SELECT c FROM Community c ORDER BY id")
	 List<Community> listAllCommunitiesByBlogger(Blogger blogger);
	
}
