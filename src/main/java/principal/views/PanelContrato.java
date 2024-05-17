package principal.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import principal.controllers.ControladorContrato;
import principal.model.Contrato;
import principal.model.Tipocontrato;
import principal.model.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PanelContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfDescripcion;
	private JTextField jtfTipoContrato;
	private JTextField jtfUsuario;
	private Contrato current;
	private JFormattedTextField jftfFecha;
	private JSpinner jspLimite;
	private JSlider jslSaldo;
	private JLabel lblSaldoActual;
	private static JDialog currentDialog;

	/**
	 * Create the panel.
	 */
	public PanelContrato() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPrimero();
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarUltimo();
			}
		});
		btnUltimo.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/nuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/eliminar.png")));
		toolBar.add(btnEliminar);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 160, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblGestinDeContratos = new JLabel("Gestión de Contratos");
		GridBagConstraints gbc_lblGestinDeContratos = new GridBagConstraints();
		gbc_lblGestinDeContratos.gridwidth = 3;
		gbc_lblGestinDeContratos.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestinDeContratos.gridx = 0;
		gbc_lblGestinDeContratos.gridy = 0;
		panel.add(lblGestinDeContratos, gbc_lblGestinDeContratos);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 1;
		panel.add(lblDescripcion, gbc_lblDescripcion);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 1;
		panel.add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 2;
		panel.add(lblFecha, gbc_lblFecha);
		
		 jftfFecha = new JFormattedTextField();
		GridBagConstraints gbc_jftfFecha = new GridBagConstraints();
		gbc_jftfFecha.gridwidth = 2;
		gbc_jftfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jftfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jftfFecha.gridx = 1;
		gbc_jftfFecha.gridy = 2;
		panel.add(jftfFecha, gbc_jftfFecha);
		
		JLabel lblLmite = new JLabel("Límite:");
		GridBagConstraints gbc_lblLmite = new GridBagConstraints();
		gbc_lblLmite.insets = new Insets(0, 0, 5, 5);
		gbc_lblLmite.gridx = 0;
		gbc_lblLmite.gridy = 3;
		panel.add(lblLmite, gbc_lblLmite);
		
		 jspLimite = new JSpinner();
		GridBagConstraints gbc_jspLimite = new GridBagConstraints();
		gbc_jspLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jspLimite.gridwidth = 2;
		gbc_jspLimite.insets = new Insets(0, 0, 5, 0);
		gbc_jspLimite.gridx = 1;
		gbc_jspLimite.gridy = 3;
		panel.add(jspLimite, gbc_jspLimite);
		
		JLabel lblNewLabel = new JLabel("Saldo:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 4;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		 jslSaldo = new JSlider();
		 jslSaldo.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent e) {
		 		lblSaldoActual.setText("Saldo Actual: " + (int)jslSaldo.getValue());
		 	}
		 });
		GridBagConstraints gbc_jslSaldo = new GridBagConstraints();
		gbc_jslSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jslSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_jslSaldo.gridx = 1;
		gbc_jslSaldo.gridy = 4;
		panel.add(jslSaldo, gbc_jslSaldo);
		
		lblSaldoActual = new JLabel("Saldo:");
		GridBagConstraints gbc_lblSaldoActual = new GridBagConstraints();
		gbc_lblSaldoActual.insets = new Insets(0, 0, 5, 0);
		gbc_lblSaldoActual.gridx = 2;
		gbc_lblSaldoActual.gridy = 4;
		panel.add(lblSaldoActual, gbc_lblSaldoActual);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato:");
		GridBagConstraints gbc_lblTipoDeContrato = new GridBagConstraints();
		gbc_lblTipoDeContrato.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDeContrato.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeContrato.gridx = 0;
		gbc_lblTipoDeContrato.gridy = 5;
		panel.add(lblTipoDeContrato, gbc_lblTipoDeContrato);
		
		jtfTipoContrato = new JTextField();
		jtfTipoContrato.setEnabled(false);
		GridBagConstraints gbc_jtfTipoContrato = new GridBagConstraints();
		gbc_jtfTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTipoContrato.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTipoContrato.gridx = 1;
		gbc_jtfTipoContrato.gridy = 5;
		panel.add(jtfTipoContrato, gbc_jtfTipoContrato);
		jtfTipoContrato.setColumns(10);
		
		JButton btnTipoContrato = new JButton("Seleccionar");
		btnTipoContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelTipoDeContrato ptc = new PanelTipoDeContrato();
				abrirNuevoDialogo(ptc);
				Tipocontrato tc = PanelTipoDeContrato.getTipoContrato(current);
				if (tc != null) {
					current.setTipocontrato(tc);
				}
				jtfTipoContrato.setText(current.getTipocontrato().getId() + " - " + current.getTipocontrato().getDescripcion());
			}
		});
		GridBagConstraints gbc_btnTipoContrato = new GridBagConstraints();
		gbc_btnTipoContrato.insets = new Insets(0, 0, 5, 0);
		gbc_btnTipoContrato.gridx = 2;
		gbc_btnTipoContrato.gridy = 5;
		panel.add(btnTipoContrato, gbc_btnTipoContrato);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 6;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		jtfUsuario = new JTextField();
		jtfUsuario.setEnabled(false);
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 6;
		panel.add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JButton btnUsuario = new JButton("Seleccionar");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelUsuario pu = new PanelUsuario();
				abrirNuevoDialogo(pu);
				Usuario u = PanelUsuario.getUsuario();
				if (u != null) {
					current.setUsuario(u);
				}
				
				jtfUsuario.setText( current.getUsuario().getNombreUsuario());
			}
		});
		GridBagConstraints gbc_btnUsuario = new GridBagConstraints();
		gbc_btnUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_btnUsuario.gridx = 2;
		gbc_btnUsuario.gridy = 6;
		panel.add(btnUsuario, gbc_btnUsuario);
		mostrarPrimero();

	}
	
	public static JDialog getDialogo() {
		if (currentDialog != null) {
			return currentDialog;
		}else
		{
			System.out.println("El dialogo es nulo");
			return null;
		}
	}
	
	public void abrirNuevoDialogo(JPanel panel) {
		JDialog dialogo = new JDialog();
		currentDialog = dialogo;
		// El usuario no puede redimensionar el di�logo
		dialogo.setResizable(true);
		// t�tulo del d�alogo
		dialogo.setTitle("Gestión de Tipo de Contratos");
		// Introducimos el panel creado sobre el di�logo
		dialogo.setContentPane(panel);
		// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
		
		
	}
	
	
	
	
	public void mostrarPrimero() {
		current = (Contrato) ControladorContrato.getInstance().findFirst();
		mostrarContrato();
	}
	
	public void mostrarAnterior() {
		current = (Contrato) ControladorContrato.getInstance().findPrevious(current);
		mostrarContrato();
	}
	
	public void mostrarSiguiente() {
		current = (Contrato) ControladorContrato.getInstance().findNext(current);
		mostrarContrato();
	}
	
	public void mostrarUltimo() {
		current = (Contrato) ControladorContrato.getInstance().findLast();
		mostrarContrato();
	}
	

	public void mostrarContrato() {
		if (current != null) {
			this.jtfDescripcion.setText(current.getDescripcion());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			this.jftfFecha.setText(sdf.format(current.getFechaFirma()));
			this.jtfUsuario.setText(current.getUsuario().getNombreUsuario());
			this.jslSaldo.setMaximum((int)current.getLimite());
		
			this.jspLimite.setValue((Object)current.getLimite());
			this.jslSaldo.setValue((int)current.getSaldo());
			this.jtfTipoContrato.setText(current.getId() + " - " +   current.getTipocontrato().getDescripcion());

		}
	}
	
	
	

}
