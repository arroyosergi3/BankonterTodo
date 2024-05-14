package principal.controllers;

import principal.model.Tipocontrato;

public class ControladorTipOContrato extends Controlador{

	public ControladorTipOContrato(Class entidadControlada, String unidadPersistencia) {
		super(Tipocontrato.class, "PanelBankonterTodo");
	}
	
	private static ControladorTipOContrato instance = null;
	
	public static ControladorTipOContrato getInstance() {
		if (instance == null) {
			instance = new ControladorTipOContrato(Tipocontrato.class, "PanelBankonterTodo");
		}
		return instance;
	}
	
	

}
