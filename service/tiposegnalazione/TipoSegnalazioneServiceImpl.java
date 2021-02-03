package it.prova.progettoprovajpawebmaven.service.tiposegnalazione;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.progettoprovajpawebmaven.dao.tiposegnalazione.TipoSegnalazioneDAO;
import it.prova.progettoprovajpawebmaven.model.TipoSegnalazione;
import it.prova.progettoprovajpawebmaven.web.listener.LocalEntityManagerFactoryListener;

public class TipoSegnalazioneServiceImpl implements TipoSegnalazioneService {
	
	private TipoSegnalazioneDAO tipoSegnalazioneDAO;

	@Override
	public void setTipoSegnalazioneDao(TipoSegnalazioneDAO tipoSegnalazioneDAO) {
		this.tipoSegnalazioneDAO = tipoSegnalazioneDAO;

	}

	@Override
	public List<TipoSegnalazione> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			tipoSegnalazioneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return tipoSegnalazioneDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public TipoSegnalazione caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			tipoSegnalazioneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return tipoSegnalazioneDAO.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(TipoSegnalazione input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			tipoSegnalazioneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			tipoSegnalazioneDAO.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(TipoSegnalazione input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			tipoSegnalazioneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			tipoSegnalazioneDAO.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void rimuovi(TipoSegnalazione input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			tipoSegnalazioneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			tipoSegnalazioneDAO.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}
	
	@Override
	public TipoSegnalazione cercaPerDescrizione(String descrizioneInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			tipoSegnalazioneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return tipoSegnalazioneDAO.findByDescrizione(descrizioneInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
