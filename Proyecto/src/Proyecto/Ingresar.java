package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Arrays;

import Proyecto.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Ingresar extends JFrame {

	private JPanel contentPane;
	private JTextField cd;
	private JTextField nm;
	private JTextField ap1;
	private JTextField ap2;
	private JTextField cel;
	private JTextField tel;
	public static JCheckBox tiempo = new JCheckBox("Tiempo completo");
	public static JCheckBox libreta = new JCheckBox("Libreta de conducir");
	public static JCheckBox porte = new JCheckBox("Porte de armas");
	private JTextField textField;
	public static int CodArt;
	public static String perform;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingresar frame = new Ingresar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ingresar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Panel.frmAdministrador.setEnabled(true);
				dispose();
			}
		});
		setTitle("Ingresar");
		setBounds(100, 100, 472, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 517, 274);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCdulaDeIdentidad = new JLabel("C\u00E9dula de Identidad");
		lblCdulaDeIdentidad.setBounds(10, 15, 102, 20);
		panel.add(lblCdulaDeIdentidad);

		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setBounds(10, 50, 102, 20);
		panel.add(lblNombre);

		JLabel lblNewLabel = new JLabel("Primer Apellido");
		lblNewLabel.setBounds(10, 85, 102, 20);
		panel.add(lblNewLabel);

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(10, 120, 102, 20);
		panel.add(lblSegundoApellido);

		cd = new JTextField();
		cd.setBounds(122, 15, 105, 20);
		cd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (cd.getText().length() == 8) {
					getToolkit().beep();
					e.consume();
				}
				if (String.valueOf(e.getKeyChar()).matches("^[a-zA-Z ñ]+$$")) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		panel.add(cd);
		cd.setColumns(10);

		nm = new JTextField();
		nm.setBounds(122, 50, 105, 20);
		nm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (!String.valueOf(e.getKeyChar()).matches("^[a-zA-Z ñ]+$$")) {
					getToolkit().beep();
					e.consume();
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		panel.add(nm);
		nm.setColumns(10);

		ap1 = new JTextField();
		ap1.setBounds(122, 85, 105, 20);
		ap1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!String.valueOf(e.getKeyChar()).matches("^[a-zA-Z ñ]+$$")) {
					getToolkit().beep();
					e.consume();
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		panel.add(ap1);
		ap1.setColumns(10);

		ap2 = new JTextField();
		ap2.setBounds(122, 120, 105, 20);
		panel.add(ap2);
		ap2.setColumns(10);
		ap2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!String.valueOf(e.getKeyChar()).matches("^[a-zA-Z ñ]+$$")) {
					getToolkit().beep();
					e.consume();
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					getToolkit().beep();
					e.consume();
				}
			}
		});

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(10, 155, 102, 20);
		panel.add(lblTelfono);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 190, 102, 20);
		panel.add(lblCelular);

		cel = new JTextField();
		cel.setBounds(122, 190, 105, 20);
		panel.add(cel);
		cel.setColumns(10);
		cel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (cel.getText().length() == 9) {
					getToolkit().beep();
					e.consume();
				}
				if (String.valueOf(e.getKeyChar()).matches("^[a-zA-Z ñ]+$$")) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		tel = new JTextField();
		tel.setBounds(122, 155, 105, 20);
		panel.add(tel);
		tel.setColumns(10);
		tel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (tel.getText().length() == 8) {
					getToolkit().beep();
					e.consume();
				}
				if (String.valueOf(e.getKeyChar()).matches("^[a-zA-Z ñ]+$$")) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Performance");
		comboBox.setBounds(244, 104, 86, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem() == "Otro") {

					textField.setVisible(true);
				} else {
					perform = comboBox.getSelectedItem().toString();
					textField.setVisible(false);
				}
			}
		});

		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Aikido", "Wing Chun", "Jiu-Jitsu", "JeetKune Do", "KFM", "Krov Mag\u00E1", "Otro" }));
		panel.add(comboBox);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(302, 240, 128, 23);
		panel.add(btnCancelar);

		JSeparator separator = new JSeparator();
		separator.setBounds(237, 15, 1, 195);
		separator.setOrientation(SwingConstants.VERTICAL);
		panel.add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 15, 197, 78);
		panel.add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Aikido", "Wing Chun", "Jiu-Jitsu", "JeetKune Do", "KFM",
					"Krov Mag\u00E1" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(87, 240, 128, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				Metodos.categorizar();
				Metodos.actualizar("INSERT INTO Empleado VALUES ('" + cd.getText() + "','" + nm.getText() + "','"
						+ ap1.getText() + "','" + ap2.getText() + "','" + tel.getText() + "','" + cel.getText() + "','"
						+ Metodos.cate + "','Disponible')");
				Metodos.consulta("SELECT TOP 1 * FROM ArteMarcial ORDER BY CodArt DESC");
				try {
					while (Metodos.rs.next()) {
						if (Metodos.rs.getString("CodArt") != "") {
							CodArt = Integer.parseInt(Metodos.rs.getString("CodArt"));
							CodArt++;
							Metodos.actualizar("INSERT INTO ArteMarcial VALUES ('" + CodArt + "')");
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				for (int i = 0; i < list.getSelectedIndices().length; i++) {
					Metodos.actualizar("INSERT INTO NomArt VALUES ('" + CodArt + "','"
							+ list.getSelectedValues()[list.getSelectedIndices()[i]] + "')");
				}
				if (textField.isVisible()) {
					perform = textField.getText();
				}

				Metodos.actualizar(
						"INSERT INTO Practica VALUES ('" + cd.getText() + "','" + CodArt + "','" + perform + "')");
				Metodos.fetchAll(Panel.table);
				dispose();
				Panel.frmAdministrador.setEnabled(true);
			}
		});
		panel.add(btnNewButton);
		tiempo.setBounds(244, 187, 246, 23);
		panel.add(tiempo);
		libreta.setBounds(244, 161, 216, 23);
		panel.add(libreta);
		porte.setBounds(244, 135, 199, 23);
		panel.add(porte);

		textField = new JTextField();
		textField.setBounds(340, 104, 103, 20);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

			}
		});
		panel.add(textField);
		textField.setVisible(false);
		textField.setColumns(10);
	}
}