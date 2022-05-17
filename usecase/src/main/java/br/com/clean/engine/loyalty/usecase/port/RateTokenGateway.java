package br.com.clean.engine.loyalty.usecase.port;

import br.com.clean.engine.loyalty.domain.LoyaltyCalculate;

public interface RateTokenGateway {
	void deserializeRateToken(LoyaltyCalculate loyaltyCalculate);

}
