package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Comment;
/*Author: Sanket Nadargi*/

//Repository interface for the Comment entity
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
