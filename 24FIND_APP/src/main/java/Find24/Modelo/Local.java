package Find24.Modelo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Local implements Serializable {
	//
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="LOC_ID")
	private int id;
	
	@Column(name="LOC_NOMBRE")
	private String nombre;
	
	@Column(name="LOC_DIRECCION")
	private String direccion;
	
	@Column(name="LOC_HORARIOS")
	private String horarios;
	
	@Column(name="LOC_DESCRIPCION")
	private String descripcion;
	
	@Column(name="LOC_LAT")
	private String lat;
	
	@Column(name="LOC_LNG")
	private String lng;
	public int getID() {
		return id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getHorarios() {
		return horarios;
	}
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
}
