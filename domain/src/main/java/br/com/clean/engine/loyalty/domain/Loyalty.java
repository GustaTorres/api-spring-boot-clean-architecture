package br.com.clean.engine.loyalty.domain;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.PositiveOrZero;

import br.com.clean.engine.loyalty.domain.validators.ValidBothPointsInformed;
import lombok.Data;

@Data
@ValidBothPointsInformed
public class Loyalty {

	@PositiveOrZero
	private Integer amountPoints = 0;

	@PositiveOrZero
	private Integer amountPointsClub = 0;

	private BigDecimal discountValue;
	private BigDecimal sellPriceWithDiscount;
	private Integer pointsToAccumulate;
	private BigDecimal comissionPercentage;
	private BigDecimal comissionPointsPercentage;
	private BigDecimal discountPointsPercentage;
	private BigDecimal costBase;
	private Integer totalPoints;
	private Integer totalPointsClub;
	private Integer totalPointsSell;
	private Integer totalPointsSellClub;
	private List<Map<String, Object>> buckets = new ArrayList<>();
	
	public void addBucket(final Map<String, Object> bucket) {
		if(isEmpty(buckets)) {
			this.buckets = new ArrayList<>();
		}
		this.buckets.add(bucket);
	}
}
