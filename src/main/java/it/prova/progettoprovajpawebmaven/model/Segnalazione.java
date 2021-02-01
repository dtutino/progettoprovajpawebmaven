package it.prova.progettoprovajpawebmaven.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "segnalazione")
public class Segnalazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_segnalazione_id")
	private TipoSegnalazione tipoSegnalazione;
	@Column(name = "descrizione")
	private String descrizione;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="localita_id")
	private Localita localita;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stato_id")
	private Stato stato;
	
	public Segnalazione() {
		super();
	}

	public Segnalazione(TipoSegnalazione tipoSegnalazione, String descrizione, Localita localita, Stato stato) {
		super();
		this.tipoSegnalazione = tipoSegnalazione;
		this.descrizione = descrizione;
		this.localita = localita;
		this.stato = stato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoSegnalazione getTipoSegnalazione() {
		return tipoSegnalazione;
	}

	public void setTipoSegnalazione(TipoSegnalazione tipoSegnalazione) {
		this.tipoSegnalazione = tipoSegnalazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Localita getLocalita() {
		return localita;
	}

	public void setLocalita(Localita localita) {
		this.localita = localita;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

}
