package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BlanlistEntity;
import com.example.demo.persistence.BlanlistRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BlanlistService {
	
	@Autowired
	private BlanlistRepository repo;
	
	public String testService() {
		
		BlanlistEntity entity = BlanlistEntity.builder().title("My first dream lego").build();
		
		repo.save(entity);
		
		BlanlistEntity savedEntity = repo.findById(entity.getId()).get();
		return savedEntity.getTitle();
	}
	
}
