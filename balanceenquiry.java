import javax.swing.*;

import java.awt.*;

import java.awt.event.*;
import java.sql.*;

public class balanceenquiry extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;

    balanceenquiry(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 510, 150, 30);
        back.addActionListener(this);
        image.add(back);

        conn c = new conn();
        int balance = 0;
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            } catch (Exception e) {
                    System.out.println(e);
                }

        JLabel text = new JLabel("Your Account balance is Rs." + balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 30);
        image.add(text);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new transection(pinnumber).setVisible(true);
    }
    public static void main(String[] args) {
        new balanceenquiry("");
    }
}
