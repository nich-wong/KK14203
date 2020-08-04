
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.event.*;

public class MyPanel extends JPanel {
    private JLabel lblTitle;
    private JLabel lblName;
    private JLabel lblMatric;
    private JLabel lblCourse;
    private JLabel lblRating;
    private JLabel lblOutcome;
    private JButton btnSubmit;
    private JTextField textfieldName;
    private JTextField textfieldMatric;
    private JComboBox comboCourse;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JRadioButton radio4;
    private JRadioButton radio5;
    private JCheckBox checkBasic;
    private JCheckBox checkAdvanced;
    private JTextArea text1;
    private JButton btnClear;
    private ButtonGroup radioGroup;
    private ButtonGroup checkGroup;
    String text;
    String textFinal = "Student's Evaluation\n\n";

    public MyPanel() {
        //construct preComponents
        String[] comboCourseItems = {"KK14203 OOP", "KT14203 CAO", "KT14403 DS"};
        
        //construct components
        lblTitle = new JLabel ("Course Evaluation Form");
        lblName = new JLabel (" Name");
        lblMatric = new JLabel (" Matric No.");
        lblCourse = new JLabel (" Course Code");
        lblRating = new JLabel (" Rating");
        lblOutcome = new JLabel (" Outcome");
        btnSubmit = new JButton ("Submit");
        textfieldName = new JTextField (5);
        textfieldMatric = new JTextField (5);
        comboCourse = new JComboBox (comboCourseItems);
        radio1 = new JRadioButton ("1");
        radio2 = new JRadioButton ("2");
        radio3 = new JRadioButton ("3");
        radio4 = new JRadioButton ("4");
        radio5 = new JRadioButton ("5");
        checkBasic = new JCheckBox ("Basic Knowledge");
        checkAdvanced = new JCheckBox ("Advanced Knowledge");
        text1 = new JTextArea (10, 10);
        btnClear = new JButton ("Clear");
        
        //add button groups
        radioGroup = new ButtonGroup();
        radioGroup.add (radio1);
        radioGroup.add (radio2);
        radioGroup.add (radio3);
        radioGroup.add (radio4);
        radioGroup.add (radio5);
        checkGroup = new ButtonGroup();
        checkGroup.add(checkBasic);
        checkGroup.add(checkAdvanced);
        
        //adjust size and set layout
        setPreferredSize (new Dimension (391, 563));
        setLayout (null);

        //add components
        add (lblTitle);
        add (lblName);
        add (lblMatric);
        add (lblCourse);
        add (lblRating);
        add (lblOutcome);
        add (btnSubmit);
        add (textfieldName);
        add (textfieldMatric);
        add (comboCourse);
        add (radio1);
        add (radio2);
        add (radio3);
        add (radio4);
        add (radio5);
        add (checkBasic);
        add (checkAdvanced);
        add (text1);
        add (btnClear);
        
        //set component bounds (only needed by Absolute Positioning)
        lblTitle.setBounds (120, 5, 140, 25);
        lblName.setBounds (10, 40, 85, 25);
        lblMatric.setBounds (10, 70, 85, 25);
        lblCourse.setBounds (10, 100, 85, 25);
        lblRating.setBounds (10, 130, 80, 25);
        lblOutcome.setBounds (10, 160, 80, 25);
        btnSubmit.setBounds (15, 195, 100, 25);
        textfieldName.setBounds (105, 40, 165, 25);
        textfieldMatric.setBounds (105, 70, 165, 25);
        comboCourse.setBounds (105, 100, 120, 25);
        radio1.setBounds (100, 135, 35, 20);
        radio2.setBounds (140, 135, 35, 20);
        radio3.setBounds (180, 135, 35, 20);
        radio4.setBounds (220, 135, 35, 20);
        radio5.setBounds (260, 135, 35, 20);
        checkBasic.setBounds (100, 160, 130, 25);
        checkAdvanced.setBounds (230, 160, 155, 25);
        text1.setBounds (15, 235, 360, 300);
        btnClear.setBounds (130, 195, 100, 25);
        
        //action listener
        btnSubmit.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){	
        		checkValidation();
        		text1.append(text);
        		writeFile();	
        	}
        });
        
        btnClear.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){	
        			text1.setText(null);
        			deleteFromFile();
        			JOptionPane.showMessageDialog(null, "Text removed from file.");
        			textFinal = "Student's Evaluation\n\n";
        	}
        });
        
    }
    
    
    public void checkValidation() {

		String name = textfieldName.getText();
    	String matric = textfieldMatric.getText();
    	
    	//check if button groups are selected
    	boolean checkbox = false;
    	boolean radio = false;
    	if (checkBasic.isSelected() == false && checkAdvanced.isSelected() == false) {
    		checkbox = true;}
    	if (radio1.isSelected() == false && radio2.isSelected() == false && radio3.isSelected() == false && radio4.isSelected() == false &&  radio5.isSelected() == false) {
    		radio = true;}
    	
    	//check if there are empty fields
    	if (textfieldName.getText().equals("")|| textfieldMatric.getText().equals("") || checkbox == true || radio == true) {
    		JOptionPane.showMessageDialog(this,"Please fill in empty fields.");}
    	
    	else {
    		getText(name, matric);
    		JOptionPane.showMessageDialog(null, "File successfully updated");
    	}
 		
    }
    
    //additional methods
    
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
		return null;
    }
    
    public String getText(String name, String matric) {
    	String comboText = (String) comboCourse.getSelectedItem();
		String radioText = getSelectedButtonText(radioGroup);    		
		String checkboxText = getSelectedButtonText(checkGroup);

		text = name + " (" + matric + ")\nCourse: "+ comboText + " (Rating: " + radioText + ")\nOutcome: " + checkboxText + "\n\n" ;
		
		textFinal += text;
		return text;
    }
    
    public void writeFile() {
    	File file1 = new File("Students's Evaluation.txt");
		try {
			file1.createNewFile();
			FileWriter writer = new FileWriter(file1);
			writer.write(textFinal); 
		    writer.flush();
		    writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
    
    public void deleteFromFile() {
    	File file1 = new File("Students's Evaluation.txt");
		try {
			file1.createNewFile();
			FileWriter writer = new FileWriter(file1);
			writer.write(""); 
		    writer.flush();
		    writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
    
    public void setTextArea(String t) {
    	text1.setText(t);
    }
    
    
}
