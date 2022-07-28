
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

/**
 * This class extends JFrame, it displays the insertionSort code for the user as a reference
 * 
 * 
 * @author Ali&Yara
 *
 */
public class InsertionCode extends JFrame implements ActionListener{
	 JButton back;
	 JButton start;
	 JLabel lb1;
	 JLabel lb2;
	 JLabel lb3;
	 JLabel lb4;
	 JLabel lb5;
	 JLabel lb6;
	 JLabel lb7;
	 JLabel lb8;
	 JLabel lb9;
	 JLabel lb10;
	 JLabel lb11;
	 JLabel lb12;
	 JLabel lb13;
	 JLabel lb14;
	 JLabel lb15;
	 JLabel lb16;
	 JLabel lb17;
	 JLabel lb18;

	InsertionCode(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		
		//our main frame
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		
		

		//Below we initialize all of our JComponents
		JPanel panel = new JPanel();
		JLabel label= new JLabel();
		JPanel shadow= new JPanel();

		lb1 = new JLabel(); 
		lb2 = new JLabel(); 
		lb3 = new JLabel(); 
		lb4 = new JLabel(); 
		lb5 = new JLabel(); 
		lb6 = new JLabel(); 
		lb7 = new JLabel(); 
		lb8 = new JLabel(); 
		lb9 = new JLabel(); 
		lb10 = new JLabel(); 
		lb11 = new JLabel(); 
		lb12 = new JLabel(); 
		lb13 = new JLabel(); 
		lb14 = new JLabel(); 
		lb15 = new JLabel(); 
		lb16 = new JLabel(); 
		lb17 = new JLabel(); 
		lb18 = new JLabel(); 


		//Our back button, once the user clicks it,
		//the current window is disposed and a new InsertionSort window is displayed
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

		
		//Our main panel on which all of our JComponents will be added
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);
		
		//Shadow behind title label
		shadow.setBounds(234, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		
		
		//Our label title 
		label.setText("     	 Insertion Code");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(230, 20, 240,60 );
		
		
		//In the labels below we write our code one line per label
		
		lb13.setHorizontalTextPosition(JLabel.CENTER);
		lb13.setVerticalTextPosition(JLabel.TOP);
		lb13.setForeground(Color.white);
		lb13.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb13.setBounds(10,60,700,100);
		lb13.setText("Main {");
		
		lb14.setHorizontalTextPosition(JLabel.CENTER);
		lb14.setVerticalTextPosition(JLabel.TOP);
		lb14.setBackground(Color.white);
		lb14.setForeground(new Color(255, 87, 34));
		lb14.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		lb14.setBounds(60,80,700,100);
		lb14.setText("//function to swap");

		lb1.setHorizontalTextPosition(JLabel.CENTER);
		lb1.setVerticalTextPosition(JLabel.TOP);
		lb1.setForeground(Color.white);
		lb1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb1.setBounds(60,100,700,100);
		lb1.setText("static void swap(int[] array, int i, int j) {");
		
		lb2.setHorizontalTextPosition(JLabel.CENTER);
		lb2.setVerticalTextPosition(JLabel.TOP);
		lb2.setForeground(Color.white);
		lb2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb2.setBounds(90,120,700,100);
		lb2.setText("int temp=array[i];");
		
		lb3.setHorizontalTextPosition(JLabel.CENTER);
		lb3.setVerticalTextPosition(JLabel.TOP);
		lb3.setForeground(Color.white);
		lb3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb3.setBounds(90,140,700,100);
		lb3.setText("array[i]=array[j];");

		lb4.setHorizontalTextPosition(JLabel.CENTER);
		lb4.setVerticalTextPosition(JLabel.TOP);
		lb4.setForeground(Color.white);
		lb4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb4.setBounds(90,160,700,100);
		lb4.setText("array[j]=temp;");
		
		lb5.setHorizontalTextPosition(JLabel.CENTER);
		lb5.setVerticalTextPosition(JLabel.TOP);
		lb5.setForeground(Color.white);
		lb5.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb5.setBounds(60,180,700,100);
		lb5.setText("}");
		
		lb15.setHorizontalTextPosition(JLabel.CENTER);
		lb15.setVerticalTextPosition(JLabel.TOP);
		lb15.setBackground(Color.white);
		lb15.setForeground(new Color(255, 87, 34));
		lb15.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		lb15.setBounds(60,200,700,100);
		lb15.setText("//function to sort using insertion sort");
		
		lb6.setHorizontalTextPosition(JLabel.CENTER);
		lb6.setVerticalTextPosition(JLabel.TOP);
		lb6.setForeground(Color.white);
		lb6.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb6.setBounds(60,220,700,100);
		lb6.setText("static void insertionSort(int[] array) {");


		lb7.setHorizontalTextPosition(JLabel.CENTER);
		lb7.setVerticalTextPosition(JLabel.TOP);
		lb7.setForeground(Color.white);
		lb7.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb7.setBounds(90,240,700,100);
		lb7.setText("for(int i=0;i<array.length;i++) {");
		
		lb16.setHorizontalTextPosition(JLabel.CENTER);
		lb16.setVerticalTextPosition(JLabel.TOP);
		lb16.setBackground(Color.white);
		lb16.setForeground(new Color(255, 87, 34));
		lb16.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		lb16.setBounds(90,260,700,100);
		lb16.setText("//loop through all the elements in the array");
		
		lb8.setHorizontalTextPosition(JLabel.CENTER);
		lb8.setVerticalTextPosition(JLabel.TOP);
		lb8.setForeground(Color.white);
		lb8.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb8.setBounds(120,280,700,100);
		lb8.setText("for(int j=i;(j>0 && (array[j]<array[j-1]));j--) {");
		
		lb17.setHorizontalTextPosition(JLabel.CENTER);
		lb17.setVerticalTextPosition(JLabel.TOP);
		lb17.setBackground(Color.white);
		lb17.setForeground(new Color(255, 87, 34));
		lb17.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		lb17.setBounds(120,300,700,100);
		lb17.setText("//compare current element with previous ones and swap if it's smaller");
		
		lb9.setHorizontalTextPosition(JLabel.CENTER);
		lb9.setVerticalTextPosition(JLabel.TOP);
		lb9.setForeground(Color.white);
		lb9.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb9.setBounds(150,320,700,100);
		lb9.setText("swap(array,j,j-1);");
		
		lb10.setHorizontalTextPosition(JLabel.CENTER);
		lb10.setVerticalTextPosition(JLabel.TOP);
		lb10.setForeground(Color.white);
		lb10.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb10.setBounds(120,340,700,100);
		lb10.setText("}");
		
		lb11.setHorizontalTextPosition(JLabel.CENTER);
		lb11.setVerticalTextPosition(JLabel.TOP);
		lb11.setForeground(Color.white);
		lb11.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb11.setBounds(90,360,700,100);
		lb11.setText("}");
		
		lb12.setHorizontalTextPosition(JLabel.CENTER);
		lb12.setVerticalTextPosition(JLabel.TOP);
		lb12.setForeground(Color.white);
		lb12.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb12.setBounds(60,380,700,100);
		lb12.setText("}");
		
		lb18.setHorizontalTextPosition(JLabel.CENTER);
		lb18.setVerticalTextPosition(JLabel.TOP);
		lb18.setForeground(Color.white);
		lb18.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb18.setBounds(10,400,700,100);
		lb18.setText("}");
		

		panel.add(label);
		panel.add(shadow);
		panel.add(back);
		panel.add(lb1);
		panel.add(lb2);	
		panel.add(lb3);	
		panel.add(lb4);	
		panel.add(lb5);	
		panel.add(lb6);	
		panel.add(lb7);	
		panel.add(lb8);	
		panel.add(lb9);	
		panel.add(lb10);	
		panel.add(lb11);	
		panel.add(lb12);	
		panel.add(lb13);	
		panel.add(lb14);	
		panel.add(lb15);	
		panel.add(lb16);	
		panel.add(lb17);	
		panel.add(lb18);	
        JScrollPane pane = new JScrollPane(panel);

		this.setContentPane(pane);

		this.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		
		//if the user clicks on the "back" button a new INsertionSort() window is displayed and the cirrent window is disposed
		if (e.getSource()==back) {
			new InsertionSort();
			this.dispose();
		}
	}
}
