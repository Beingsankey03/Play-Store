package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Download;
/*Author: Sanket Nadargi*/

//Repository interface for the Download entity
@Repository
public interface DownloadRepository extends JpaRepository<Download,Long> {
	

}
