package br.com.clean.engine.loyalty.dataprovider;

import static java.util.stream.Collectors.toList;

import java.util.List;

import br.com.clean.engine.loyalty.domain.Item;
import org.springframework.stereotype.Component;

import br.com.clean.engine.loyalty.domain.LoyaltyCalculate;
import br.com.clean.engine.loyalty.usecase.port.RateTokenGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RateTokenDataProvider implements RateTokenGateway {
	@Override
	public void deserializeRateToken(final LoyaltyCalculate loyaltyCalculate) {
		final List<Item> availableItems = decodeRateToken(loyaltyCalculate.getAvailableItems());
		final List<Item> selectedItems = decodeRateToken(loyaltyCalculate.getSelectedItems());
		loyaltyCalculate.setAvailableItems(availableItems);
		loyaltyCalculate.setSelectedItems(selectedItems);
	}
	
	public List<Item> decodeRateToken(final List<Item> items) {
		return items
				.stream()
				.map(this::decodeRateToken)
				.collect(toList());
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public Item decodeRateToken(final Item item) {
		final var rateToken = item.getRateToken();
//		final RateToken rateTokenDeserialized = tokenUtil.deserializeToken(rateToken);
//		final Map<String, Object> decodedRateToken = new ObjectMapper().convertValue(rateTokenDeserialized, Map.class);
//		item.setDecodedRateToken(decodedRateToken);
		return item;
	}

}
