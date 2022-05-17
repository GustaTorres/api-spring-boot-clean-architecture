package br.com.clean.engine.loyalty.controller.mapper;

import static java.util.Optional.ofNullable;

import br.com.clean.engine.loyalty.controller.model.request.LoyaltyCalculateRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.clean.engine.loyalty.controller.model.response.LoyaltyCalculateResponse;
import br.com.clean.engine.loyalty.controller.model.response.LoyaltyDetailResponse;
import br.com.clean.engine.loyalty.controller.model.response.LoyaltyResponse;
import br.com.clean.engine.loyalty.domain.Loyalty;
import br.com.clean.engine.loyalty.domain.LoyaltyCalculate;
import br.com.clean.engine.loyalty.domain.Params;

@Mapper
public interface LoyaltyCalculateMapper {

	LoyaltyCalculate loyaltyRequestToLoyaltyCalculate(LoyaltyCalculateRequest loyaltyRequest);

	LoyaltyCalculateResponse loyaltyCalculateToLoyaltyCalculateResponse(LoyaltyCalculate loyaltyCalculate);

	 @Mapping(target = "loyaltyDetail", source = "loyalty", 
		      defaultExpression = "java(loyaltyToLoyaltyDetailResponse(loyalty))")
	LoyaltyResponse loyaltyToLoyaltyResponse(final Loyalty loyalty);
	
	LoyaltyDetailResponse loyaltyToLoyaltyDetailResponse(final Loyalty loyalty);

	@AfterMapping
	default void verifyShowDetail(final LoyaltyCalculate loyaltyCalculate , @MappingTarget final  LoyaltyCalculateResponse loyaltyCalculateResponse ) {
		ofNullable(loyaltyCalculate)
		.map(LoyaltyCalculate::getParams)
		.filter(Params::isShowDetail)
		.ifPresentOrElse(params -> {},() -> {
			loyaltyCalculateResponse.getAvailableItems().forEach(item -> ofNullable(item.getLoyalty()).ifPresent(loyalty -> loyalty.setLoyaltyDetail(null)));
			loyaltyCalculateResponse.getSelectedItems().forEach(item -> ofNullable(item.getLoyalty()).ifPresent(loyalty -> loyalty.setLoyaltyDetail(null)));
		});
	}

}
