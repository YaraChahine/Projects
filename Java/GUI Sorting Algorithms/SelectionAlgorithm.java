
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

public class SelectionAlgorithm extends JFrame implements ActionListener{
	 JButton back;
	 JButton start;
	 JLabel[] labels;

	SelectionAlgorithm(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		this.setLayout(null);

		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		JPanel panel = new JPanel();
		JPanel line1= new JPanel();
		JPanel line2= new JPanel();
		JLabel label= new JLabel();
		JPanel shadow= new JPanel();
		this.add(panel);
        JScrollPane pane = new JScrollPane(panel);

		start= new JButton();
		labels= new JLabel[20]; 

	    Icon icon = new ImageIcon("C:\\Users\\HES\\Desktop\\Java Labs\\Project_CP3\\src\\arrow.png");               
	    start.setBounds(30,200,40,40);
	    start.addActionListener(this);
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

		
		
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		
		shadow.setBounds(239, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		
		
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

		//lb.setText("test");
		for  ( int i = 0 ; i < 10 ; i++) {
			labels[i] = new JLabel();
			labels[i].setHorizontalTextPosition(JLabel.CENTER);
			labels[i].setVerticalTextPosition(JLabel.TOP);
			labels[i].setForeground(Color.white);
			labels[i].setFont(new Font("Century Gothic", Font.BOLD, 18));
			panel.add(labels[i]);

		}

	
		line1.setBounds(80,140,5,300);
		line1.setBackground(new Color(255, 87, 34));
		panel.add(line1);
		
		line2.setBounds(625,140,5,300);
		line2.setBackground(new Color(255, 87, 34));
		panel.add(line2);
		labels[0].setBounds(130,120,700,100);
		labels[0].setText("SelectionSort(array,size)" );

		labels[1].setBounds(210,150,700,100);
		labels[1].setText("repeat (size - 1 ) times");

		labels[2].setBounds(210,180,700,100);
		labels[2].setText("set the first unsorted element as the minimum" );
		
		labels[3].setBounds(210,210,700,100);
		labels[3].setText("for each of the unsorted elements" );
	
		labels[4].setBounds(230,240,700,100);
		labels[4].setText("if element < currentMinimum" );

		
		labels[5].setBounds(250,270,700,100);
		labels[5].setText("set element as new minimum" );

		labels[6].setBounds(210,300,700,100);
		labels[6].setText("swap minimum with first unsorted position" );

		labels[7].setBounds(130,330,700,100);
		labels[7].setText("end SelectionSort" );
		
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
		panel.add(back);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		
		if (e.getSource()==back) {
			new SelectionSort();
			this.dispose();
		}
	}
	
	
	
	
	
	
	}