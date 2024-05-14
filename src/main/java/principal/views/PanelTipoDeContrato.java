package principal.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import principal.controllers.ControladorTipOContrato;
import principal.controllers.DatosDeTabla;
import principal.model.Tipocontrato;

import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class PanelTipoDeContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfBusqueda;
	private JTable table;
	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public PanelTipoDeContrato() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
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
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		
		this.dtm = getDefaultTableModelNoEditable();
		table = new JTable(dtm);
		scrollPane.setViewportView(table);

	}
	
	
	private void buscar() {
		List<Tipocontrato> e = (List<Tipocontrato>) ControladorTipOContrato.getInstance().
				findbyString(this.jtfBusqueda.getText().toLowerCase(), "tipocontrato");
		Object[][] datosFiltrados = new Object[e.size()][2];
		for (int i = 0; i < e.size(); i++) {
			Tipocontrato es = e.get(i);
			datosFiltrados[i][0] = es.getId();
			datosFiltrados[i][1] = es.getDescripcion();
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
