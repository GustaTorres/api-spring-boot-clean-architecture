package br.com.clean.engine.loyalty.controller.model.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParamsRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5450470941575832012L;
	
	private boolean showDetail;
}
