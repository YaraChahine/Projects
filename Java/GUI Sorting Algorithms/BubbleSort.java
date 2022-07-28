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
import javax.swing.border.Border;


/** 
 * <html><p>This the "BubbleSort" class, it extends JFrame. It contains a new window on which
 * the main BubbleSort frame is displayed.</p> 
 * <p>This window displays  three options:</p>
 * The Algorithm for Bubble Sort</br>
 * The Demo for Bubble Sort 
 * <br>The Code for Bubble Sort </br>
 * 
 * 
 * 
 * @author Ali&Yara
 *</html>
 */
public class BubbleSort extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//We initialize our three buttons outside the constructor 
	//So that theActionPerformed method can recognize them
	JButton button2;
	JButton button1;
	JButton button3;

	BubbleSort(){
		

		Border border= BorderFactory.createRaisedSoftBevelBorder();

		
		//The below is our main frame, with a null Layout
		this.setLayout(null);
		this.setTitle("Sorting Algorithms");
		this.setSize(550,650);
		this.setLocation(375,60);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		this.setResizable(false);
		this.setBackground(new Color(255, 255, 255));

		
		//Below are our JComponent used in this frame
		JPanel panel= new JPanel();
		JPanel shadow = new JPanel();
		JPanel shadow2 = new JPanel();
		JPanel shadow3 = new JPanel();
		JPanel shadow4 = new JPanel();
		JPanel line= new JPanel();
		JPanel line2= new JPanel();
		JPanel line3= new JPanel();
		JPanel line4= new JPanel();
		JLabel label= new JLabel();


		button1= new JButton();
		button2= new JButton();
		button3= new JButton();

		//this is our panel on which we add all of the other components
		panel.setBounds(0, 0, 700, 700);
		panel.setBackground(new Color(48, 56, 65));
		panel.setLayout(null);
		this.add(panel);

		
		
		
		
		
		//These lines are decorative.
		//They are set on the extreme bounds of our frame
		//to distinguish between the current frame and the main one
		//since the main one will stay open
		//That's why we gave these lines a distinct orange color
		line.setBounds(0,0,5,650);
		line.setBackground(new Color(255, 87, 34));
		line.setLayout(null);
		panel.add(line);
		
		
		line2.setBounds(0,0,650,5);	
		line2.setBackground(new Color(255, 87, 34));
		line2.setLayout(null);
		panel.add(line2);
	
		line3.setBounds(0,606,550,5);
		line3.setBackground(new Color(255, 87,34));
		line3.setLayout(null);
		panel.add(line3);

		line4.setBounds(529,0,7,650);
		line4.setBackground(new Color(255, 87, 34));
		line4.setLayout(null);
		panel.add(line4);
		

		
		
		//This label is our title, its specifications
		//are similar to the main title's in our main frame.
		label.setText("      Bubble Sort ");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("Century Gothic", Font.BOLD, 30));
		label.setIconTextGap(20);
		label.setBackground(new Color(0, 173, 181));
		label.setOpaque(true);
		label.setBounds(150, 40, 250,70 );
		panel.add(label);

		

		
		//Our first button leads to the "BubbleAlgorithm" window
		//Just like the other buttons, we start by specifying its bounds
		//Then we set its background color, text, text position, text font, text color
		//border, and then we add the action listener.
		button1.setBounds(155, 220, 230, 50);
		button1.setBackground(new Color(255, 255, 255));
		button1.setText(" Algorithm ");
		button1.setHorizontalTextPosition(JButton.CENTER);
		button1.setFocusable(false);
		button1.setFont(new Font("Century Gothic", Font.BOLD,22));
		button1.setForeground(new Color(255, 87, 34));
		button1.setBorder(border);
		button1.addActionListener(this);
		panel.add(button1);


		   
		
		//Our second button leads to the "BubbleDemo" window
		button2.setBounds(155,325,230,50);
		button2.setBackground(new Color(255,255,255));
		button2.setText(" Demo ");
		button2.setHorizontalTextPosition(JButton.CENTER);
		button2.setFocusable(false);
		button2.setFont(new Font("Century Gothic", Font.BOLD,22));
		button2.setForeground(new Color(0, 173, 181));
		button2.setBorder(border);
		button2.addActionListener(this);
		panel.add(button2);
		
		
		
		//Our third button leads to "BubbleCode" window
		button3.setBounds(155,430,230,50);
		button3.setBackground(new Color(255,255,255));
		button3.setText(" Code ");
		button3.setHorizontalTextPosition(JButton.CENTER);
		button3.setFocusable(false);
		button3.setFont(new Font("Century Gothic", Font.BOLD,22));
		button3.setForeground(new Color(48, 56, 65));
		button3.setBorder(border);
		button3.addActionListener(this);		
		panel.add(button3);

		
		
		
		//The below are shadows that we add under labels and buttons
				//to give the components a raised and non-flat look
				shadow.setBounds(158, 222, 230, 52);
				shadow.setBackground(new Color(35,35,30));
				panel.add(shadow);
				
				shadow2.setBounds(158, 326, 230, 53);
				shadow2.setBackground(new Color(35,35,35));
				panel.add(shadow2);
				
				shadow3.setBounds(158,430,230,53);
				shadow3.setBackground(new Color(35,35,35));
				panel.add(shadow3);
				
				shadow4.setBounds(155, 41, 248,74	);
				shadow4.setBackground(new Color(35,35,35));
				panel.add(shadow4);
  

		//After adding all of our components, we set our frame
		//visibility to true so that it can appear in front of us
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//The following conditions check which button has been clicked 
		//and launches the corresponding window accordingly.
		
		if (e.getSource()==button1) {
			new BubbleAlgorithm();
			this.dispose();;
		}
		
		if (e.getSource()==button2) {
			new BubbleDemo();
			this.dispose();;
		}
		
		if (e.getSource()==button3) {
			new BubbleCode();
			this.dispose();;
		}
	}
}