import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class BucketDemo extends JFrame  implements ActionListener{

	
	JPanel panel; //initialize panel and labels
	JLabel number37;
	JLabel number54;
	JLabel number23;
	JLabel number12;
	JLabel number44;
	JLabel number10;
	JLabel number57;
	JLabel number17;
	JLabel number26;
	JLabel number28;
	JLabel number0;
	JLabel number1;
	JLabel number2;
	JLabel number3;
	JLabel number4;
	JLabel number5;
	JLabel number6;
	JLabel number7;
	JLabel number8;
	JLabel number9;

	JButton back; //initialize back button
	JButton[] buttons; //initialize array of buttons
	JLabel[] labels; //initialize array of labels
	Border border= BorderFactory.createRaisedSoftBevelBorder();

public BucketDemo() {
	
	this.setLayout(null);

	this.setTitle("Sorting Algorithms");
	this.setSize(750,700);
	this.setLocation(330,0);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	this.setResizable(false);
	this.setBackground(new Color(255, 255, 255));

	panel = new JPanel();
	JLabel label= new JLabel();
	JPanel shadow= new JPanel();
	this.add(panel);
    JScrollPane pane = new JScrollPane(panel);

	number37 = new JLabel();
	number54= new JLabel();
	number23= new JLabel();
	number12= new JLabel();
	number44= new JLabel();
	number10= new JLabel();
	number57= new JLabel();
	number17= new JLabel();
	number26= new JLabel();
	number28= new JLabel();
	number0= new JLabel();
	number1= new JLabel();
	number2= new JLabel();
	number3= new JLabel();
	number4= new JLabel();
	number5= new JLabel();
	number6= new JLabel();
	number7= new JLabel();
	number8= new JLabel();
	number9= new JLabel();

	labels= new JLabel[30];
	buttons= new JButton[8];

	panel.setBounds(0, 0, 750, 1000);
	panel.setPreferredSize(new Dimension(750, 3000));
	panel.setBackground(new Color(48, 56, 65));
	panel.setLayout(null);
	
	//set shadow for BucketDemo label
	shadow.setBounds(251, 24, 240, 60);
	shadow.setBackground(new Color(35,35,35));
	
	//set characteristics of title label
	label.setText("  Bucket Sort Demo");
	label.setHorizontalTextPosition(JLabel.CENTER);
	label.setVerticalTextPosition(JLabel.TOP);
	label.setForeground(Color.white);
	label.setFont(new Font("Century Gothic", Font.BOLD, 24));
	label.setIconTextGap(20);
	label.setBackground(new Color(0, 173, 181));
	label.setOpaque(true);
	label.setBounds(247, 20, 240,60 );

	//set the common characteristics for all labels
	for ( int i=0; i < labels.length; i++) {
		labels[i]= new JLabel();
		labels[i].setHorizontalTextPosition(JLabel.CENTER);
		labels[i].setVerticalTextPosition(JLabel.TOP);
		labels[i].setForeground(Color.white);
		labels[i].setFont(new Font("Century Gothic", Font.BOLD, 16));
		labels[i].setIconTextGap(20);
	}
	
	//set the common characteristics for all buttons
	for ( int i=1; i<buttons.length;i++) {
		buttons[i]= new JButton();
		buttons[i].setLayout(null);
		buttons[i].setBackground(new Color(0, 173, 181));
		buttons[i].setText("Step "+ i);
		buttons[i].setForeground(Color.white);
		buttons[i].setFont(new Font("Century Gothic",Font.BOLD , 20));
		buttons[i].setIconTextGap(0);
		buttons[i].setFocusable(false);
		buttons[i].setBorder(border);
		buttons[i].addActionListener(this);	
	}
	
	buttons[1].setBounds(310, 280, 100, 60);
	panel.add(buttons[1]); //add first button
	back= new JButton(); //add back button
	    
	//set characteristics for back button
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
	
	//set characteristics of the numbers
	number37.setText("  37");
	number37.setHorizontalTextPosition(JLabel.CENTER);
	number37.setVerticalTextPosition(JLabel.CENTER);
	number37.setForeground(new Color(255, 87, 34));
	number37.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number37.setIconTextGap(20);
	number37.setBackground(Color.white);
	number37.setOpaque(true);
	number37.setBounds(30, 160, 60,60 );
	number37.setBorder(border);	
	
	number54.setText("  54");
	number54.setHorizontalTextPosition(JLabel.CENTER);
	number54.setVerticalTextPosition(JLabel.CENTER);
	number54.setForeground(new Color(255, 87, 34));
	number54.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number54.setIconTextGap(20);
	number54.setBackground(Color.white);
	number54.setOpaque(true);
	number54.setBounds(100, 160, 60,60 ); 
	number54.setBorder(border);
	
	number23.setText("  23");
	number23.setHorizontalTextPosition(JLabel.CENTER);
	number23.setVerticalTextPosition(JLabel.CENTER);
	number23.setForeground(new Color(255, 87, 34));
	number23.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number23.setIconTextGap(20);
	number23.setBackground(Color.white);
	number23.setOpaque(true);
	number23.setBounds(170, 160, 60,60 );
	number23.setBorder(border);

	number12.setText("  12");
	number12.setHorizontalTextPosition(JLabel.CENTER);
	number12.setVerticalTextPosition(JLabel.CENTER);
	number12.setForeground(new Color(255, 87, 34));
	number12.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number12.setIconTextGap(20);
	number12.setBackground(Color.white);
	number12.setOpaque(true);
	number12.setBounds(240, 160, 60,60 );
	number12.setBorder(border);
	
	number44.setText("  44");
	number44.setHorizontalTextPosition(JLabel.CENTER);
	number44.setVerticalTextPosition(JLabel.CENTER);
	number44.setForeground(new Color(255, 87, 34));
	number44.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number44.setIconTextGap(20);
	number44.setBackground(Color.white);
	number44.setOpaque(true);
	number44.setBounds(310, 160, 60,60 );
	number44.setBorder(border);
	
	number10.setText("  10");
	number10.setHorizontalTextPosition(JLabel.CENTER);
	number10.setVerticalTextPosition(JLabel.CENTER);
	number10.setForeground(new Color(255, 87, 34));
	number10.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number10.setIconTextGap(20);
	number10.setBackground(Color.white);
	number10.setOpaque(true);
	number10.setBounds(380, 160, 60,60 );
	number10.setBorder(border);

	number57.setText("  57");
	number57.setHorizontalTextPosition(JLabel.CENTER);
	number57.setVerticalTextPosition(JLabel.CENTER);
	number57.setForeground(new Color(255, 87, 34));
	number57.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number57.setIconTextGap(20);
	number57.setBackground(Color.white);
	number57.setOpaque(true);
	number57.setBounds(450, 160, 60,60 );
	number57.setBorder(border);
	
	number17.setText("  17");
	number17.setHorizontalTextPosition(JLabel.CENTER);
	number17.setVerticalTextPosition(JLabel.CENTER);
	number17.setForeground(new Color(255, 87, 34));
	number17.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number17.setIconTextGap(20);
	number17.setBackground(Color.white);
	number17.setOpaque(true);
	number17.setBounds(520, 160, 60,60 );
	number17.setBorder(border);
	
	number28.setText("  28");
	number28.setHorizontalTextPosition(JLabel.CENTER);
	number28.setVerticalTextPosition(JLabel.CENTER);
	number28.setForeground(new Color(255, 87, 34));
	number28.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number28.setIconTextGap(20);
	number28.setBackground(Color.white);
	number28.setOpaque(true);
	number28.setBounds(590, 160, 60,60 );
	number28.setBorder(border);
	
	number26.setText("  26");
	number26.setHorizontalTextPosition(JLabel.CENTER);
	number26.setVerticalTextPosition(JLabel.CENTER);
	number26.setForeground(new Color(255, 87, 34));
	number26.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number26.setIconTextGap(20);
	number26.setBackground(Color.white);
	number26.setOpaque(true);
	number26.setBounds(660, 160, 60,60 );
	number26.setBorder(border);
	this.setContentPane(pane);

	//add back button and labels
	panel.add(back);
	panel.add(label);
	panel.add(shadow);
	panel.add(number37);
	panel.add(number54);
	panel.add(number23);
	panel.add(number12);
	panel.add(number44);
	panel.add(number10);
	panel.add(number57);
	panel.add(number17);
	panel.add(number26);
	panel.add(number28);

	this.setVisible(true);
}

// this function runs our demo
public void actionPerformed(ActionEvent e) {
	//go back and dispose current window if "back" button is pressed
	if (e.getSource()==back) {
		new BucketSort();
		this.dispose();
	}
	
	//after pressing the first button, do the following
	if ( e.getSource()==buttons[1]) {
		panel.add(labels[2]); //add all labels and the next button
		panel.add(labels[3]);
		panel.add(labels[4]);
		panel.add(labels[5]);
		panel.add(labels[6]);
		panel.add(labels[7]);
		panel.add(labels[8]);
		panel.add(labels[9]);
		panel.add(labels[10]);
		panel.add(labels[11]);
		panel.add(labels[12]);
		panel.add(labels[13]);
		panel.add(buttons[2]);

		labels[2].setText("We remove each number from the list and divide it by 10,then put it in a suitable bucket");
		labels[2].setBounds(50,330,700,60);
		
		labels[3].setText("|0 - 9|10 - 19|20 - 29|30 - 39|40 - 49|50 - 59|60 - 69|");
		labels[3].setBounds(120,350,700,60);
		
		labels[4].setText("12");
		labels[4].setBounds(190,370,700,60);

		labels[5].setText("23");
		labels[5].setBounds(250,370,700,60);
		
		labels[6].setText("10");
		labels[6].setBounds(190,390,700,60);
		
		labels[7].setText("17");
		labels[7].setBounds(190,410,700,60);
		
		labels[8].setText("28");
		labels[8].setBounds(250,390,700,60);
		
		labels[9].setText("26");
		labels[9].setBounds(250,410,700,60);
		
		labels[10].setText("37");
		labels[10].setBounds(310,370,700,60);
		
		labels[11].setText("44");
		labels[11].setBounds(370,370,700,60);
		
		labels[12].setText("54");
		labels[12].setBounds(430,370,700,60);
		
		labels[13].setText("57");
		labels[13].setBounds(430,390,700,60);
		
		buttons[2].setBounds(310,480,100,60); //set the bounds of the new button
	}
	
	if (e.getSource()==buttons[2]) {
		panel.add(labels[14]);
		panel.add(labels[15]);
		panel.add(labels[16]);
		panel.add(labels[17]);
		panel.add(labels[18]);
		panel.add(labels[19]);
		panel.add(labels[20]);
		panel.add(labels[21]);
		panel.add(labels[22]);
		panel.add(labels[23]);
		panel.add(labels[24]);
		panel.add(labels[25]);
		panel.add(buttons[3]);

		labels[14].setText("We sort the numbers in each bucket using one of the sorting algorithms");
		labels[14].setBounds(50,540,700,60);
		labels[15].setText("|0 - 9|10 - 19|20 - 29|30 - 39|40 - 49|50 - 59|60 - 69|");
		labels[15].setBounds(120,560,700,60);
		
		labels[16].setText("10");
		labels[16].setBounds(190,580,700,60);

		labels[17].setText("23");
		labels[17].setBounds(250,580,700,60);
		
		labels[18].setText("12");
		labels[18].setBounds(190,600,700,60);
		
		labels[19].setText("17");
		labels[19].setBounds(190,620,700,60);
		
		labels[20].setText("26");
		labels[20].setBounds(250,600,700,60);
		
		labels[21].setText("28");
		labels[21].setBounds(250,620,700,60);
		
		labels[22].setText("37");
		labels[22].setBounds(310,580,700,60);
		
		labels[23].setText("44");
		labels[23].setBounds(370,580,700,60);
		
		labels[24].setText("54");
		labels[24].setBounds(430,580,700,60);
		
		labels[25].setText("57");
		labels[25].setBounds(430,600,700,60);
		
		buttons[3].setBounds(310,690,100,60);
	}
	
		if (e.getSource()==buttons[3]) {
			panel.add(labels[26]);
			panel.add(labels[27]);
			panel.add(number0);
			panel.add(number1);
			panel.add(number2);
			panel.add(number3);
			panel.add(number4);
			panel.add(number5);
			panel.add(number6);
			panel.add(number7);
			panel.add(number8);
			panel.add(number9);

			labels[26].setText("We then remove the numbers from the buckets, one by one, and add them to a list");
			labels[26].setBounds(50,730,700,60);
			labels[27].setText("List is sorted");
			labels[27].setBounds(310,750,700,60);

			number0.setText("  10");
			number0.setHorizontalTextPosition(JLabel.CENTER);
			number0.setVerticalTextPosition(JLabel.CENTER);
			number0.setForeground(new Color(255, 87, 34));
			number0.setFont(new Font("Century Gothic", Font.BOLD, 25));
			number0.setIconTextGap(20);
			number0.setBackground(Color.white);
			number0.setOpaque(true);
			number0.setBounds(30, 800, 60,60 );
			number0.setBorder(border);
			number0.setForeground(Color.white);
			number0.setBackground(new Color(255, 87, 34));
			
			number1.setText("  12");
			number1.setHorizontalTextPosition(JLabel.CENTER);
			number1.setVerticalTextPosition(JLabel.CENTER);
			number1.setForeground(new Color(255, 87, 34));
			number1.setFont(new Font("Century Gothic", Font.BOLD, 25));
			number1.setIconTextGap(20);
			number1.setBackground(Color.white);
			number1.setOpaque(true);
			number1.setBounds(100, 800, 60,60 );
			number1.setBorder(border);
			number1.setForeground(Color.white);
			number1.setBackground(new Color(255, 87, 34));
			
			number2.setText("  17");
			number2.setHorizontalTextPosition(JLabel.CENTER);
			number2.setVerticalTextPosition(JLabel.CENTER);
			number2.setForeground(new Color(255, 87, 34));
			number2.setFont(new Font("Century Gothic", Font.BOLD, 25));
			number2.setIconTextGap(20);
			number2.setBackground(Color.white);
			number2.setOpaque(true);
			number2.setBounds(170, 800, 60,60 );
			number2.setBorder(border);
			number2.setForeground(Color.white);
			number2.setBackground(new Color(255, 87, 34));
			
			number3.setText("  23");
			number3.setHorizontalTextPosition(JLabel.CENTER);
			number3.setVerticalTextPosition(JLabel.CENTER);
			number3.setForeground(new Color(255, 87, 34));
			number3.setFont(new Font("Century Gothic", Font.BOLD, 25));
			number3.setIconTextGap(20);
			number3.setBackground(Color.white);
			number3.setOpaque(true);
			number3.setBounds(240, 800, 60,60 );
			number3.setBorder(border);
			number3.setForeground(Color.white);
			number3.setBackground(new Color(255, 87, 34));
			
			number4.setText("  26");
			number4.setHorizontalTextPosition(JLabel.CENTER);
			number4.setVerticalTextPosition(JLabel.CENTER);
			number4.setForeground(new Color(255, 87, 34));
			number4.setFont(new Font("Century Gothic", Font.BOLD, 25));
			number4.setIconTextGap(20);
			number4.setBackground(Color.white);
			number4.setOpaque(true);
			number4.setBounds(310, 800, 60,60 );
			number4.setBorder(border);
			number4.setForeground(Color.white);
			number4.setBackground(new Color(255, 87, 34));
			
			number5.setText("  28");
			number5.setHorizontalTextPosition(JLabel.CENTER);
			number5.setVerticalTextPosition(JLabel.CENTER);
			number5.setForeground(new Color(255, 87, 34));
			number5.setFont(new Font("Century Gothic", Font.BOLD, 25));
			number5.setIconTextGap(20);
			number5.setBackground(Color.white);
			number5.setOpaque(true);
			number5.setBounds(380, 800, 60,60 );
			number5.setBorder(border);
			number5.setForeground(Color.white);
			number5.setBackground(new Color(255, 87, 34));
			
			number6.setText("  37");
			number6.setHorizontalTextPosition(JLabel.CENTER);
			number6.setVerticalTextPosition(JLabel.CENTER);
			number6.setForeground(new Color(255, 87, 34));
			number6.setFont(new Font("Century Gothic", Font.BOLD, 25));
			number6.setIconTextGap(20);
			number6.setBackground(Color.white);
			number6.setOpaque(true);
			number6.setBounds(450, 800, 60,60 );
			number6.setBorder(border);
			number6.setForeground(Color.white);
			number6.setBackground(new Color(255, 87, 34));
			
			number7.setText("  44");
			number7.setHorizontalTextPosition(JLabel.CENTER);
			number7.setVerticalTextPosition(JLabel.CENTER);
			number7.setForeground(new Color(255, 87, 34));
			number7.setFont(new Font("Century Gothic", Font.BOLD, 25));
			number7.setIconTextGap(20);
			number7.setBackground(Color.white);
			number7.setOpaque(true);
			number7.setBounds(520, 800, 60,60 );
			number7.setBorder(border);
			number7.setForeground(Color.white);
			number7.setBackground(new Color(255, 87, 34));
			
			number8.setText("  54");
			number8.setHorizontalTextPosition(JLabel.CENTER);
			number8.setVerticalTextPosition(JLabel.CENTER);
			number8.setForeground(new Color(255, 87, 34));
			number8.setFont(new Font("Century Gothic", Font.BOLD, 25));
			number8.setIconTextGap(20);
			number8.setBackground(Color.white);
			number8.setOpaque(true);
			number8.setBounds(590, 800, 60,60 );
			number8.setBorder(border);
			number8.setForeground(Color.white);
			number8.setBackground(new Color(255, 87, 34));
			
			number9.setText("  57");
			number9.setHorizontalTextPosition(JLabel.CENTER);
			number9.setVerticalTextPosition(JLabel.CENTER);
			number9.setForeground(new Color(255, 87, 34));
			number9.setFont(new Font("Century Gothic", Font.BOLD, 25));
			number9.setIconTextGap(20);
			number9.setBackground(Color.white);
			number9.setOpaque(true);
			number9.setBounds(660, 800, 60,60 );
			number9.setBorder(border);
			number9.setForeground(Color.white);
			number9.setBackground(new Color(255, 87, 34));
		}
   	}
 }