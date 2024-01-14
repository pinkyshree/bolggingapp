package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.entity.Blogger;
import com.entity.Community;

@Repository
public interface IBloggerRepository extends JpaRepository<Blogger, Integer>
{
	@Query(value = "SELECT b FROM Blogger b ORDER BY id")
	 List<Blogger> findAllCommunity(Community community);
}
