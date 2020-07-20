
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
		
public class MyPanel extends JPanel {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JComboBox comboTop;
    private JLabel label4;
    private JComboBox comboSize;
    private JTextField textName;
    private JButton button1;
    private JTextArea textOut;
    private JButton button2;
    private JLabel label5;
    private JTextField textQuantity;
    
    String getSize, order, priceOutput = " ", finalOutput = " ";
    double priceSize, priceOrder;
    double priceSmall = 45;
    double priceMedium = 65;
    double priceBig = 80;
    double totalPrice = 0;

    
    public MyPanel() {
        //construct preComponents
        String[] comboTopItems = {"Chocolate", "Cherries", "Whipped Cream"};
        String[] comboSizeItems = {"RM45 - Small", "RM65 - Medium", "RM80 - Large"};

        //construct components
        label1 = new JLabel ("Cake Menu");
        label2 = new JLabel ("Cake Name:");
        label3 = new JLabel ("Toppings:");
        comboTop = new JComboBox (comboTopItems);
        label4 = new JLabel ("Cake Size:");
        comboSize = new JComboBox (comboSizeItems);
        textName = new JTextField (5);
        button1 = new JButton ("Add to Order");
        textOut = new JTextArea (5, 5);
        button2 = new JButton ("Finalize Order");
        label5 = new JLabel ("Quantity:");
        textQuantity = new JTextField (5);
        
        //adjust size and set layout
        setPreferredSize (new Dimension (330, 490));
        setLayout (null);

        //add components
        add (label1);
        add (label2);
        add (label3);
        add (comboTop);
        add (label4);
        add (comboSize);
        add (textName);
        add (button1);
        add (textOut);
        add (button2);
        add (label5);
        add (textQuantity);
        

        //set component bounds (only needed by Absolute Positioning)
        label1.setBounds (120, 10, 100, 25);
        label2.setBounds (20, 45, 115, 25);
        label3.setBounds (20, 80, 105, 25);
        comboTop.setBounds (150, 80, 150, 25);
        label4.setBounds (20, 115, 100, 25);
        comboSize.setBounds (150, 115, 150, 25);
        textName.setBounds (150, 45, 150, 25);
        button1.setBounds (105, 200, 115, 25);
        textOut.setBounds (15, 240, 300, 180);
        button2.setBounds (105, 435, 115, 25);
        label5.setBounds (20, 150, 100, 25);
        textQuantity.setBounds (150, 150, 150, 25);
        
          
        textOut.setLineWrap(true);
        textOut.setWrapStyleWord(true);

        
        
        //set action listener
        button1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		switch(comboSize.getSelectedIndex()){
            	case 0: getSize = "Small";
            			priceSize = priceSmall;
            			break;
            	case 1: getSize = "Medium"; 
            			priceSize = priceMedium;
            			break;
            	case 2: getSize = "Large"; 
            			priceSize = priceBig;
            			break;
            	default: break; 
        		}
        		
        		order = (textName.getText() +" Cake ("+ textQuantity.getText() + "), Topping: " + comboTop.getSelectedItem() + ", Size: " + getSize + "\n");
        		priceOrder = priceSize * Double.parseDouble(textQuantity.getText()) + 10;
        		priceOutput = "Price: RM"+ Double.toString(priceOrder) + "\n\n";
        		textOut.append(order);
        		textOut.append(priceOutput);
        		totalPrice += priceOrder;
        		finalOutput += (order + priceOutput);
      		} 
      	});
        
        button2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		textOut.append("\nTotal Price: RM" + totalPrice);
        		finalOutput += "\nTotal Price: RM" + totalPrice;
        		
        		
        		File file = new File("Cake Order.txt");
        		PrintWriter output;
				try {
					output = new PrintWriter(file);
					output.print("Cake Order\n\n" + finalOutput);
	        		output.close();
				} catch (FileNotFoundException e1) {			
					e1.printStackTrace();
				}
        	        		
        		
      		} 
      	});
        
        
    }
    
}
