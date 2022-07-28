

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
 * This class extends JFrame, it displays the BucketCode Code for the user ot see and understand
 * 
 * 
 */
public class BucketCode extends JFrame implements ActionListener{
	 JButton back;
	 JButton start;
	JLabel[]  labels;
	BucketCode(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		//Our main frame
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		//Our JComponents
		labels= new JLabel[47];
		JPanel panel = new JPanel();
		JLabel label= new JLabel();
		JPanel shadow= new JPanel();


        //We initialize all the labels in our JLabel array 
		for ( int i=0; i < 47 ; i++) {
			labels[i] = new JLabel();
			labels[i].setHorizontalTextPosition(JLabel.CENTER);
			labels[i].setVerticalTextPosition(JLabel.TOP);
			labels[i].setForeground(Color.white);
			labels[i].setFont(new Font("Century Gothic", Font.BOLD, 16));
			panel.add(labels[i]);
			
		}

	    //Our back button that disposes the current window and opens a new "BucketSort" window
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

		
		//Ou rmain panel on which all JComponents will be added
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(1060, 1060));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);
		
		//This shadow will be added under out title label
		shadow.setBounds(234, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		
		//our title Label "Bucket Code"
		label.setText("  	     Bucket Code");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(230, 20, 240,60 );
		
		
		
		
		//We start adding our code one line per label;
		labels[32].setBounds(10,60,700,100);		
		labels[32].setText("Main {");
		
		
		labels[33].setBounds(60,80,700,100);
		labels[33].setText("//function to swap");
		
		;
		labels[1].setBounds(60,100,700,100);
		labels[1].setText("static void swap(LinkedList<Integer> bucket,int i,int j) {");
		

		labels[2].setBounds(90,120,700,100);
		labels[2].setText("int element1 = bucket.get(i);");
		
	
		labels[3].setBounds(90,140,900,100);
		labels[3].setText("int element2 = bucket.get(j);");

		labels[4].setBounds(90,160,700,100);
		labels[4].setText("bucket.set(i, element2);");
		
	
		labels[5].setBounds(90,180,700,100);
		labels[5].setText("bucket.set(j, element1);");
		
		
		labels[6].setBounds(60,200,700,100);
		labels[6].setText("}");
		
	
		labels[34].setForeground(new Color(255, 87, 34));
		labels[34].setFont(new Font("Century Gothic", Font.ITALIC, 18));
		labels[34].setBounds(60,220,700,100);
		labels[34].setText("//use selection sort to sort the elements in the buckets");
		

		labels[7].setBounds(60,240,700,100);
		labels[7].setText("static void selectionSort(LinkedList<Integer> bucket) {");
		

		labels[8].setBounds(90,260,700,100);
		labels[8].setText("for(int i=0;i<bucket.size();i++) {");
		

		labels[9].setBounds(120,280,700,100);
		labels[9].setText("int min=i;");

		labels[10].setBounds(120,300,700,100);
		labels[10].setText("for(int j=i+1;j<bucket.size();j++) {");
		
		
		labels[11].setBounds(150,320,700,100);
		labels[11].setText("if (bucket.get(j)<bucket.get(min))");
		
	
		labels[12].setBounds(180,340,700,100);
		labels[12].setText("min=j;");
		
		
		labels[13].setBounds(120,360,700,100);
		labels[13].setText("}");
		

		labels[14].setBounds(120,380,700,100);
		labels[14].setText("swap(bucket,i,min);");
		

		labels[15].setBounds(90,400,700,100);
		labels[15].setText("}");

		labels[16].setBounds(60,420,700,100);
		labels[16].setText("}");
		
		
		labels[35].setForeground(new Color(255, 87, 34));
		labels[35].setFont(new Font("Century Gothic", Font.ITALIC, 18));
		labels[35].setBounds(60,440,700,100);
		labels[35].setText("//function that implements bucket sort");
	
		
		labels[31].setBounds(60,460,700,100);
		labels[31].setText("static void bucketSort(int[] array,int bucketsNumber) {");
		

		labels[17].setBounds(90,480,700,100);
		labels[17].setText("LinkedList[] buckets=new LinkedList[bucketsNumber];");
		
		
		labels[42].setBackground(Color.white);
		labels[42].setForeground(new Color(255, 87, 34));
		labels[42].setFont(new Font("Century Gothic", Font.ITALIC, 18));
		labels[42].setBounds(90,500,700,100);
		labels[42].setText("//make a linked list of buckets");
		
		

		labels[18].setBounds(90,520,700,100);
		labels[18].setText("for(int i=0;i<bucketsNumber;i++) {");

		labels[19].setBounds(120,540,700,100);
		labels[19].setText("buckets[i]=new LinkedList<Integer>();");
		
		
	
		labels[43].setForeground(new Color(255, 87, 34));
		labels[43].setFont(new Font("Century Gothic", Font.ITALIC, 18));
		labels[43].setBounds(120,560,700,100);
		labels[43].setText("//each bucket has a linked list of integers");
		
		
		labels[20].setBounds(90,580,700,100);
		labels[20].setText("}");
		
	
		labels[21].setBounds(90,600,700,100);
		labels[21].setText("for(int number:array) {");
		
	
		labels[22].setBounds(120,620,700,100);
		labels[22].setText("int j=number/10;");
		
		
		labels[23].setBounds(120,640,700,100);
		labels[23].setText("buckets[j].add(number);");
		
		
		labels[44].setForeground(new Color(255, 87, 34));
		labels[44].setFont(new Font("Century Gothic", Font.ITALIC, 18));
		labels[44].setBounds(120,660,700,100);
		labels[44].setText("//put the elements in the suitable bucket based on the division");
	
		labels[24].setFont(new Font("Century Gothic", Font.ITALIC, 18));
		labels[24].setBounds(90,680,700,100);
		labels[24].setText("}");
		
	
		labels[25].setBounds(90,700,700,100);
		labels[25].setText("for(LinkedList<Integer> bucket:buckets) {");
		
		labels[26].setBounds(120,720,700,100);
		labels[26].setText("selectionSort(bucket);");
		

		labels[45].setForeground(new Color(255, 87, 34));
		labels[45].setFont(new Font("Century Gothic", Font.ITALIC, 18));
		labels[45].setBounds(120,740,700,100);
		labels[45].setText("//sort elements in each bucket using selection sort");
		

		labels[27].setFont(new Font("Century Gothic", Font.BOLD, 18));
		labels[27].setBounds(90,760,700,100);
		labels[27].setText("}");
		
		
		labels[28].setFont(new Font("Century Gothic", Font.BOLD, 18));
		labels[28].setBounds(90,780,700,100);
		labels[28].setText("int i = 0;");
		

		labels[29].setBounds(90,800,700,100);
		labels[29].setText("for(LinkedList<Integer> bucket:buckets){");

		labels[30].setBounds(120,820,700,100);
		labels[30].setText("for(int number:bucket){");
		
	
		labels[46].setForeground(new Color(255, 87, 34));
		labels[46].setFont(new Font("Century Gothic", Font.ITALIC, 18));
		labels[46].setBounds(150,840,700,100);
		labels[46].setText("//rebuild the new (sorted) array ");
		
	
		labels[36].setBounds(150,860,700,100);
		labels[36].setText("array[i] = number;");
		
	
		labels[37].setBounds(150,880,700,100);
		labels[37].setText("i++;");
		
		
		labels[38].setBounds(120,900,700,100);
		labels[38].setText("}");
		

		labels[39].setBounds(90,920,700,100);
		labels[39].setText("}");

		labels[40].setBounds(60,940,700,100);
		labels[40].setText("}");

		labels[41].setBounds(10,960,700,100);
		labels[41].setText("}");
        JScrollPane pane = new JScrollPane(panel);

		this.setContentPane(pane);

		//we add remaining components to the panel and we make our frame visible;
		panel.add(label);
		panel.add(shadow);
		panel.add(back);
		

		this.setVisible(true);
		
	}
	

	public void actionPerformed(ActionEvent e) {
		//if the user clicks on this button, the current window will be disposed and a new "BucketSort()" window will be displayed
		if (e.getSource()==back) {
			new BucketSort();
			this.dispose();
		}
	}
}