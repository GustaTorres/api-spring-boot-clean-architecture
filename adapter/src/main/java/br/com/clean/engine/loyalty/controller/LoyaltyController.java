package br.com.clean.engine.loyalty.controller;

import br.com.clean.engine.loyalty.controller.model.request.LoyaltyCalculateRequest;
import br.com.clean.engine.loyalty.controller.mapper.LoyaltyCalculateMapper;
import br.com.clean.engine.loyalty.controller.model.response.LoyaltyCalculateResponse;
import br.com.clean.engine.loyalty.domain.LoyaltyCalculate;
import br.com.clean.engine.loyalty.usecase.LoyaltyCalculationUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoyaltyController {

	private final LoyaltyCalculationUseCase loyaltyCalculationUseCase;
	private final LoyaltyCalculateMapper mapper;

	public LoyaltyCalculateResponse calculate(final LoyaltyCalculateRequest loyaltyCalculateRequest) {
		final LoyaltyCalculate loyaltyCalculate = mapper.loyaltyRequestToLoyaltyCalculate(loyaltyCalculateRequest);
		final LoyaltyCalculate loyaltyCalculated = loyaltyCalculationUseCase.calculate(loyaltyCalculate);
		return mapper.loyaltyCalculateToLoyaltyCalculateResponse(loyaltyCalculated);
	}
}
