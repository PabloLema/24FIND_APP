package Find24.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import Find24.DAO.PersonaDAO;
import Find24.Modelo.Local;
import Find24.Modelo.Persona;
import Find24.Modelo.Telefono;

@ManagedBean
@ViewScoped
public class PersonaController {
	
	@Inject
	private PersonaDAO personaDAO;
	
	private Persona persona;
	
	private List<Persona> personas;
	
	private String id;
	
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		persona = new Persona();
		ListarPersonas();
		persona.addTelefono(new Telefono());
		persona.addLocal(new Local());
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		cargarDatosEditar(id);
	}

	public String Guardar() {
		try {
				personaDAO.guardar(persona);
				ListarPersonas();			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return "ListaClientes";
	}
		
	public String eliminarPersona(String ID) {
		try {
			personaDAO.Borrar(ID);
			ListarPersonas();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ListaClientes";
	}

	public String cargarDatosEditar(String CI) {
		persona = personaDAO.Leer(CI);
		return "EditarCliente";
	}
	
	public void ListarPersonas() {
		personas = personaDAO.listadoPersonas();
	}
	
	public String addTelefono() {
		persona.addTelefono(new Telefono());
		return null;
	}
	
	public String addLocal() {
		persona.addLocal(new Local());
		return null;
	}
	
}