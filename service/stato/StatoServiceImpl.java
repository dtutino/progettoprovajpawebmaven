package it.prova.progettoprovajpawebmaven.service.stato;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.progettoprovajpawebmaven.dao.stato.StatoDAO;
import it.prova.progettoprovajpawebmaven.model.Stato;
import it.prova.progettoprovajpawebmaven.web.listener.LocalEntityManagerFactoryListener;

public class StatoServiceImpl implements StatoService {

	private StatoDAO statoDAO;

	@Override
	public void setStatoDao(StatoDAO statoDAO) {
		this.statoDAO = statoDAO;

	}

	@Override
	public List<Stato> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			statoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return statoDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Stato caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			statoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return statoDAO.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Stato input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			statoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			statoDAO.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(Stato input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			statoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			statoDAO.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void rimuovi(Stato input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			statoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			statoDAO.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}
	
	@Override
	public Stato cercaPerDescrizione(String descrizioneInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			statoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return statoDAO.findByDescrizione(descrizioneInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
