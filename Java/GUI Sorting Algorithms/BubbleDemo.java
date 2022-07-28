import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.WEST;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
/**
 * This class displays an animation of how the Bubble Sort algorithm works, using Timers
 * 
 * 
 * @author yara&ali
 *
 */
public class BubbleDemo extends JFrame implements ActionListener{
	 
	//We initialize our components
	JButton back;
	 JButton start;
	 JLabel number3;
	 JLabel number5;
	 JLabel number2;
	 JLabel number4;
	 JLabel number1;
	 JLabel number0;
	 JLabel lb;
	 JLabel pass;
	 JLabel pass2;
	 Timer timer0 = new Timer (15, this);
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
	 Timer timer21 = new Timer(15,this);
	 Timer timer22 = new Timer(15,this);
	 Timer timer23 = new Timer(15,this);
	 Timer timer24 = new Timer(15,this);
	 Timer timer25 = new Timer(15,this);
	 Timer timer26 = new Timer(15,this);
	 Timer timer27 = new Timer(15,this);

	 //These variables are the x component of our buttons, we defined them here since we use them
	 //outside of the constructor, and we increment and decrement each
		int end=0;
		int j=30;
		int x= 146;
		int l=262;
		int z=378;
		int t=494;
		int r =610;
		int u=610;
		int m=800;
		int n=660;
		int o=0;
		int counter=0;

	BubbleDemo(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		
		
		
		//Our frame
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
        JScrollPane pane = new JScrollPane(panel);

		start= new JButton();
		number3= new JLabel();
		number5= new JLabel();
		number2= new JLabel();
		number4= new JLabel();
		number1= new JLabel();
		number0= new JLabel();
		lb = new JLabel(); 
		pass= new JLabel();
		pass2=new JLabel();
	    start.setBounds(30,200,40,40);
	    start.addActionListener(this);
	    

	    //this is our "back" button, when the user clicks on it, current window is disposed
	    // and a new BubbleSOrt window is displayed
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

		
		
		
		//our panel on which all other components are added
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);

		
		
		//shadow label to be added behind our Title Label 
		shadow.setBounds(234, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		
		
		
		
		
		
		//our Title Label
		label.setText("  Bubble Sort Demo");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(230, 20, 240,60 );

		
		
		
		//This label is used to describe what is happening in the demo step by step
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setVerticalTextPosition(JLabel.TOP);
		lb.setForeground(Color.white);
		lb.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb.setBounds(220,140,600,70);
	
		
		
		//This label tells which pass are on in our bubble sort, 
		//since it is useful for the user to see that in each n passes, n numbers are in
		//their correct position
		pass.setHorizontalTextPosition(JLabel.CENTER);
		pass.setVerticalTextPosition(JLabel.TOP);
		pass.setForeground(Color.white);
		pass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		pass.setBounds(262,340,600,70);
		pass.setText("Number of passes: 0");
		
		
		
		
		//This label goes right under the previous ones, it displays how many items are in the correct position
		pass2.setHorizontalTextPosition(JLabel.CENTER);
		pass2.setVerticalTextPosition(JLabel.TOP);
		pass2.setForeground(Color.white);
		pass2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		pass2.setBounds(173,360,600,70);
		pass2.setText("Number of items in correct position: 0");
		panel.add(pass2);
		
		
		

		
		//In the following, we set a number in each label,
		// setting their position, fonts and other specifications
		
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
		

		
		number2.setText("   2");
		number2.setHorizontalTextPosition(JLabel.CENTER);
		number2.setVerticalTextPosition(JLabel.CENTER);
		number2.setForeground(new Color(255, 87, 34));
		number2.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number2.setIconTextGap(20);
		number2.setBackground(Color.white);
		number2.setOpaque(true);
		number2.setBounds(262, 260, 60,60 );
		number2.setBorder(border);

		
		
		number4.setText("   4");
		number4.setHorizontalTextPosition(JLabel.CENTER);
		number4.setVerticalTextPosition(JLabel.CENTER);
		number4.setForeground(new Color(255, 87, 34));
		number4.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number4.setIconTextGap(20);
		number4.setBackground(Color.white);
		number4.setOpaque(true);
		number4.setBounds(378, 260, 60,60 );
		number4.setBorder(border);

		
		
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
		
		
		
		number0.setText("   0");
		number0.setHorizontalTextPosition(JLabel.CENTER);
		number0.setVerticalTextPosition(JLabel.CENTER);
		number0.setForeground(new Color(255, 87, 34));
		number0.setFont(new Font("Century Gothic", Font.BOLD, 25));
		number0.setIconTextGap(20);
		number0.setBackground(Color.white);
		number0.setOpaque(true);
		number0.setBounds(610, 260, 60,60 );
		number0.setBorder(border);


		
		panel.add(label);
		panel.add(shadow);
		panel.add(number3);
		panel.add(number5);
		panel.add(number2);
		panel.add(number4);
		panel.add(number1);
		panel.add(number0);
		panel.add(back);
		panel.add(lb);
		panel.add(pass);
		
		this.setVisible(true);
		
		//When the frame is launched, the first timer starts and the other timers follow it
		timer0.start();
		
		
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==back) {
			new BubbleSort();
			this.dispose();
		}
		
		

		
		
		//When the first timer is triggered, we start by coloring the elements moving
		
		if (e.getSource()==timer0) {
		   
			number3.setBackground(new Color(255, 87, 34));
			number3.setForeground(Color.white);
			number5.setBackground(new Color(255, 87, 34));
			number5.setForeground(Color.white);
			lb.setText("3 is less than 5 so we do not swap");
			o=o+1;    // since 3<5, no need to swap
			if ( o == 100) { // however we increment the variable o so that there is a delay/pause
				timer0.stop();//before the other timer begins
				o=0;			// after stopping our current timer , we set o to 0 so that we can use it again
				timer1.start(); // we trigger timer1 to start
			}
		}
		
		
		//When timer1 begins, we set the color back to the default value for the previous numbers
		//and we color the new numbers that we reached
		if (e.getSource()==timer1 && !timer0.isRunning()) {

			number3.setBackground(Color.white);
			number3.setForeground(new Color(255, 87, 34));
			number2.setBackground(new Color(255, 87, 34));
			number2.setForeground(Color.white);
			lb.setText("5 is bigger than 2 so we swap ");
			o=o+1;   //As previously explained, we wait a little bit so that the user can
			if ( o == 100) { //carefully and slowly read the message displayed
				timer1.stop();
				o=0;	
				timer2.start();
			}
			
		}
		if (e.getSource()==timer2 && !timer1.isRunning()) {
			
			//Now since a swap is needed between 5 and 2
			//we take the variables holding their positions values
			//5's position is incremented until it reaches 262 and takes 2's spot
			//2's position is decremented until it reached 146 and 5's spot
			x=x+1;
			l=l-1;
			number5.setBounds(x, 260 , 60, 60);
			number2.setBounds(l,260, 60, 60);
			if (x==262 || l == 146) { //When both items are in their correct positions
				timer2.stop();		//the timer stops and the following one begins
				end++;
				timer3.start();  //Note** here we used || instead of && just to be careful because sometimes
									//we can miss a value by one unit and this would prevent the timers of stopping
				
			}
			
		}
		
		
		//for the following timers, we do exactly as above for the remaining elments
		//the only difference is that when an element is in its correct position we color it with blue
		//to signalize that it is sorted
		if (e.getSource()==timer3 && !timer2.isRunning()) {
		
			number2.setBackground(Color.white);
			number2.setForeground(new Color(255, 87, 34));
			number4.setBackground(new Color(255, 87, 34));
			number4.setForeground(Color.white);
			lb.setText("5 is bigger than 4 so we swap ");
			o=o+1;
			if ( o == 100) {
				timer3.stop();
				o=0;
				timer4.start();
			}
		}
		
		if (e.getSource()==timer4 && !timer3.isRunning()) {
			x=x+1;
			z=z-1;
			number5.setBounds(x, 260 , 60, 60);
			number4.setBounds(z,260, 60, 60);
			if (x==378 || z == 262) {
				timer4.stop();
				end++;
				timer5.start();
				
			}
			
		}
		
		
		if (e.getSource()==timer5 && !timer4.isRunning()) {		   

			number4.setBackground(Color.white);
			number4.setForeground(new Color(255, 87, 34));
			number1.setBackground(new Color(255, 87, 34));
			number1.setForeground(Color.white);
			lb.setText("5 is bigger than 1 so we swap ");
			o=o+1;
			if ( o == 100) {
				timer5.stop();
				o=0;	
				timer6.start();
			}
			
		}
		
		
		if (e.getSource()==timer6 && !timer5.isRunning()) {
					
			x=x+1;
			t=t-1;
			number5.setBounds(x, 260 , 60, 60);
			number1.setBounds(t,260, 60, 60);
			if (x==494 || t == 378) {
				timer6.stop();
				end++;
				timer7.start();
						}
			
		}
		
		if (e.getSource()==timer7 && !timer6.isRunning()) {
			//	timer5.restart();
			   

				number1.setBackground(Color.white);
				number1.setForeground(new Color(255, 87, 34));
				number0.setBackground(new Color(255, 87, 34));
				number0.setForeground(Color.white);
				lb.setText("5 is bigger than 0 so we swap ");
				o=o+1;
				if ( o == 100) {
					timer7.stop();
					o=0;	
					timer8.start();
				}
				//timer1.stop();
			}
			
			
			if (e.getSource()==timer8 && !timer7.isRunning()) {
				//timer6.restart();
				//int z=378;
				//int t=494;
				x=x+1;
				r=r-1;
				number5.setBounds(x, 260 , 60, 60);
				number0.setBounds(r,260, 60, 60);
				if (x==610 || r == 494) {
					timer8.stop();
					number0.setBackground(Color.white);
					number0.setForeground(new Color(255, 87, 34));
					number5.setBackground(new Color(0, 173, 181));
					pass.setText("Number of passes: 1");
					pass2.setText("Number of items in correct position: 1 (5)");
					end++;
					timer9.start();
					//o=0;
				}
				//o++;
			}
			
			
			
			if (e.getSource()==timer9 && !timer8.isRunning()) {
				//	timer5.restart();
				   

					number3.setBackground(new Color(255, 87, 34));
					number3.setForeground(Color.white);

					number2.setBackground(new Color(255, 87, 34));
					number2.setForeground(Color.white);
					lb.setText("3 is bigger than 2 so we swap ");
					o=o+1;
					if ( o == 100) {
						timer9.stop();
						o=0;	
						timer10.start();
					}
					//timer1.stop();
				}
			
			
			if (e.getSource()==timer10 && !timer9.isRunning()) {
				//timer6.restart();
				//int z=378;
				//int t=494;
				j=j+1;
				l=l-1;
				number3.setBounds(j, 260 , 60, 60);
				number2.setBounds(l,260, 60, 60);
				if (j==146 || l==30) {
					timer10.stop();
					number2.setBackground(Color.white);
					number2.setForeground(new Color(255, 87, 34));
					end++;
					timer11.start();
					//o=0;
				}
				//o++;
			}
			
			
			
			if (e.getSource()==timer11 && !timer10.isRunning()) {
				//	timer5.restart();
				   

					number4.setBackground(new Color(255, 87, 34));
					number4.setForeground(Color.white);

					//number2.setBackground(new Color(255, 87, 34));
					//number2.setForeground(Color.white);
					lb.setText("3 is less than 4 so we do not swap ");
					o=o+1;
					if ( o == 100) {
						timer11.stop();
						o=0;	
						timer12.start();
					}
					//timer1.stop();
				}
			
			
			if (e.getSource()==timer12 && !timer11.isRunning()) {
				//	timer5.restart();
				   
					number3.setBackground(Color.white);
					number3.setForeground(new Color(255, 87, 34));	
					number1.setBackground(new Color(255, 87, 34));
					number1.setForeground(Color.white);

					//number2.setBackground(new Color(255, 87, 34));
					//number2.setForeground(Color.white);
					lb.setText("4 is bigger than 1 so we swap ");
					o=o+1;
					if ( o == 100) {
						timer12.stop();
						o=0;	
						timer13.start();
					}
					//timer1.stop();
				}
			
			
			
			if (e.getSource()==timer13 && !timer12.isRunning()) {
				//timer6.restart();
				//int z=378;
				//int t=494;
				z=z+1;
				t=t-1;
				number4.setBounds(z, 260 , 60, 60);
				number1.setBounds(t,260, 60, 60);
				if (z==378 || t==262) {
					timer13.stop();
					number1.setBackground(Color.white);
					number1.setForeground(new Color(255, 87, 34));
					end++;
					timer14.start();
					//o=0;
				}
				//o++;
			}
			
			
			
			
			if (e.getSource()==timer14 && !timer13.isRunning()) {
				//	timer5.restart();
				  	
					number0.setBackground(new Color(255, 87, 34));
					number0.setForeground(Color.white);

					//number2.setBackground(new Color(255, 87, 34));
					//number2.setForeground(Color.white);
					lb.setText("4 is bigger than 0 so we swap ");
					o=o+1;
					if ( o == 100) {
						timer14.stop();
						o=0;	
						timer15.start();
					}
					//timer1.stop();
				}
			
			if (e.getSource()==timer15 && !timer14.isRunning()) {
				//timer6.restart();
				//int z=378;
				//int t=494;
				z=z+1;
				r=r-1;
				number4.setBounds(z, 260 , 60, 60);
				number0.setBounds(r,260, 60, 60);
				if (z==494 || r==378) {
					timer15.stop();
					number0.setBackground(Color.white);
					number0.setForeground(new Color(255, 87, 34));
					number4.setBackground(new Color(0, 173, 181));
					pass.setText("Number of passes:  2");
					pass2.setText("Number of items in correct position: 2 (4-5)");	
					end++;
					timer16.start();
					//timer14.start();
					//o=0;
				}
				//o++;
			}
			
			
			
			if (e.getSource()==timer16 && !timer15.isRunning()) {
				//	timer5.restart();
				   

					number2.setBackground(new Color(255, 87, 34));
					number2.setForeground(Color.white);
					number3.setBackground(new Color(255, 87, 34));
					number3.setForeground(Color.white);

					//number2.setBackground(new Color(255, 87, 34));
					//number2.setForeground(Color.white);
					lb.setText("2 is less than 3 so we do not swap ");
					o=o+1;
					if ( o == 100) {
						timer16.stop();
						o=0;	
						timer17.start();
					}
					//timer1.stop();
				}
			
			

			if (e.getSource()==timer17 && !timer16.isRunning()) {
				//	timer5.restart();
				   
					number2.setBackground(Color.white);
					number2.setForeground(new Color(255, 87, 34));	
					number1.setBackground(new Color(255, 87, 34));
					number1.setForeground(Color.white);

					//number2.setBackground(new Color(255, 87, 34));
					//number2.setForeground(Color.white);
					lb.setText("3 is bigger than 1 so we swap ");
					o=o+1;
					if ( o == 100) {
						timer17.stop();
						o=0;	
						timer18.start();
					}
					//timer1.stop();
				}
			
			
			if (e.getSource()==timer18 && !timer17.isRunning()) {
				//timer6.restart();
				//int z=378;
				//int t=494;
				j=j+1;
				t=t-1;
				number3.setBounds(j, 260 , 60, 60);
				number1.setBounds(t,260, 60, 60);
				if (j==262 || t==146) {
					timer18.stop();
					number1.setBackground(Color.white);
					number1.setForeground(new Color(255, 87, 34));
					end++;
					timer19.start();
					//o=0;
				}
				//o++;
			}
			
			
			

			if (e.getSource()==timer19 && !timer18.isRunning()) {
				//	timer5.restart();
				   
				
					number0.setBackground(new Color(255, 87, 34));
					number0.setForeground(Color.white);

					//number2.setBackground(new Color(255, 87, 34));
					//number2.setForeground(Color.white);
					lb.setText("3 is bigger than 0 so we swap ");
					o=o+1;
					if ( o == 100) {
						timer19.stop();
						o=0;	
						timer20.start();
					}
					//timer1.stop();
				}
			
			
			if (e.getSource()==timer20 && !timer19.isRunning()) {
				//timer6.restart();
				//int z=378;
				//int t=494;
				j=j+1;
				r=r-1;
				number3.setBounds(j, 260 , 60, 60);
				number0.setBounds(r,260, 60, 60);
				if (j==378 || r==262) {
					timer20.stop();
					number0.setBackground(Color.white);
					number0.setForeground(new Color(255, 87, 34));
					number3.setBackground(new Color(0, 173, 181));
					pass.setText("Number of passes: 3");
					pass2.setText("Number of items in correct position: 3 (3-4-5)");
					timer21.start();
					//o=0;
				}
				//o++;
			}
			
			
			if (e.getSource()==timer21 && !timer20.isRunning()) {
				//	timer5.restart();
				   

					number2.setBackground(new Color(255, 87, 34));
					number2.setForeground(Color.white);
					number1.setBackground(new Color(255, 87, 34));
					number1.setForeground(Color.white);

					//number2.setBackground(new Color(255, 87, 34));
					//number2.setForeground(Color.white);
					lb.setText("2 is bigger than 1 so we swap ");
					o=o+1;
					if ( o == 100) {
						timer21.stop();
						o=0;	
						timer22.start();
					}
					//timer1.stop();
				}
			
			
			
			if (e.getSource()==timer22 && !timer21.isRunning()) {
				//timer6.restart();
				//int z=378;
				//int t=494;
				l=l+1;
				t=t-1;
				number2.setBounds(l, 260 , 60, 60);
				number1.setBounds(t,260, 60, 60);
				if (l==146 || t==30) {
					timer22.stop();
					number1.setBackground(Color.white);
					number1.setForeground(new Color(255, 87, 34));
					end++;
					timer23.start();
					//o=0;
				}
				//o++;
			}
			
	
			
			if (e.getSource()==timer23 && !timer22.isRunning()) {
				//	timer5.restart();
				   

				
					number0.setBackground(new Color(255, 87, 34));
					number0.setForeground(Color.white);

					//number2.setBackground(new Color(255, 87, 34));
					//number2.setForeground(Color.white);
					lb.setText("2 is bigger than 0 so we swap ");
					o=o+1;
					if ( o == 100) {
						timer23.stop();
						o=0;	
						timer24.start();
					}
					//timer1.stop();
				}
			
			
			
			if (e.getSource()==timer24 && !timer23.isRunning()) {
				//timer6.restart();
				//int z=378;
				//int t=494;
				l=l+1;
				r=r-1;
				number2.setBounds(l, 260 , 60, 60);
				number0.setBounds(r,260, 60, 60);
				if (l==262 || r==146) {
					timer24.stop();
					number0.setBackground(Color.white);
					number0.setForeground(new Color(255, 87, 34));
					number2.setBackground(new Color(0, 173, 181));
					pass.setText("Number of passes: 4");
					pass2.setText("Number of items in correct position: 4 (2-3-4-5)");
					end++;
					timer25.start();
					//o=0;
				}
				//o++;
			}
			
			if (e.getSource()==timer25 && !timer24.isRunning()) {
				//	timer5.restart();
				   

				
					number0.setBackground(new Color(255, 87, 34));
					number0.setForeground(Color.white);

					number1.setBackground(new Color(255, 87, 34));
					number1.setForeground(Color.white);
					//number2.setBackground(new Color(255, 87, 34));
					//number2.setForeground(Color.white);
					lb.setText("1 is bigger than 0 so we swap ");
					o=o+1;
					if ( o == 100) {
						timer25.stop();
						o=0;	
						timer26.start();
					}
					//timer1.stop();
				}
			
			
			
			if (e.getSource()==timer26 && !timer25.isRunning()) {
				//timer6.restart();
				//int z=378;
				//int t=494;
				t=t+1;
				r=r-1;
				number1.setBounds(t, 260 , 60, 60);
				number0.setBounds(r,260, 60, 60);
				if (t==146 || r==30) {
					timer26.stop();
					number0.setBackground(new Color(0, 173, 181));
					number1.setBackground(new Color(0, 173, 181));
					pass.setText("Number of passes: 5");
					pass2.setText("Number of items in correct position: 6 (0-1-2-3-4-5)");
				}
				//o++;
			}
			
			
			
			
	/*	if (e.getSource() == timer2 && end==1) {
			z=z+ 1;
			t=t-1;
			button2.setBounds(z, 320 , 100, 50);
	     	button5.setBounds(t,320, 100, 50);
			label1.setText("1 is the second smallest element, we swap it with the element at index 1");
			if ( z==660 && t==240) {
				timer2.stop();
				end++;
			}
		}
		if (e.getSource() == timer5 && end==2) {
			o=o+1;
			label1.setText("2 is the second smallest element, it is already at index 2");
			if(o==300) {
				timer5.stop();
				end++;
			}
		}
		if (e.getSource() == timer3 && end==3) {
			r=r+ 1;
			u=u-1;
			button1.setBounds(u, 320 , 100, 50); //3
	     	button4.setBounds(r,320, 100, 50); //4
			label1.setText("3 is the third smallest element, we swap it with the element at index 3");
			if (u==520 && r==800) {
				timer3.stop();
				end++;
		}
			
		}
		if (e.getSource() == timer4 && end==4) {
			n=n+ 1;
			m=m-1;
			button2.setBounds(n, 320 , 100, 50); //3
	     	button4.setBounds(m,320, 100, 50); //4
			label1.setText("4 is the third smallest element, we swap it with the element at index 4, and last element is automatically at it's right place");
			if (m==660 && n==800) {
				timer4.stop();
				end++;
		}
		*/	
		}
	}

	
