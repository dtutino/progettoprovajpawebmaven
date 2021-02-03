package it.prova.progettoprovajpawebmaven.dao.localita;

import it.prova.progettoprovajpawebmaven.dao.IBaseDAO;
import it.prova.progettoprovajpawebmaven.model.Localita;

public interface LocalitaDAO extends IBaseDAO<Localita> {
	
	public Localita findByDescrizione(String descrizione) throws Exception;
	
	public Localita getEagerSegnalazioni(Long id) throws Exception;

}
