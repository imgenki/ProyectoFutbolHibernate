import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "equiposobservaciones")
public class EquiposObservaciones {
	@Id
	@GeneratedValue(generator = "myForeign")
	@GenericGenerator(name = "myForeign", strategy = "foreign", parameters = {
			@org.hibernate.annotations.Parameter(name = "property", value = "equipo") })
	int codEquipo;

	@Column(columnDefinition = "varchar(200)")
	String observaciones;

	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Equipos equipo;
	
	
	
	@Override
	public String toString() {
		return "Observaciones: "+ observaciones;
	}

	public EquiposObservaciones() {
		super();
	}

	public EquiposObservaciones(String observaciones) {
		super();
		this.observaciones = observaciones;
	}

	public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Equipos getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}

}
