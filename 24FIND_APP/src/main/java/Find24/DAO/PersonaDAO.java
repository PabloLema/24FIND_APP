package Find24.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Find24.Modelo.Persona;

@Stateless
public class PersonaDAO {
	
	@Inject
	private EntityManager em;
	
	public void InsertarPersona(Persona persona) {
		em.persist(persona);
	}
	
	public void ActualizarPersona(Persona persona) {
		em.merge(persona);
	}
	
	public void guardar(Persona persona) {
		
		Persona p = Leer(persona.getCi());
		if (p == null) {
			InsertarPersona(persona);
		} else {
			ActualizarPersona(persona);
		}
	}
	
	public Persona Leer(String ci) {
		Persona persona = em.find(Persona.class, ci);
		return persona;
	}
	
	public void Borrar(String ID) {
		Persona persona = Leer(ID);
		em.remove(persona);
	}
	
	public List<Persona> listadoPersonas() {
		String jpql = "SELECT p FROM Persona p";
		Query query = em.createQuery(jpql, Persona.class);
		@SuppressWarnings("unchecked")
		List<Persona> list = query.getResultList();
		return list;
	}

}
