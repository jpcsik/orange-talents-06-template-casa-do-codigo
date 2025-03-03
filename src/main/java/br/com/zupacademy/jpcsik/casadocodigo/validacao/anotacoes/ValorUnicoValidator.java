package br.com.zupacademy.jpcsik.casadocodigo.validacao.anotacoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, Object>{

	private String campo;
	private Class<?> classe;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(ValorUnico anotacao) {
		campo = anotacao.fieldName();
		classe = anotacao.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("SELECT a FROM "+classe.getName()+" a WHERE "+campo+"=:value");
		query.setParameter("value", value);
		List<?> resultList = query.getResultList();
		return resultList.isEmpty();
	}

}