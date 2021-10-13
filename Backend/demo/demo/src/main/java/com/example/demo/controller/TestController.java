package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
	
	// http://localhost:8080/test
	@GetMapping
	public String testController() {
		System.out.println("/test");
		return "Hello World!";
	}
	
	// http://localhost:8080/test/testGetMapping
	@GetMapping("/testGetMapping")
	public String testControllerWithPath() {
		System.out.println("/test/testGetMapping");
		return "Hellow World! testGetMapping";
	}
	
	@GetMapping("/{id}")
	public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
		return "2Hello World to : " + id;
	}
	
}
