package br.com.clean.engine.loyalty.controller.model.response;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoyaltyResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8869748162041250156L;

	private Integer amountPoints;
	private Integer amountPointsClub;
	private BigDecimal discountValue;
	private BigDecimal sellPriceWithDiscount;
	private Integer pointsToAccumulate;
	private LoyaltyDetailResponse loyaltyDetail;
}
