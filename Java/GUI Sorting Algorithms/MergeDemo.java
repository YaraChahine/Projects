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
/**
 * This class extends JFrame , it presents a demo on how merge sort works
 * 
 * @author ali&yara
 *
 */
public class MergeDemo extends JFrame  implements ActionListener{

	//Components to be used
	JPanel panel;
	JLabel number3;
	JLabel number5;
	JLabel number2;
	JLabel number1;
	JLabel number4;
	JLabel number0;
	JButton back;
	JLabel[] numbers;
	JButton[] buttons;
	JLabel[] labels;

public MergeDemo() {
	Border border= BorderFactory.createRaisedSoftBevelBorder();
	
	
	//our main frame
	this.setLayout(null);
	this.setTitle("Sorting Algorithms");
	this.setSize(750,700);
	this.setLocation(330,0);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	this.setResizable(false);
	this.setBackground(new Color(255, 255, 255));

	
	
	
	
	//We initialize our components
	panel = new JPanel();
	JLabel label= new JLabel();
	JPanel shadow= new JPanel();

	number3= new JLabel();
	number5= new JLabel();
	number2= new JLabel();
	number4= new JLabel();
	number1= new JLabel();
	number0= new JLabel();

	 labels= new JLabel[10];
	numbers = new JLabel[37];
	buttons= new JButton[8];


	
	
	//our panel on which all JComponents will be added
	panel.setBounds(0, 0, 750, 1000);
	panel.setPreferredSize(new Dimension(750, 3000));
	panel.setBackground(new Color(48, 56, 65));
	panel.setLayout(null);
	this.add(panel);
 	
	
	//Shadow to be put behind   Tite label
	shadow.setBounds(251, 24, 240, 60);
	shadow.setBackground(new Color(35,35,35));
	
	
	
	//Title Label
	label.setText("  Merge Sort Demo");
	label.setHorizontalTextPosition(JLabel.CENTER);
	label.setVerticalTextPosition(JLabel.TOP);
	label.setForeground(Color.white);
	label.setFont(new Font("Century Gothic", Font.BOLD, 24));
	label.setIconTextGap(20);
	label.setBackground(new Color(0, 173, 181));
	label.setOpaque(true);
	label.setBounds(247, 20, 240,60 );

	
	
	
	//We are using many labels in this demo, that is why we created a JLabel array
	//in the following we are looping across the array and setting the common specifications
	//that are the same in all our labels
	for ( int i=0; i < labels.length; i++) {
		labels[i]= new JLabel();
		labels[i].setHorizontalTextPosition(JLabel.CENTER);
		labels[i].setVerticalTextPosition(JLabel.TOP);
		labels[i].setForeground(Color.white);
		labels[i].setFont(new Font("Century Gothic", Font.BOLD, 16));
		labels[i].setIconTextGap(20);
	}
	
	
	
	
	//The following two labels specify the left and right indices
	labels[0].setText("Left Index L= 0");	
	labels[0].setBounds(60,160,100,60);
	labels[0].setFont(new Font("Century Gothic", Font.BOLD, 12));
	labels[1].setFont(new Font("Century Gothic", Font.BOLD, 12));

	labels[1].setText("Right Index R= 5");
	labels[1].setBounds(580,160,100,60);
	panel.add(labels[0]);
	panel.add(labels[1]);
	
	
	
	
	//In this demo we are also using numerous buttons 
	//so we initialize them in the following for loop and set the common features that are shared
	//between them
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
	
	
	//We add our first button since we want it to be visible upon entering the demo
	buttons[1].setBounds(310, 280, 100, 60);
	panel.add(buttons[1]);
	
	
	
		//our "back" button, if the user clicks it
	//current window is disposed and a new MergeSort window is displayed
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
	
		
		
		//We also have numerous numbers since we will be creating subarrays to explain the merge sort
		//so we loop across ou r numbers array and set the common features and specifications shared between them
	for (int i=0; i<numbers.length; i++) {
		numbers[i]= new JLabel();
		numbers[i].setHorizontalTextPosition(JLabel.CENTER);
		numbers[i].setVerticalTextPosition(JLabel.CENTER);
		numbers[i].setForeground(new Color(255, 87, 34));
		numbers[i].setFont(new Font("Century Gothic", Font.BOLD, 25));
		numbers[i].setIconTextGap(20);
		numbers[i].setBackground(Color.white);
		numbers[i].setOpaque(true);
		numbers[i].setBorder(border);
	}
	
	

	
	// in the following , we specify the numbers appearing on the labels upon entry to the demo
	number3.setText("   3");
	number3.setHorizontalTextPosition(JLabel.CENTER);
	number3.setVerticalTextPosition(JLabel.CENTER);
	number3.setForeground(new Color(255, 87, 34));
	number3.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number3.setIconTextGap(20);
	number3.setBackground(Color.white);
	number3.setOpaque(true);
	number3.setBounds(160, 160, 60,60 );
	number3.setBorder(border);
	
	
	number5.setText("   5");
	number5.setHorizontalTextPosition(JLabel.CENTER);
	number5.setVerticalTextPosition(JLabel.CENTER);
	number5.setForeground(new Color(255, 87, 34));
	number5.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number5.setIconTextGap(20);
	number5.setBackground(Color.white);
	number5.setOpaque(true);
	number5.setBounds(230, 160, 60,60 ); 
	number5.setBorder(border);
	

	
	number2.setText("   2");
	number2.setHorizontalTextPosition(JLabel.CENTER);
	number2.setVerticalTextPosition(JLabel.CENTER);
	number2.setForeground(new Color(255, 87, 34));
	number2.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number2.setIconTextGap(20);
	number2.setBackground(Color.white);
	number2.setOpaque(true);
	number2.setBounds(300, 160, 60,60 );
	number2.setBorder(border);

	
	
	number4.setText("   4");
	number4.setHorizontalTextPosition(JLabel.CENTER);
	number4.setVerticalTextPosition(JLabel.CENTER);
	number4.setForeground(new Color(255, 87, 34));
	number4.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number4.setIconTextGap(20);
	number4.setBackground(Color.white);
	number4.setOpaque(true);
	number4.setBounds(370, 160, 60,60 );
	number4.setBorder(border);

	
	
	number1.setText("   1");
	number1.setHorizontalTextPosition(JLabel.CENTER);
	number1.setVerticalTextPosition(JLabel.CENTER);
	number1.setForeground(new Color(255, 87, 34));
	number1.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number1.setIconTextGap(20);
	number1.setBackground(Color.white);
	number1.setOpaque(true);
	number1.setBounds(440, 160, 60,60 );
	number1.setBorder(border);
	
	
	
	number0.setText("   0");
	number0.setHorizontalTextPosition(JLabel.CENTER);
	number0.setVerticalTextPosition(JLabel.CENTER);
	number0.setForeground(new Color(255, 87, 34));
	number0.setFont(new Font("Century Gothic", Font.BOLD, 25));
	number0.setIconTextGap(20);
	number0.setBackground(Color.white);
	number0.setOpaque(true);
	number0.setBounds(510, 160, 60,60 );
	number0.setBorder(border);

    JScrollPane pane = new JScrollPane(panel);

	this.setContentPane(pane);

	
	//We add the remaining components
	panel.add(back);
	panel.add(label);
	panel.add(shadow);
	panel.add(number3);
	panel.add(number5);
	panel.add(number2);
	panel.add(number4);
	panel.add(number1);
	panel.add(number0);

	this.setVisible(true);
	


}

@Override
 public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource()==back) {
		new MergeSort();
		this.dispose();
	}
	
	
	
	//the following demo is not timer based, but rather button based.
	//Whenever a user click on "Step 1", "Step 2" , etc... , new steps are shown
	//demonstrating how the arrays are being partitioned and sorted
	if ( e.getSource()==buttons[1]) {

		
	panel.add(labels[2]);
	panel.add(labels[3]);
	panel.add(labels[4]);
	panel.add(labels[5]);
	panel.add(numbers[0]);
	panel.add(numbers[1]);
	panel.add(numbers[2]);
	panel.add(numbers[3]);
	panel.add(numbers[4]);
	panel.add(numbers[5]);
	panel.add(buttons[2]);
	
	
		
		labels[2].setText("If L < R");
		labels[2].setBounds(320,330,100,60);
		
		labels[3].setText("We get the middle : M = ( L+ R ) /2");
		labels[3].setBounds(240,350,400,60);
		
		labels[4].setText("We divide the array into two arrays, one from L to M, out from M to R");
		labels[4].setBounds(120,370,600,60);

		labels[5].setText("We keep doing the above until L >= R");
		labels[5].setBounds(240,390,400,60);
		
		
		numbers[0].setText("   3");
		numbers[0].setBounds(80,470,60,60);
		numbers[1].setText("   5");
		numbers[1].setBounds(150,470,60,60);
		numbers[2].setText("   2");	
		numbers[2].setBounds(220,470,60,60);

		numbers[3].setText("   4");
		numbers[3].setBounds(440,470,60,60);
		numbers[4].setText("   1");
		numbers[4].setBounds(510,470,60,60);
		numbers[5].setText("   0");
		numbers[5].setBounds(580,470,60,60);
		
		buttons[2].setBounds(310,600,100,60);
		
	
	}
	
	
	if (e.getSource()==buttons[2]) {
		panel.add(labels[6]);
		for ( int i=6; i<=11; i++) {
		panel.add(numbers[i]);
		}
		panel.add(buttons[3]);
		labels[6].setText("We do same the same as step 1");
		labels[6].setBounds(250 ,680 ,400,60);	
		numbers[6].setText("   3");
		numbers[6].setBounds(30,765,60,60);
		numbers[7].setText("   5");
		numbers[7].setBounds(100,765,60,60);
		numbers[8].setText("   2");	
		numbers[8].setBounds(220,765,60,60);

		numbers[9].setText("   4");
		numbers[9].setBounds(440,765,60,60);
		numbers[10].setText("   1");
		numbers[10].setBounds(510,765,60,60);
		numbers[11].setText("   0");
		numbers[11].setBounds(630,765,60,60);
		
		buttons[3].setBounds(310,885,100,60);	
		
	}
	
	
	
	if (e.getSource()==buttons[3]) {
		for ( int i=12; i<=17; i++) {
		panel.add(numbers[i]);
		}
		panel.add(buttons[4]);
		numbers[12].setText("   3");
		numbers[12].setBounds(30,1010,60,60);
		numbers[13].setText("   5");
		numbers[13].setBounds(150,1010,60,60);
		numbers[14].setText("   2");
		numbers[14].setBounds(270,1010,60,60);
		numbers[15].setText("   4");
		numbers[15].setBounds(390,1010,60,60);
		numbers[16].setText("   1");
		numbers[16].setBounds(510,1010,60,60);
		numbers[17].setText("   0");
		numbers[17].setBounds(630,1010,60,60);
		buttons[4].setBounds(310,1130,100,60);	
		

	}
	
	
	

	if (e.getSource()==buttons[4]) {
		panel.add(labels[7]);
		panel.add(labels[8]);		
		for ( int i=18; i<=23; i++) {
		panel.add(numbers[i]);
		}
		panel.add(buttons[5]);
		labels[7].setText("After dividing the array into smallest units (L=R), ");
		labels[7].setBounds(200 ,1210 ,500,60);	
		labels[8].setText("merging starts based on elements comparison");
		labels[8].setBounds(200 ,1230 ,710,60);	
		numbers[18].setText("   3");
		numbers[18].setBounds(30,1310,60,60);
		numbers[19].setText("   5");
		numbers[19].setBounds(100,1310,60,60);
		numbers[20].setText("   2");	
		numbers[20].setBounds(220,1310,60,60);

		numbers[21].setText("   1");
		numbers[21].setBounds(440,1310,60,60);
		numbers[22].setText("   4");
		numbers[22].setBounds(510,1310,60,60);
		numbers[23].setText("   0");
		numbers[23].setBounds(630,1310,60,60);
		
		buttons[5].setBounds(310,1430,100,60);	
		
	}
	
	
	
	if ( e.getSource()==buttons[5]) {

		for ( int i=24; i<=29; i++) {
			panel.add(numbers[i]);
		}
		panel.add(buttons[6]);
		numbers[24].setText("   2");
		numbers[24].setBounds(80,1560,60,60);
		numbers[25].setText("   3");
		numbers[25].setBounds(150,1560,60,60);
		numbers[26].setText("   5");	
		numbers[26].setBounds(220,1560,60,60);

		numbers[27].setText("   0");
		numbers[27].setBounds(440,1560,60,60);
		numbers[28].setText("   1");
		numbers[28].setBounds(510,1560,60,60);
		numbers[29].setText("   4");
		numbers[29].setBounds(580,1560,60,60);
		
		buttons[6].setBounds(310,1690,100,60);
		
	
	}
	
	
	if(e.getSource()==buttons[6]) {
		for ( int i=30; i<=35; i++) {
			numbers[i].setForeground(Color.white);
			numbers[i].setBackground(new Color(255, 87, 34));
			panel.add(numbers[i]);
		}
		numbers[30].setText("   0");
		numbers[30].setBounds(160,1820,60,60);
		numbers[31].setText("   1");
		numbers[31].setBounds(230,1820,60,60);
		numbers[32].setText("   2");	
		numbers[32].setBounds(300,1820,60,60);

		numbers[33].setText("   3");
		numbers[33].setBounds(370,1820,60,60);
		numbers[34].setText("   4");
		numbers[34].setBounds(440,1820,60,60);
		numbers[35].setText("   5");
		numbers[35].setBounds(510,1820,60,60);
		
		
	}
	
	

 }
 }