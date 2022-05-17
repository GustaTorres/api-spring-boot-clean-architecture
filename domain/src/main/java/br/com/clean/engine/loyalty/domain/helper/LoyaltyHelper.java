package br.com.clean.engine.loyalty.domain.helper;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.clean.engine.loyalty.domain.Item;
import br.com.clean.engine.loyalty.domain.Loyalty;
import br.com.clean.engine.loyalty.domain.LoyaltyCalculate;
import org.springframework.util.Assert;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lombok.SneakyThrows;

public class LoyaltyHelper {

	private static XmlMapper xmlMapper = new XmlMapper();

	private LoyaltyHelper() {
	}

	public static void decodeRateToken(final LoyaltyCalculate loyaltyCalculate) {
		final List<Item> availableItems = decodeRateToken(loyaltyCalculate.getAvailableItems());
		final List<Item> selectedItems = decodeRateToken(loyaltyCalculate.getSelectedItems());
		loyaltyCalculate.setAvailableItems(availableItems);
		loyaltyCalculate.setSelectedItems(selectedItems);
	}

	public static List<Item> decodeRateToken(final List<Item> items) {
		return items.stream().map(item -> decodeRateToken(item)).collect(toList());
	}

	@SneakyThrows
	public static Item decodeRateToken(final Item item) {
		final var rateToken = item.getRateToken();
		final var decodedBytes = Base64.getDecoder().decode(rateToken);
		final var decodedString = new String(decodedBytes);
		@SuppressWarnings("unchecked")
		final Map<String, Object> decodedRateToken = xmlMapper.readValue(decodedString, Map.class);
		item.setDecodedRateToken(decodedRateToken);
		return item;
	}

	public static Loyalty validLoyalty(final Loyalty loyalty) {
		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		final Validator validator = factory.getValidator();
		final Set<ConstraintViolation<Loyalty>> violations = validator.validate(loyalty);
		Assert.isTrue(isEmpty(violations), String.format("Violations were found: %s", violations));
		return loyalty;
	}
}
