package br.com.zupacademy.jpcsik.casadocodigo.validacao.anotacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValorUnicoValidator.class})
public @interface ValorUnico {
	 
	String message() default "Já está cadastrado!";
	 
	Class<?>[] groups() default {};
	 
	Class<? extends Payload>[] payload() default {};
	 
	String fieldName();
	 
	Class<?> domainClass();
}