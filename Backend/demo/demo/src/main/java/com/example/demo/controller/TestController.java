package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;

@RestController
@RequestMapping("test")
public class TestController {
	
	// http://localhost:8080/test
	@GetMapping
	public String testController() {
		//System.out.println("/test@@@@@@@@@@@@@@@@@@@@@@");
		return "Hello World!";
	}
	
	// http://localhost:8080/test/testGetMapping
	@GetMapping("/testGetMapping")
	public String testControllerWithPath() {
		//System.out.println("/test/testGetMapping@@@@@@@@@@@@@@@@@@@");
		return "Hellow World! testGetMapping";
	}
	
	@GetMapping("/{id}")
	public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
		return "Hello World to : " + id;
	}
	
	
	// http://localhost:8080/test/testRequestParam?id={id}
	@GetMapping("/testRequestParam")
	public String testControllerRequestParam(@RequestParam(required = false) int id) {
		return "Hello World to Param : " + id;
	}
	
	//Request Body 에 JSON 형태로 값 담아서 보내준다. -> Postman 에서 확인
	@GetMapping("/testRequestBody")
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
		return testRequestBodyDTO.getMessage() + " by " + testRequestBodyDTO.getId();
	}
	
	//받은 값을 화면에 JSON 형태로 표시
	@GetMapping("/testResponseBody")
	public ResponseDTO<String> testControllerResponseBody(){
		List<String> list = new ArrayList<>();
		list.add("Response DTO");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return response;
	}
	
	@GetMapping("/testResponseEntity")
	public ResponseEntity<?> testControllerResponseEntity(){
		List<String> list = new ArrayList<>();
		list.add("Happy 400!");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		
		return ResponseEntity.badRequest().body(response);
	}
	
}
