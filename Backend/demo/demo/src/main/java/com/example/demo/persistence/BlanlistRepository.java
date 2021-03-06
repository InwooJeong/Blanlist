package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BlanlistEntity;

import java.util.List;

@Repository
public interface BlanlistRepository extends JpaRepository<BlanlistEntity, String>{
	List<BlanlistEntity> findByUserId(String userId);
}
