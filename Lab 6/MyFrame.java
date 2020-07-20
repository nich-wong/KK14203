import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("Cake Ordering System");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		getContentPane().add (new MyPanel());
		pack();
		setVisible (true);
		
		
	}
}