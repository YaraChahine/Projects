

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
 * The "BucketAlgorithm" class extends JFrame and displays a frame on which the bucket algorithm is written.
 * 
 * @author HES
 *
 */
public class BucketAlgorithm extends JFrame implements ActionListener{
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

	BucketAlgorithm(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		//We create our frame
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		//These are the JComponents to be used
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
	    back= new JButton();
	
		//We set the bounds and the background of our JPanel  on which everything else will be added
	    //Then we add the JPanel to our frame;
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);

		
		//This is our "Back" button, when the user clicks on it , he/she goes back to the "BucketSOrt" window
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
		
	

		
		//This is our title Label in the center top of our panel.
		label.setText("  	 Bucket Algorithm");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(230, 20, 240,60 );
		panel.add(label);
		

		//This shadow is a dark label we add udner our  title to make it lok raised
		shadow.setBounds(234, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		panel.add(shadow);
		
		//In the following, we start adding our text each line in a different label
		lb1.setHorizontalTextPosition(JLabel.CENTER);
		lb1.setVerticalTextPosition(JLabel.TOP);
		lb1.setForeground(Color.white);
		lb1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb1.setBounds(60,100,700,100);
		lb1.setText("bucketSort()");
		
		lb2.setHorizontalTextPosition(JLabel.CENTER);
		lb2.setVerticalTextPosition(JLabel.TOP);
		lb2.setForeground(Color.white);
		lb2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb2.setBounds(90,120,700,100);
		lb2.setText("create N buckets each of which can hold a range of values");
		
		lb3.setHorizontalTextPosition(JLabel.CENTER);
		lb3.setVerticalTextPosition(JLabel.TOP);
		lb3.setForeground(Color.white);
		lb3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb3.setBounds(90,140,700,100);
		lb3.setText("for all the buckets");

		lb4.setHorizontalTextPosition(JLabel.CENTER);
		lb4.setVerticalTextPosition(JLabel.TOP);
		lb4.setForeground(Color.white);
		lb4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb4.setBounds(120,160,700,100);
		lb4.setText("initialize each bucket with 0 values");
		
		lb5.setHorizontalTextPosition(JLabel.CENTER);
		lb5.setVerticalTextPosition(JLabel.TOP);
		lb5.setForeground(Color.white);
		lb5.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb5.setBounds(90,180,700,100);
		lb5.setText("for all the buckets");
		
		lb6.setHorizontalTextPosition(JLabel.CENTER);
		lb6.setVerticalTextPosition(JLabel.TOP);
		lb6.setForeground(Color.white);
		lb6.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb6.setBounds(120,200,700,100);
		lb6.setText("put elements into buckets matching the range");
		
		lb7.setHorizontalTextPosition(JLabel.CENTER);
		lb7.setVerticalTextPosition(JLabel.TOP);
		lb7.setForeground(Color.white);
		lb7.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb7.setBounds(90,220,700,100);
		lb7.setText("for all the buckets");
		
		lb8.setHorizontalTextPosition(JLabel.CENTER);
		lb8.setVerticalTextPosition(JLabel.TOP);
		lb8.setForeground(Color.white);
		lb8.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb8.setBounds(120,240,700,100);
		lb8.setText("sort elements in each bucket");
		
		lb9.setHorizontalTextPosition(JLabel.CENTER);
		lb9.setVerticalTextPosition(JLabel.TOP);
		lb9.setForeground(Color.white);
		lb9.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb9.setBounds(90,260,700,100);
		lb9.setText("gather elements from each bucket");
		
		lb10.setHorizontalTextPosition(JLabel.CENTER);
		lb10.setVerticalTextPosition(JLabel.TOP);
		lb10.setForeground(Color.white);
		lb10.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb10.setBounds(60,280,700,100);
		lb10.setText("end bucketSort");
		
		
		
		//This is to add our ScrollPane so that we are able to se more of our panel as we scroll down
		 JScrollPane pane = new JScrollPane(panel);
		this.setContentPane(pane);

		

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

		this.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		//if the user clicks on the "back"' button, they go bsck to the "BucketSort" window, and the current window is disposed
		if (e.getSource()==back) {
			new BucketSort();
			this.dispose();
		}
	}
	
}
