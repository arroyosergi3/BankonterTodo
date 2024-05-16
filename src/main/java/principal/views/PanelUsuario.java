package principal.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import principal.controllers.ControladorUsuario;
import principal.model.Usuario;

import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class PanelUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfBusqueda;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnApellido;
	private JRadioButton rdbtnNombre;
	private JRadioButton rdbtnDninie;
	private JCheckBox chckbxCaseSensitive;
	private JList list;
	private JButton btnOk;
	private DefaultListModel<Usuario> listModelusuario = null;
	private static Usuario u = null;


	/**
	 * Create the panel.
	 */
	public PanelUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		jtfBusqueda = new JTextField();
		jtfBusqueda.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				listModelusuario.removeAllElements();
				buscar();
				
			}
		});
		GridBagConstraints gbc_jtfBusqueda = new GridBagConstraints();
		gbc_jtfBusqueda.insets = new Insets(0, 0, 5, 0);
		gbc_jtfBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBusqueda.gridx = 0;
		gbc_jtfBusqueda.gridy = 0;
		add(jtfBusqueda, gbc_jtfBusqueda);
		jtfBusqueda.setColumns(10);
		
		 rdbtnApellido = new JRadioButton("Apellido");
		buttonGroup.add(rdbtnApellido);
		GridBagConstraints gbc_rdbtnApellido = new GridBagConstraints();
		gbc_rdbtnApellido.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnApellido.gridx = 0;
		gbc_rdbtnApellido.gridy = 1;
		add(rdbtnApellido, gbc_rdbtnApellido);
		
		 rdbtnNombre = new JRadioButton("Nombre");
		buttonGroup.add(rdbtnNombre);
		GridBagConstraints gbc_rdbtnNombre = new GridBagConstraints();
		gbc_rdbtnNombre.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNombre.gridx = 0;
		gbc_rdbtnNombre.gridy = 2;
		add(rdbtnNombre, gbc_rdbtnNombre);
		
		 rdbtnDninie = new JRadioButton("DNI/NIE");
		buttonGroup.add(rdbtnDninie);
		GridBagConstraints gbc_rdbtnDninie = new GridBagConstraints();
		gbc_rdbtnDninie.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnDninie.gridx = 0;
		gbc_rdbtnDninie.gridy = 3;
		add(rdbtnDninie, gbc_rdbtnDninie);
		
		 chckbxCaseSensitive = new JCheckBox("Case Sensitive");
		GridBagConstraints gbc_chckbxCaseSensitive = new GridBagConstraints();
		gbc_chckbxCaseSensitive.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxCaseSensitive.gridx = 0;
		gbc_chckbxCaseSensitive.gridy = 4;
		add(chckbxCaseSensitive, gbc_chckbxCaseSensitive);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		add(scrollPane, gbc_scrollPane);
		
		 list = new JList(this.getDefaultListModel());
		scrollPane.setViewportView(list);
		
		 btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridx = 0;
		gbc_btnOk.gridy = 6;
		add(btnOk, gbc_btnOk);

	}
	
	public static Usuario getUsuario() {
		if (u != null) {
			return u;
		}
		else {
			System.out.println("El usuario es nulo");
			return null;
		}
		
	}
	
	public void buscar() {
		List<Usuario> usuariosParaLista = null;
		
		if (rdbtnApellido.isSelected()) {
			 usuariosParaLista = 	(List<Usuario>) ControladorUsuario.getInstance().findbyString(this.jtfBusqueda.getText(), "usuario", "apellido", this.chckbxCaseSensitive.isSelected());
			
		}
		if (rdbtnNombre.isSelected()) {
			 usuariosParaLista = 	(List<Usuario>) ControladorUsuario.getInstance().findbyString(this.jtfBusqueda.getText(), "usuario", "nombreUsuario", this.chckbxCaseSensitive.isSelected());
			
		}
		
		if (usuariosParaLista != null) {
			for (Usuario usuario : usuariosParaLista) {
				this.listModelusuario.addElement(usuario);
			}
			
		}
		
	}
	
	
	private DefaultListModel getDefaultListModel () {
		this.listModelusuario = new DefaultListModel<Usuario>();
		return this.listModelusuario;
	}
	
	
	
	
	
	
	
	
	
	

}
