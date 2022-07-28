
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

public class TimeComplexity extends JFrame implements ActionListener{
	JButton button2;
	JButton button1;
	JButton button3;
	JButton button4;
	JLabel label2;
	JLabel label3;
	JPanel panel;
	int counter=0;
	TimeComplexity(){
		

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		this.setLayout(null);

		this.setTitle("Sorting Algorithms");
		this.setSize(550,650);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));
		//this.setLayout(new BorderLayout());
		panel= new JPanel();
		JPanel shadow = new JPanel();
		JPanel shadow2 = new JPanel();
		JPanel shadow3 = new JPanel();
		JPanel shadow4 = new JPanel();
		JPanel shadow5 = new JPanel();

		JPanel line= new JPanel();
		JPanel line2= new JPanel();
		JPanel line3= new JPanel();
		JPanel line4= new JPanel();

		JLabel label= new JLabel();
		label2= new JLabel();
		label3= new JLabel();


		button1= new JButton();
		button2= new JButton();
		button3= new JButton();
		button4= new JButton();

		shadow.setBounds(158, 222, 230, 52);
		shadow.setBackground(new Color(35,35,30));
		shadow2.setBounds(158, 326, 230, 53);
		shadow2.setBackground(new Color(35,35,35));
		shadow3.setBounds(158,430,230,53);
		shadow3.setBackground(new Color(35,35,35));
		shadow4.setBounds(100, 41, 355,74);
		shadow4.setBackground(new Color(35,35,35));
		shadow5.setBounds(158,535,230,53);
		shadow5.setBackground(new Color(35,35,35));
		line.setBounds(0,0,5,650);
		line.setBackground(new Color(255, 87, 34));
		line.setLayout(null);
		line2.setBounds(0,0,650,5);
		line2.setBackground(new Color(255, 87, 34));
		line2.setLayout(null);
		line3.setBounds(0,606,550,5);
		line3.setBackground(new Color(255, 87,34));
		line3.setLayout(null);
		line4.setBounds(529,0,7,650);
		line4.setBackground(new Color(255, 87, 34));
		line4.setLayout(null);
		panel.setBounds(0, 0, 700, 700);
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
	
		this.add(panel);
		
		label.setText("      Time Complexity ");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 30));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(100, 40, 350,70 );
		
		label2.setForeground(Color.white);
		label2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		label2.setText("");
		label2.setBounds(100, 100, 400, 70);
		
		label3.setForeground(Color.white);
		label3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label3.setText("");
		label3.setBounds(80, 120, 700, 70);
		
		
		//this.add(button6);
		button1.setBounds(155, 220, 230, 50);
		button1.setBackground(new Color(255, 255, 255));
		//Border border1= BorderFactory.createLineBorder(Color.black, 5);
		//button1.setBorder(border1);
		button1.setText(" O(n^2) ");
		button1.setHorizontalTextPosition(JButton.CENTER);
		button1.setFocusable(false);
		button1.setFont(new Font("Century Gothic", Font.BOLD,22));
		button1.setForeground(new Color(255, 87, 34));
		button1.setBorder(border);
		button1.addActionListener(this);
		//shadow.add(button1);
		panel.add(button1);


	//	panel.add(button1);
		   
		
		
		button2.setBounds(155,325,230,50);
		button2.setBackground(new Color(255,255,255));
		//Border border1= BorderFactory.createLineBorder(Color.black, 5);
		//button1.setBorder(border1);
		button2.setText(" O(n*log n) ");
		button2.setHorizontalTextPosition(JButton.CENTER);
		button2.setFocusable(false);
		button2.setFont(new Font("Century Gothic", Font.BOLD,22));
		button2.setForeground(new Color(0, 173, 181));
		button2.setBorder(border);
		button2.addActionListener(this);
		panel.add(button2);
		
		
		
		
		button3.setBounds(155,430,230,50);
		button3.setBackground(new Color(255,255,255));
		//Border border1= BorderFactory.createLineBorder(Color.black, 5);
		//button1.setBorder(border1);
		button3.setText(" O(n+k) ");
		button3.setHorizontalTextPosition(JButton.CENTER);
		button3.setFocusable(false);
		button3.setFont(new Font("Century Gothic", Font.BOLD,22));
		button3.setForeground(new Color(48, 56, 65));
		button3.setBorder(border);
		button3.addActionListener(this);

		
		
		
		panel.add(button3);
		button4.setBounds(155,535,230,50);
		button4.setBackground(new Color(255,255,255));
		//Border border1= BorderFactory.createLineBorder(Color.black, 5);
		//button1.setBorder(border1);
		button4.setText(" Start ");
		button4.setHorizontalTextPosition(JButton.CENTER);
		button4.setFocusable(false);
		button4.setFont(new Font("Century Gothic", Font.BOLD,22));
		button4.setForeground(new Color(48, 56, 65));
		button4.setBorder(border);
		button4.addActionListener(this);
		//panel.add(button6);
    	panel.add(shadow);
		panel.add(shadow2);
		panel.add(shadow3);
	
	//	label.setBorder(border);
		panel.add(label);
		panel.add(label2);
		panel.add(label3);

		panel.add(shadow4);

		panel.add(line);
		panel.add(line2);
		panel.add(line3);
		panel.add(line4);
		this.setVisible(true);
		panel.add(button4);
		panel.add(shadow5);

	}

	public void actionPerformed(ActionEvent e) {
	//	while(true){
		if (e.getSource()==button1 && ((counter%6)-1)==0) {
			label3.setText("Yes, that's correct! O(n^2) is the time complexity of bubble sort.");
			}
			if ((e.getSource()==button2 || e.getSource()==button3)&& ((counter%6)-1)==0) {
				label3.setText("No, that's wrong! O(n^2) is the time complexity of bubble sort.");
			}
			if (e.getSource()==button1 && ((counter%6)-1)==1) {
				label3.setText("Yes, that's correct! O(n^2) is the time complexity of selection sort.");
			}
			if ((e.getSource()==button2 || e.getSource()==button3)&& ((counter%6)-1)==1) {
				label3.setText("No, that's wrong! O(n^2) is the time complexity of selection sort.");

			}
			if (e.getSource()==button1 && ((counter%6)-1)==2) {
				label3.setText("Yes, that's correct! O(n^2) is the time complexity of insertion sort.");
			}
			if ((e.getSource()==button2 || e.getSource()==button3)&& ((counter%6)-1)==2) {
				label3.setText("No, that's wrong! O(n^2) is the time complexity of insertion sort.");
			}
	
			if (e.getSource()==button2 && ((counter%6)-1)==3) {
				label3.setText("Yes, that's correct! O(n*log n) is the time complexity of merge sort.");
			}
			if ((e.getSource()==button1 || e.getSource()==button3)&& ((counter%6)-1)==3) {
				label3.setText("No, that's wrong! O(n*log n) is the time complexity of merge sort.");
			}
			
			if (e.getSource()==button3 && ((counter%6)-1)==4) {
				label3.setText("Yes, that's correct! O(n+k) is the time complexity of bucket sort.");
			}
			if ((e.getSource()==button2 || e.getSource()==button1)&& ((counter%6)-1)==4) {
				label3.setText("No, that's wrong! O(n+k) is the time complexity of bucket sort.");
			}
			
			if (e.getSource()==button1 && ((counter%6)-1)==-1) {
				label3.setText("Yes, that's correct! O(n^2) is the time complexity of quick sort.");
			}
			if ((e.getSource()==button2 || e.getSource()==button3)&& ((counter%6)-1)==-1) {
				label3.setText("No, that's wrong! O(n^2) is the time complexity of quick sort.");
			}
		if(e.getSource()==button4) {
			if(counter%6==0) {
				label2.setText("What is the time complexity of bubble sort?");
				label3.setText("");
				button4.setText("Next Question");
				counter++;
			}
			else if (counter%6==1) {
				label2.setText("What is the time complexity of selection sort?");
				label3.setText("");
				counter++;
			}
			else if (counter%6==2) {
				label2.setText("What is the time complexity of insertion sort?");
				label3.setText("");
				counter++;
			}
			else if (counter%6==3) {
				label2.setText("What is the time complexity of merge sort?");
				label3.setText("");
				counter++;
			}
			else if (counter%6==4) {
				label2.setText("What is the time complexity of bucket sort?");
				label3.setText("");
				counter++;
			}
			else if (counter%6==5) {
				label2.setText("What is the time complexity of quick sort?");
				label3.setText("");
				counter++;
			}
		}
	}
}