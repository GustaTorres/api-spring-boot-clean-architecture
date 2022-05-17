package br.com.clean.engine.loyalty.controller.model.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3477930215047211152L;

	private Integer rph;
	private String rateToken;
	private LoyaltyRequest loyalty;

}
