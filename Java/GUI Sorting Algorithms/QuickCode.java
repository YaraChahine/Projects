
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
 *This class extends AJFrame, it displays the code for QUick Sort for the user as a reference
 * 
 * 
 * @author yara&ali
 *
 */
public class QuickCode extends JFrame implements ActionListener{
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
	 JLabel lb15;
	 JLabel lb16;
	 JLabel lb17;
	 JLabel lb18;
	 JLabel lb19;
	 JLabel lb20;
	 JLabel lb21;
	 JLabel lb22;
	 JLabel lb23;
	 JLabel lb24;
	 JLabel lb25;
	 JLabel lb26;
	 JLabel lb27;
	 JLabel lb28;
	 JLabel lb29;

	QuickCode(){

		Border border= BorderFactory.createRaisedSoftBevelBorder();
		//our main frame
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(715,500);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(true);
		this.setBackground(new Color(255, 255, 255));

		
		//Our JComponents that are used in this class
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
		lb15 = new JLabel(); 
		lb16 = new JLabel(); 
		lb17 = new JLabel(); 
		lb18 = new JLabel(); 
		lb19 = new JLabel(); 
		lb20 = new JLabel(); 
		lb21 = new JLabel(); 
		lb22 = new JLabel(); 
		lb23 = new JLabel(); 
		lb24 = new JLabel(); 
		lb25 = new JLabel(); 
		lb26 = new JLabel(); 
		lb27 = new JLabel(); 
		lb28 = new JLabel(); 
		lb29 = new JLabel(); 

		
		//Our "back" button, when the user clicks on it, the current window is disposed and a new QUckSort
		//window is disposed
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
		
		
		//our main panel on which all of our JComponents are added
		panel.setBounds(0, 0, 700, 1000);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);
      
        //Shadow that we put behind our title label to make it look raised
		shadow.setBounds(234, 24, 240, 60);
		shadow.setBackground(new Color(35,35,35));
		
		
		//our title Label
		label.setText("  	 Quick Code");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 24));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(230, 20, 240,60 );
		
		
		
		//In the following, we wrtie the Quick Sort code one line per label
		lb25.setHorizontalTextPosition(JLabel.CENTER);
		lb25.setVerticalTextPosition(JLabel.TOP);
		lb25.setForeground(Color.white);
		lb25.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb25.setBounds(10,60,700,100);
		lb25.setText("Main {");
		
		lb28.setHorizontalTextPosition(JLabel.CENTER);
		lb28.setVerticalTextPosition(JLabel.TOP);
		lb28.setBackground(Color.white);
		lb28.setForeground(new Color(255, 87, 34));
		lb28.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		lb28.setBounds(60,80,700,100);
		lb28.setText("//function to swap");

		lb1.setHorizontalTextPosition(JLabel.CENTER);
		lb1.setVerticalTextPosition(JLabel.TOP);
		lb1.setForeground(Color.white);
		lb1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb1.setBounds(60,100,700,100);
		lb1.setText("static void swap(int[] array, int i, int j) {");
		
		lb2.setHorizontalTextPosition(JLabel.CENTER);
		lb2.setVerticalTextPosition(JLabel.TOP);
		lb2.setForeground(Color.white);
		lb2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb2.setBounds(90,120,700,100);
		lb2.setText("int temp=array[i];");
		
		lb3.setHorizontalTextPosition(JLabel.CENTER);
		lb3.setVerticalTextPosition(JLabel.TOP);
		lb3.setForeground(Color.white);
		lb3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb3.setBounds(90,140,700,100);
		lb3.setText("array[i]=array[j];");

		lb4.setHorizontalTextPosition(JLabel.CENTER);
		lb4.setVerticalTextPosition(JLabel.TOP);
		lb4.setForeground(Color.white);
		lb4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb4.setBounds(90,160,700,100);
		lb4.setText("array[j]=temp;");
		
		lb5.setHorizontalTextPosition(JLabel.CENTER);
		lb5.setVerticalTextPosition(JLabel.TOP);
		lb5.setForeground(Color.white);
		lb5.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb5.setBounds(60,200,700,100);
		lb5.setText("}");
		
		lb27.setHorizontalTextPosition(JLabel.CENTER);
		lb27.setVerticalTextPosition(JLabel.TOP);
		lb27.setBackground(Color.white);
		lb27.setForeground(new Color(255, 87, 34));
		lb27.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		lb27.setBounds(60,220,700,100);
		lb27.setText("//next function chooses pivot and sorts according to it");
		
		lb6.setHorizontalTextPosition(JLabel.CENTER);
		lb6.setVerticalTextPosition(JLabel.TOP);
		lb6.setForeground(Color.white);
		lb6.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb6.setBounds(60,240,700,100);
		lb6.setText("public static int partition(int[] array,int low,int high) {");
		
		lb7.setHorizontalTextPosition(JLabel.CENTER);
		lb7.setVerticalTextPosition(JLabel.TOP);
		lb7.setForeground(Color.white);
		lb7.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb7.setBounds(90,260,700,100);
		lb7.setText("int pivot=array[high];");
		
		lb8.setHorizontalTextPosition(JLabel.CENTER);
		lb8.setVerticalTextPosition(JLabel.TOP);
		lb8.setForeground(Color.white);
		lb8.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb8.setBounds(90,280,700,100);
		lb8.setText("int i=low-1;");
		
		lb9.setHorizontalTextPosition(JLabel.CENTER);
		lb9.setVerticalTextPosition(JLabel.TOP);
		lb9.setForeground(Color.white);
		lb9.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb9.setBounds(90,300,700,100);
		lb9.setText("for(int j=low;j<high;j++) {");
		
		lb10.setHorizontalTextPosition(JLabel.CENTER);
		lb10.setVerticalTextPosition(JLabel.TOP);
		lb10.setForeground(Color.white);
		lb10.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb10.setBounds(120,320,700,100);
		lb10.setText("if(array[j]<=pivot) {");
		
		lb11.setHorizontalTextPosition(JLabel.CENTER);
		lb11.setVerticalTextPosition(JLabel.TOP);
		lb11.setForeground(Color.white);
		lb11.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb11.setBounds(150,340,700,100);
		lb11.setText("i++;");
		
		lb12.setHorizontalTextPosition(JLabel.CENTER);
		lb12.setVerticalTextPosition(JLabel.TOP);
		lb12.setForeground(Color.white);
		lb12.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb12.setBounds(150,360,700,100);
		lb12.setText("swap(array,i,j);");
		
		lb13.setHorizontalTextPosition(JLabel.CENTER);
		lb13.setVerticalTextPosition(JLabel.TOP);
		lb13.setForeground(Color.white);
		lb13.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb13.setBounds(120,380,700,100);
		lb13.setText("}");
		
		lb14.setHorizontalTextPosition(JLabel.CENTER);
		lb14.setVerticalTextPosition(JLabel.TOP);
		lb14.setForeground(Color.white);
		lb14.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb14.setBounds(90,400,700,100);
		lb14.setText("}");
		
		lb15.setHorizontalTextPosition(JLabel.CENTER);
		lb15.setVerticalTextPosition(JLabel.TOP);
		lb15.setForeground(Color.white);
		lb15.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb15.setBounds(90,420,700,100);
		lb15.setText("swap(array,i+1,high);");
		
		lb16.setHorizontalTextPosition(JLabel.CENTER);
		lb16.setVerticalTextPosition(JLabel.TOP);
		lb16.setForeground(Color.white);
		lb16.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb16.setBounds(90,440,700,100);
		lb16.setText("return i+1;");
		
		lb17.setHorizontalTextPosition(JLabel.CENTER);
		lb17.setVerticalTextPosition(JLabel.TOP);
		lb17.setForeground(Color.white);
		lb17.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb17.setBounds(60,460,700,100);
		lb17.setText("}");
		
		lb26.setHorizontalTextPosition(JLabel.CENTER);
		lb26.setVerticalTextPosition(JLabel.TOP);
		lb26.setBackground(Color.white);
		lb26.setForeground(new Color(255, 87, 34));
		lb26.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		lb26.setBounds(60,480,700,100);
		lb26.setText("//next function implements quicksort by sorting according to partition");

		lb18.setHorizontalTextPosition(JLabel.CENTER);
		lb18.setVerticalTextPosition(JLabel.TOP);
		lb18.setForeground(Color.white);
		lb18.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb18.setBounds(60,500,700,100);
		lb18.setText("static void quick(int[] array, int low, int high) {");
		
		lb19.setHorizontalTextPosition(JLabel.CENTER);
		lb19.setVerticalTextPosition(JLabel.TOP);
		lb19.setForeground(Color.white);
		lb19.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb19.setBounds(90,520,700,100);
		lb19.setText("if (low<high) {");
		
		lb20.setHorizontalTextPosition(JLabel.CENTER);
		lb20.setVerticalTextPosition(JLabel.TOP);
		lb20.setForeground(Color.white);
		lb20.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb20.setBounds(120,540,700,100);
		lb20.setText("int pi=partition(array,low,high);");
		
		lb21.setHorizontalTextPosition(JLabel.CENTER);
		lb21.setVerticalTextPosition(JLabel.TOP);
		lb21.setForeground(Color.white);
		lb21.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb21.setBounds(120,560,700,100);
		lb21.setText("quick(array,low,pi-1);");
		
		lb22.setHorizontalTextPosition(JLabel.CENTER);
		lb22.setVerticalTextPosition(JLabel.TOP);
		lb22.setForeground(Color.white);
		lb22.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb22.setBounds(120,580,700,100);
		lb22.setText("quick(array,pi+1,high);");
		
		lb23.setHorizontalTextPosition(JLabel.CENTER);
		lb23.setVerticalTextPosition(JLabel.TOP);
		lb23.setForeground(Color.white);
		lb23.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb23.setBounds(90,600,700,100);
		lb23.setText("}");
		
		lb24.setHorizontalTextPosition(JLabel.CENTER);
		lb24.setVerticalTextPosition(JLabel.TOP);
		lb24.setForeground(Color.white);
		lb24.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb24.setBounds(60,620,700,100);
		lb24.setText("}");
		
		lb29.setHorizontalTextPosition(JLabel.CENTER);
		lb29.setVerticalTextPosition(JLabel.TOP);
		lb29.setForeground(Color.white);
		lb29.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lb29.setBounds(10,640,700,100);
		lb29.setText("}");
	
		
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
		panel.add(lb15);	
		panel.add(lb16);	
		panel.add(lb17);	
		panel.add(lb18);	
		panel.add(lb19);	
		panel.add(lb20);	
		panel.add(lb21);	
		panel.add(lb22);	
		panel.add(lb23);	
		panel.add(lb24);	
		panel.add(lb25);
		panel.add(lb26);		
		panel.add(lb27);		
		panel.add(lb28);	
		panel.add(lb29);	
		  JScrollPane pane = new JScrollPane(panel);		
			this.setContentPane(pane);

		this.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		//When the user clicks on this button,the current window is disposed and a new Quick Sort window is displayed
		if (e.getSource()==back) {
			new QuickSort();
			this.dispose();
		}
	}
}