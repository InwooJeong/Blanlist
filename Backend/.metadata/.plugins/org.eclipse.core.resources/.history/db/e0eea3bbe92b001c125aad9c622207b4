package com.example.demo.dto;

import com.example.demo.model.BlanlistEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlanlistDTO {
	private String id;
	private String title;
	private boolean bought;
	
	public BlanlistDTO(final BlanlistEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.bought = entity.isBought();
	}
	
	public static BlanlistEntity toEntity(final BlanlistDTO bdto) {
		return BlanlistEntity.builder().id(bdto.getId())
									   .title(bdto.getTitle())
									   .bought(bdto.isBought())
									   .build();
	}
	
}
