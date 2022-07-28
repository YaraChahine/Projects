
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
 * The "Insertion Algorithm" , extends JFrame, displays the insertion algorithm for the user too read and understand
 * 
 * @author Ali&Yara
 *
 */
public class InsertionAlgorithm extends JFrame implements ActionListener{
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

	InsertionAlgorithm(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		
		//Below is our main frame on which everything else will be added
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		
		//We initilaize our JCOmponents
		JPanel panel = new JPanel();
		JLabel label= new JLabel();
		JPanel shadow= new JPanel();

	    back= new JButton();


		lb1 = new JLabel(); 
		lb2 = new JLabel(); 
		lb3 = new JLabel(); 
		lb4 = new JLabel(); 
		lb5 = new JLabel(); 
		lb6 = new JLabel(); 
		lb7 = new JLabel(); 
		lb8 = new JLabel(); 
		lb9 = new JLabel(); 

		//his is our panel on which all other ocmponents will be added.
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);

	    //When the useer clicks on the "Back" button, the current window is disposed and a new "InsertionSort" window is displayed
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

		//We add this shadow a=under the title to make it look rased
		shadow.setBounds(234, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));

		
		//This is our title.
		label.setText("  	 Insertion Algorithm");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(230, 20, 240,60 );
		
		//We start adding our algorithm, one line per label
		lb1.setHorizontalTextPosition(JLabel.CENTER);
		lb1.setVerticalTextPosition(JLabel.TOP);
		lb1.setForeground(Color.white);
		lb1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb1.setBounds(60,100,700,100);
		lb1.setText("insertionSort(array)");
		
		lb2.setHorizontalTextPosition(JLabel.CENTER);
		lb2.setVerticalTextPosition(JLabel.TOP);
		lb2.setForeground(Color.white);
		lb2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb2.setBounds(90,120,700,100);
		lb2.setText("mark first element as sorted");
		
		lb3.setHorizontalTextPosition(JLabel.CENTER);
		lb3.setVerticalTextPosition(JLabel.TOP);
		lb3.setForeground(Color.white);
		lb3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb3.setBounds(90,140,700,100);
		lb3.setText("for each unsorted element X");

		lb4.setHorizontalTextPosition(JLabel.CENTER);
		lb4.setVerticalTextPosition(JLabel.TOP);
		lb4.setForeground(Color.white);
		lb4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb4.setBounds(120,160,700,100);
		lb4.setText("'extract' the element X");
		
		lb5.setHorizontalTextPosition(JLabel.CENTER);
		lb5.setVerticalTextPosition(JLabel.TOP);
		lb5.setForeground(Color.white);
		lb5.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb5.setBounds(120,180,700,100);
		lb5.setText("for j <- lastSortedIndex down to 0");
		
		lb6.setHorizontalTextPosition(JLabel.CENTER);
		lb6.setVerticalTextPosition(JLabel.TOP);
		lb6.setForeground(Color.white);
		lb6.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb6.setBounds(150,200,700,100);
		lb6.setText("if current element j > X");
		
		lb7.setHorizontalTextPosition(JLabel.CENTER);
		lb7.setVerticalTextPosition(JLabel.TOP);
		lb7.setForeground(Color.white);
		lb7.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb7.setBounds(180,220,700,100);
		lb7.setText("move sorted element to the right by 1");
		
		lb8.setHorizontalTextPosition(JLabel.CENTER);
		lb8.setVerticalTextPosition(JLabel.TOP);
		lb8.setForeground(Color.white);
		lb8.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb8.setBounds(120,240,700,100);
		lb8.setText("break loop and insert X here");
		
		lb9.setHorizontalTextPosition(JLabel.CENTER);
		lb9.setVerticalTextPosition(JLabel.TOP);
		lb9.setForeground(Color.white);
		lb9.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb9.setBounds(60,260,700,100);
		lb9.setText("end insertionSort");
	
        JScrollPane pane = new JScrollPane(panel);
		this.setContentPane(pane);
		
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

		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		//If the user clicks on the "back" button, the current window is disposed and a new insertionSort window is displayed
		if (e.getSource()==back) {
			new InsertionSort();
			this.dispose();
		}
	}
}