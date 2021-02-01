package it.prova.progettoprovajpawebmaven.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "localita")
public class Localita extends CommonEntity {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localita")
	private Set<Segnalazione> listaSegnalazioni = new HashSet<>();

	public Set<Segnalazione> getListaSegnalazioni() {
		return listaSegnalazioni;
	}

	public void setListaSegnalazioni(Set<Segnalazione> listaSegnalazioni) {
		this.listaSegnalazioni = listaSegnalazioni;
	}

}
