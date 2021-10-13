package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
		
		BlanlistEntity entity = BlanlistEntity.builder().product("My first dream lego").build();
		
		repo.save(entity);
		
		BlanlistEntity savedEntity = repo.findById(entity.getId()).get();
		return savedEntity.getProduct();
	}
	
	public List<BlanlistEntity> create(final BlanlistEntity entity){
		validate(entity);
		
		repo.save(entity);
		log.info("Entity id : { } is saved.", entity.getId());
		return repo.findByUserId(entity.getUserId());
	}
	
	private void validate(final BlanlistEntity entity) {
		if(entity == null) {
			String isNull = "Entity can't be null.";
			log.warn(isNull);
			throw new RuntimeException(isNull);
		}
		
		if(entity.getUserId() == null) {
			String userIsNull = "Unknown user.";
			log.warn(userIsNull);
			throw new RuntimeException(userIsNull);
		}
	}
	
	public List<BlanlistEntity> retrieve(final String userId){
		return repo.findByUserId(userId);
	}
	
	public List<BlanlistEntity> update(final BlanlistEntity entity){
		validate(entity);
		
		final Optional<BlanlistEntity> original = repo.findById(entity.getId());
		
		original.ifPresent(blan -> {
			blan.setProduct(entity.getProduct());
			blan.setBought(entity.isBought());
			
			repo.save(blan);
		});
		
		return retrieve(entity.getUserId());
	}
	
}
