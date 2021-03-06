package it.prova.progettoprovajpawebmaven.dao.stato;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.progettoprovajpawebmaven.model.Stato;

public class StatoDAOImpl implements StatoDAO {

private EntityManager entityManager; 
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Stato> list() throws Exception {
		return entityManager.createQuery("from Stato", Stato.class).getResultList();
	}

	@Override
	public Stato findOne(Long id) throws Exception {
		return entityManager.find(Stato.class, id);
	}

	@Override
	public void update(Stato input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.merge(input);

	}

	@Override
	public void insert(Stato input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);

	}

	@Override
	public void delete(Stato input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));

	}

}
