package principal.controllers;

import java.util.List;

import javax.persistence.EntityManager;

import principal.model.Contrato;
import principal.model.Entidad;
import principal.model.Tipocontrato;
import principal.model.Usuario;

public class ControladorUsuario extends Controlador {

	public ControladorUsuario(String unidadPersistencia) {
		super(Usuario.class, unidadPersistencia);
		// TODO Auto-generated constructor stub
	}

	private static ControladorUsuario instance = null;

	public static ControladorUsuario getInstance() {
		if (instance == null) {
			instance = new ControladorUsuario("PanelBankonterTodo");
		}
		return instance;
	}

	public List<? extends Entidad> findbyString(String str, String nombretabla, String campo, boolean isCaseSensitive) {
		if (isCaseSensitive) {
			try {
				EntityManager em = getEntityManagerFactory().createEntityManager();
				List<? extends Entidad> l = em
						.createNativeQuery("select * from " + nombretabla + " where " + campo +  " like '%" + str + "%'",
								Usuario.class)
						.getResultList();
				em.close();
				return l;
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
		else {
			try {
				EntityManager em = getEntityManagerFactory().createEntityManager();
				List<? extends Entidad> l = em
						.createNativeQuery("select * from " + nombretabla + " where UPPER(" + campo + ") like '%" + str.toUpperCase() + "%'",
								Usuario.class)
						.getResultList();
				em.close();
				return l;
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
		
		
	}

}
