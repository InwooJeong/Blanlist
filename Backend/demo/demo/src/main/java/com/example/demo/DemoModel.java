package com.example.demo;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//롬복 테스트
@Builder
@RequiredArgsConstructor
public class DemoModel {
	
	@NonNull
	private String id;
}
