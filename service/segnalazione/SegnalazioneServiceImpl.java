package it.prova.progettoprovajpawebmaven.service.segnalazione;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.progettoprovajpawebmaven.dao.segnalazione.SegnalazioneDAO;
import it.prova.progettoprovajpawebmaven.model.Segnalazione;
import it.prova.progettoprovajpawebmaven.web.listener.LocalEntityManagerFactoryListener;

public class SegnalazioneServiceImpl implements SegnalazioneService {
	
	private SegnalazioneDAO segnalazioneDAO;

	@Override
	public void setSegnalazioneDao(SegnalazioneDAO segnalazioneDAO) {
		this.segnalazioneDAO = segnalazioneDAO;

	}

	@Override
	public List<Segnalazione> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			segnalazioneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return segnalazioneDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Segnalazione caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			segnalazioneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return segnalazioneDAO.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Segnalazione input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			segnalazioneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			segnalazioneDAO.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(Segnalazione input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			segnalazioneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			segnalazioneDAO.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void rimuovi(Segnalazione input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			segnalazioneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			segnalazioneDAO.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<Segnalazione> findByExample(Segnalazione input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
