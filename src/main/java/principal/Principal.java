package principal;


import javax.swing.JFrame;

import principal.views.PanelContrato;





public class Principal extends JFrame{

	static Principal instance = null;

	

	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	

	public Principal() {
		super("Gestion de Contratos");
		this.setBounds(0,0,800,600);

		PanelContrato pc = new PanelContrato();
	

		
		this.getContentPane().add(pc);
		
	}
	
	



	public static void main(String[] args) {

		Principal.getInstance().setVisible(true);
		
	}

}
