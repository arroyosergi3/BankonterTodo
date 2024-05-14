package principal.controllers;

import principal.model.Contrato;

public class ControladorContrato extends Controlador{

	public ControladorContrato(Class entidadControlada, String unidadPersistencia) {
		super(Contrato.class, "PanelBankonterTodo");
	}
	
	private static ControladorContrato instance = null;
	
	public static ControladorContrato getInstance() {
		if (instance == null) {
			instance = new ControladorContrato(Contrato.class, "PanelBankonterTodo");
		}
		return instance;
	}
	
	

}
