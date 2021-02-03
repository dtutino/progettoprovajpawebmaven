package it.prova.progettoprovajpawebmaven.dao.localita;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.progettoprovajpawebmaven.model.Localita;

public class LocalitaDAOImpl implements LocalitaDAO {

private EntityManager entityManager; 
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Localita> list() throws Exception {
		return entityManager.createQuery("from Localita", Localita.class).getResultList();
	}

	@Override
	public Localita findOne(Long id) throws Exception {
		return entityManager.find(Localita.class, id);
	}

	@Override
	public void update(Localita input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.merge(input);

	}

	@Override
	public void insert(Localita input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);

	}

	@Override
	public void delete(Localita input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));

	}
	
	@Override
	public Localita findByDescrizione(String descrizione) throws Exception {
		if (descrizione == null || descrizione.isEmpty()) {
			throw new Exception("Problema valore in input");
		}
		
		TypedQuery<Localita> query = entityManager.createQuery("select l FROM Localita l where l.descrizione = ?1", Localita.class);
		query.setParameter(1, descrizione);
		System.out.println(descrizione);
		return query.getSingleResult();
	}

}
