
import static javax.swing.SwingConstants.CENTER;

import static javax.swing.SwingConstants.WEST;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

public class InsertionDemo extends JFrame implements ActionListener{
	 JButton back; //initialize back button
	 JLabel number3; //initialize the numbers as labels
	 JLabel number5;
	 JLabel number2;
	 JLabel number4;
	 JLabel number1;
	 JLabel number0;
	 JLabel lb1; //initialize 2 extra labels to write on them
	 JLabel lb2;
	 Timer timer0 = new Timer (15, this); //initialize timers
	 Timer timer1 = new Timer (15, this);
     Timer timer2= new Timer( 15, this);
	 Timer timer3= new Timer(15, this);
	 Timer timer4= new Timer( 15, this);
	 Timer timer5= new Timer( 15, this);
	 Timer timer6= new Timer( 15, this);
	 Timer timer7= new Timer( 15, this);
	 Timer timer8= new Timer( 15, this);
	 Timer timer9= new Timer( 15, this);
	 Timer timer10= new Timer( 15, this);
	 Timer timer11= new Timer( 15, this);
	 Timer timer12= new Timer( 15, this);
	 Timer timer13= new Timer( 15, this);
	 Timer timer14= new Timer( 15, this);
	 Timer timer15= new Timer( 15, this);
	 Timer timer16= new Timer( 15, this);
	 Timer timer17= new Timer( 15, this);
	 Timer timer18= new Timer( 15, this);
	 Timer timer19= new Timer( 15, this);
	 Timer timer20= new Timer( 15, this);

	 
		int j=30; //initialize variables that will be used in the actionPerformed function
		int x= 146;
		int l=262;
		int z=378;
		int t=494;
		int u=610;
		int o=0;
	InsertionDemo(){

		Border border= BorderFactory.createRaisedSoftBevelBorder(); 

		this.setLayout(null);

		this.setTitle("Sorting Algorithms"); 
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		JPanel panel = new JPanel();
		JLabel label= new JLabel();
		JPanel shadow= new JPanel();
		this.add(panel); //add panel
        JScrollPane pane = new JScrollPane(panel);

		number3= new JLabel();
		number5= new JLabel();
		number2= new JLabel();
		number4= new JLabel();
		number1= new JLabel();
		number0= new JLabel();
		lb1 = new JLabel(); 
		lb2 = new JLabel(); 
	    Icon icon = new ImageIcon("C:\\Users\\HES\\Desktop\\Java Labs\\Project_CP3\\src\\arrow.png");   //set icon            
	    back= new JButton();
	    
	    
	    //set characteristics of back button, which is used to dispose current window and display InsertionSort 
	    //window
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
		
		//set characteristics of panel on which all other components are added
		panel.setBounds(0, 0, 700, 1000);  
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		
		//set shadow for Insertion Demo label
		shadow.setBounds(234, 24, 240, 60); 
		shadow.setBackground(new Color(35,35,35));
		
		//set characteristics of title label
		label.setText("  	 Insertion Demo");  
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(230, 20, 240,60 );

		//set characteristics of first label
		lb1.setHorizontalTextPosition(JLabel.CENTER);  
		lb1.setVerticalTextPosition(JLabel.TOP);
		lb1.setForeground(Color.white);
		lb1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb1.setBounds(70,140,700,100);
		
		//set characteristics of second label, lb1 and lb2 are used to describe the steps of the demo 
		lb2.setHorizontalTextPosition(JLabel.CENTER);  
		lb2.setVerticalTextPosition(JLabel.TOP);
		lb2.setForeground(Color.white);
		lb2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb2.setBounds(100,160,700,100);
		
		//set characteristics of the numbers
		number3.setText("   3");								
		number3.setHorizontalTextPosition(JLabel.CENTER);
		number3.setVerticalTextPosition(JLabel.CENTER);
		number3.setForeground(new Color(255, 87, 34));
		number3.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number3.setIconTextGap(20);
		number3.setBackground(Color.white);
		number3.setOpaque(true);
		number3.setBorder(border);
		number3.setBounds(30, 260, 60,60 );		
		
		number5.setText("   5");
		number5.setHorizontalTextPosition(JLabel.CENTER);
		number5.setVerticalTextPosition(JLabel.CENTER);
		number5.setForeground(new Color(255, 87, 34));
		number5.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number5.setIconTextGap(20);
		number5.setBackground(Color.white);
		number5.setOpaque(true);
		number5.setBounds(146, 260, 60,60 ); 
		number5.setBorder(border);
		
		
		number0.setText("   0");
		number0.setHorizontalTextPosition(JLabel.CENTER);
		number0.setVerticalTextPosition(JLabel.CENTER);
		number0.setForeground(new Color(255, 87, 34));
		number0.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number0.setIconTextGap(20);
		number0.setBackground(Color.white);
		number0.setOpaque(true);
		number0.setBounds(262, 260, 60,60 );
		number0.setBorder(border);

		
		number2.setText("   2");
		number2.setHorizontalTextPosition(JLabel.CENTER);
		number2.setVerticalTextPosition(JLabel.CENTER);
		number2.setForeground(new Color(255, 87, 34));
		number2.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number2.setIconTextGap(20);
		number2.setBackground(Color.white);
		number2.setOpaque(true);
		number2.setBounds(378, 260, 60,60 );
		number2.setBorder(border);

		
		number1.setText("   1");
		number1.setHorizontalTextPosition(JLabel.CENTER);
		number1.setVerticalTextPosition(JLabel.CENTER);
		number1.setForeground(new Color(255, 87, 34));
		number1.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number1.setIconTextGap(20);
		number1.setBackground(Color.white);
		number1.setOpaque(true);
		number1.setBorder(border);
		number1.setBounds(494, 260, 60,60 );
		
		
		number4.setText("   4");
		number4.setHorizontalTextPosition(JLabel.CENTER);
		number4.setVerticalTextPosition(JLabel.CENTER);
		number4.setForeground(new Color(255, 87, 34));
		number4.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number4.setIconTextGap(20);
		number4.setBackground(Color.white);
		number4.setOpaque(true);
		number4.setBounds(610, 260, 60,60 );
		number4.setBorder(border);

		this.setContentPane(pane);

		//add all labels
		panel.add(label);
		panel.add(shadow);
		panel.add(number3);
		panel.add(number5);
		panel.add(number2);
		panel.add(number4);
		panel.add(number1);
		panel.add(number0);
		panel.add(back);
		panel.add(lb1);
		panel.add(lb2);		
		this.setVisible(true);
		timer0.start();
}

	// this function runs our demo
	public void actionPerformed(ActionEvent e) { 
		//go back and dispose current window if "back" button is pressed
		if (e.getSource()==back) { 
			new InsertionSort();
			this.dispose();
		}
		//if we are at timer 0, do the following 
		if (e.getSource()==timer0) {
			number3.setBackground(new Color(255, 87, 34)); //change color of these numbers
			number3.setForeground(Color.white);
			number5.setBackground(new Color(255, 87, 34));
			number5.setForeground(Color.white);
			lb1.setText("We check the element at index 1 and compare it with that at index 0"); //write down the steps
			lb2.setText("5 is greater than 3 so we do not swap");
			o=o+1;
			if ( o == 100) { //give the user time to check what is happening, when done stop timer0 and start timer1
				timer0.stop();
				o=0;
				timer1.start();
			}
		}
		//make sure previous timer is not running before starting new one
		if (e.getSource()==timer1 && !timer0.isRunning()) {
			number3.setBackground(Color.white);
			number3.setForeground(new Color(255, 87, 34));
			number0.setBackground(new Color(255, 87, 34));
			number0.setForeground(Color.white);
			lb1.setText("We check the element at index 2 and compare it with that at index 1");
			lb2.setText("0 is less than 5 so we swap them");
			o=o+1;
			if ( o == 100) {
				timer1.stop();
				o=0;	
				timer2.start();
			}
		}
		if (e.getSource()==timer2 && !timer1.isRunning()) {
			//here we are swapping numbers
			x=x+1;
			l=l-1;
			number5.setBounds(x, 260 , 60, 60);
			number0.setBounds(l,260, 60, 60);
			if (x==262 || l == 146) {
				timer2.stop();
				timer3.start();
				}
		}
		if (e.getSource()==timer3 && !timer2.isRunning()) {
			number5.setBackground(Color.white);
			number5.setForeground(new Color(255, 87, 34));
			number3.setBackground(new Color(255, 87, 34));
			number3.setForeground(Color.white);
			lb1.setText("We then compare it with that at index 1");
			lb2.setText("0 is less than 3 so we swap them");
			o=o+1;
			if ( o == 100) {
				timer3.stop();
				o=0;	
				timer4.start();
			}
		}
		if (e.getSource()==timer4 && !timer3.isRunning()) {
			j=j+1;
			l=l-1;
			number3.setBounds(j, 260 , 60, 60);
			number0.setBounds(l,260, 60, 60);
			if (l==30 || j == 146) {
				timer4.stop();
				timer5.start();
				}
		}
		if (e.getSource()==timer5 && !timer4.isRunning()) {
			number3.setBackground(Color.white);
			number3.setForeground(new Color(255, 87, 34));
			number0.setBackground(Color.white);
			number0.setForeground(new Color(255, 87, 34));
			number2.setBackground(new Color(255, 87, 34));
			number2.setForeground(Color.white);
			number5.setBackground(new Color(255, 87, 34));
			number5.setForeground(Color.white);
			lb1.setText("We check the element at index 3 and compare it with that at index 2");
			lb2.setText("2 is less than 5 so we swap them");
			o=o+1;
			if ( o == 100) {
				timer5.stop();
				o=0;	
				timer6.start();
			}
		}
		if (e.getSource()==timer6 && !timer5.isRunning()) {
			x=x+1;
			z=z-1;
			number5.setBounds(x, 260 , 60, 60);
			number2.setBounds(z,260, 60, 60);
			if (z==262 || x == 378) {
				timer6.stop();
				timer7.start();
				}
		}
		if (e.getSource()==timer7 && !timer6.isRunning()) {
			number5.setBackground(Color.white);
			number5.setForeground(new Color(255, 87, 34));
			number3.setBackground(new Color(255, 87, 34));
			number3.setForeground(Color.white);
			lb1.setText("We now compare 2 with the element at index 1");
			lb2.setText("2 is less than 3 so we swap them");
			o=o+1;
			if ( o == 100) {
				timer7.stop();
				o=0;	
				timer8.start();
			}
		}
		if (e.getSource()==timer8 && !timer7.isRunning()) {
			j=j+1;
			z=z-1;
			number3.setBounds(j, 260 , 60, 60);
			number2.setBounds(z,260, 60, 60);
			if (z==146 || j == 262) {
				timer8.stop();
				timer9.start();
				}
		}
		if (e.getSource()==timer9 && !timer8.isRunning()) {
			number3.setBackground(Color.white);
			number3.setForeground(new Color(255, 87, 34));
			number0.setBackground(new Color(255, 87, 34));
			number0.setForeground(Color.white);
			lb1.setText("We now compare 2 with the element at index 0");
			lb2.setText("2 is greater than 0 so we keep them");
			o=o+1;
			if ( o == 100) {
				timer9.stop();
				o=0;	
				timer10.start();
			}
		}
		if (e.getSource()==timer10 && !timer9.isRunning()) {
			number2.setBackground(Color.white);
			number2.setForeground(new Color(255, 87, 34));
			number0.setBackground(Color.white);
			number0.setForeground(new Color(255, 87, 34));
			number1.setBackground(new Color(255, 87, 34));
			number1.setForeground(Color.white);
			number5.setBackground(new Color(255, 87, 34));
			number5.setForeground(Color.white);
			lb1.setText("We check the element at index 4 and compare it with that at index 3");
			lb2.setText("1 is less than 5 so we swap them");
			o=o+1;
			if ( o == 100) {
				timer10.stop();
				o=0;	
				timer11.start();
			}
		}
		if (e.getSource()==timer11 && !timer10.isRunning()) {
			x=x+1;
			t=t-1;
			number1.setBounds(t, 260 , 60, 60);
			number5.setBounds(x,260, 60, 60);
			if (x==494 || t == 378) {
				timer11.stop();
				timer12.start();
				}
		}
		if (e.getSource()==timer12 && !timer11.isRunning()) {
			number5.setBackground(Color.white);
			number5.setForeground(new Color(255, 87, 34));
			number3.setBackground(new Color(255, 87, 34));
			number3.setForeground(Color.white);
			lb1.setText("We now compare 1 with the element at index 2");
			lb2.setText("1 is less than 3 so we swap them");
			o=o+1;
			if ( o == 100) {
				timer12.stop();
				o=0;	
				timer13.start();
			}
		}
		if (e.getSource()==timer13 && !timer12.isRunning()) {
			j=j+1;
			t=t-1;
			number1.setBounds(t, 260 , 60, 60);
			number3.setBounds(j,260, 60, 60);
			if (j==378 || t == 262) {
				timer13.stop();
				timer14.start();
				}
		}
		if (e.getSource()==timer14 && !timer13.isRunning()) {
			number3.setBackground(Color.white);
			number3.setForeground(new Color(255, 87, 34));
			number2.setBackground(new Color(255, 87, 34));
			number2.setForeground(Color.white);
			lb1.setText("We now compare 1 with the element at index 1");
			lb2.setText("1 is less than 2 so we swap them");
			o=o+1;
			if ( o == 100) {
				timer14.stop();
				o=0;	
				timer15.start();
			}
		}
		if (e.getSource()==timer15 && !timer14.isRunning()) {
			z=z+1;
			t=t-1;
			number1.setBounds(t, 260 , 60, 60);
			number2.setBounds(z,260, 60, 60);
			if (t==146 || z == 262) {
				timer15.stop();
				timer16.start();
				}
		}
		if (e.getSource()==timer16 && !timer15.isRunning()) {
			number2.setBackground(Color.white);
			number2.setForeground(new Color(255, 87, 34));
			number0.setBackground(new Color(255, 87, 34));
			number0.setForeground(Color.white);
			lb1.setText("We now compare 1 with the element at index 0");
			lb2.setText("1 is greater than 0 so we keep them");
			o=o+1;
			if ( o == 100) {
				timer16.stop();
				o=0;	
				timer17.start();
			}
		}
		if (e.getSource()==timer17 && !timer16.isRunning()) {
			number1.setBackground(Color.white);
			number1.setForeground(new Color(255, 87, 34));
			number0.setBackground(Color.white);
			number0.setForeground(new Color(255, 87, 34));
			number4.setBackground(new Color(255, 87, 34));
			number4.setForeground(Color.white);
			number5.setBackground(new Color(255, 87, 34));
			number5.setForeground(Color.white);
			lb1.setText("We check the element at index 5 and compare it with that at index 4");
			lb2.setText("4 is less than 5 so we swap them");
			o=o+1;
			if ( o == 100) {
				timer17.stop();
				o=0;	
				timer18.start();
			}
		}
		if (e.getSource()==timer18 && !timer17.isRunning()) {
			x=x+1;
			u=u-1;
			number4.setBounds(u, 260 , 60, 60);
			number5.setBounds(x,260, 60, 60);
			if (u==494 || x == 610) {
				timer18.stop();
				timer19.start();
				}
		}
		if (e.getSource()==timer19 && !timer18.isRunning()) {
			number5.setBackground(Color.white);
			number5.setForeground(new Color(255, 87, 34));
			number3.setBackground(new Color(255, 87, 34));
			number3.setForeground(Color.white);
			lb1.setText("We now compare 4 with the element at index 3");
			lb2.setText("4 is greater than 3 so we keep them");
			o=o+1;
			if ( o == 100) {
				timer19.stop();
				o=0;	
				timer20.start();
			}
		}
		if (e.getSource()==timer20 && !timer19.isRunning()) {
			number4.setBackground(Color.white);
			number4.setForeground(new Color(255, 87, 34));
			number3.setBackground(Color.white);
			number3.setForeground(new Color(255, 87, 34));
			lb1.setText("The array has been sorted");
			lb2.setText("");
			o=o+1;
			if ( o == 100) {
				timer20.stop();
				o=0;	
			}
		}
	}
}