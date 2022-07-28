
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
 * The BubbleAlgorithm class simply displays the algorithm
 * for the user.
 * 
 * 
 * @author Ali&Yara
 *
 */
public class BubbleAlgorithm extends JFrame implements ActionListener{
	 JButton back;
	 JButton start;
	 JLabel[] labels;

	BubbleAlgorithm(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();
		//We start by setting our frame, its size and location
		//in addition to its default close operation,title
		//and null layout.
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(false);
		this.setBackground(new Color(255, 255, 255));

		
		
		//We initialize our JComponents
		JPanel panel = new JPanel();
		JPanel line1= new JPanel();
		JPanel line2= new JPanel();
		JLabel label= new JLabel();
		JPanel shadow= new JPanel();
	    back= new JButton();

	    //Since we have many labels to write in,
	    //We created a JLabel array to save lines of code.
		labels= new JLabel[20]; 


		
		
		
		//This is our main panel on which all of the other 
		//components will be added
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);

	    
		//Below is the "Back" button that takes us back to the Sorting Menu
		
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
		panel.add(back);

		
	
		
		//This is our title
		label.setText("  	 Bubble Algorithm");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(235, 20, 240,60 );
		panel.add(label);
	
		//This is the dark label that we added behind the title as a shadow
		//to make it look rased
		shadow.setBounds(239, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		panel.add(shadow);
		
		
		//In this for loop, we initialize the elements in our JLabel arrays
		//and we set the parameters that are the same in all jlabels.
		for  ( int i = 0 ; i < 10 ; i++) {
			labels[i] = new JLabel();
			labels[i].setHorizontalTextPosition(JLabel.CENTER);
			labels[i].setVerticalTextPosition(JLabel.TOP);
			labels[i].setForeground(Color.white);
			labels[i].setFont(new Font("Century Gothic", Font.BOLD, 18));
			panel.add(labels[i]);

		}
		
	
		//The below two lines are decorative only
		line1.setBounds(80,140,5,220);
		line1.setBackground(new Color(255, 87, 34));
		panel.add(line1);
		
		line2.setBounds(625,140,5,220);
		line2.setBackground(new Color(255, 87, 34));
		panel.add(line2);
		
		
		//Below we start adding our Algorithm text using JLabels
		labels[0].setBounds(130,140,700,100);
		labels[0].setText("bubbleSort(array)" );
		panel.add(labels[0]);
		
		labels[1].setBounds(210,170,700,100);
		labels[1].setText("for i <- 1 to indexOfLastUnsortedElement-1" );
		panel.add(labels[1]);
		
		labels[2].setBounds(240,200,700,100);
		labels[2].setText("if leftElement > rightElement" );
		panel.add(labels[2]);
		
		labels[3].setBounds(210,230,700,100);
		labels[3].setText("swap leftElement and rightElement" );
		panel.add(labels[3]);
		
		labels[4].setBounds(130,260,700,100);
		labels[4].setText("end bubbleSort" );
		panel.add(labels[4]);
		
	
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		//If the user clicks on back, we go back to "BubbleSort" window and
		//dispose the current one 
		if (e.getSource()==back) {
			new BubbleSort();
			this.dispose();
		}
	}
	
	
	
	
	
	
	}