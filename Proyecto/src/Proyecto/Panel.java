package Proyecto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Proyecto.Proyecto;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JList;
import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;

import Proyecto.Metodos;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import Proyecto.Ingresar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JSeparator;
import javax.swing.event.ChangeListener;
import java.awt.TextArea;
import javax.swing.JTextField;

public class Panel {
	Proyecto pro = new Proyecto();
	public static JButton btnNewButton_1 = new JButton("Eliminar");
	public static JFrame frmAdministrador;
	public int[] select;
	public static JTable table;
	public static String valor;
	public static boolean edit = false;
	public static JComboBox e = new JComboBox();
	public static JComboBox c = new JComboBox();
	public static int ns;
	private JTable table_1;
	private JPasswordField passwordField;
	public static JTable table_2;
	public static JTextField textField;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel window = new Panel();
					window.frmAdministrador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		frmAdministrador = new JFrame();
		frmAdministrador.setResizable(false);
		frmAdministrador.setTitle("Administrador");
		frmAdministrador.setBounds(100, 100, 565, 290);
		frmAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministrador.setVisible(true);
		frmAdministrador.setDefaultCloseOperation(frmAdministrador.DO_NOTHING_ON_CLOSE);
		frmAdministrador.getContentPane().setLayout(null);
		JLabel lblNroservicio = new JLabel();
		lblNroservicio.setBounds(10, 11, 140, 14);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Metodos.consulta("SELECT TOP 1 * FROM Servicio ORDER BY NumSer DESC");
				try {
					while (Metodos.rs.next()) {
						if (Metodos.rs.getString("NumSer") != "") {
							ns = Integer.parseInt(Metodos.rs.getString("NumSer"));
							ns++;
						}
					}
					lblNroservicio.setText("Nro.Servicio: "+String.valueOf(ns));
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		tabbedPane.setBounds(0, 0, 559, 261);
		tabbedPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					Proyecto window = new Proyecto();
					window.frame.setVisible(true);
					frmAdministrador.dispose();
				}
			}
		});
		frmAdministrador.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Administrar", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 534, 169);
		panel.add(scrollPane);
		table = new JTable();
		table.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
			public void editingCanceled(ChangeEvent e) {
				Metodos.actualizar("UPDATE Empleado SET " + table.getColumnName(table.getSelectedColumn()) + "='"
						+ table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()) + "' where "
						+ table.getColumnName(table.getSelectedColumn()) + "='" + Panel.valor + "'");
			}

			public void editingStopped(ChangeEvent e) {
				Metodos.actualizar("UPDATE Empleado SET " + table.getColumnName(table.getSelectedColumn()) + "='"
						+ table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()) + "' where "
						+ table.getColumnName(table.getSelectedColumn()) + "='" + Panel.valor + "'");

			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				valor = table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();

			}
		});

		scrollPane.setViewportView(table);

		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.WHITE);
		table.setVisible(true);
		table.setLayout(new GridLayout(0, 5, 3, 3));
		table.setForeground(Color.black);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		Metodos.fetchAll(table);
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingresar in = new Ingresar();
				in.setVisible(true);

				frmAdministrador.setEnabled(false);
			}
		});
		
		btnNewButton.setBounds(29, 199, 102, 23);
		panel.add(btnNewButton);

		c.setModel(new DefaultComboBoxModel(
				new String[] { "VIP", "Alto A", "Alto B", "Alto C", "Medio A", "Medio B", "Medio C", "Bajo" }));

		e.setModel(new DefaultComboBoxModel(new String[] { "Disponible", "Ausente" }));

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.eliminar(table);
			}
		});
		btnNewButton_1.setBounds(291, 199, 102, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Refrescar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Metodos.fetchAll(table);
			}
		});
		btnNewButton_2.setBounds(422, 199, 102, 23);
		panel.add(btnNewButton_2);

		JToggleButton tglbtnNewToggleButton = new JToggleButton("Editor");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (edit = false) {
					table.setCellSelectionEnabled(true);
					table.setRowSelectionAllowed(false);
					table.setColumnSelectionAllowed(false);
					table.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(c));
					table.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(e));
				} else {
					table.setCellSelectionEnabled(false);
					table.setRowSelectionAllowed(true);
					table.setColumnSelectionAllowed(true);
				}
			}
		});
		tglbtnNewToggleButton.setBounds(160, 199, 102, 23);
		panel.add(tglbtnNewToggleButton);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Contrataciones", null, panel_2, null);
		panel_2.setLayout(null);
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Numero de cliente");
		passwordField.setBounds(85, 52, 65, 20);
		panel_2.add(passwordField);

		JLabel lblNewLabel = new JLabel("Nro.Cliente:");
		lblNewLabel.setBounds(10, 57, 65, 14);
		panel_2.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "VIP", "Alto", "Medio", "Bajo" }));
		comboBox.setBounds(85, 102, 65, 20);
		panel_2.add(comboBox);
		panel_2.add(lblNroservicio);
		
		JSpinner FechaInicio = new JSpinner();	
		FechaInicio.setModel(new SpinnerDateModel(new Date(1509418800000L), new Date(1509418800000L), null, Calendar.DAY_OF_YEAR));
		FechaInicio.setBounds(85, 152, 65, 20);
		panel_2.add(FechaInicio);
		
		JSpinner FechaFinal = new JSpinner();
		FechaFinal.setModel(new SpinnerDateModel(new Date(1509418800000L), new Date(1506826800000L), null, Calendar.DAY_OF_YEAR));
		FechaFinal.setBounds(85, 202, 65, 20);
		panel_2.add(FechaFinal);
		
		JLabel lblFechaInicial = new JLabel("Fecha Inicial:");
		lblFechaInicial.setBounds(10, 155, 90, 14);
		panel_2.add(lblFechaInicial);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final:");
		lblFechaFinal.setBounds(10, 204, 90, 14);
		panel_2.add(lblFechaFinal);
		
		JLabel lblServicio = new JLabel("Servicio:");
		lblServicio.setBounds(10, 106, 65, 14);
		panel_2.add(lblServicio);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(246, 11, 2, 176);
		panel_2.add(separator);
		
		JButton btnContratar = new JButton("Contratar");
		btnContratar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(passwordField.getPassword());
				for (int a = 0; a < table_1.getSelectedRows().length; a++) {
				Metodos.actualizar("INSERT INTO Brinda VALUES ('"+table_1.getValueAt(table_1.getSelectedRows()[a], 0)+"','"+FechaInicio+"','"+FechaFinal.getValue()+"')");
				}
				Metodos.actualizar("INSERT INTO Servicio VALUES ('" + ns +"','"+comboBox.getSelectedItem()+"','"+password+"')");
				lblNroservicio.setText("Nro.Servicio: "+ns);
				}
		});
		btnContratar.setBounds(351, 199, 105, 23);
		panel_2.add(btnContratar);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(258, 11, 286, 176);
				panel_2.add(scrollPane_1);
		
				table_1 = new JTable();
				scrollPane_1.setViewportView(table_1);
				table_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				table_1.setColumnSelectionAllowed(true);
				table_1.setBackground(Color.WHITE);
				table_1.setVisible(true);
				table_1.setLayout(new GridLayout(0, 5, 3, 3));
				table_1.setForeground(Color.black);
				table_1.setPreferredScrollableViewportSize(new Dimension(500, 70));
				table_1.setFillsViewportHeight(true);
				table_1.setColumnSelectionAllowed(false);
				table_1.setRowSelectionAllowed(true);
				Metodos.fetchPar(table_1);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Consultas", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 31, 554, 202);
		panel_3.add(scrollPane_2);
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_2.setColumnSelectionAllowed(true);
		table_2.setBackground(Color.WHITE);
		table_2.setVisible(true);
		table_2.setLayout(new GridLayout(0, 5, 3, 3));
		table_2.setForeground(Color.black);
		table_2.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table_2.setFillsViewportHeight(true);
		table_2.setColumnSelectionAllowed(false);
		table_2.setRowSelectionAllowed(true);
		textField = new JTextField();
		textField.setBounds(0, 0, 455, 20);
		panel_3.add(textField);
		
		JButton btnNewButton_3 = new JButton("Consultar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.consultas();
			}
		});
		btnNewButton_3.setBounds(465, -1, 89, 23);
		panel_3.add(btnNewButton_3);
		
		
		

		frmAdministrador.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int op = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere salir?", "Salir",
						JOptionPane.YES_NO_OPTION);
				if (op == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}
}