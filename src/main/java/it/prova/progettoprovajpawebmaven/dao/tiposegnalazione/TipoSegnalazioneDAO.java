package it.prova.progettoprovajpawebmaven.dao.tiposegnalazione;

import it.prova.progettoprovajpawebmaven.dao.IBaseDAO;
import it.prova.progettoprovajpawebmaven.model.TipoSegnalazione;

public interface TipoSegnalazioneDAO extends IBaseDAO<TipoSegnalazione> {
	
	public TipoSegnalazione findByDescrizione(String descrizione) throws Exception;

}
