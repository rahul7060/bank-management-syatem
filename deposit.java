import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.util.*;

public class deposit extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit, back;
    String pinnumber;

    deposit(String pinnumber){

        this.pinnumber = pinnumber;


        setLayout(null);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdrawl");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(350, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(350, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);



        //frame adjustment
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null,"Please the Amount!");
            }else {
                try {
                conn c = new conn();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs."+number+" Deposited Successfully");
                setVisible(false);
                new transection(pinnumber).setVisible(true);

            } catch (Exception e){
                System.out.println(e);
            }
            } 
        } else if (ae.getSource() == back) {
            setVisible(false);
            new transection(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new deposit("");
    }
}
