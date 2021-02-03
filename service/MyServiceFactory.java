package it.prova.progettoprovajpawebmaven.service;

import it.prova.progettoprovajpawebmaven.dao.localita.LocalitaDAO;
import it.prova.progettoprovajpawebmaven.dao.localita.LocalitaDAOImpl;
import it.prova.progettoprovajpawebmaven.dao.segnalazione.SegnalazioneDAO;
import it.prova.progettoprovajpawebmaven.dao.segnalazione.SegnalazioneDAOImpl;
import it.prova.progettoprovajpawebmaven.dao.stato.StatoDAO;
import it.prova.progettoprovajpawebmaven.dao.stato.StatoDAOImpl;
import it.prova.progettoprovajpawebmaven.dao.tiposegnalazione.TipoSegnalazioneDAO;
import it.prova.progettoprovajpawebmaven.dao.tiposegnalazione.TipoSegnalazioneDAOImpl;
import it.prova.progettoprovajpawebmaven.service.localita.LocalitaService;
import it.prova.progettoprovajpawebmaven.service.localita.LocalitaServiceImpl;
import it.prova.progettoprovajpawebmaven.service.segnalazione.SegnalazioneService;
import it.prova.progettoprovajpawebmaven.service.segnalazione.SegnalazioneServiceImpl;
import it.prova.progettoprovajpawebmaven.service.stato.StatoService;
import it.prova.progettoprovajpawebmaven.service.stato.StatoServiceImpl;
import it.prova.progettoprovajpawebmaven.service.tiposegnalazione.TipoSegnalazioneService;
import it.prova.progettoprovajpawebmaven.service.tiposegnalazione.TipoSegnalazioneServiceImpl;

public class MyServiceFactory {

	private static SegnalazioneService SEGNALAZIONE_SERVICE_INSTANCE = null;
	private static SegnalazioneDAO SEGNALAZIONEDAO_INSTANCE = null;
	
	private static TipoSegnalazioneService TIPOSEGNALAZIONE_SERVICE_INSTANCE = null;
	private static TipoSegnalazioneDAO TIPOSEGNALAZIONEDAO_INSTANCE = null;
	
	private static LocalitaService LOCALITA_SERVICE_INSTANCE = null;
	private static LocalitaDAO LOCALITADAO_INSTANCE = null;
	
	private static StatoService STATO_SERVICE_INSTANCE = null;
	private static StatoDAO STATODAO_INSTANCE = null;

	public static SegnalazioneService getSegnalazioneServiceInstance() {
		if (SEGNALAZIONE_SERVICE_INSTANCE == null)
			SEGNALAZIONE_SERVICE_INSTANCE = new SegnalazioneServiceImpl();

		if (SEGNALAZIONEDAO_INSTANCE == null)
			SEGNALAZIONEDAO_INSTANCE = new SegnalazioneDAOImpl();

		SEGNALAZIONE_SERVICE_INSTANCE.setSegnalazioneDao(SEGNALAZIONEDAO_INSTANCE);

		return SEGNALAZIONE_SERVICE_INSTANCE;
	}
	
	public static TipoSegnalazioneService getTipoSegnalazioneServiceInstance() {
		if (TIPOSEGNALAZIONE_SERVICE_INSTANCE == null)
			TIPOSEGNALAZIONE_SERVICE_INSTANCE = new TipoSegnalazioneServiceImpl();

		if (TIPOSEGNALAZIONEDAO_INSTANCE == null)
			TIPOSEGNALAZIONEDAO_INSTANCE = new TipoSegnalazioneDAOImpl();

		TIPOSEGNALAZIONE_SERVICE_INSTANCE.setTipoSegnalazioneDao(TIPOSEGNALAZIONEDAO_INSTANCE);

		return TIPOSEGNALAZIONE_SERVICE_INSTANCE;
	}
	
	public static LocalitaService getLocalitaServiceInstance() {
		if (LOCALITA_SERVICE_INSTANCE == null)
			LOCALITA_SERVICE_INSTANCE = new LocalitaServiceImpl();

		if (LOCALITADAO_INSTANCE == null)
			LOCALITADAO_INSTANCE = new LocalitaDAOImpl();

		LOCALITA_SERVICE_INSTANCE.setLocalitaDao(LOCALITADAO_INSTANCE);

		return LOCALITA_SERVICE_INSTANCE;
	}
	
	public static StatoService getStatoServiceInstance() {
		if (STATO_SERVICE_INSTANCE == null)
			STATO_SERVICE_INSTANCE = new StatoServiceImpl();

		if (STATODAO_INSTANCE == null)
			STATODAO_INSTANCE = new StatoDAOImpl();

		STATO_SERVICE_INSTANCE.setStatoDao(STATODAO_INSTANCE);

		return STATO_SERVICE_INSTANCE;
	}
	
}
