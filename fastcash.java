import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.util.Date;  // Date class in also in sql package amnd in util package also so compiler get confused!!
                        // so we have to write explicitly Date!
import java.sql.*;  // Date class in also in sql package amnd in util package also so compiler get confused!!

public class fastcash extends JFrame implements ActionListener{

    JButton hundred, cashwith, fastcash, mini, pinchng, balance, back;
    String pinnumber;  // local variable defined into global veriable

    fastcash(String pinnumber){

        this.pinnumber = pinnumber; //local variable

        setLayout(null);  // default set null

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select withdrawl amount:");
        text.setBounds(235, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        hundred = new JButton("Rs.100");
        hundred.setBounds(170, 400, 150, 30);
        hundred.addActionListener(this);
        image.add(hundred);

        cashwith = new JButton("Rs.500");
        cashwith.setBounds(350, 400, 150, 30);
        cashwith.addActionListener(this);
        image.add(cashwith);

        fastcash = new JButton("Rs.1000");
        fastcash.setBounds(170, 435, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        mini = new JButton("Rs.2000");
        mini.setBounds(350, 435, 150, 30);
        mini.addActionListener(this);
        image.add(mini);

        pinchng = new JButton("Rs.5000");
        pinchng.setBounds(170, 470, 150, 30);
        pinchng.addActionListener(this);
        image.add(pinchng);

        balance = new JButton("Rs.10,000");
        balance.setBounds(350, 470, 150, 30);
        balance.addActionListener(this);
        image.add(balance);

        back = new JButton("Back");
        back.setBounds(350, 505, 150, 30);
        back.addActionListener(this);
        image.add(back);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true); //this would be at last in the page

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back) {
            setVisible(false);
            new transection(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date  = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs."+amount+" debited successfully!");

                setVisible(false);
                new transection(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new fastcash("");
    }
}
