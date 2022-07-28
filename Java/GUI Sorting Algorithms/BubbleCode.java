
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.WEST;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
 * this class extends JFrame, it displays the Bubble Sort code for the user as a reference
 * 
 * @author yara&ali
 *
 */
public class BubbleCode extends JFrame implements ActionListener{
	 JButton back;
	 JButton start;
	 JLabel[] labels;

	BubbleCode(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		
		
		//Our main frame
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		
		//our JComponents
		JPanel panel = new JPanel();
		JLabel label= new JLabel();
		JPanel shadow= new JPanel();
		labels= new JLabel[20]; 

		
		//our "back" button, when the user click on it, 
		//the current window is disposed
		//and a new BubbleSort window is displayed
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

		
		
		
		//our main panel on which all other components will be added
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);
		
		
		//shadow to be added behind out title label to make it look raised
		shadow.setBounds(239, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		
		
		
		
		//our Title Label
		label.setText("  	 Bubble Code");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(235, 20, 240,60 );

		
		
		
		//Initializing our JLabels and giving them the specifications
		//that are common between all of them
		for  ( int i = 0 ; i < 20 ; i++) {
			labels[i] = new JLabel();
			labels[i].setHorizontalTextPosition(JLabel.CENTER);
			labels[i].setVerticalTextPosition(JLabel.TOP);
			labels[i].setForeground(Color.white);
			labels[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
			panel.add(labels[i]);
		}

		
		
		
		
		
		//We start adding the code one line per label
		labels[0].setBounds(20,60,700,100);
		labels[0].setText("class Main{" );
		
		
		
		labels[1].setBounds(50,95,700,100);
		labels[1].setText("//perform the bubble sort");
		labels[1].setForeground(new Color(255, 87, 34));
		labels[1].setFont(new Font("Century Gothic", Font.ITALIC, 15));

		labels[2].setBounds(50,115,700,100);
		labels[2].setText("static void bubbleSort(int array[]) {" );
		
		labels[3].setBounds(80,135,700,100);
		labels[3].setText("int size = array.length;" );
	
		labels[4].setBounds(120,155,700,100);
		labels[4].setText("// loop to access each array element" );
		labels[4].setForeground(new Color(255, 87, 34));
		labels[4].setFont(new Font("Century Gothic", Font.ITALIC, 15));
		
		labels[5].setBounds(150,175,700,100);
		labels[5].setText("for (int i = 0; i < size - 1; i++)" );
		
		
		labels[6].setBounds(170,195,700,100);
		labels[6].setText("// loop to compare array elements" );
		labels[6].setForeground(new Color(255, 87, 34));
		labels[6].setFont(new Font("Century Gothic", Font.ITALIC, 15));
	
		labels[7].setBounds(170,215,700,100);
		labels[7].setText("for (int j = 0; j < size - i - 1; j++)" );
		
		labels[8].setBounds(190,235,700,100);
		labels[8].setText("// compare two adjacent elements" );
		labels[8].setForeground(new Color(255, 87, 34));
		labels[8].setFont(new Font("Century Gothic", Font.ITALIC, 15));
		
		labels[9].setBounds(190,255,700,100);
		labels[9].setText("// change > to < to sort in descending order" );		
		labels[9].setForeground(new Color(255, 87, 34));
		labels[9].setFont(new Font("Century Gothic", Font.ITALIC, 15));
		
		labels[10].setBounds(190,275,700,100);
		labels[10].setText("if (array[j] > array[j + 1]) {" );
		
		labels[11].setBounds(210,295,700,100);
		labels[11].setText("//swapping occurs if elements are not in the intended order" );
		labels[11].setForeground(new Color(255, 87, 34));
		labels[11].setFont(new Font("Century Gothic", Font.ITALIC, 15));
	
		
		labels[12].setBounds(210,315,700,100);
		labels[12].setText("int temp = array[j];" );		

		
		labels[13].setBounds(210,335,700,100);
		labels[13].setText("array[j] = array[j + 1];" );	
		
		labels[14].setBounds(210,355,700,100);
		labels[14].setText("array[j + 1] = temp;  }" );	
		
		
		labels[15].setBounds(50,375,700,100);
		labels[15].setText("}" );	
		
		labels[16].setBounds(20,395,700,100);
		labels[16].setText("}" );	
		
		
	
		
		this.add(panel);
		panel.add(label);
		panel.add(shadow);
		panel.add(back);
		this.setVisible(true);

		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		//if the user clicks in this "back" button, the current window is disposed
		//and a new BUbbleSOrt window is displayed
		if (e.getSource()==back) {
			new BubbleSort();
			this.dispose();
		}
	}
	
	
	
	
	
	
	}