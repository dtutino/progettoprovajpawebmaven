package it.prova.progettoprovajpawebmaven.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tiposegnalazione")
public class TipoSegnalazione extends CommonEntity {
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoSegnalazione")
	private Set<Segnalazione> listaSegnalazioni = new HashSet<>();
	
	public Set<Segnalazione> getListaSegnalazioni() {
		return listaSegnalazioni;
	}

	public void setListaSegnalazioni(Set<Segnalazione> listaSegnalazioni) {
		this.listaSegnalazioni = listaSegnalazioni;
	}
}
