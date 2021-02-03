package it.prova.progettoprovajpawebmaven.service.stato;

import java.util.List;

import it.prova.progettoprovajpawebmaven.dao.stato.StatoDAO;
import it.prova.progettoprovajpawebmaven.model.Stato;

public interface StatoService {
	
	public void setStatoDao(StatoDAO statoDAO);

	public List<Stato> listAll() throws Exception;

	public Stato caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Stato input) throws Exception;

	public void inserisciNuovo(Stato input) throws Exception;

	public void rimuovi(Stato input) throws Exception;
	
	public Stato cercaPerDescrizione(String descrizioneInput) throws Exception;

}
