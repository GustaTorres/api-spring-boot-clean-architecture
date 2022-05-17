package br.com.clean.engine.loyalty.controller;

import br.com.clean.engine.loyalty.controller.model.request.LoyaltyCalculateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clean.engine.loyalty.controller.model.response.LoyaltyCalculateResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/loyalty")
@RequiredArgsConstructor
public class SpringLoyaltyController {
	
	private final LoyaltyController loyaltyController;

	@PostMapping("/calculate")
	public ResponseEntity<LoyaltyCalculateResponse> calculate(
			@RequestBody final LoyaltyCalculateRequest loyaltyCalculateRequest) {
		final LoyaltyCalculateResponse loyaltyCalculateResponse = loyaltyController.calculate(loyaltyCalculateRequest);
		return ResponseEntity.ok(loyaltyCalculateResponse);
	}
	
}
