package Proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import javax.sound.midi.Synthesizer;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import Proyecto.Panel;
import Proyecto.Proyecto;

public class Metodos {
	public static Proyecto pro = new Proyecto();
	public static ResultSet rs;
	public static int ci;
	public static ArrayList<Integer> fila;
	public static DefaultTableModel dtm = new DefaultTableModel(0, 0);
	public static boolean enc = false;
	public static String cate = "";
	public static String str = "";
	public static boolean coin = false;
	public static int CodArt;

	public static boolean driver() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void consulta(String query) {
		try {
			Connection conexion = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Proyecto;user=sa;password=123456789;");
			Statement statement = conexion.createStatement();
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void actualizar(String update) {
		try {
			Connection conexion = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Proyecto;user=sa;password=123456789;");
			Statement statement = conexion.createStatement();
			statement.executeUpdate(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void consultas(){

			try {
				consulta(Panel.textField.getText());
				Panel.textField.setText("");
				Panel.table_2.setModel(buildTableModel(rs));
			} catch (SQLException e) {
				e.printStackTrace();
			}


	}
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	public static void login(JPasswordField pass, JTextField user) {

		try {
			// Nombre_Usuario
			
			String password = new String(pass.getPassword());
			consulta("SELECT CI_Usu FROM Usuario");
			while (rs.next()) {

				ci = rs.getInt("CI_Usu");

				if (password.contains(String.valueOf(ci))) {

					consulta("SELECT tipo_usu FROM Usuario WHERE CI_Usu=" + ci);

					while (rs.next()) {

						if (rs.getString("tipo_usu").contains("Administrador")) {

							consulta("SELECT Nombre_Usuario FROM Usuario WHERE CI_Usu=" + ci);
							while (rs.next()) {

								if ("useradmin".contains(rs.getString("Nombre_Usuario"))) {
									Panel ad = new Panel();
									enc = true;
								}
							}
						} else if ("Operador".contains(rs.getString("tipo_usu"))) {

							consulta("SELECT Nombre_Usuario FROM Usuario WHERE CI_Usu=" + ci);
							while (rs.next()) {
								if ("userope".contains(rs.getString("Nombre_Usuario"))) {
									Panel op = new Panel();
									op.btnNewButton_1.setEnabled(false);
									op.btnNewButton_1.setVisible(false);
									enc = true;
								}
							}
						}
					}
				}
			}
			if (enc == false) {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
				Proyecto window = new Proyecto();
				window.frame.setVisible(true);
			}

		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());

		}
	}

	public static void fetchAll(JTable table) {
		try {
			dtm = new DefaultTableModel(0, 0);
			
			dtm.setColumnIdentifiers(new String[] { "Cedula", "Nombre", "Apellido", "Apellido 2", "Telefono", "Celular",
					"Categoria", "Estado" });
			consulta("SELECT CIEmpleado,Nombre,Apellido1,Apellido2,Telefono,Celular,Categoria,Estado FROM Empleado");
			while (rs.next()) {
				dtm.addRow(new Object[] { rs.getString("CIEmpleado"), rs.getString("Nombre"), rs.getString("Apellido1"),
						rs.getString("Apellido2"), rs.getString("Telefono"), rs.getString("Celular"),
						rs.getString("Categoria"), rs.getString("Estado") });
			}
			table.setModel(dtm);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	public static void fetchPar(JTable table) {
		try {
			dtm = new DefaultTableModel(0, 0);
			dtm.setColumnIdentifiers(new String[] { "Cedula","Inicio", "Finalizacion", "Estado" });
			consulta("SELECT Empleado.CIEmpleado,Estado,FechaInicio,FechaFinal from Empleado,Brinda where Empleado.CIEmpleado=Brinda.CIEmpleado;");
			while (rs.next()) {

				dtm.addRow(new Object[] { rs.getString("CIEmpleado"),rs.getString("FechaInicio"),
						rs.getString("FechaFinal"),rs.getString("Estado") });
			}
			table.setModel(dtm);
		} catch (SQLException e) {
			e.printStackTrace();

		} 
	}

	public static void eliminar(JTable table) {
		for (int e = 0; e < table.getSelectedRows().length; e++) {
			try {
				consulta("SELECT * FROM Practica WHERE CIEmpleado=" + table.getValueAt(table.getSelectedRows()[e], 0));

				while (rs.next()) {
					if (rs.getString("CodArt") != "") {
						CodArt = Integer.parseInt(rs.getString("CodArt"));
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			actualizar("DELETE FROM Empleado where CIEmpleado=" + table.getValueAt(table.getSelectedRows()[e], 0));
			actualizar("DELETE FROM Practica where CIEmpleado=" + table.getValueAt(table.getSelectedRows()[e], 0));
			actualizar("DELETE FROM NomArt where CodArt=" + CodArt);
			actualizar("DELETE FROM ArteMarcial where CodArt=" + CodArt);

		}
		fetchAll(table);
	}

	public static void categorizar() {
		if (Ingresar.tiempo.isSelected() && Ingresar.libreta.isSelected() && Ingresar.porte.isSelected()) {
			cate = ("VIP");
		} else if (Ingresar.tiempo.isSelected() && Ingresar.libreta.isSelected()) {
			cate = ("Alto A");
		} else if (Ingresar.tiempo.isSelected() && Ingresar.porte.isSelected()) {
			cate = ("Alto B");
		} else if (Ingresar.libreta.isSelected() && Ingresar.porte.isSelected()) {
			cate = ("Alto C");
		} else if (Ingresar.tiempo.isSelected()) {
			cate = ("Medio A");
		} else if (Ingresar.libreta.isSelected()) {
			cate = ("Medio B");
		} else if (Ingresar.porte.isSelected()) {
			cate = ("Medio C");
		} else if (!Ingresar.tiempo.isSelected() && !Ingresar.libreta.isSelected() && !Ingresar.porte.isSelected()) {
			cate = ("Bajo");
		}
	}

}