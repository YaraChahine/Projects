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
import javax.swing.border.Border;
/**
 * this class extends JFrame, it displays the MergeSort code for the user to have as a reference
 * 
 * 
 * @author ali&yara
 *
 */
public class MergeCode extends JFrame implements ActionListener{
	 JButton back;
	 JButton start;
	 JLabel[] labels;

	MergeCode(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		
		//our main frame
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(650,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		//our JComponenta
		JPanel panel = new JPanel();
		JLabel label= new JLabel();
		JPanel shadow= new JPanel();
		JLabel labelIcon= new JLabel();
		JLabel labelIcon2= new JLabel();

		//if the user clicks on this button the current window is disposed
		//and a new MergeSirt window is displayed
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
		
		
		
		//our codes images, since this code is long we decided to include it as screenshots instead of
		//using JLabels
		ImageIcon code= new ImageIcon("C:\\Users\\HES\\Desktop\\MergeCode.png");
		ImageIcon code2= new ImageIcon("C:\\Users\\HES\\Desktop\\MergeCode2.png");

    

		start= new JButton();
		labels= new JLabel[20]; 


		//our "back" button,, when the user clicks on it, this window is disposed
		//and a new MergeCode window is displayed
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

		
		//the panel on which everything else will be added
		panel.setBounds(0, 0, 800, 1000);
		panel.setPreferredSize(new Dimension(900, 1200));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		
		
		//the shadow to be added under out title Label
		shadow.setBounds(184, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		
		
		//Our title Label
		label.setText("      	 Merge Code");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(180, 20, 240,60 );

		//our main panel on which everything will be added
		panel.add(label);
		panel.add(shadow);
		this.add(panel);
		
		//we add the labels on which we are adding the code images onto our panel
		panel.add(labelIcon);
		panel.add(labelIcon2);

		//we set the icon ( code image) to our two Label Icons,
		//we set the image alignment of the images in the center and we make
		//an orange frame to separate it from the background
		labelIcon.setIcon(code);
		labelIcon.setOpaque(true);
		labelIcon.setBounds(100,130,430,320);
		
		labelIcon2.setIcon(code2);
		labelIcon2.setOpaque(true);
		labelIcon2.setBounds(60,460,520,460);
		
		labelIcon.setBackground(new Color(255, 87, 34));
		labelIcon2.setBackground(new Color(255, 87, 34));
		
		labelIcon.setVerticalAlignment(JLabel.CENTER);
		labelIcon.setHorizontalAlignment(JLabel.CENTER);
		labelIcon2.setVerticalAlignment(JLabel.CENTER);
		labelIcon2.setHorizontalAlignment(JLabel.CENTER);
		
		
		panel.add(back);
		JScrollPane pane= new JScrollPane(panel);
		this.setContentPane(pane);

		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//When user clicks on "back" , current window is disposed
		//and a new MergeSort window is displayed
		if (e.getSource()== back) {
			new MergeSort();
			this.dispose();
		}
		
		

	}
	
	
}