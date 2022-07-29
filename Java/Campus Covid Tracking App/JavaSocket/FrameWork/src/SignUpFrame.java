import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SignUpFrame extends JFrame implements ActionListener {
    public DataInputStream dataInputStream;
    public DataOutputStream dataOutputStream;

    public JTextField firstNameField;
    public JTextField lastNameField;
    public JTextField emailField;
    public JTextField usernameField;
    public JPasswordField passwordField;
    public JFileChooser fileChooser;
    public FileDialog fd;
    public JButton loadButton;
    public String userImagePath;
    public BufferedImage userImage;
    public JLabel imagePathLabel;
    public JMenu vaccinationStatus;
    public JLabel vaccinatedFormLabel;
    public JRadioButton bVaccinated;
    public JRadioButton bNotVaccinated;
    public String vacStatus = "Not vaccinated";
    public JButton CertificateButton;
    public String certificatePath;
    public JLabel certificateLabel;
    public JPanel panel;
    public JButton submit;
    public JButton back;

    public SignUpFrame(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {

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

        JScrollPane pane = new JScrollPane(panel);
        this.setContentPane(pane);


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

        JPanel SignUpShadow = new JPanel();
        SignUpShadow.setBounds(87, 85, 180, 48);
        SignUpShadow.setBackground(new Color(210, 210, 210));
        SignUpShadow.setOpaque(true);
        SignUpShadow.setLayout(null);
        panel.add(SignUpShadow);


        JPanel SignUpBackground = new JPanel();
        SignUpBackground.setBounds(2, 0, 176, 46);
        SignUpBackground.setBackground(new Color(255, 255, 255));
        SignUpBackground.setOpaque(true);
        SignUpBackground.setLayout(null);
        SignUpBackground.setBorder(null);
        SignUpShadow.add(SignUpBackground);

        JLabel SignUpLabel = new JLabel("Sign Up Form");
        SignUpLabel.setFont(new Font("Arial", Font.BOLD, 20));
        SignUpLabel.setForeground(new Color(109, 151, 233));
        SignUpLabel.setBounds(30, 0, 170, 40);
        SignUpBackground.add(SignUpLabel);

        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        firstNameLabel.setForeground(new Color(109, 151, 233));
        firstNameLabel.setBounds(10, 180, 130, 30);
        panel.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(130, 180, 200, 30);
        firstNameField.setBackground(new Color(250, 250, 250));
        firstNameField.setBorder(border);
        panel.add(firstNameField);


        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        lastNameLabel.setForeground(new Color(109, 151, 233));
        lastNameLabel.setBounds(10, 230, 130, 30);
        panel.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(130, 230, 200, 30);
        lastNameField.setBackground(new Color(250, 250, 250));
        lastNameField.setBorder(border);
        panel.add(lastNameField);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        emailLabel.setForeground(new Color(109, 151, 233));
        emailLabel.setBounds(10, 280, 70, 30);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(130, 280, 200, 30);
        emailField.setBackground(new Color(250, 250, 250));
        emailField.setBorder(border);
        panel.add(emailField);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        usernameLabel.setForeground(new Color(109, 151, 233));
        usernameLabel.setBounds(10, 330, 120, 30);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(130, 330, 200, 30);
        usernameField.setBackground(new Color(250, 250, 250));
        usernameField.setBorder(border);
        panel.add(usernameField);


        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setForeground(new Color(109, 151, 233));
        passwordLabel.setBounds(10, 380, 120, 30);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(130, 380, 200, 30);
        passwordField.setBackground(new Color(250, 250, 250));
        passwordField.setBorder(border);
        panel.add(passwordField);


        JLabel fileLabel = new JLabel("Upload photo: ");
        fileLabel.setFont(new Font("Arial", Font.BOLD, 14));
        fileLabel.setForeground(new Color(109, 151, 233));
        fileLabel.setBounds(10, 430, 120, 30);
        panel.add(fileLabel);


        imagePathLabel = new JLabel();
        imagePathLabel.setFont(new Font("Arial", Font.BOLD, 7));
        imagePathLabel.setForeground(new Color(109, 151, 233));
        imagePathLabel.setBounds(260, 430, 120, 30);
        imagePathLabel.setText("tesT");
        panel.add(imagePathLabel);

        loadButton = new JButton("Choose Photo");
        loadButton.setBounds(130, 430, 115, 30);
        loadButton.setForeground(new Color(255, 255, 255));
        loadButton.setBackground(new Color(109, 151, 233));
        loadButton.setFocusable(false);
        panel.add(loadButton);

        loadButton.addActionListener(ev -> {
            JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
            fc.addChoosableFileFilter(new FileNameExtensionFilter("Image files",
                    new String[]{"png", "jpg", "jpeg", "gif"}));
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                try {
                    BufferedImage userImage = ImageIO.read(fc.getSelectedFile());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                userImagePath = fc.getSelectedFile().toString();

                imagePathLabel.setText(userImagePath);


            }
        });


        JLabel vaccinationLabel = new JLabel("Vaccination Status: ");
        vaccinationLabel.setBounds(10, 480, 125, 30);
        vaccinationLabel.setFont(new Font("Arial", Font.BOLD, 12));
        vaccinationLabel.setForeground(new Color(109, 151, 233));
        panel.add(vaccinationLabel);

        bVaccinated = new JRadioButton("Vaccinated");
        bNotVaccinated = new JRadioButton("Not Vaccinated");
        ButtonGroup group1 = new ButtonGroup();
        group1.add(bNotVaccinated);
        group1.add(bVaccinated);
        bVaccinated.setBounds(140, 480, 140, 30);
        bVaccinated.setBackground(new Color(255, 255, 255));
        bNotVaccinated.setBackground(new Color(255, 255, 255));

        bVaccinated.addActionListener(this);
        bNotVaccinated.addActionListener(this);
        bNotVaccinated.setBounds(140, 510, 140, 30);
        panel.add(bNotVaccinated);
        panel.add(bVaccinated);

        // to be added in case vaccinated is true
        vaccinatedFormLabel = new JLabel();
        vaccinatedFormLabel.setForeground(new Color(109, 151, 233));
        vaccinatedFormLabel.setBounds(10, 550, 300, 30);
        vaccinatedFormLabel.setFont(new Font("Arial", Font.BOLD, 14));
        vaccinatedFormLabel.setText(" ");

        panel.add(vaccinatedFormLabel);


        certificateLabel = new JLabel();
        certificateLabel.setFont(new Font("Arial", Font.BOLD, 12));
        certificateLabel.setForeground(new Color(109, 151, 233));
        certificateLabel.setBounds(80, 620, 200, 30);
        certificateLabel.setText(" ");

        CertificateButton = new JButton("Upload Certificate");
        CertificateButton.setBounds(90, 600, 166, 30);
        CertificateButton.setForeground(new Color(255, 255, 255));
        CertificateButton.setBackground(new Color(109, 151, 233));
        CertificateButton.setFocusable(false);


        CertificateButton.addActionListener(ev -> {
            JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
            //   fc.addChoosableFileFilter(new FileNameExtensionFilter("Image files",
            //      new String[] { "png", "jpg", "jpeg", "gif" }));
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                certificatePath = fc.getSelectedFile().toString();
                certificateLabel.setText(certificatePath);


            }
        });


        submit = new JButton("Sign In");
        submit.setBounds(230, 570, 100, 30);
        submit.setForeground(new Color(255, 255, 255));
        submit.setBackground(new Color(109, 151, 233));
        submit.addActionListener(this);
        panel.add(submit);

        back = new JButton("Back");
        back.setBounds(10, 570, 100, 30);
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(109, 151, 233));
        back.addActionListener(this);
        panel.add(back);

        this.setVisible(true);


			/*fileChooser = new JFileChooser();
			fileChooser.setBounds(130, 380, 200, 70);
			fileChooser.addChoosableFileFilter( new ImageFilter());
            fileChooser.setAcceptAllFileFilterUsed(false);
			*/

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        try {
            if (e.getSource() == bVaccinated) {
                vaccinatedFormLabel.setText("Please upload your vaccination certificate");
                vacStatus = "Vaccinated";
                panel.add(CertificateButton);
                panel.add(certificateLabel);
                CertificateButton.setVisible(true);
                certificateLabel.setVisible(true);
                submit.setBounds(230, 680, 100, 30);
                back.setBounds(10, 680, 100, 30);


            } else if (e.getSource() == bNotVaccinated) {
                vaccinatedFormLabel.setText(" ");
                vacStatus = "Not vaccinated";
                CertificateButton.setVisible(false);
                certificateLabel.setVisible(false);
                submit.setBounds(230, 570, 100, 30);
                back.setBounds(10, 570, 100, 30);

            } else if (e.getSource() == submit) {

                if (!usernameField.getText().equals("") && !passwordField.getText().equals("") && !firstNameField.getText().equals("") && !lastNameField.getText().equals("") && !emailField.getText().equals("")) {
                    String str = firstNameField.getText() + "\n"
                            + lastNameField.getText() + "\n"
                            + emailField.getText() + "\n"
                            + usernameField.getText() + "\n"
                            + passwordField.getText() + "\n"
                            + userImagePath + "\n"
                            + vacStatus + "\n"
                            + certificatePath;
                    dataOutputStream.writeUTF(str);
                    if (dataInputStream.readUTF().equalsIgnoreCase("Done")) {
                        AccountPageFrame accountPageFrame = new AccountPageFrame(dataInputStream, dataOutputStream);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Username Already exists!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Fill all the fields!");
                }

            } else if (e.getSource() == back) {
                System.out.println("Back");
                dataOutputStream.writeUTF("back");
                MyFrame myFrame = new MyFrame(dataInputStream, dataOutputStream);
                this.dispose();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
}
