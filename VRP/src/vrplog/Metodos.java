package vrplog;

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

//import Login.Panel;
//import Login.Login;

public class Metodos {
	public static Login pro = new Login();
	public static ResultSet rs;
	public static int ci;
	public static ArrayList<Integer> fila;
	public static DefaultTableModel dtm = new DefaultTableModel(0, 0);
	public static boolean enc = false;
	public static String cate = "";
	public static String str = "";
	public static boolean coin = false;
	public static int CodArt;
	public static Statement statement;
	public static Connection conexion = null;
	public static String un="";
	public static String ps="";
	public static void conectar(String password, String username){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/vrplog?useSSL=false";
		try {
		    conexion = DriverManager.getConnection(url, username, password);
			statement = conexion.createStatement();
			un=username;
			ps=password;
		} catch (SQLException e) {
			JOptionPane.showConfirmDialog(null, "No se ha podido conectar a la base de datos","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			String un="";
			String ps="";	
		}
		// if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
	}
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
			conectar(ps,un);
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void actualizar(String update) {
		try {
			conectar(ps,un);
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

	

}