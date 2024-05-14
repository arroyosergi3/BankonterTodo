package principal.controllers;

import java.util.List;

import principal.model.Tipocontrato;

public class DatosDeTabla {

	private static Object[][] datos = null;
 	
	
	
	
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Descripcion"};
	}
	
	
	public static Object[][] getDatosDeTabla() {
		if (datos == null) {
			List<Tipocontrato> estudiantes = (List<Tipocontrato>) ControladorTipOContrato.getInstance().findAll();
			datos = new Object[estudiantes.size()][2];
			for (int i = 0; i < estudiantes.size(); i++) {
				Tipocontrato e = estudiantes.get(i);
				datos[i][0] = e.getId();
				datos[i][1] = e.getDescripcion();
				
			}
		}
		
		return datos;
	}

	
	
}
