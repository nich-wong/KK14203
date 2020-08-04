import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	JMenuBar menuBar1;
	String text = "Output: ";
	MyPanel panel;
	
	public MyFrame() {
		
		JMenuBar menuBar1;
		JMenu menu1 = new JMenu ("Menu");
        JMenuItem menuLoad = new JMenuItem("Load Data");
        JMenuItem menuExit = new JMenuItem("Exit");
        menu1.add(menuLoad);
        menu1.add(menuExit);
        
        menuBar1 = new JMenuBar();
        menuBar1.add(menu1);
        
		setTitle("Evaluation");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setJMenuBar(menuBar1);
        getContentPane().add (panel = new MyPanel());
        pack();
        setVisible (true);
        
        menuExit.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		int confirmed = JOptionPane.showConfirmDialog(null, 
        			"Are you sure you want to exit the program?", "Exit Program Message Box",
        			JOptionPane.YES_NO_OPTION);
            	if (confirmed == JOptionPane.YES_OPTION) dispose();
        	}
        });
        
        menuLoad.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		
        	    try {
        	    	FileReader reader = new FileReader("Students's Evaluation.txt"); 
        	    	int i;    
        	        while((i=reader.read())!=-1) text +=(char)i;   
        	        panel.setTextArea(text);
        	        reader.close();    
	        	    
				} catch (IOException e1) {
					e1.printStackTrace();
				}   
        	    	
        	}
        });
        
	}
}
