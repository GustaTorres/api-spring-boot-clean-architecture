package br.com.clean.engine.loyalty.dataprovider;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.clean.engine.loyalty.usecase.port.ComissionGateway;

@Component
public class ComissionDataProvider implements ComissionGateway {

	@Value("${percentage.comission}")
	private BigDecimal percentageComission;

	@Override
	public BigDecimal getComission() {
		return percentageComission;
	}

}
