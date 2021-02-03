package it.prova.progettoprovajpawebmaven.service.segnalazione;

import java.util.List;

import it.prova.progettoprovajpawebmaven.dao.segnalazione.SegnalazioneDAO;
import it.prova.progettoprovajpawebmaven.model.Segnalazione;

public interface SegnalazioneService {
	
		public void setSegnalazioneDao(SegnalazioneDAO segnalazioneDAO);

		public List<Segnalazione> listAll() throws Exception;

		public Segnalazione caricaSingoloElemento(Long idInput) throws Exception;

		public void aggiorna(Segnalazione input) throws Exception;

		public void inserisciNuovo(Segnalazione input) throws Exception;

		public void rimuovi(Segnalazione input) throws Exception;

		public List<Segnalazione> findByExample(Segnalazione input) throws Exception;

}
