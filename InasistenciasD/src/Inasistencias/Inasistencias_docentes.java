package Inasistencias;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.sun.javafx.geom.Rectangle;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Inasistencias_docentes {
	private String Hoy = "";
	private JFrame frmInasistenciasDocentes;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inasistencias_docentes window = new Inasistencias_docentes();
					window.frmInasistenciasDocentes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inasistencias_docentes() {
		initialize();
	}

	private void initialize() {
		frmInasistenciasDocentes = new JFrame();
		frmInasistenciasDocentes.setTitle("Inasistencias Docentes");
		frmInasistenciasDocentes.setBounds(100, 100, 849, 418);
		frmInasistenciasDocentes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnNewButton = new JButton("Falta Hoy");
		btnNewButton.setBounds(10, 46, 110, 23);
		btnNewButton.setEnabled(false);
		frmInasistenciasDocentes.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 11, 693, 357);
		frmInasistenciasDocentes.getContentPane().add(scrollPane);

		JButton btnNewButton_1 = new JButton("Grupo IE");
		btnNewButton_1.setEnabled(false);
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("MoolBoran", Font.PLAIN, 22));
		scrollPane.setViewportView(textArea);
		JButton btnRefrescar = new JButton("Refrescar");
		btnNewButton_1.setBounds(10, 80, 110, 23);
		frmInasistenciasDocentes.getContentPane().add(btnNewButton_1);
		frmInasistenciasDocentes.getContentPane().add(btnNewButton);
		btnRefrescar.setBounds(10, 12, 110, 23);
		frmInasistenciasDocentes.getContentPane().add(btnRefrescar);

		JButton btnNoticias = new JButton("Noticias");
		btnNoticias.setEnabled(false);
		btnNoticias.setBounds(10, 345, 110, 23);
		frmInasistenciasDocentes.getContentPane().add(btnNoticias);

		JLabel lblProximamente = new JLabel("Proximamente :");
		lblProximamente.setHorizontalAlignment(SwingConstants.CENTER);
		lblProximamente.setBounds(10, 320, 110, 14);
		frmInasistenciasDocentes.getContentPane().add(lblProximamente);
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "http://its.edu.uy/its/modulos/inasistencias_docentes/inasistencias_mostrar_web.php";

				try {
					String Desde = "";
					String Hasta = "";
					String Just = "";
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date date = new Date();
					int contador = 1;
					WebClient webClient = new WebClient();
					HtmlPage currentPage = webClient.getPage(url);
					DOMSource domSource = new DOMSource(currentPage.getDocumentElement());
					StringWriter writer = new StringWriter();
					StreamResult result = new StreamResult(writer);
					TransformerFactory tf = TransformerFactory.newInstance();
					Transformer transformer = tf.newTransformer();
					transformer.transform(domSource, result);
					String html = writer.toString();
					String Texto = "";
					Document doc = Jsoup.parse(html);
					Document document = doc;

					while (contador <= document.getElementsByClass("TablaPar").size()
							+ document.getElementsByClass("TablaImPar").size()) {
						Date Date3 = (dateFormat.parse(
								document.select("#the-table > tbody > tr:nth-child(" + contador + ")> td:nth-child(3)")
										.text()));
						Date Date2 = (dateFormat.parse(
								document.select("#the-table > tbody > tr:nth-child(" + contador + ")> td:nth-child(2)")
										.text()));
						Just = document.select("#the-table > tbody > tr:nth-child(" + contador + ")> td:nth-child(1)")
								.text();
						String out = new String(Just.getBytes("ISO-8859-1"), "UTF-8").substring(1);
						Desde = "  Desde: " + document
								.select("#the-table > tbody > tr:nth-child(" + contador + ")> td:nth-child(2)").text();
						Hasta = "  Hasta: " + document
								.select("#the-table > tbody > tr:nth-child(" + contador + ")> td:nth-child(3)").text();
						Texto = Texto + out.toUpperCase() + Desde + Hasta + "\r\n";
						
						if ((date.after(Date2) && date.before(Date3)||date.equals(Date2)||date.equals(Date3))) {

							if (Texto != "\r\n") {
								Hoy = Hoy + out + "\r\n";
							}
						}
						contador++;

					}
					textArea.setText(Texto);
					btnNewButton.setEnabled(true);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							textArea.setText("  Fecha: " + dateFormat.format(date) + "\r\n" + Hoy + "");
							btnNewButton_1.setEnabled(true);
							btnNewButton_1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									String Texto2 = "";
									Calendar calendar = Calendar.getInstance();
									Date date = calendar.getTime();
									int contador = 1;
									String[] text = textArea.getText().split("\r\n");
									String op = (new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()));
									textArea.setText("");
									while (contador < text.length) {
										switch (op) {

										case "Monday":
											if (text[contador].contains("CASTRO") && text[contador].contains("JOSE")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de Ingles (1 Hora,entras 13:20)" + "\r\n");

											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("VILLAMIL")
													&& text[contador].contains("SILVIA")) {
												Texto2 = Texto2 + ("Hoy no hay clase de APT (1 Hora)" + "\r\n");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("ARES") && text[contador].contains("MANUEL")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de Electronica  (3 Horas)" + "\r\n");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("GIACOBBE")
													&& text[contador].contains("RUDDY")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de Diseño Web  (2 Horas)" + "\r\n");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("LATIERRO")
													&& text[contador].contains("HUGO")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de Matematica  (1 Hora,sales 18:10)"
																+ "\r\n");
											} else {
												contador++;
												continue;
											}
										case "Tuesday":
											if (text[contador].contains("HERNANDEZ")
													&& text[contador].contains("NORA")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de Programacion  (3 Horas,entras 14:50)"
																+ "\r\n");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("LATIERRO")
													&& text[contador].contains("HUGO")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de Matematica  (2 Horas)" + "\r\n");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("FERNANDEZ L")) {
												Texto2 = Texto2 + ("Hoy no hay clase de Quimica  (2 Horas,sales 16:40)"
														+ "\r\n");
											} else {
												contador++;
												continue;
											}
										case "Wednesday":
											if (text[contador].contains("VILLAMIL")
													&& text[contador].contains("SILVIA")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de APT (2 Horas,entras 14:05)" + "\r\n");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("OLAZARRI")) {

												Texto2 = Texto2 + ("Hoy no hay clase de Geometria (2 Horas)" + "\r\n");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("CHIRIBAO")
													&& text[contador].contains("ESTHER")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de Sistema Operativo (3 Horas)" + "\r\n");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("LIZUAIN")
													&& text[contador].contains("CARLOS")) {
												Texto2 = Texto2 + ("Hoy no hay clase de Economia (1 Hora,sales 18:10)"
														+ "\r\n");
											} else {
												contador++;
												continue;
											}
										case "Thursday":
											if (text[contador].contains("OLAZARRI")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de Geometria (1 Hora, entras 14:50)"
																+ "\r\n");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("FERNANDEZ L")) {
												Texto2 = Texto2 + ("Hoy no hay clase de Quimica (1 Hora)" + "\r\n");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("NUÑEZ") && text[contador].contains("VICTOR")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de Taller de mantenimiento(4 Horas,sales 15:35)"
																+ "\r\n");
											} else {
												contador++;
												continue;
											}
										case "Friday":
											if (text[contador].contains("GONZALEZ") && text[contador].contains("ANA")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de Base de Datos (3 Horas,entras 14:50 ");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("LIZUAIN")
													&& text[contador].contains("CARLOS")) {
												Texto2 = Texto2 + ("Hoy no hay clase de Economia(2 Horas)" + "\r\n");
											} else {
												contador++;
												continue;
											}
											if (text[contador].contains("CASTRO") && text[contador].contains("JOSE")) {
												Texto2 = Texto2
														+ ("Hoy no hay clase de Ingles(2 Horas,sales 16:40)" + "\r\n");
											} else {
												contador++;
												continue;
											}

										}

									}
									if (Texto2 == "") {
										textArea.setText("No falta nadie para nuestro grupo :( \r\n");
										switch (op) {
										case "Monday":
											textArea.append("Hoy entras 12:35\r\n");
											textArea.append(
													"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\r\n");
											textArea.append("Materias de hoy:\r\n");
											textArea.append("Ingles\r\n");
											textArea.append("APT\r\n");
											textArea.append("Electronica\r\n");
											textArea.append("Diseño Web\r\n");
											textArea.append("Matematica\r\n");
											break;
										case "Tuesday":
											textArea.append("Hoy entras 12:35\r\n");
											textArea.append(
													"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\r\n");
											textArea.append("Materias de hoy:\r\n");
											textArea.append("Programaciòn\r\n");
											textArea.append("Matematica\r\n");
											textArea.append("Quimica\r\n");
											break;
										case "Wednesday":
											textArea.append("Hoy entras 12:35\r\n");
											textArea.append(
													"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\r\n");
											textArea.append("Materias de hoy:\r\n");
											textArea.append("APT\r\n");
											textArea.append("Geometria\r\n");
											textArea.append("Sistema Operativo\r\n");
											textArea.append("Economia\r\n");
											break;
										case "Thursday":
											textArea.append("Hoy entras 14:05\r\n");
											textArea.append(
													"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\r\n");
											textArea.append("Materias de hoy:\r\n");
											textArea.append("Geometria\r\n");
											textArea.append("Quimica\r\n");
											textArea.append("Taller\r\n");
											break;
										case "Friday":
											textArea.append("Hoy entras 12:35\r\n");
											textArea.append(
													"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------\r\n");
											textArea.append("Materias de hoy:\r\n");
											textArea.append("Base de Datos\r\n");
											textArea.append("Economia\r\n");
											textArea.append("Ingles\r\n");
											break;
										}
									} else {
										textArea.setText(Texto2);
									}
								}
							});

						}
					});

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}

		});

	}
}
