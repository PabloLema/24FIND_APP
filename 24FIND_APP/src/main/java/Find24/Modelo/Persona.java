package Find24.Modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Size(min = 0, max = 10)
	@Column(name="PER_CI")
	private String ci;
	
	@NotNull
	@Size(min = 4, max = 20)
	@Column(name="PER_NOMBRE")
	private String nombre;
	
	@NotNull
	@Size(min = 4, max = 20)
	@Column(name="PER_APELLIDO")
	private String apellido;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "TEL_PER_CI", referencedColumnName = "PER_CI")
	private Set<Telefono> telefonos;
	
	@NotNull
	@Size(min = 4, max = 20)
	@Column(name="PER_DIRECCION")
	private String direccion;
	
	@Email
	@Column(name="PER_CORREO")
	private String correo;
	
	@NotNull
	private String tipoPersona;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "LOC_PER_CI", referencedColumnName = "PER_CI")
	private Set<Local> locales;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Set<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Set<Local> getLocales() {
		return locales;
	}

	public void setLocales(Set<Local> locales) {
		this.locales = locales;
	}

	public void addTelefono(Telefono telefono) {
		if (this.telefonos == null) 
			this.telefonos = new HashSet<>();
		this.telefonos.add(telefono);
	}
	
	public void addLocal(Local local) {
		if (this.locales == null)
			this.locales = new HashSet<>();
		this.locales.add(local);
	}
	
}
