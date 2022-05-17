package br.com.clean.engine.loyalty.controller.model.response;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoyaltyCalculateResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3328814644321710222L;

	private List<ItemResponse> availableItems;
	private List<ItemResponse> selectedItems;

}
