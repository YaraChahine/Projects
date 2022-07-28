
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
 * This class displays the algorithm for the Merge Sort so that the user can better understand it.
 * 
 * 
 * @author Ali&Yara
 *
 */
public class MergeAlgorithm extends JFrame implements ActionListener{
	 JButton back;
	 JButton start;
	 JLabel[] labels;

	MergeAlgorithm(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		
		//This is our frame on which everything else will be added
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		//These are our JComponents
		JPanel panel = new JPanel();
		JPanel line1= new JPanel();
		JPanel line2= new JPanel();
		JLabel label= new JLabel();
		JPanel shadow= new JPanel();


		labels= new JLabel[20]; 
	    back= new JButton();

	    //When the user clicks on this  button, they will go back to the "MergeSort" window
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

		
		//Our main panel on which everything else will be added
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);
		
		//We add this shadow below the title label to make it look raised 
		shadow.setBounds(239, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		
		//Our Title Label
		label.setText(" Selection Algorithm");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(235, 20, 240,60 );
		label.setBorder(border);

		
		//We created this JLabel array since we have many. In this for loop
		//We initialize each label and the common features between them all.
		for  ( int i = 0 ; i < 10 ; i++) {
			labels[i] = new JLabel();
			labels[i].setHorizontalTextPosition(JLabel.CENTER);
			labels[i].setVerticalTextPosition(JLabel.TOP);
			labels[i].setForeground(Color.white);
			labels[i].setFont(new Font("Century Gothic", Font.BOLD, 17));
			panel.add(labels[i]);

		}

	
		
		//the below two lines are decorative
		line1.setBounds(80,140,5,300);
		line1.setBackground(new Color(255, 87, 34));
		panel.add(line1);
		

		line2.setBounds(625,140,5,300);
		line2.setBackground(new Color(255, 87, 34));
		panel.add(line2);
		
		//We start adding the algorithm text one line per label, specifying the bounds of each
		labels[0].setBounds(90,90,700,100);
		labels[0].setText("MergeSort(arr[], l,  r)" );

		labels[1].setBounds(120,120,700,100);
		labels[1].setText("If r > l");

		labels[2].setBounds(120,150,700,100);
		labels[2].setText("1. Find the middle point to divide the array into two halves: " );
		
		labels[3].setBounds(170,180,700,100);
		labels[3].setText("Call mergeSort(arr, l, m)" );
	
		labels[4].setBounds(120,210,700,100);
		labels[4].setText("2. Call mergeSort for first half:" );

		
		labels[5].setBounds(200,240,700,100);
		labels[5].setText("Call mergeSort(arr, l, m)" );

		labels[6].setBounds(120,270,700,100);
		labels[6].setText("3. Call mergeSort for second half" );

		labels[7].setBounds(200,300,700,100);
		labels[7].setText("Call mergeSort(arr, m+1, r)" );

		labels[8].setBounds(120,330,700,100);
		labels[8].setText("4. Merge the two halves sorted in step 2 and 3:" );

		labels[9].setBounds(200,360,700,100);
		labels[9].setText("Call merge(arr, l, m, r)" );
		
		
		//Finally, we add the panel to the frame and the JComponents to the panel.
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
		panel.add(back);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		//When the user clicks on the "back" button, the current window is disposed and a new MergeSort window is displayed
		if (e.getSource()==back) {
			new MergeSort();
			this.dispose();
		}
	}
	
	
	
	
	
	
	}