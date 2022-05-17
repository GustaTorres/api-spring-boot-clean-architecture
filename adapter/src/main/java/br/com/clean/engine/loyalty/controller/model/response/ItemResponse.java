package br.com.clean.engine.loyalty.controller.model.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3477930215047211152L;

	private Integer rph;
	private String rateToken;
	private LoyaltyResponse loyalty;

}
