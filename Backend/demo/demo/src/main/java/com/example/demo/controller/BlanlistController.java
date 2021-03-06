package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BlanlistDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.BlanlistEntity;
import com.example.demo.service.BlanlistService;

@RestController
@RequestMapping("blan")
public class BlanlistController {
	
	@Autowired
	private BlanlistService service;
	
	@GetMapping("/test")
	public ResponseEntity<?> testBlanlist(){
		String str = service.testService();
		List<String> list = new ArrayList<>();
		list.add(str);
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	public ResponseEntity<?> createBlanlst(@RequestBody BlanlistDTO bdto){
		try {
			// temporary version. 일단 상관없이 부트로 구현 후 프론트엔드(리액트) 합체만 생각
			String temporaryUserID = "temporary-user";
			
			BlanlistEntity entity = BlanlistDTO.toEntity(bdto);
			
			entity.setId(null);
			
			entity.setUserId(temporaryUserID);
			
			List<BlanlistEntity> entities = service.create(entity);
			
			//Stream! 다시 공부 하기@@@@!!!
			List<BlanlistDTO> bdtos = entities.stream().map(BlanlistDTO::new).collect(Collectors.toList());
			
			ResponseDTO<BlanlistDTO> response = ResponseDTO.<BlanlistDTO>builder().data(bdtos).build();
			
			return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			String error = e.getMessage();
			ResponseDTO<BlanlistDTO> response = ResponseDTO.<BlanlistDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> retrieveBlanList(){
		// temporary version. 일단 상관없이 부트로 구현 후 프론트엔드(리액트) 합체만 생각
		String temporaryUserID = "temporary-user";
		
		List<BlanlistEntity> entities = service.retrieve(temporaryUserID);
		List<BlanlistDTO> bdtos = entities.stream().map(BlanlistDTO::new).collect(Collectors.toList());
		
		ResponseDTO<BlanlistDTO> response = ResponseDTO.<BlanlistDTO>builder().data(bdtos).build();
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping
	public ResponseEntity<?> updateBlan(@RequestBody BlanlistDTO bdto){
		String temporaryUserID = "temporary-user";
		
		BlanlistEntity entity = BlanlistDTO.toEntity(bdto);
		
		entity.setUserId(temporaryUserID);
		
		List<BlanlistEntity> entities = service.update(entity);
		List<BlanlistDTO> bdtos = entities.stream().map(BlanlistDTO::new).collect(Collectors.toList());
		
		ResponseDTO<BlanlistDTO> response = ResponseDTO.<BlanlistDTO>builder().data(bdtos).build();

		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteBlan(@RequestBody BlanlistDTO bdto){
		try {
			String temporaryUserID = "temporary-user";
			
			BlanlistEntity entity = BlanlistDTO.toEntity(bdto);
			
			entity.setUserId(temporaryUserID);
			
			List<BlanlistEntity> entities = service.delete(entity);
			List<BlanlistDTO> bdtos = entities.stream().map(BlanlistDTO::new).collect(Collectors.toList());
			
			ResponseDTO<BlanlistDTO> response = ResponseDTO.<BlanlistDTO>builder().data(bdtos).build();
			
			return ResponseEntity.ok().body(response);
		}catch (Exception e) {
			String error = e.getMessage();
			ResponseDTO<BlanlistDTO> response = ResponseDTO.<BlanlistDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
}
