
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
 * This class extends JFrame and display the Quick Sort algorithm
 * 
 * @author Yara&Ali
 *
 */
public class QuickAlgorithm extends JFrame implements ActionListener{
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

	QuickAlgorithm(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		
		//Our frame
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		
		
		//Our JComponents to be added
		JPanel panel = new JPanel();
		JLabel label= new JLabel();
		JPanel shadow= new JPanel();

		start= new JButton();
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
	    back= new JButton();
	    
	    
	    
	    //Our "back" button, when the user clicks on it, they go back to the "QUickSort" window and the current one is disposed
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
		
		
		//Our main panel on which all other JComponents will be aded
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);
		
		
		// We add this shadow under out title label to make it look raised
		shadow.setBounds(234, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		
		
		//This is our main label
		label.setText("  	 Quick Algorithm");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(230, 20, 240,60 );
		
		
		//We initialize all of our labels and add our agorithm one line per label
		lb1.setHorizontalTextPosition(JLabel.CENTER);
		lb1.setVerticalTextPosition(JLabel.TOP);
		lb1.setForeground(Color.white);
		lb1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb1.setBounds(60,100,700,100);
		lb1.setText("quickSort(array, leftmostIndex, rightmostIndex)");
		
		lb2.setHorizontalTextPosition(JLabel.CENTER);
		lb2.setVerticalTextPosition(JLabel.TOP);
		lb2.setForeground(Color.white);
		lb2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb2.setBounds(90,120,700,100);
		lb2.setText("if (leftmostIndex < rightmostIndex)");
		
		lb3.setHorizontalTextPosition(JLabel.CENTER);
		lb3.setVerticalTextPosition(JLabel.TOP);
		lb3.setForeground(Color.white);
		lb3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb3.setBounds(120,140,700,100);
		lb3.setText("pivotIndex <- partition(array,leftmostIndex, rightmostIndex)");

		lb4.setHorizontalTextPosition(JLabel.CENTER);
		lb4.setVerticalTextPosition(JLabel.TOP);
		lb4.setForeground(Color.white);
		lb4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb4.setBounds(120,160,700,100);
		lb4.setText("quickSort(array, leftmostIndex, pivotIndex - 1)");
		
		lb5.setHorizontalTextPosition(JLabel.CENTER);
		lb5.setVerticalTextPosition(JLabel.TOP);
		lb5.setForeground(Color.white);
		lb5.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb5.setBounds(120,180,700,100);
		lb5.setText("quickSort(array, pivotIndex, rightmostIndex)");
		
		lb6.setHorizontalTextPosition(JLabel.CENTER);
		lb6.setVerticalTextPosition(JLabel.TOP);
		lb6.setForeground(Color.white);
		lb6.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb6.setBounds(60,200,700,100);
		lb6.setText("partition(array, leftmostIndex, rightmostIndex)");
		
		lb7.setHorizontalTextPosition(JLabel.CENTER);
		lb7.setVerticalTextPosition(JLabel.TOP);
		lb7.setForeground(Color.white);
		lb7.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb7.setBounds(90,220,700,100);
		lb7.setText("set rightmostIndex as pivotIndex");
		
		lb8.setHorizontalTextPosition(JLabel.CENTER);
		lb8.setVerticalTextPosition(JLabel.TOP);
		lb8.setForeground(Color.white);
		lb8.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb8.setBounds(90,240,700,100);
		lb8.setText("storeIndex <- leftmostIndex - 1");
		
		lb9.setHorizontalTextPosition(JLabel.CENTER);
		lb9.setVerticalTextPosition(JLabel.TOP);
		lb9.setForeground(Color.white);
		lb9.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb9.setBounds(90,260,700,100);
		lb9.setText("for i <- leftmostIndex + 1 to rightmostIndex");
		
		lb10.setHorizontalTextPosition(JLabel.CENTER);
		lb10.setVerticalTextPosition(JLabel.TOP);
		lb10.setForeground(Color.white);
		lb10.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb10.setBounds(90,280,700,100);
		lb10.setText("if element[i] < pivotElement");
		
		lb11.setHorizontalTextPosition(JLabel.CENTER);
		lb11.setVerticalTextPosition(JLabel.TOP);
		lb11.setForeground(Color.white);
		lb11.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb11.setBounds(120,300,700,100);
		lb11.setText("swap element[i] and element[storeIndex]");
		
		lb12.setHorizontalTextPosition(JLabel.CENTER);
		lb12.setVerticalTextPosition(JLabel.TOP);
		lb12.setForeground(Color.white);
		lb12.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb12.setBounds(120,320,700,100);
		lb12.setText("storeIndex++");
		
		lb13.setHorizontalTextPosition(JLabel.CENTER);
		lb13.setVerticalTextPosition(JLabel.TOP);
		lb13.setForeground(Color.white);
		lb13.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb13.setBounds(90,340,700,100);
		lb13.setText("swap pivotElement and element[storeIndex+1]");
		
		lb14.setHorizontalTextPosition(JLabel.CENTER);
		lb14.setVerticalTextPosition(JLabel.TOP);
		lb14.setForeground(Color.white);
		lb14.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb14.setBounds(60,360,700,100);
		lb14.setText("return storeIndex + 1");
		
		
        JScrollPane pane = new JScrollPane(panel);

		this.setContentPane(pane);

		//We add all of our components to our Panel
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

		this.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		//If the user clicks on the " back " button, the ucrrent iwndow is disposed and a new "QuickSort" window u=is displayed
		if (e.getSource()==back) {
			new QuickSort();
			this.dispose();
		}
	}
}