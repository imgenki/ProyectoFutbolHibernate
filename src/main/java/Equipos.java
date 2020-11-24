import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipos {

	@Id
	@Column(columnDefinition = "integer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codEquipo;

	@Column(columnDefinition = "varchar(40)")
	private String nomEquipo;
	
	@Column ( columnDefinition= "bit")
	private boolean internacional;
	
	@Column ( columnDefinition = "varchar(60)")
	private String localidad;
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn (name="codEquipo")
	private EquiposObservaciones equiposobservacion;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="equipo", orphanRemoval = true )
	List<Contratos> contrato = new ArrayList<Contratos>(); 
	
	@ManyToOne (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="codLiga")
	private Ligas liga;
	
	

	@Override
	public String toString() {
		return "Equipo:\ncodEquipo=" + codEquipo + ",\nnomEquipo=" + nomEquipo + ", \ninternacional=" + internacional
				+ ", \nlocalidad=" + localidad + ", \nliga=" + liga.getNomLiga();
	}

	public Equipos() {
		super();
	}

	public Equipos(String nomEquipo, boolean internacional, String localidad, Ligas liga) {
		super();
		this.nomEquipo = nomEquipo;
		this.internacional = internacional;
		this.localidad = localidad;
		this.liga = liga;
	}

	public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getNomEquipo() {
		return nomEquipo;
	}

	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}

	public boolean isInternacional() {
		return internacional;
	}

	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public EquiposObservaciones getEquiposobservacion() {
		return equiposobservacion;
	}

	public void setEquiposobservacion(EquiposObservaciones equiposobservacion) {
		this.equiposobservacion = equiposobservacion;
	}

	public List<Contratos> getContrato() {
		return contrato;
	}

	public void setContrato(List<Contratos> contrato) {
		this.contrato = contrato;
	}

	public Ligas getLiga() {
		return liga;
	}

	public void setLiga(Ligas liga) {
		this.liga = liga;
	}
	
	
	
}
