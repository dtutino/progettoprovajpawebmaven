package it.prova.progettoprovajpawebmaven.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stato")
public class Stato extends CommonEntity {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stato")
	private Set<Segnalazione> listaSegnalazioni = new HashSet<>();

	public Stato() {
		super();
	}

	public Stato(String descrizione) {
		super(descrizione);
	}

	public Set<Segnalazione> getListaSegnalazioni() {
		return listaSegnalazioni;
	}

	public void setListaSegnalazioni(Set<Segnalazione> listaSegnalazioni) {
		this.listaSegnalazioni = listaSegnalazioni;
	}

	@Override
	public String toString() {
		return "Stato [descrizione=" + descrizione + "]";
	}
	
	

}
