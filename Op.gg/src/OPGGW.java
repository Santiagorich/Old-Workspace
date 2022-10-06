import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import org.jsoup.*;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OPGGW {

	private JFrame frame;
	private JTextField MMR;
	private JTextField LP;
	private JTextField Wins;
	private JTextField Losses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OPGGW window = new OPGGW();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OPGGW() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    		
		JLabel lblMmr = new JLabel("MMR");
		lblMmr.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblMmr);
		
		JLabel lblLp = new JLabel("LP");
		lblLp.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblLp);
		
		JLabel lblWins = new JLabel("Wins");
		lblWins.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblWins);
		
		JLabel lblLosses = new JLabel("Losses");
		lblLosses.setBounds(10, 86, 46, 14);
		frame.getContentPane().add(lblLosses);
		
		MMR = new JTextField();
		MMR.setBounds(45, 8, 86, 20);
		frame.getContentPane().add(MMR);
		MMR.setColumns(10);
		
		LP = new JTextField();
		LP.setColumns(10);
		LP.setBounds(45, 36, 86, 20);
		frame.getContentPane().add(LP);
		
		Wins = new JTextField();
		Wins.setColumns(10);
		Wins.setBounds(45, 61, 86, 20);
		frame.getContentPane().add(Wins);
		
		Losses = new JTextField();
		Losses.setColumns(10);
		Losses.setBounds(45, 86, 86, 20);
		frame.getContentPane().add(Losses);
		
	}
}
