package lowHigh;

// import libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lowHighProject extends JFrame
{
	//initialize text fields and password field
	private JButton button, clear;   
	private JTextField textBox1, textBox2, textBox3;
	private JLabel label1, label2, labelspace;
	
	public lowHighProject()
	{
		// super with text at the top
		super( "Show the Largest and Smallest Numbers" );
		
		//method
		prepareGUI();
	}
	
	public static void main(String[] args){
		//application object to close operation 
		lowHighProject application = new lowHighProject();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	private void prepareGUI() {
	
		 Container theWindow = getContentPane();
		 theWindow.setLayout( new FlowLayout() );
		 
		// create text field with default size
		 textBox1 = new JTextField(10);
		 theWindow.add( textBox1 );
		 
		// create text field with default text
		 textBox2 = new JTextField(10);
		 theWindow.add( textBox2 );
		 
		// create text field with default text
		textBox3 = new JTextField(10);
		theWindow.add( textBox3 );
		 
		 // register event handlers 
		 button = new JButton("What are the highest and lowest numbers?");
		 theWindow.add( button );
		 
		 managesText managing= new managesText();
		 button.addActionListener(managing);
		 
		 clearText clearing= new clearText();
		 
		 clear = new JButton("Clear");
		 theWindow.add( clear );
		 clear.addActionListener(clearing);
		 
		 label1 = new JLabel("");
		 theWindow.add(label1);
		 
		 label2 = new JLabel("");	 
		 theWindow.add(label2);
		 
		 setSize( 450, 150 );
		 setVisible( true );
	} 
	
	 //private internal class for the management of events
	 private class clearText implements ActionListener
	 {
		public void actionPerformed(ActionEvent f) {
			textBox1.setText("");
			textBox2.setText("");
			textBox3.setText("");
		}
	 }
 
	// private internal class for the management of events
	 private class managesText implements ActionListener
	 {
	 // processing text field events
		 public void actionPerformed(ActionEvent e)
		 {
			 String newString="";
			 int valueOne = 0, valueTwo = 0, valueThree = 0;
			 // initialize string
			 
			 newString= textBox1.getText();
			 valueOne = Integer.parseInt(newString);

			 newString= textBox2.getText();
			 valueTwo = Integer.parseInt(newString);
				 
			 newString= textBox3.getText();
			 valueThree = Integer.parseInt(newString);
 
			 int[] array = new int[]{valueOne, valueTwo, valueThree}; //variables for the array
			 
			 int smallest = array[0];
             int largest = array[0];
               
             for(int i=1; i< array.length; i++)
                {
                        if(array[i] > largest)
                                largest = array[i];
                        else if (array[i] < smallest)
                                smallest = array[i];
                }
               
             label1.setText("Largest Number is : " + largest);
             label2.setText(" | Smallest Number is : " + smallest);

		 }
	 }
}