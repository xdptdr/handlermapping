package com.github.xdptdr.mbwar.servlet;

import java.util.Calendar;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(JPABeanI.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class JPABean implements JPABeanI {

	@PersistenceContext(unitName = "TOTO")
	private EntityManager entityManager;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create() {

		Calendar cal = Calendar.getInstance();

		MyEntity entity = new MyEntity();
		entity.setId(cal.getTimeInMillis());
		entityManager.persist(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<MyEntity> getAll() {
		Query query = entityManager.createQuery("select me from MyEntity me");
		return query.getResultList();
	}

	

}
