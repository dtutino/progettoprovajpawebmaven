package it.prova.progettoprovajpawebmaven.dao;

import it.prova.progettoprovajpawebmaven.dao.localita.LocalitaDAO;
import it.prova.progettoprovajpawebmaven.dao.localita.LocalitaDAOImpl;
import it.prova.progettoprovajpawebmaven.dao.segnalazione.SegnalazioneDAO;
import it.prova.progettoprovajpawebmaven.dao.segnalazione.SegnalazioneDAOImpl;
import it.prova.progettoprovajpawebmaven.dao.stato.StatoDAO;
import it.prova.progettoprovajpawebmaven.dao.stato.StatoDAOImpl;
import it.prova.progettoprovajpawebmaven.dao.tiposegnalazione.TipoSegnalazioneDAO;
import it.prova.progettoprovajpawebmaven.dao.tiposegnalazione.TipoSegnalazioneDAOImpl;

public class MyDaoFactory {
	
	private static SegnalazioneDAO segnalazioneDaoInstance = null;
	private static TipoSegnalazioneDAO tipoSegnalazioneDaoInstance = null;
	private static LocalitaDAO localitaDaoInstance = null;
	private static StatoDAO statoDaoInstance = null;

	public static SegnalazioneDAO getSegnalazioneDAOInstance() {
		if (segnalazioneDaoInstance == null)
			segnalazioneDaoInstance = new SegnalazioneDAOImpl();

		return segnalazioneDaoInstance;
	}
	
	public static TipoSegnalazioneDAO getTipoSegnalazioneDAOInstance() {
		if (tipoSegnalazioneDaoInstance == null)
			tipoSegnalazioneDaoInstance = new TipoSegnalazioneDAOImpl();

		return tipoSegnalazioneDaoInstance;
	}
	
	public static LocalitaDAO getLocalitaDAOInstance() {
		if (localitaDaoInstance == null)
			localitaDaoInstance = new LocalitaDAOImpl();

		return localitaDaoInstance;
	}
	
	public static StatoDAO getStatoDAOInstance() {
		if (statoDaoInstance == null)
			statoDaoInstance = new StatoDAOImpl();

		return statoDaoInstance;
	}

}
