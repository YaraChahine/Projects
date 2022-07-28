
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
 * This class extends JFrame , it displays the Selection Sort code for the user to use as reference
 * 
 * @author yara&ali
 *
 */
public class SelectionCode extends JFrame implements ActionListener{
	 JButton back;
	 JButton start;
	 JLabel[] labels;

	SelectionCode(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		
		//This is our main frame
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		
		//Below are the JComponents that will be used in this class
		JPanel panel = new JPanel();
		JPanel line1= new JPanel();
		JPanel line2= new JPanel();
		JLabel label= new JLabel();
		JPanel shadow= new JPanel();
		labels= new JLabel[20]; 
		
		
		
		//our "back" button, when the user clicks on it, the current window is disposed and a new "Selection Sort" wwindow is displayed
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

		
		//The panel on which all of our JComponents will be added
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);

		
		//Shadow added behind our title Label
		shadow.setBounds(239, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		
		
		
		//Our title label
		label.setText("  	 Selection Code");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(235, 20, 240,60 );

		
		
		
		
		
		//A for loop to initialize our labels
		for  ( int i = 0 ; i < 20 ; i++) {
			labels[i] = new JLabel();
			labels[i].setHorizontalTextPosition(JLabel.CENTER);
			labels[i].setVerticalTextPosition(JLabel.TOP);
			labels[i].setForeground(Color.white);
			labels[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
			panel.add(labels[i]);

		}
	
		
		
		
		
		//Below e added the SelecctionSort code one line per label
	
		labels[0].setBounds(20,60,700,100);
		labels[0].setText("class SelectionSort {" );
		
		
		
		labels[1].setBounds(50,95,700,100);
		labels[1].setText("void selectionSort(int array[]) {");
	

		labels[2].setBounds(50,115,700,100);
		labels[2].setText("int size = array.length;" );
		
		labels[3].setBounds(80,135,700,100);
		labels[3].setText("for (int step = 0; step < size - 1; step++) {" );
	
		labels[4].setBounds(120,155,700,100);
		labels[4].setText("int min_idx = step;" );
	
		
		labels[5].setBounds(150,175,700,100);
		labels[5].setText("for (int i = step + 1; i < size; i++) {" );
		
		
		labels[6].setBounds(170,195,700,100);
		labels[6].setText("// To sort in descending order, change > to < in this line." );
		labels[6].setForeground(new Color(255, 87, 34));
		labels[6].setFont(new Font("Century Gothic", Font.ITALIC, 15));
	
		labels[7].setBounds(170,215,700,100);
		labels[7].setText("// Select the minimum element in each loop." );
		labels[7].setForeground(new Color(255, 87, 34));
		labels[7].setFont(new Font("Century Gothic", Font.ITALIC, 15));
		
		
		labels[8].setBounds(190,235,700,100);
		labels[8].setText("if (array[i] < array[min_idx]) {" );
		
		labels[9].setBounds(190,255,700,100);
		labels[9].setText("min_idx = i;}" );		

		labels[10].setBounds(150,275,700,100);
		labels[10].setText("}" );
		
		labels[11].setBounds(210,295,700,100);
		labels[11].setText(" // put min at the correct position" );
		labels[11].setForeground(new Color(255, 87, 34));
		labels[11].setFont(new Font("Century Gothic", Font.ITALIC, 15));
	
		
		labels[12].setBounds(120,315,700,100);
		labels[12].setText("int temp = array[step];" );		

		
		labels[13].setBounds(120,335,700,100);
		labels[13].setText("array[j] = array[j + 1];" );	
		
		labels[14].setBounds(120,355,700,100);
		labels[14].setText("array[min_idx] = temp;" );	
		
		
		labels[15].setBounds(50,375,700,100);
		labels[15].setText("}" );	
		
		labels[16].setBounds(20,395,700,100);
		labels[16].setText("}" );	
		
		
	
		//We add our components to our panel and we make this frame visible
		this.add(panel);
		panel.add(label);
		panel.add(shadow);
		panel.add(labels[0]);
		panel.add(labels[1]);
		panel.add(labels[2]);
		panel.add(labels[3]);
		panel.add(labels[4]);
		panel.add(labels[5]);
		panel.add(labels[6]);
		panel.add(labels[7]);
		panel.add(labels[8]);
		panel.add(labels[9]);
		panel.add(labels[10]);
		panel.add(labels[11]);
		panel.add(labels[12]);
		panel.add(labels[13]);
		panel.add(labels[14]);
		panel.add(labels[15]);
		panel.add(labels[16]);
		panel.add(back);
		this.setVisible(true);

		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		//I fthe user clicks on the "ack" button this window is disposed and a new SelectionSort window is displayed
		if (e.getSource()==back) {
			new SelectionSort();
			this.dispose();
		}
	}
	
	
	
	
	
	
	}