package it.prova.progettoprovajpawebmaven.service.tiposegnalazione;

import java.util.List;

import it.prova.progettoprovajpawebmaven.dao.tiposegnalazione.TipoSegnalazioneDAO;
import it.prova.progettoprovajpawebmaven.model.TipoSegnalazione;

public interface TipoSegnalazioneService {
	
	public void setTipoSegnalazioneDao(TipoSegnalazioneDAO tipoSegnalazioneDAO);

	public List<TipoSegnalazione> listAll() throws Exception;

	public TipoSegnalazione caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(TipoSegnalazione input) throws Exception;

	public void inserisciNuovo(TipoSegnalazione input) throws Exception;

	public void rimuovi(TipoSegnalazione input) throws Exception;
	
	public TipoSegnalazione cercaPerDescrizione(String descrizioneInput) throws Exception;

}
