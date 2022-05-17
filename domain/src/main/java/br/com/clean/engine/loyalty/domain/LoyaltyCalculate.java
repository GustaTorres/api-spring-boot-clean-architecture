package br.com.clean.engine.loyalty.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import lombok.Data;

@Data
public class LoyaltyCalculate {
	private List<Item> availableItems;
	private List<Item> selectedItems;
	private Params params;

	public List<Item> getAllItems() {
		return Stream
				.concat(this.availableItems.stream(), this.selectedItems.stream())
				.collect(toList());
	}
}
