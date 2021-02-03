package it.prova.progettoprovajpawebmaven.dao.segnalazione;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.progettoprovajpawebmaven.model.Segnalazione;

public class SegnalazioneDAOImpl implements SegnalazioneDAO {
	
	private EntityManager entityManager;
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Segnalazione> list() throws Exception {
		return entityManager.createQuery("from Segnalazione", Segnalazione.class).getResultList();
	}

	@Override
	public Segnalazione findOne(Long id) throws Exception {
		return entityManager.find(Segnalazione.class, id);
	}

	@Override
	public void update(Segnalazione input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.merge(input);

	}

	@Override
	public void insert(Segnalazione input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);

	}

	@Override
	public void delete(Segnalazione input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));

	}

}
