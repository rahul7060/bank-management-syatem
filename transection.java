import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class transection extends JFrame implements ActionListener{

    JButton deposit, cashwith, fastcash, mini, pinchng, balance, exit;
    String pinnumber;  // local variable defined into global veriable

    transection(String pinnumber){

        this.pinnumber = pinnumber; //local variable

        setLayout(null);  // default set null

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your transection");
        text.setBounds(235, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 400, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        cashwith = new JButton("Cash Withdrawl");
        cashwith.setBounds(350, 400, 150, 30);
        cashwith.addActionListener(this);
        image.add(cashwith);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 435, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        mini = new JButton("Mini Statement");
        mini.setBounds(350, 435, 150, 30);
        mini.addActionListener(this);
        image.add(mini);

        pinchng = new JButton("Pin Change");
        pinchng.setBounds(170, 470, 150, 30);
        pinchng.addActionListener(this);
        image.add(pinchng);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(350, 470, 150, 30);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(350, 505, 150, 30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true); //this would be at last in the page

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == cashwith) {
            setVisible(false);
            new withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new fastcash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchng) {
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balance) {
            setVisible(false);
            new balanceenquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == mini) {
            new ministatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new transection("");
    }
}
