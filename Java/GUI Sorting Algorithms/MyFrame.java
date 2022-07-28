
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
/**
 * MyFrame class extends JFrame, it represents the frame in our main Window
 * It includes buttons for each of our six Sorting Algorithms.
 * @author Yara&Ali
 *
 */
public class MyFrame extends JFrame implements ActionListener{
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	MyFrame(){
		

		
		Border border= BorderFactory.createRaisedSoftBevelBorder();

		//We start by specifying our frame parameters.
		//We set the Layout to "null" to have flexibility 
		//over the location and bounds of the components we are adding.
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(700,700);
		this.setLocation(300,15);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setResizable(false);
		this.setBackground(new Color(255, 255, 255));
		
		
	
       //We start initializing our JComponents, 
		//our main JPanel on which everything else is set
		
		JPanel panel= new JPanel();
		JPanel shadow = new JPanel();
		JPanel shadow2 = new JPanel();
		JPanel shadow3 = new JPanel();
		JPanel shadow4 = new JPanel();
		JPanel shadow5 = new JPanel();
		JPanel shadow6 = new JPanel();
		JPanel shadow7 = new JPanel();
		JPanel line= new JPanel();
		JPanel line2= new JPanel();
		JPanel line3= new JPanel();
		JLabel label= new JLabel();
		JLabel label2= new JLabel();

		
		
		//Here we define the buttons that are going to use
		//Each refers to a sorting algorithm while the 7th
		//is the "Test your knowledge" button.
		button1= new JButton();
		button2= new JButton();
		button3= new JButton();
	    button4= new JButton();
		button5= new JButton();
		button6= new JButton();
		button7= new JButton();
		
		
		//We define the bounds, layout and color
		//of our panel then we add it to our frame
		panel.setBounds(0, 0, 700, 700);
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);

		
		
		
		//The below three lines are a "decoration"
		//that add interest to our panel.
		line.setBounds(20,0,3,700);
		line.setBackground(new Color(255, 87, 34));
		line.setLayout(null);
		panel.add(line);
	
		line2.setBounds(0,633,700,3);
		line2.setBackground(new Color(255, 87, 34));
		line2.setLayout(null);
		panel.add(line2);
		
		line3.setBounds(100,200,500,2);
		line3.setBackground(new Color(255, 255,255));
		line3.setLayout(null);
		panel.add(line3);

		//This label is our title,we specify its position
		//background and foreground colors. 
		label.setText("    Sorting Algorithms ");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 30));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(187, 40, 325,70 );
    	panel.add(label);
		
			
		
		//This label is our subtitle, informing the user that he/she has
		//to click on one of the sorting algorithms to learn how it works.
		label2.setText("  Click on an Algorithm to see how it works ! ");
		label2.setHorizontalTextPosition(JLabel.CENTER);
		label2.setVerticalTextPosition(JLabel.TOP);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Century Gothic", Font.ROMAN_BASELINE, 20));
		label2.setBounds(125, 150, 450,70 );
		panel.add(label2);
	
	
		
		
		//The following is our first button, "Bubble Sort"
		//We start by setting its bounds manually, and changing the 
		//background and foreground colors.
		//We set its border to the raised bevel border we previously initialized
		//to make it look even more raised.
		//All of our buttons have an action listener that takes us
		//to a new window when clicked.
		button1.setBounds(90, 265, 230, 50);
		button1.setBackground(new Color(255, 255, 255));
		button1.setText(" Bubble Sort ");
		button1.setHorizontalTextPosition(JButton.CENTER);
		button1.setFocusable(false);
		button1.setFont(new Font("Century Gothic", Font.BOLD,22));
		button1.setForeground(new Color(255, 87, 34));
		button1.setBorder(border);
		button1.addActionListener(this);
		panel.add(button1);


		
		
		//This is our second button "Selection Sort",
		//Everything is similar to Button1 except the bounds of course.
		button2.setBounds(90,370,230,50);
		button2.setBackground(new Color(255,255,255));
		button2.setText(" Selection Sort ");
		button2.setHorizontalTextPosition(JButton.CENTER);
		button2.setFocusable(false);
		button2.setFont(new Font("Century Gothic", Font.BOLD,22));
		button2.setForeground(new Color(0, 173, 181));
		button2.setBorder(border);
		button2.addActionListener(this);
		panel.add(button2);
		
		
		
		
		//3rd button, "Insertion Sort"
		button3.setBounds(90,475,230,50);
		button3.setBackground(new Color(255,255,255));
		button3.setText(" Insertion Sort ");
		button3.setHorizontalTextPosition(JButton.CENTER);
		button3.setFocusable(false);
		button3.setFont(new Font("Century Gothic", Font.BOLD,22));
		button3.setForeground(new Color(48, 56, 65));
		button3.setBorder(border);
		button3.addActionListener(this);
		panel.add(button3);

		
		
		
		//4th button, "Merge Sort"
		button4.setBounds(380, 265, 230, 50);
		button4.setBackground(new Color(255, 255, 255));
		button4.setText(" Merge Sort ");
		button4.setHorizontalTextPosition(JButton.CENTER);
		button4.setFocusable(false);
		button4.setFont(new Font("Century Gothic", Font.BOLD,22));
		button4.setForeground(new Color(255, 87, 34));
		button4.setBorder(border);
		button4.addActionListener(this);
		panel.add(button4);


		
		//5th button, "Quick Sort"
		button5.setBounds(380,370,230,50);
		button5.setBackground(new Color(255, 255, 255));
		button5.setText(" Quick Sort ");
		button5.setHorizontalTextPosition(JButton.CENTER);
		button5.setFocusable(false);
		button5.setFont(new Font("Century Gothic", Font.BOLD,22));
		button5.setForeground(new Color(0, 173, 181));
		button5.setBorder(border);
		button5.addActionListener(this);
		panel.add(button5);
		
		
		
		//6th button, "Bucket Sort"
		button6.setBounds(380,475,230,50);
		button6.setBackground(new Color(255,255,255));
		button6.setText(" Bucket Sort ");
		button6.setHorizontalTextPosition(JButton.CENTER);
		button6.setFocusable(false);
		button6.setFont(new Font("Century Gothic", Font.BOLD,22));
		button6.setForeground(new Color(48, 56, 65));
		button6.setBorder(border);
		button6.addActionListener(this);
		panel.add(button6);


		
		//7th button, "Test Your Knowledge!"
		//Unlike the other buttons, clicking on this button does not
		//take us on a Sorting Algorithm Window, but rather to a window
		//where a few questions are asked about Time Complexity
		//So that the user can test his/her knowledge
		button7.setBounds(190,560,300,50);
		button7.setBackground(Color.white);
		button7.setText(" Test Your Knowledge! ");
		button7.setHorizontalTextPosition(JButton.CENTER);
		button7.setFocusable(false);
		button7.setFont(new Font("Century Gothic", Font.BOLD,22));
		button7.setForeground(new Color(255, 87, 34));
		button7.setBorder(border);
		button7.addActionListener(this);
		button7.setBorder(border);
		panel.add(button7);
		
		
		
		//We create these shadow labels to be put
				//under our used labels and buttons
				//to display the illusion that they are floating
				//which gives it a modern feel that the user would like
				shadow.setBounds(90, 265, 235, 55);
				shadow.setBackground(new Color(35,35,30));
		    	panel.add(shadow);
			
				shadow2.setBounds(90, 370, 235, 55);
				shadow2.setBackground(new Color(35,35,35));
				panel.add(shadow2);
			
				shadow3.setBounds(90,475,235,55);
				shadow3.setBackground(new Color(35,35,35));
				panel.add(shadow3);
			
				shadow5.setBounds(380, 265, 235, 55);
				shadow5.setBackground(new Color(35,35,30));
				panel.add(shadow5);

				shadow6.setBounds(380, 370, 235, 55);
				shadow6.setBackground(new Color(35,35,35));
				panel.add(shadow6);
			
				shadow7.setBounds(380,475,235,55);
				shadow7.setBackground(new Color(35,35,35));
				panel.add(shadow7);
				
				shadow4.setBounds(187, 40, 330,75	);
				shadow4.setBackground(new Color(35,35,35));
				panel.add(shadow4);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		//In the following, we check on which button was the action peformed
		// and accordingly, we launch the respective window
		//However, we do not dispose the main window 
		//Since we should keep it open in case
		// we wanna see and compare between different sorting algorithm
		//at the same time;
		
		if (e.getSource()==button1) {
			new BubbleSort();
		}
		if (e.getSource()==button2) {
			new SelectionSort();
		}
		if (e.getSource()==button3) {
			new InsertionSort();
		}if (e.getSource()==button4) {
			new MergeSort();
		}if (e.getSource()==button5) {
			new QuickSort();
		}if (e.getSource()==button6) {
			new BucketSort();
		}if (e.getSource()==button7) {
			new TimeComplexity();
		}
	

		
	
}










		
	
}

