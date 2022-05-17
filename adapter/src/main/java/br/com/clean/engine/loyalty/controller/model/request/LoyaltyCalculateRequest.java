package br.com.clean.engine.loyalty.controller.model.request;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoyaltyCalculateRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9075491759365621765L;

	private List<ItemRequest> availableItems;
	private List<ItemRequest> selectedItems;
	private ParamsRequest params;
}
