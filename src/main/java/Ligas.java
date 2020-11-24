import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ligas")
public class Ligas {
	@Id
	@Column(columnDefinition = "char(5)")
	String codLiga;
	@Column(columnDefinition = "varchar(50)")
	String nomLiga;
	@OneToMany(cascade = {CascadeType.ALL, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy="liga", orphanRemoval = true)
	private List<Equipos> equipos = new ArrayList<Equipos>();

	
	
	@Override
	public String toString() {
		return "Liga codLiga=" + codLiga + ", nomLiga=" + nomLiga;
	}

	public Ligas() {
		super();
	}

	public Ligas(String codLiga, String nomLiga) {
		super();
		this.codLiga = codLiga;
		this.nomLiga = nomLiga;
	}

	public String getCodLiga() {
		return codLiga;
	}

	public void setCodLiga(String codLiga) {
		this.codLiga = codLiga;
	}

	public String getNomLiga() {
		return nomLiga;
	}

	public void setNomLiga(String nomLiga) {
		this.nomLiga = nomLiga;
	}

	public List<Equipos> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipos> equipos) {
		this.equipos = equipos;
	}
	
}
