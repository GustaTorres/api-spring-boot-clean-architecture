package br.com.clean.engine.loyalty.domain;

import java.util.Map;

import lombok.Data;

@Data
public class Item  {
	private Integer rph;
	private String rateToken;
	private Loyalty loyalty;
	private Map<String,Object> decodedRateToken;
}
