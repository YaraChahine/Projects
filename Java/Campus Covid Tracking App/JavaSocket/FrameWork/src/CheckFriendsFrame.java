import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class CheckFriendsFrame extends JFrame implements ActionListener {

    public DataInputStream dataInputStream;
    public DataOutputStream dataOutputStream;
    public JPanel panel;
    public JLabel imgLabel;
    public boolean bool = false;
    public JButton back;
    public String[] friendsStatusArray;
    public String[][] friendsStatus;
    public String received;
    public  String[] columnNames;

    public CheckFriendsFrame(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    dataOutputStream.writeUTF("Exit");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        Border border = BorderFactory.createRaisedSoftBevelBorder();

        this.setLayout(null);
        this.setTitle("CovidLess");
        this.setSize(385, 640);
        this.setLocation(300, 15);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(new Color(255, 255, 255));

        panel = new JPanel();
        panel.setBounds(0, 0, 385, 640);

        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(375, 770));
        this.add(panel);

        JPanel headerShadow = new JPanel();
        headerShadow.setBounds(0, 0, 375, 48);
        headerShadow.setBackground(new Color(220, 220, 220));
        headerShadow.setOpaque(true);
        headerShadow.setLayout(null);
        panel.add(headerShadow);

        JPanel header = new JPanel();
        header.setBounds(0, 0, 375, 45);
        header.setBackground(new Color(109, 151, 233));
        header.setLayout(null);
        headerShadow.add(header);

        JLabel logo = new JLabel("CovidLess.");
        logo.setBounds(10, 2, 180, 40);
        logo.setForeground(new Color(255, 255, 255));
        logo.setFont(new Font("Bodoni Mt", Font.ITALIC, 32));
        header.add(logo);

        JPanel titleShadow = new JPanel();
        titleShadow.setBounds(97, 85, 180, 48);
        titleShadow.setBackground(new Color(210, 210, 210));
        titleShadow.setOpaque(true);
        titleShadow.setLayout(null);
        panel.add(titleShadow);

        JPanel TitleBackground = new JPanel();
        TitleBackground.setBounds(2, 0, 176, 46);
        TitleBackground.setBackground(new Color(255, 255, 255));
        TitleBackground.setOpaque(true);
        TitleBackground.setLayout(null);
        TitleBackground.setBorder(null);
        titleShadow.add(TitleBackground);

        JLabel trustedLabel = new JLabel("Trusted Friends");
        trustedLabel.setFont(new Font("Arial", Font.BOLD, 20));
        trustedLabel.setForeground(new Color(109, 151, 233));
        trustedLabel.setBounds(13, 0, 170, 40);
        TitleBackground.add(trustedLabel);

        try {
            received = dataInputStream.readUTF();
            System.out.println(received);
            friendsStatusArray = received.split("\n");
            int len = friendsStatusArray.length;
            friendsStatus = new String[len/2][2];

            int index = 0;
            for (int i=0; i<friendsStatus.length; i++) {
                for (int j=0; j<2; j++){
                    friendsStatus[i][j]= friendsStatusArray[index];
                    index++;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        columnNames = new String[2];
        columnNames[0]="Name";
        columnNames[1]="Status";


        JTable j = new JTable(friendsStatus, columnNames);
        j.setBounds(40, 270, 300, 200);
        j.setForeground(new Color(60,60,60));
        panel.add(j);

        back= new JButton("Back");
        back.setForeground(new Color(255,255,255));
        back.setBackground(new Color(109, 151, 233));
        back.setBounds(120,500,130,30);
        back.addActionListener(this);
        panel.add(back);

        JPanel headerShadow1= new JPanel();
        headerShadow1.setBounds(60, 205, 100, 30);

        JPanel headerShadow2= new JPanel();
        headerShadow2.setBounds(210, 205, 100, 30);


        headerShadow1.setBackground(new Color(109, 151, 233));
        headerShadow1.setLayout(null);
        headerShadow1.setPreferredSize(new Dimension(375, 770));
        panel.add(headerShadow1);

        headerShadow2.setBackground(new Color(109, 151, 233));
        headerShadow2.setLayout(null);
        headerShadow2.setPreferredSize(new Dimension(375, 770));
        panel.add(headerShadow2);


        JLabel tableHeader1= new JLabel("Username");
        tableHeader1.setForeground(new Color(255,255,255));
        tableHeader1.setBounds(20, 0, 100, 25);
        headerShadow1.add(tableHeader1);

        JLabel tableHeader2= new JLabel("Health Status");
        tableHeader2.setForeground(new Color(255,255,255));
        tableHeader2.setBounds(10,0,100,25);
        headerShadow2.add(tableHeader2);
        // Initializing the JTable

        this.setVisible(true);

    };



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            new AccountPageFrame(dataInputStream, dataOutputStream);
            this.dispose();
        }
    }
}



