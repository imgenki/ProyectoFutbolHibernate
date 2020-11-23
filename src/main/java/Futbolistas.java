import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "futbolistas")
public class Futbolistas {
	@Id
	@Column(columnDefinition = "char(9)")
	String codDNIoNIE;
	@Column(columnDefinition = "varchar(50)")
	String nombre;
	@Column(columnDefinition = "varchar(40)")
	String nacionalidad;
	
	@OneToMany (cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER,mappedBy="futbolista")
	List<Contratos> contratos = new ArrayList<Contratos>(); 

	
	
	@Override
	public String toString() {
		return "Futbolista: codDNIoNIE=" + codDNIoNIE + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad;
	}

	public Futbolistas() {
		super();
	}

	public Futbolistas(String codDNIoNIE, String nombre, String nacionalidad) {
		super();
		this.codDNIoNIE = codDNIoNIE;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	public String getCodDNIoNIE() {
		return codDNIoNIE;
	}

	public void setCodDNIoNIE(String codDNIoNIE) {
		this.codDNIoNIE = codDNIoNIE;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
