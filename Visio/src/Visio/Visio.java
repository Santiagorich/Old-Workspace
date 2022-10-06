package Visio;

import java.awt.MouseInfo;

import javax.swing.JFrame;
import javax.swing.KeyStroke;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.view.mxCellEditor;
import com.mxgraph.view.mxGraph;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Event;
import java.awt.event.MouseMotionAdapter;

public class Visio extends JFrame 
{		
	static Object last = null;

	static double y;
    static double x;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	public Visio() 
	{
		getContentPane().setEnabled(false);
		setType(Type.UTILITY);
		getContentPane().setBackground(Color.WHITE);
		mxCellEditor editor = new mxCellEditor(null);
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		graphComponent.getGraphControl().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			         y= e.getY();
			         x= e.getX();
			}
			
		});
		
		graphComponent.getGraphControl().setBackground(Color.WHITE);
		graphComponent.setFocusable(false);
		getContentPane().add(graphComponent);
		KeyStroke key =KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if (e.getKeyCode()==KeyEvent.VK_1){	
					graph.getModel().beginUpdate();
				   last=graph.insertVertex(parent, null, null,x , y, 80, 30);
				   graph.getModel().endUpdate();				
				}
				if (e.getKeyCode()==KeyEvent.VK_2){
					graph.getModel().beginUpdate();
					last=graph.insertVertex(parent, null, null, x, y, 80, 30,"shape=rhombus");
					   graph.getModel().endUpdate();
					   
				}
				if (e.getKeyCode()==KeyEvent.VK_RIGHT){
					graph.getModel().beginUpdate();
					graph.selectNextCell();
					   graph.getModel().endUpdate();	
					}
				if (e.getKeyCode()==KeyEvent.VK_LEFT){
					graph.getModel().beginUpdate();
					graph.selectPreviousCell();
					 graph.getModel().endUpdate();
					}
				if (e.getKeyCode()==KeyEvent.VK_3){
					if(graph.isSelectionEmpty()!=true){
						graph.getModel().beginUpdate();

					Object v1 = graph.insertVertex(parent, null, null, x,y, 30, 30,"fillColor=none;shape=text;");
					graph.insertEdge(parent, null, null, graph.getSelectionCell(),v1);
					 graph.getModel().endUpdate();

					}
					else{
						graph.getModel().beginUpdate();

					Object v1 = graph.insertVertex(parent, null, null, x,y, 30, 30,"fillColor=none;shape=text;");
					graph.insertEdge(parent, null, null, last,v1);
					editor.getEditingCell();
					graph.getModel().endUpdate();
					

					}
					
					   if((e.getKeyChar() == 0x1a)) {
				            
				        System.out.println("Algo");
				    }

						
				
				}
				}
		});};
		


	public static void main(String[] args)
	{
		
		Visio frame = new Visio();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 320);		
		frame.setVisible(true);
		frame.setExtendedState(MAXIMIZED_BOTH);
		
		
		
	}

}