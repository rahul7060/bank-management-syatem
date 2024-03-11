import java.awt.*;

import java.awt.event.*; // action listler implementation 

import javax.swing.*;

import java.sql.*;

public class login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardTextfield;
    JPasswordField pinTextfield;

    login() {  // constructor
        setTitle("A T M");

        setLayout(null); // default layout is null now

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image img2 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel label = new JLabel(img3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card no. :");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 40);
        add(cardno);

        cardTextfield = new JTextField();
        cardTextfield.setBounds(300, 150, 230, 30);
        cardTextfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextfield);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextfield = new JPasswordField();
        pinTextfield.setBounds(300, 220, 230, 30);
        pinTextfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextfield);

        login = new JButton("Log in");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white); //text font (setForeground)
        login.addActionListener(this);  //"this" object means this object is working now 
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white); //text font (setForeground)
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white); //text font (setForeground)
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae){  //action performed when we click on th ebutton
        if (ae.getSource() == clear){
            cardTextfield.setText("");
            pinTextfield.setText("");
        } else if(ae.getSource() == login){
            conn c = new conn();
            String cardnumber = cardTextfield.getText();
            String pinnumber = pinTextfield.getText(); // this happens because pin is password type
            String query = "select * from login where card_number = '"+cardnumber+"'and pin = '"+pinnumber+"'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new transection(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Cardno. or Pin");
                }

            } catch (Exception e) {
                System.out.println(e);
            } 
        }else if(ae.getSource() == signup){

            setVisible(false);
            new signup().setVisible(true);  //call the signup form
        }
    }
    public static void main(String[] args) {
        new login(); //call login function 
    }
}