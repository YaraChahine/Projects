import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 * This class extends JFrame, it presents an animation of how the SelectionSort works
 * 
 * 
 * @author yara&ali
 *
 */
public class SelectionDemo extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	//We initiate the variables and componentns that will be used outside of the constructor here
	JPanel panel;
	JLabel[] numbers;
	JButton back;
	JLabel label;
	JLabel label1;
	JLabel label2;
	JPanel shadow; 
	//These are timers used to animate the labels and change their positions
	Timer timer0= new Timer(10,this);
	Timer timer1 = new Timer (10, this);
	Timer timer2= new Timer( 10, this);
	Timer timer3= new Timer( 10, this);
	Timer timer4= new Timer( 10, this);
	Timer timer5= new Timer( 10, this);
	Timer timer6= new Timer( 10, this);
	Timer timer7= new Timer( 10, this);
	Timer timer8= new Timer( 10, this);
	Timer timer9= new Timer( 10, this);

	
	//These are variables each with the value of the x position of each label
	// so that we can increment and decrement them when using the timers
	int end=0;
	int x= 30;
	int l=610;
	int z=146;
	int t=494;
	int r =378;
	int u=610;
	int m=610;
	int n=494;
	int o=0;
	int y=0;
	SelectionDemo(){
		
		Border border= BorderFactory.createRaisedSoftBevelBorder();
		
		//This is our main frame
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));
		
		//Initializing our JComponents
		panel= new JPanel();
		shadow= new JPanel();
		label= new JLabel();
		label1= new JLabel();
		label2 = new JLabel();

		
		
		
		//our main panel on which all JComponents will be added
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		
		
		
		//Shadow to make our Title Label look raised
		shadow.setBounds(228, 24, 253, 60);
		shadow.setBackground(new Color(35,35,35));
		
		
		
	
		//our Title label
		label.setText("  Selection Sort Demo");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(224, 20, 253,60 ); 
		
		
		//Label1 and label 2 are used to describe what is going on as the demo starts
		//step by step
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setVerticalTextPosition(JLabel.TOP);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label1.setIconTextGap(20);
		label1.setBounds(120, 130,600,60 ); 
		panel.add(label1);
		
		

		label2.setHorizontalTextPosition(JLabel.CENTER);
		label2.setVerticalTextPosition(JLabel.TOP);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label2.setIconTextGap(20);
		label2.setBounds(120, 130,600,60 ); 
		panel.add(label2);
	
		
		
		//In the following, we initliaizng our array of numbers and set the common sepcifications
		//between them to save numerous lines of code.
		numbers= new JLabel[6];
		for ( int i=0; i<6; i++) {
			numbers[i]= new JLabel();
			numbers[i].setHorizontalTextPosition(JLabel.CENTER);
			numbers[i].setVerticalTextPosition(JLabel.CENTER);
			numbers[i].setForeground(new Color(255, 87, 34));
			numbers[i].setFont(new Font("Century Gothic", Font.BOLD, 25));
			numbers[i].setIconTextGap(20);
			numbers[i].setBackground(Color.white);
			numbers[i].setOpaque(true);
			numbers[i].setBorder(border);

			panel.add(numbers[i]);
		}
		
		
		
		
		
		
			//our "backc" button is used to dispose current window and launch SelectionSort window
		    back= new JButton();
			back.setBounds(20, 20, 60, 60);
			back.setLayout(null);
			back.setBackground(new Color(255, 87, 34));
			back.setText("<");
			back.setForeground(Color.white);
			back.setFont(new Font("Century Gothic",Font.BOLD , 44));
			back.setIconTextGap(0);
			back.setFocusable(false);
			back.setBorder(border);
			back.addActionListener(this);
			
			
			
			//We give each number its value and set it at its corresponding position
			
			numbers[0].setText("   3");
			numbers[0].setBounds(30,260,60,60);
			numbers[1].setText("   5");
			numbers[1].setBounds(146,260,60,60);
			numbers[2].setText("   2");
			numbers[2].setBounds(262,260,60,60);
			numbers[3].setText("   4");
			numbers[3].setBounds(378,260,60,60);
			numbers[4].setText("   1");
			numbers[4].setBounds(494,260,60,60);
			numbers[5].setText("   0");
			numbers[5].setBounds(610,260,60,60);
		
			
			//we add remaining components to our panel
			panel.add(label);
			
			panel.add(shadow);
			panel.add(back);
			this.add(panel);

			this.setVisible(true);
			
			
			//we start with the first timer and the animation begins
			timer0.start();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource()==back) {
			new SelectionSort();
			this.dispose();
		}
		

		
		//in the first timer, we color the first element signaling that it is currently our minimum
		//the we successively color each following element in search for a new minimum if it exists
		//we do so with a variable "y" that we increment in the timer
		//and whenever it reaches certain values we color or decolor numbers
		if (e.getSource()==timer0) {
			label1.setText("We set the number at index 0 as Mininum (3)");
			label2.setText("Then we scan the array to check if there is a number less than Minimum");
			label1.setBounds(190, 130,600,60 ); 
			label2.setBounds(87, 160,600,60 ); 

			numbers[0].setBackground(new Color(255, 87, 34));
			numbers[0].setForeground(Color.white);
			y=y+1;
			if (y==70) {
				numbers[1].setBackground(new Color(255, 87, 34));
				numbers[1].setForeground(Color.white);		
			}
			
		 
			if (y==140) {
				numbers[1].setBackground(Color.white);
				numbers[1].setForeground(new Color(255, 87, 34));
				numbers[2].setBackground(new Color(255, 87, 34));
				numbers[2].setForeground(Color.white);		
			}
			if (y==210) {
				numbers[2].setBackground(Color.white);
				numbers[2].setForeground(new Color(255, 87, 34));
				numbers[3].setBackground(new Color(255, 87, 34));
				numbers[3].setForeground(Color.white);		
			}
			
			if (y==280) {
				numbers[3].setBackground(Color.white);
				numbers[3].setForeground(new Color(255, 87, 34));
				numbers[4].setBackground(new Color(255, 87, 34));
				numbers[4].setForeground(Color.white);		
			}
			if (y==350) {
				numbers[4].setBackground(Color.white);
				numbers[4].setForeground(new Color(255, 87, 34));
				numbers[5].setBackground(new Color(255, 87, 34));
				numbers[5].setForeground(Color.white);		
			}
			if (y==420) {
				timer0.stop();
				timer1.start();
				y=0;
			}
		}
		
		
		//if we find a new minimum , we swap it with the older minimum and when they exchange spots
		//timer stops and dollowing timer begins
		if (e.getSource()==timer1 && !timer0.isRunning()) {
		    x=x+1;
			l=l-1;
			label2.setText("");
			label1.setText("0 is the smallest element, we swap it with the element at index 0");
			label1.setBounds(130, 130,600,60 ); 

			numbers[0].setBounds(x,260,60,60);
			numbers[5].setBounds(l,260,60,60);
			if (x==610 || l == 30) {
				timer1.stop();
				numbers[0].setBackground(Color.white);
				numbers[0].setForeground(new Color(255, 87, 34));
				numbers[5].setBackground(new Color(0, 173, 181));
				numbers[5].setForeground(Color.white);	
				;
				timer2.start();
			}
		}
		//We do same as above for all following timers
		if (e.getSource() == timer2 && !timer1.isRunning()) {
			
			label1.setText("We set the number at index 1 as Mininum (5)");
			label2.setText("Then we scan the array to check if there is a number less than Minimum");
			label1.setBounds(190, 130,600,60 ); 
			label2.setBounds(87, 160,600,60 ); 

			numbers[1].setBackground(new Color(255, 87, 34));
			numbers[1].setForeground(Color.white);
			y=y+1;
			if (y==70) {
				numbers[2].setBackground(new Color(255, 87, 34));
				numbers[2].setForeground(Color.white);		
			}
			if (y==140) {
				numbers[2].setBackground(Color.white);
				numbers[2].setForeground(new Color(255, 87, 34));
				numbers[3].setBackground(new Color(255, 87, 34));
				numbers[3].setForeground(Color.white);		
			}
			if (y==210) {
				numbers[3].setBackground(Color.white);
				numbers[3].setForeground(new Color(255, 87, 34));
				numbers[4].setBackground(new Color(255, 87, 34));
				numbers[4].setForeground(Color.white);		
			}
			
			if (y==280) {
				numbers[4].setBackground(Color.white);
				numbers[4].setForeground(new Color(255, 87, 34));
	
			}
			if (y==350) {
				numbers[4].setBackground(Color.white);
				numbers[4].setForeground(new Color(255, 87, 34));
				numbers[0].setBackground(new Color(255, 87, 34));
				numbers[0].setForeground(Color.white);		
			}
			
			if (y==420) {
				numbers[0].setBackground(Color.white);
				numbers[0].setForeground(new Color(255, 87, 34));
				numbers[4].setBackground(new Color(255, 87, 34));
				numbers[4].setForeground(Color.white);
			}
			if (y==490) {
				timer2.stop();
				timer3.start();
				y=0;
			}
			
			
		}
		if (e.getSource() == timer3 && !timer2.isRunning()) {
			z=z+ 1;
			t=t-1;
			numbers[1].setBounds(z, 260,60,60);
	    numbers[4].setBounds(t,260,60,60);
		label2.setText("");

			label1.setText("1 is the second smallest element, we swap it with the element at index 1");
			label1.setBounds(100, 130,600,60 ); 

			if ( z==494 || t==146) {
				timer3.stop();
				numbers[1].setBackground(Color.white);
				numbers[1].setForeground(new Color(255, 87, 34));
				numbers[4].setBackground(new Color(0, 173, 181));
				numbers[4].setForeground(Color.white);
				;
				timer4.start();
			}
		}
		
		if (e.getSource() == timer4 && !timer3.isRunning()) {
			
			label1.setText("We set the number at index 2 as Mininum (2)");
			label2.setText("Then we scan the array to check if there is a number less than Minimum");
			label1.setBounds(190, 130,600,60 ); 
			label2.setBounds(87, 160,600,60 ); 

			numbers[2].setBackground(new Color(255, 87, 34));
			numbers[2].setForeground(Color.white);
			y=y+1;
			if (y==70) {
				numbers[3].setBackground(new Color(255, 87, 34));
				numbers[3].setForeground(Color.white);		
			}
			if (y==140) {
				numbers[3].setBackground(Color.white);
				numbers[3].setForeground(new Color(255, 87, 34));
				numbers[1].setBackground(new Color(255, 87, 34));
				numbers[1].setForeground(Color.white);		
			}
			if (y==210) {
				numbers[1].setBackground(Color.white);
				numbers[1].setForeground(new Color(255, 87, 34));
				numbers[0].setBackground(new Color(255, 87, 34));
				numbers[0].setForeground(Color.white);		
			}
			
			if (y==280) {
				numbers[0].setBackground(Color.white);
				numbers[0].setForeground(new Color(255, 87, 34));
	
			}
			if (y==350) {
				timer4.stop();
				timer5.start();
				y=0;
			}
			
			
			
		}
		
		if (e.getSource() == timer5 && !timer4.isRunning()) {
			o=o+1;
			label1.setText("There is no number less than Minimum and it is already in its correct position");
			label1.setBounds(100, 130, 600,60 ); 
			label2.setText("");
			numbers[2].setBackground(new Color(0, 173, 181));

			if(o==300) {
				timer5.stop();
				;
				timer6.start();
			}
		}
		
		
		if ( e.getSource()==timer6 && !timer5.isRunning()) {

			label1.setText("We set the number at index 3 as Mininum (4)");
			label2.setText("Then we scan the array to check if there is a number less than Minimum");
			label1.setBounds(190, 130,600,60 ); 
			label2.setBounds(87, 160,600,60 ); 

			numbers[3].setBackground(new Color(255, 87, 34));
			numbers[3].setForeground(Color.white);
			y=y+1;
			if (y==70) {
				numbers[1].setBackground(new Color(255, 87, 34));
				numbers[1].setForeground(Color.white);		
			}
			if (y==140) {
				numbers[1].setBackground(Color.white);
				numbers[1].setForeground(new Color(255, 87, 34));
				numbers[0].setBackground(new Color(255, 87, 34));
				numbers[0].setForeground(Color.white);		
			}
	
			
			if (y==210) {
				timer6.stop();
				timer7.start();
				y=0;
			}
			
			
		}
		if (e.getSource() == timer7 && !timer6.isRunning()) {
			r=r+ 1;
			u=u-1;
			numbers[0].setBounds(u, 260,60,60); //3
	     	numbers[3].setBounds(r,260,60,60); //4
			label1.setText("3 is the third smallest element, we swap it with the element at index 3");
			label1.setBounds(100, 130, 600,60 ); 
			label2.setText("");
			if (u==378 || r==610) {
				timer7.stop();
				numbers[3].setBackground(Color.white);
				numbers[3].setForeground(new Color(255, 87, 34));
				numbers[0].setBackground(new Color(0, 173, 181));
				;
				timer8.start();
		}
		}	
			
			
			if ( e.getSource()== timer8 && !timer7.isRunning()) {

				label1.setText("We set the number at index 4 as Mininum (5)");
				label2.setText("Then we scan the array to check if there is a number less than Minimum");
				label1.setBounds(190, 130,600,60 ); 
				label2.setBounds(87, 160,600,60 ); 

				numbers[1].setBackground(new Color(255, 87, 34));
				numbers[1].setForeground(Color.white);
				y=y+1;
				if (y==70) {
					numbers[3].setBackground(new Color(255, 87, 34));
					numbers[3].setForeground(Color.white);		
				
					timer8.stop();
					timer9.start();
					y=0;
				}
				
			}
		
		if (e.getSource() == timer9 && !timer8.isRunning()) {
			label1.setText("4 is the third smallest element, we swap it with the element at index 4,");
			label1.setBounds(120, 130, 700,60 ); 
			 label2.setText("and last element is automatically at it's right place");
				label2.setBounds(160, 160, 700,60 ); 
			n=n+ 1;
			m=m-1;
			numbers[3].setBounds(m, 260,60,60); //3
	     	numbers[1].setBounds(n,260,60,60); //4
			
			 if (m==494 || n==610) {
				timer9.stop();

				numbers[3].setBackground(new Color(0, 173, 181));
				numbers[1].setBackground(new Color(0, 173, 181));
				
		}
			
		}
		}
		
		
	}


