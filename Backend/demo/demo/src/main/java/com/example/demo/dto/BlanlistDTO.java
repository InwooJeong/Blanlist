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
	private String product;
	private boolean bought;
	
	public BlanlistDTO(final BlanlistEntity entity) {
		this.id = entity.getId();
		this.product = entity.getProduct();
		this.bought = entity.isBought();
	}
	
	public static BlanlistEntity toEntity(final BlanlistDTO bdto) {
		return BlanlistEntity.builder().id(bdto.getId())
									   .product(bdto.getProduct())
									   .bought(bdto.isBought())
									   .build();
	}
	
}
