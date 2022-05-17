package br.com.clean.engine.loyalty.usecase;

import br.com.clean.engine.loyalty.domain.Item;
import br.com.clean.engine.loyalty.domain.LoyaltyCalculate;
import br.com.clean.engine.loyalty.usecase.port.BucketsDSGateway;
import br.com.clean.engine.loyalty.usecase.port.RateTokenGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;

@RequiredArgsConstructor
public class LoyaltyCalculationUseCase {

	private final BucketsDSGateway bucketsDSGateway;
	private final RateTokenGateway rateTokenGateway;

	private static final Integer ZERO = 0;
	private static final BigDecimal MAX_PERCENT = BigDecimal.valueOf(1.0);
	private static final String SHARE = "share";

	public LoyaltyCalculate calculate(final LoyaltyCalculate loyaltyCalculate) {
		Assert
		.isTrue(
				!isEmpty(loyaltyCalculate.getAvailableItems()) || 
				!isEmpty(loyaltyCalculate.getSelectedItems()),
				"availableItems or selectedItems should be informed");
		
		rateTokenGateway.deserializeRateToken(loyaltyCalculate);
		
		final var allRateTokens = loyaltyCalculate
				.getAllItems()
				.stream()
				.map(Item::getDecodedRateToken)
				.collect(Collectors.toList());
		
		final List<Map<String, Object>> allBuckets = bucketsDSGateway.findAllBuckets(allRateTokens, null);
		
		loyaltyCalculate
		.getAvailableItems()
		.forEach(item -> performCalculation(item, allBuckets));
		
		loyaltyCalculate
		.getSelectedItems()
		.forEach(item -> performCalculation(item, allBuckets));
		
		return loyaltyCalculate;
	}

	private void performCalculation(final Item item, final List<Map<String, Object>> allBuckets) {
		//TODO: some business logic
	}
}
