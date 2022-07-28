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

public class QuickDemo extends JFrame implements ActionListener{
	 JButton back; //initialize back button
	 JLabel number3; //initialize the numbers as labels
	 JLabel number5;
	 JLabel number2;
	 JLabel number4;
	 JLabel number1;
	 JLabel number0;
	 JLabel lb1; //initialize 2 extra labels to write on them
	 JLabel lb2;
	 JLabel lb3;
	 JLabel lb4;
	 JLabel lb5;
	 JLabel lb6;
	 JLabel lb7;
	 JLabel lb8;
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
	 Timer timer21= new Timer( 15, this);
	 Timer timer22= new Timer( 15, this);
	 Timer timer23= new Timer( 15, this);
	 Timer timer24= new Timer( 15, this);
	 Timer timer25= new Timer( 15, this);
	 Timer timer26= new Timer( 15, this);
	 Timer timer27= new Timer( 15, this);
	 Timer timer28= new Timer( 15, this);
	 Timer timer29= new Timer( 15, this);
	 Timer timer30= new Timer( 15, this);
	 Timer timer31= new Timer( 15, this);
	 Timer timer32= new Timer( 15, this);
	 Timer timer33= new Timer( 15, this);
	 Timer timer34= new Timer( 15, this);
	 Timer timer35= new Timer( 15, this);
	 Timer timer36= new Timer( 15, this);
	 Timer timer37= new Timer( 15, this);
	 Timer timer38= new Timer( 15, this);
	 Timer timer39= new Timer( 15, this);
	 Timer timer40= new Timer( 15, this);
	 Timer timer41= new Timer( 15, this);
	 Timer timer42= new Timer( 15, this);
	 Timer timer43= new Timer( 15, this);
	 Timer timer44= new Timer( 15, this);
	 Timer timer45= new Timer( 15, this);
	 Timer timer46= new Timer( 15, this);
	 Timer timer47= new Timer( 15, this);
	 
	 int j=30;  //initialize variables that will be used in the actionPerformed function
	 int x= 146;
	 int l=262;
	 int z=378;
	 int t=494;
	 int u=610;
	 int o=0;

	 QuickDemo(){

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
		this.add(panel);
        JScrollPane pane = new JScrollPane(panel);

		number3= new JLabel();
		number5= new JLabel();
		number2= new JLabel();
		number4= new JLabel();
		number1= new JLabel();
		number0= new JLabel();
		lb1 = new JLabel(); 
		lb2 = new JLabel(); 
		lb3 = new JLabel(); 
		lb4 = new JLabel(); 
		lb5 = new JLabel(); 
		lb6 = new JLabel(); 
		lb7 = new JLabel(); 
		lb8 = new JLabel(); 

	    Icon icon = new ImageIcon("C:\\Users\\HES\\Desktop\\Java Labs\\Project_CP3\\src\\arrow.png");               
	    back= new JButton();
	    
	    //set characteristics of back button, which is used to dispose current window and display QuickSort 
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
		
		//set shadow for Quick Demo label
		shadow.setBounds(234, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		
		//set characteristics of title label
		label.setText("  	 Quick Demo");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(230, 20, 240,60 );
		
		//set characteristics of all labels with different bounds
		lb1.setHorizontalTextPosition(JLabel.CENTER);
		lb1.setVerticalTextPosition(JLabel.TOP);
		lb1.setForeground(Color.white);
		lb1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb1.setBounds(30,140,700,100);
		
		lb8.setHorizontalTextPosition(JLabel.CENTER);
		lb8.setVerticalTextPosition(JLabel.TOP);
		lb8.setForeground(Color.white);
		lb8.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb8.setBounds(60,160,700,100);
		
		lb2.setHorizontalTextPosition(JLabel.CENTER);
		lb2.setVerticalTextPosition(JLabel.TOP);
		lb2.setForeground(Color.white);
		lb2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb2.setBounds(55, 210, 700,60 );

		lb3.setHorizontalTextPosition(JLabel.CENTER);
		lb3.setVerticalTextPosition(JLabel.TOP);
		lb3.setForeground(Color.white);
		lb3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb3.setBounds(171,210,700,60);
		
		lb4.setHorizontalTextPosition(JLabel.CENTER);
		lb4.setVerticalTextPosition(JLabel.TOP);
		lb4.setForeground(Color.white);
		lb4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb4.setBounds(287,210,700,60);
		
		lb5.setHorizontalTextPosition(JLabel.CENTER);
		lb5.setVerticalTextPosition(JLabel.TOP);
		lb5.setForeground(Color.white);
		lb5.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb5.setBounds(403,210,700,60);
		
		lb6.setHorizontalTextPosition(JLabel.CENTER);
		lb6.setVerticalTextPosition(JLabel.TOP);
		lb6.setForeground(Color.white);
		lb6.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb6.setBounds(519,210,700,60);
		
		lb7.setHorizontalTextPosition(JLabel.CENTER);
		lb7.setVerticalTextPosition(JLabel.TOP);
		lb7.setForeground(Color.white);
		lb7.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb7.setBounds(635,210,700,60);
		
		//set characteristics of the numbers with different bounds and text
		number3.setText("   3");
		number3.setHorizontalTextPosition(JLabel.CENTER);
		number3.setVerticalTextPosition(JLabel.CENTER);
		number3.setForeground(new Color(255, 87, 34));
		number3.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number3.setIconTextGap(20);
		number3.setBackground(Color.white);
		number3.setOpaque(true);
		number3.setBorder(border);
		number3.setBounds(262, 260, 60,60 );		
		
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
		number0.setBounds(378, 260, 60,60 );
		number0.setBorder(border);

		number2.setText("   2");
		number2.setHorizontalTextPosition(JLabel.CENTER);
		number2.setVerticalTextPosition(JLabel.CENTER);
		number2.setForeground(new Color(255, 87, 34));
		number2.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number2.setIconTextGap(20);
		number2.setBackground(Color.white);
		number2.setOpaque(true);
		number2.setBounds(610, 260, 60,60 );
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
		number1.setBounds(30, 260, 60,60 );
		
		number4.setText("   4");
		number4.setHorizontalTextPosition(JLabel.CENTER);
		number4.setVerticalTextPosition(JLabel.CENTER);
		number4.setForeground(new Color(255, 87, 34));
		number4.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number4.setIconTextGap(20);
		number4.setBackground(Color.white);
		number4.setOpaque(true);
		number4.setBounds(494, 260, 60,60 );
		number4.setBorder(border);

		this.setContentPane(pane);
		
		//add labels and back button
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
		panel.add(lb3);		
		panel.add(lb4);		
		panel.add(lb5);		
		panel.add(lb6);		
		panel.add(lb7);		
		panel.add(lb8);		

		this.setVisible(true);
		//start timer0
		timer0.start();
}
	 	
	// this function runs our demo
	public void actionPerformed(ActionEvent e) {
		//go back and dispose current window if "back" button is pressed
		if (e.getSource()==back) {
			new QuickSort();
			this.dispose();
		}
		//if we are at timer 0, do the following 
		if (e.getSource()==timer0) {
			number3.setBackground(new Color(255, 87, 34)); //change color of number3
			number3.setForeground(Color.white);
			lb1.setText("Select the pivot(3), which is element at index 2(middle of the array) "); //write down the steps
			o=o+1;
			if ( o == 100) { //give the user time to check what is happening, when done stop timer0 and start timer1
				timer0.stop();
				o=0;
				timer1.start();
			}
		}
		//make sure previous timer is not running before starting new one
		if (e.getSource()==timer1 && !timer0.isRunning()) {  
			number2.setBackground(new Color(255, 87, 34));
			number2.setForeground(Color.white);
			lb1.setText("Move the pivot to the end");
			o=o+1;
			if ( o == 100) {
				timer1.stop();
				o=0;
				timer2.start();
			}
		}
		if (e.getSource()==timer2 && !timer1.isRunning()) {
			//here we are swapping numbers
			l=l+1;
			u=u-1;
			number2.setBounds(u, 260 , 60, 60);
			number3.setBounds(l,260, 60, 60);
			if (l==610 || u == 262) {
				timer2.stop();
				timer3.start();
				}
		}
		if (e.getSource()==timer3 && !timer2.isRunning()) {
			number2.setBackground(Color.white);
			number2.setForeground(new Color(255, 87, 34));
			lb1.setText("Partition the subarray");
			lb2.setText("\u2193"); //add arrows
			lb6.setText("\u2193");
			o=o+1;
			if ( o == 200) {
				timer3.stop();
				o=0;
				timer4.start();
			}
		}
		if (e.getSource()==timer4 && !timer3.isRunning()) {
			lb1.setText("Move the left bound to the right until");
			lb8.setText("it reaches a value greater than or equal to the pivot");
			lb2.setText("\u2193");
			lb6.setText("\u2193");
			o=o+1;
			if ( o == 200) {
				timer4.stop();
				o=0;
				timer5.start();
			}
		}
		if (e.getSource()==timer5 && !timer4.isRunning()) {
			number5.setBackground(Color.CYAN);
			number5.setForeground(new Color(255, 87, 34));
			lb1.setText("5 is greater than the pivot, so we stop there");
			lb8.setText("");
			lb2.setText("");
			lb3.setText("\u2193");
			o=o+1;
			if ( o == 200) {
				timer5.stop();
				o=0;
				timer6.start();
			}
		}
		if (e.getSource()==timer6 && !timer5.isRunning()) {
			lb1.setText("Move the right bound to the left until");
			lb8.setText("it crosses the left bound or finds a value less than the pivot");
			o=o+1;
			if ( o == 200) {
				timer6.stop();
				o=0;
				timer7.start();
			}
		}
		if (e.getSource()==timer7 && !timer6.isRunning()) {
			number0.setBackground(Color.CYAN);
			number0.setForeground(new Color(255, 87, 34));
			lb1.setText("0 is less than the pivot, so we stop there");
			lb8.setText("");
			lb5.setText("\u2193");
			lb6.setText("");
			o=o+1;
			if ( o == 200) {
				timer7.stop();
				o=0;
				timer8.start();
			}
		}
		if (e.getSource()==timer8 && !timer7.isRunning()) {
			lb1.setText("Swap the 2 numbers below the arrows since 5>=3>=0");
			o=o+1;
			if ( o == 200) {
				timer8.stop();
				o=0;
				timer9.start();
			}
		}
		if (e.getSource()==timer9 && !timer8.isRunning()) {
			x=x+1;
			z=z-1;
			number5.setBounds(x, 260 , 60, 60);
			number0.setBounds(z,260, 60, 60);
			if (x==378 || z == 146) {
				timer9.stop();
				timer10.start();
				}
		}
		if (e.getSource()==timer10 && !timer9.isRunning()) {
			lb1.setText("Move the left bound to the right until");
			lb8.setText("it reaches a value greater than or equal to the pivot");
			o=o+1;
			if ( o == 200) {
				timer10.stop();
				o=0;
				timer11.start();
			}
		}
		if (e.getSource()==timer11 && !timer10.isRunning()) {
			number0.setBackground(Color.white);
			number0.setForeground(new Color(255, 87, 34));
			lb1.setText("Move to 2, 2 is less than the pivot, continue");
			lb8.setText("");
			lb3.setText("");
			lb4.setText("\u2193");
			o=o+1;
			if ( o == 200) {
				timer11.stop();
				o=0;
				timer12.start();
			}
		}
		if (e.getSource()==timer12 && !timer11.isRunning()) {
			lb1.setText("5 is greater than the pivot, we stop there");
			lb4.setText("");
			o=o+1;
			if ( o == 200) {
				timer12.stop();
				o=0;
				timer13.start();
			}
		}
		if (e.getSource()==timer13 && !timer12.isRunning()) {
			lb1.setText("Move the right bound to the left until");
			lb8.setText("it crosses the left bound or finds a value less than the pivot");
			o=o+1;
			if ( o == 200) {
				timer13.stop();
				o=0;
				timer14.start();
			}
		}
		if (e.getSource()==timer14 && !timer13.isRunning()) {
			lb1.setText("");
			lb8.setText("");
			lb4.setText("\u2193");
			o=o+1;
			if ( o == 200) {
				timer14.stop();
				o=0;
				timer15.start();
			}
		}
		if (e.getSource()==timer15 && !timer14.isRunning()) {
			lb1.setText("");
			lb8.setText("");
			lb4.setText("\u2193");
			o=o+1;
			if ( o == 200) {
				timer15.stop();
				o=0;
				timer16.start();
			}
		}
		if (e.getSource()==timer16 && !timer15.isRunning()) {
			lb1.setText("Bounds have crossed");
			lb8.setText("");
			lb4.setText("");
			o=o+1;
			if ( o == 200) {
				timer16.stop();
				o=0;
				timer17.start();
			}
		}
		if (e.getSource()==timer17 && !timer16.isRunning()) {
			lb1.setText("When the bounds cross,all elements to the left of the left bound are less");
			lb8.setText("than the pivot and those to the right are greater than/equal to the pivot");
			o=o+1;
			if ( o == 200) {
				timer17.stop();
				o=0;
				timer18.start();
			}
		}
		if (e.getSource()==timer18 && !timer17.isRunning()) {
			lb1.setText("Swap the pivot with 5");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer18.stop();
				o=0;
				timer19.start();
			}
		}
		if (e.getSource()==timer19 && !timer18.isRunning()) {
			l=l-1;
			x=x+1;
			number5.setBounds(x, 260 , 60, 60);
			number3.setBounds(l,260, 60, 60);
			if (l==378 || x==610) {
				timer19.stop();
				timer20.start();
				}

		}
		if (e.getSource()==timer20 && !timer21.isRunning()) {
			number0.setBackground(Color.green);
			number0.setForeground(new Color(255, 87, 34));
			number5.setBackground(Color.white);
			number5.setForeground(new Color(255, 87, 34));
			lb5.setText("");
			lb1.setText("Call quicksort on the subarray to the left of the pivot");
			lb8.setText("New pivot is 0, swap it with the last element in this subarray");
			o=o+1;
			if ( o == 200) {
				timer20.stop();
				o=0;
				timer21.start();
			}
		}
		if (e.getSource()==timer21 && !timer20.isRunning()) {
			u=u-1;
			z=z+1;
			number0.setBounds(z, 260 , 60, 60);
			number2.setBounds(u,260, 60, 60);
			if (z==262 || u==146) {
				timer21.stop();
				timer22.start();
				}
		}
		if (e.getSource()==timer22 && !timer21.isRunning()) {
			lb1.setText("Partition the subarray");
			lb2.setText("\u2193");
			lb3.setText("\u2193");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer22.stop();
				o=0;
				timer23.start();
				}
		}
		if (e.getSource()==timer23 && !timer22.isRunning()) {
			number1.setBackground(Color.CYAN);
			number1.setForeground(new Color(255, 87, 34));
			lb1.setText("Move the left bound to the right until");
			lb8.setText("it reaches a value greater than or equal to the pivot");
			o=o+1;
			if ( o == 200) {
				timer23.stop();
				o=0;
				timer24.start();
			}
		}
		if (e.getSource()==timer24 && !timer23.isRunning()) {
			lb1.setText("2 is greater than the pivot, so the bound stays there");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer24.stop();
				o=0;
				timer25.start();
			}
		}
		if (e.getSource()==timer25 && !timer24.isRunning()) {
			number2.setBackground(Color.CYAN);
			number2.setForeground(new Color(255, 87, 34));
			lb1.setText("Move the right bound to the left until");
			lb8.setText("it crosses the left bound or finds a value less than the pivot");
			o=o+1;
			if ( o == 200) {
				timer25.stop();
				o=0;
				timer26.start();
			}
		}
		if (e.getSource()==timer26 && !timer25.isRunning()) {
			number2.setBackground(Color.white);
			number2.setForeground(new Color(255, 87, 34));
			lb3.setText("");
			lb1.setText("Bounds have crossed");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer26.stop();
				o=0;
				timer27.start();
			}
		}
		if (e.getSource()==timer27 && !timer26.isRunning()) {
			lb2.setText("");
			lb1.setText("Swap 1 with the left subarray's pivot");
			o=o+1;
			if ( o == 200) {
				timer27.stop();
				o=0;
				timer28.start();
			}
		}
		if (e.getSource()==timer28 && !timer27.isRunning()) {
			j=j+1;
			z=z-1;
			number1.setBackground(Color.white);
			number1.setForeground(new Color(255, 87, 34));
			number0.setBackground(new Color(255, 87, 34));
			number0.setForeground(Color.white);
			number1.setBounds(j, 260 , 60, 60);
			number0.setBounds(z,260, 60, 60);
			if (z==30 || j==262) {
				timer28.stop();
				timer29.start();
			}
	}
		if (e.getSource()==timer29 && !timer28.isRunning()) {
			number2.setBackground(Color.green);
			number2.setForeground(new Color(255, 87, 34));
			lb5.setText("");
			lb1.setText("Call quicksort on the subarray on the right subarray");
			lb8.setText("New pivot is 2, swap it with the last element in this subarray");
			o=o+1;
			if ( o == 200) {
				timer29.stop();
				o=0;
				timer30.start();
			}
		}
		if (e.getSource()==timer30 && !timer29.isRunning()) {
			j=j-1;
			u=u+1;
			number1.setBounds(j, 260 , 60, 60);
			number2.setBounds(u,260, 60, 60);
			if (u==262 || j==146) {
				timer30.stop();
				timer31.start();
				}
		}
		if (e.getSource()==timer31 && !timer30.isRunning()) {
			lb1.setText("Partition the subarray");
			lb3.setText("\u2193");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer31.stop();
				o=0;
				timer32.start();
				}
		}
		if (e.getSource()==timer32 && !timer31.isRunning()) {
			number1.setBackground(Color.CYAN);
			number1.setForeground(new Color(255, 87, 34));
			lb1.setText("Move the left bound to the right until");
			lb8.setText("it reaches a value greater than or equal to the pivot");
			lb3.setText("\u2193");
			o=o+1;
			if ( o == 200) {
				timer32.stop();
				o=0;
				timer33.start();
				}
		}
		if (e.getSource()==timer33 && !timer32.isRunning()) {
			lb1.setText("2 is equal to the pivot, so it stays there");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer33.stop();
				o=0;
				timer34.start();
				}
		}
		if (e.getSource()==timer34 && !timer33.isRunning()) {
			lb1.setText("Move the right bound to the left until");
			lb8.setText("it crosses the left bound or finds a value less than the pivot");
			o=o+1;
			if ( o == 200) {
				timer34.stop();
				o=0;
				timer35.start();
				}
		}
		if (e.getSource()==timer35 && !timer34.isRunning()) {
			lb1.setText("Bounds have crossed");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer35.stop();
				o=0;
				timer36.start();
				}
		}
		if (e.getSource()==timer36 && !timer35.isRunning()) {
			number2.setBackground(new Color(255, 87, 34));
			number2.setForeground(Color.white);
			lb2.setText("");
			lb3.setText("");
			lb1.setText("Thus, final location of 2 is at index 2");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer36.stop();
				o=0;
				timer37.start();
				}
		}
		if (e.getSource()==timer37 && !timer36.isRunning()) {
			number1.setBackground(new Color(255, 87, 34));
			number1.setForeground(Color.white);
			lb1.setText("Left subarray contains only 1 element(1),so it's sorted");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer37.stop();
				o=0;
				timer38.start();
				}
		}
		if (e.getSource()==timer38 && !timer37.isRunning()) {
			number1.setBackground(new Color(255, 87, 34));
			number1.setForeground(Color.white);
			number4.setBackground(Color.green);
			number4.setForeground(new Color(255, 87, 34));
			lb1.setText("Call quicksort on the subarray to the right of the pivot");
			lb8.setText("New pivot is 4, swap it with the last element in this subarray");
			o=o+1;
			if ( o == 200) {
				timer38.stop();
				o=0;
				timer39.start();
				}
		}
		if (e.getSource()==timer39 && !timer38.isRunning()) {
			x=x-1;
			t=t+1;
			number4.setBounds(t, 260 , 60, 60);
			number5.setBounds(x,260, 60, 60);
			if (t==610 || x==494) {
				timer39.stop();
				timer40.start();
				}
		}
		if (e.getSource()==timer40 && !timer39.isRunning()) {
			lb1.setText("Partition the subarray");
			lb6.setText("\u2193");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer40.stop();
				o=0;
				timer41.start();
				}
		}
		if (e.getSource()==timer41 && !timer40.isRunning()) {
			number5.setBackground(Color.CYAN);
			number5.setForeground(new Color(255, 87, 34));
			lb1.setText("Move the left bound to the right until");
			lb8.setText("it crosses the left bound or finds a value less than the pivot");
			o=o+1;
			if ( o == 200) {
				timer41.stop();
				o=0;
				timer42.start();
				}
		}
		if (e.getSource()==timer41 && !timer40.isRunning()) {
			lb1.setText("4 is equal to the pivot, so it stays there");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer41.stop();
				o=0;
				timer42.start();
				}
		}
		if (e.getSource()==timer42 && !timer41.isRunning()) {
			lb1.setText("Move the right bound to the left until");
			lb8.setText("it reaches a value greater than or equal to the pivot");
			o=o+1;
			if ( o == 200) {
				timer42.stop();
				o=0;
				timer43.start();
				}
		}
		if (e.getSource()==timer43 && !timer42.isRunning()) {
			lb1.setText("Bounds have crossed");
			lb8.setText("");
			o=o+1;
			if ( o == 200) {
				timer43.stop();
				o=0;
				timer44.start();
				}
		}
		if (e.getSource()==timer44 && !timer43.isRunning()) {
			lb1.setText("Swap the pivot to it's final position");
			lb6.setText("");
			o=o+1;
			if ( o == 200) {
				timer44.stop();
				o=0;
				timer45.start();
				}
		}
		if (e.getSource()==timer45 && !timer44.isRunning()) {
			number4.setBackground(new Color(255, 87, 34));
			number4.setForeground(Color.white);
			x=x+1;
			t=t-1;
			number5.setBounds(x, 260 , 60, 60);
			number4.setBounds(t,260, 60, 60);
			if (t==494 || x==610) {
				timer45.stop();
				timer46.start();
				}
		}
		if (e.getSource()==timer46 && !timer45.isRunning()) {
			number5.setBackground(new Color(255, 87, 34));
			number5.setForeground(Color.white);
			lb1.setText("Right subarray contains only 1 element(5),so it's sorted");
			o=o+1;
			if ( o == 200) {
				timer46.stop();
				o=0;
				timer47.start();
				}
		}
		if (e.getSource()==timer47 && !timer46.isRunning()) {
			lb1.setText("Sorted successfully by quick sort");
			o=o+1;
			if ( o == 200) {
				timer47.stop();
				}
		}
	}
}