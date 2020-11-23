import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "contratos")
public class Contratos {
	@Id
	@Column(columnDefinition = "integer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int codContrato;
	@ManyToOne (cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name = "codDNIoNIE")
	private Futbolistas futbolista;
	@ManyToOne (cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name = "codEquipo")
	private Equipos equipo;
	@Column (columnDefinition = "date")
	Date fechaInicio;
	@Column(columnDefinition = "date")
	Date fechaFin;
	@Column(columnDefinition = "integer")
	int precioAnual;
	@Column(columnDefinition = "integer")
	int precioRecision;
	
	

	@Override
	public String toString() {
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
		return "Contrato codContrato=" + codContrato + ", futbolista=" + futbolista.getNombre() + ", equipo=" + equipo.getNomEquipo()
				+ ", fechaInicio=" + dtf.format(fechaInicio) + ", fechaFin=" + dtf.format(fechaFin) + ", precioAnual=" + precioAnual
				+ ", precioRecision=" + precioRecision;
	}

	public Contratos() {
		super();
	}

	public Contratos(Futbolistas futbolista, Equipos equipo, Date fechaInicio,
			Date fechaFin, int precioAnual, int precioRecision) {
		super();
		this.futbolista = futbolista;
		this.equipo = equipo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precioAnual = precioAnual;
		this.precioRecision = precioRecision;
	}

	public int getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(int codContrato) {
		this.codContrato = codContrato;
	}

	public int getPrecioAnual() {
		return precioAnual;
	}

	public void setPrecioAnual(int precioAnual) {
		this.precioAnual = precioAnual;
	}

	public int getPrecioRecision() {
		return precioRecision;
	}

	public void setPrecioRecision(int precioRecision) {
		this.precioRecision = precioRecision;
	}

	public Futbolistas getFutbolista() {
		return futbolista;
	}

	public void setFutbolista(Futbolistas futbolista) {
		this.futbolista = futbolista;
	}

	public Equipos getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
