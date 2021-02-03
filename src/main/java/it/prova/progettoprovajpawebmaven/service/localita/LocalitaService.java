package it.prova.progettoprovajpawebmaven.service.localita;

import java.util.List;

import it.prova.progettoprovajpawebmaven.dao.localita.LocalitaDAO;
import it.prova.progettoprovajpawebmaven.model.Localita;

public interface LocalitaService {
	
	public void setLocalitaDao(LocalitaDAO localitaDAO);

	public List<Localita> listAll() throws Exception;

	public Localita caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Localita input) throws Exception;

	public void inserisciNuovo(Localita input) throws Exception;

	public void rimuovi(Localita input) throws Exception;
	
	public Localita cercaPerDescrizione(String descrizioneInput) throws Exception;

}
