package it.prova.progettoprovajpawebmaven.dao.tiposegnalazione;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.progettoprovajpawebmaven.model.TipoSegnalazione;

public class TipoSegnalazioneDAOImpl implements TipoSegnalazioneDAO {
	
	private EntityManager entityManager; 
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<TipoSegnalazione> list() throws Exception {
		return entityManager.createQuery("from TipoSegnalazione", TipoSegnalazione.class).getResultList();
	}

	@Override
	public TipoSegnalazione findOne(Long id) throws Exception {
		return entityManager.find(TipoSegnalazione.class, id);
	}

	@Override
	public void update(TipoSegnalazione input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.merge(input);

	}

	@Override
	public void insert(TipoSegnalazione input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);

	}

	@Override
	public void delete(TipoSegnalazione input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));

	}
	
	@Override
	public TipoSegnalazione findByDescrizione(String descrizione) throws Exception {
		if (descrizione == null || descrizione.isEmpty()) {
			throw new Exception("Problema valore in input");
		}
		
		TypedQuery<TipoSegnalazione> query = entityManager.createQuery("select ts FROM TipoSegnalazione ts where ts.descrizione = ?1", TipoSegnalazione.class);
		query.setParameter(1, descrizione);
		System.out.println(descrizione);
		return query.getSingleResult();
	}

}
