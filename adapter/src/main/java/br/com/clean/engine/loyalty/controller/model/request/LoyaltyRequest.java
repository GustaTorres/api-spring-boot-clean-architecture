package br.com.clean.engine.loyalty.controller.model.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoyaltyRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8869748162041250156L;

	private Integer amountPoints;
	private Integer amountPointsClub;
}
