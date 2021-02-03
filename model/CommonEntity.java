package it.prova.progettoprovajpawebmaven.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CommonEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@Column(name = "descrizione")
	protected String descrizione;
	
	public CommonEntity() {
		super();
	}
	
	public CommonEntity(String descrizione) {
		super();
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		CommonEntity other = (CommonEntity) obj;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		return true;
	}
	
	
	
}
