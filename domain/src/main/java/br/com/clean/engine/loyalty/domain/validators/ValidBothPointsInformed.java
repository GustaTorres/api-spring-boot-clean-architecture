package br.com.clean.engine.loyalty.domain.validators;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.util.Optional.ofNullable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import br.com.clean.engine.loyalty.domain.Loyalty;
import br.com.clean.engine.loyalty.domain.validators.ValidBothPointsInformed.LoyaltyBothPointsInformedValitador;

@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = LoyaltyBothPointsInformedValitador.class)
public @interface ValidBothPointsInformed {
	String message() default "Only one of the point types must be informed, amountPoints or amountPointsClub";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	class LoyaltyBothPointsInformedValitador implements ConstraintValidator<ValidBothPointsInformed, Loyalty> {

		private static final Integer ZERO = 0;

		@Override
		public boolean isValid(final Loyalty loyalty, final ConstraintValidatorContext context) {
			final Integer amountPoints = ofNullable(loyalty.getAmountPoints()).orElse(ZERO);
			final Integer amountPointsClub = ofNullable(loyalty.getAmountPointsClub()).orElse(ZERO);
			return !(amountPoints > ZERO && amountPointsClub > ZERO);
		}
	}
}
