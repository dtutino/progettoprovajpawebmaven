package it.prova.progettoprovajpawebmaven.service.localita;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.progettoprovajpawebmaven.dao.MyDaoFactory;
import it.prova.progettoprovajpawebmaven.dao.localita.LocalitaDAO;
import it.prova.progettoprovajpawebmaven.dao.segnalazione.SegnalazioneDAO;
import it.prova.progettoprovajpawebmaven.model.Localita;
import it.prova.progettoprovajpawebmaven.model.Segnalazione;
import it.prova.progettoprovajpawebmaven.web.listener.LocalEntityManagerFactoryListener;

public class LocalitaServiceImpl implements LocalitaService {

	private LocalitaDAO localitaDAO;

	@Override
	public void setLocalitaDao(LocalitaDAO localitaDAO) {
		this.localitaDAO = localitaDAO;

	}

	@Override
	public List<Localita> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			localitaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return localitaDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Localita caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			localitaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return localitaDAO.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Localita input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			localitaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			localitaDAO.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(Localita input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			localitaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			localitaDAO.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}
	
	@Override
	public void rimuovi(Localita input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			SegnalazioneDAO segnalazioneDAO = MyDaoFactory.getSegnalazioneDAOInstance();
			segnalazioneDAO.setEntityManager(entityManager);

			List<Segnalazione> lista = segnalazioneDAO.findAllByLocalita(input);

			for (Segnalazione segnalazioneItem : lista) {
				segnalazioneItem.setLocalita(null);
				segnalazioneDAO.update(segnalazioneItem);
			}

			// uso l'injection per il dao
			localitaDAO.setEntityManager(entityManager);

			// caricamento EAGER della località
			input = localitaDAO.getEagerSegnalazioni(input.getId());

			// dissocio tutte le segnalazioni da questa località
			input.getListaSegnalazioni().clear();

			// eseguo quello che realmente devo fare
			localitaDAO.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public Localita cercaPerDescrizione(String descrizioneInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			localitaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return localitaDAO.findByDescrizione(descrizioneInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
