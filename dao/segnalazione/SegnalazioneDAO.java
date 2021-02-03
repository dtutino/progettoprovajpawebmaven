package it.prova.progettoprovajpawebmaven.dao.segnalazione;


import java.util.List;

import it.prova.progettoprovajpawebmaven.dao.IBaseDAO;
import it.prova.progettoprovajpawebmaven.model.Localita;
import it.prova.progettoprovajpawebmaven.model.Segnalazione;

public interface SegnalazioneDAO extends IBaseDAO<Segnalazione> {
	
	public List<Segnalazione> findAllByLocalita(Localita input) throws Exception;
	
}
