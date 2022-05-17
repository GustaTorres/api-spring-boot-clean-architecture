package br.com.clean.engine.loyalty.controller.model.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoyaltyDetailResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5798141414934726834L;

	private List<Map<String, Object>> buckets;
	private BigDecimal comissionPercentage;
	private BigDecimal comissionPointsPercentage;
	private BigDecimal discountPointsPercentage;
	private BigDecimal costBase;
	private Integer totalPoints;
	private Integer totalPointsClub;
	private Integer totalPointsSell;
	private Integer totalPointsSellClub;

}
