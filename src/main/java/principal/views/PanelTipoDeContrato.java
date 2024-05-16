package principal.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import principal.controllers.ControladorTipOContrato;
import principal.controllers.DatosDeTabla;
import principal.model.Contrato;
import principal.model.Tipocontrato;

import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelTipoDeContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfBusqueda;
	private JTable table;
	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();
	private JScrollPane scrollPane;
	private JButton btnOk;
	private static Tipocontrato currentTipoContrato = null;

	/**
	 * Create the panel.
	 */
	public PanelTipoDeContrato() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		jtfBusqueda = new JTextField();
		jtfBusqueda.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
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
		
		 scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		
		this.dtm = getDefaultTableModelNoEditable();
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Object value = datosEnTabla[table.getSelectedRow()][0];
				Tipocontrato tc = (Tipocontrato) ControladorTipOContrato.getInstance().find((int)value);
				
				
				currentTipoContrato = tc;
			}
		});
		scrollPane.setViewportView(table);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
				
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridx = 0;
		gbc_btnOk.gridy = 2;
		add(btnOk, gbc_btnOk);

	}
	
	public void cerrar() {
		JDialog miDialogo = PanelContrato.getDialogo();
		if (miDialogo != null) {
			miDialogo.dispose();
		}
	}
	
	public static Tipocontrato getTipoContrato(Contrato c){
//		currentTipoContrato = c.getTipocontrato();
		if(currentTipoContrato != null) {
			return currentTipoContrato;
		}
		else {
			System.out.println("El Tipo de Contrato es nulo");
		}
		return null;
	}
	
	
	private void buscar() {
		List<Tipocontrato> e = (List<Tipocontrato>) ControladorTipOContrato.getInstance().
				findbyString(this.jtfBusqueda.getText().toLowerCase(), "tipocontrato");
		Object[][] datosFiltrados = new Object[e.size()][2];
		for (int i = 0; i < e.size(); i++) {
			currentTipoContrato = e.get(i);
			datosFiltrados[i][0] = currentTipoContrato.getId();
			datosFiltrados[i][1] = currentTipoContrato.getDescripcion();
	} 
        dtm = new DefaultTableModel(datosFiltrados, titulosEnTabla);
        table = new JTable(dtm); 
    table.setModel(dtm); 
    this.scrollPane.setViewportView(table);
	}
	
	
	
	private DefaultTableModel getDefaultTableModelNoEditable () {
		 dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			
			/**
			 * La sobreescritura de este método nos permite controlar qué celdas queremos que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 1) {
					return false;
				}
				return true;
			}
		};
		return dtm;
	}
	
	
	
	
	

}
