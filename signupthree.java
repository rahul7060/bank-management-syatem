import java.awt.*;

import java.awt.event.*;

import java.util.*;  //random number generate

import javax.swing.*;

public class signupthree extends JFrame implements ActionListener{

    JLabel l1, type, card, ncard, number, pin, pinc, pinnumber, services;
    JRadioButton r1, r2, r3, r4;
    JButton submit, cancel;
    JCheckBox atm, intbnk, mbnk, sms, chq, statement, declaration;
    String formno;

    signupthree(String formno){

        this.formno = formno;

        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 25));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account type");
        type.setFont(new Font("Raleway", Font.BOLD, 25));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 20));
        r1.setBounds(100, 190, 300, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 20));
        r2.setBounds(400, 190, 300, 30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 20));
        r3.setBounds(100, 240, 300, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 20));
        r4.setBounds(400, 240, 300, 30);
        add(r4);

        ButtonGroup accgroup = new ButtonGroup();
        accgroup.add(r1);
        accgroup.add(r2);
        accgroup.add(r3);
        accgroup.add(r4);


        card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 25));
        card.setBounds(100, 300, 200, 30);
        add(card);

        ncard = new JLabel("your 16 digit card number");
        ncard.setFont(new Font("Raleway", Font.BOLD, 13));
        ncard.setBounds(100, 320, 200, 30);
        add(ncard);

        number = new JLabel("XXXX-XXXX-XXXX-4134");
        number.setFont(new Font("Raleway", Font.BOLD, 25));
        number.setBounds(350, 300, 300, 30);
        add(number);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        pinc = new JLabel("your 4 digit PIN");
        pinc.setFont(new Font("Raleway", Font.BOLD, 13));
        pinc.setBounds(100, 390, 200, 30);
        add(pinc);

        pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 25));
        pinnumber.setBounds(350, 370, 200, 30);
        add(pinnumber);

        services = new JLabel("Services Recuired:");
        services.setFont(new Font("Raleway", Font.BOLD, 25));
        services.setBounds(100, 450, 300, 30);
        add(services);

        atm = new JCheckBox("ATM CARD");
        atm.setFont(new Font("Raleway", Font.BOLD, 18));
        atm.setBounds(100, 500, 200, 30);
        add(atm);

        intbnk = new JCheckBox("Internet Banking");
        intbnk.setFont(new Font("Raleway", Font.BOLD, 18));
        intbnk.setBounds(400, 500, 200, 30);
        add(intbnk);

        mbnk = new JCheckBox("Mobile Banking");
        mbnk.setFont(new Font("Raleway", Font.BOLD, 18));
        mbnk.setBounds(100, 550, 200, 30);
        add(mbnk);

        sms = new JCheckBox("EMAIL & SMS Alerts");
        sms.setFont(new Font("Raleway", Font.BOLD, 18));
        sms.setBounds(400, 550, 300, 30);
        add(sms);

        chq = new JCheckBox("Cheque Book");
        chq.setFont(new Font("Raleway", Font.BOLD, 18));
        chq.setBounds(100, 600, 200, 30);
        add(chq);

        statement = new JCheckBox("E-Statement");
        statement.setFont(new Font("Raleway", Font.BOLD, 18));
        statement.setBounds(400, 600, 200, 30);
        add(statement);

        declaration = new JCheckBox("I hearby declare that above details are correct to the best of my knowledge.");
        declaration.setFont(new Font("Raleway", Font.BOLD, 15));
        declaration.setBounds(100, 670, 800, 30);
        add(declaration);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 20));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 710, 120, 40);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 20));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450, 710, 120, 40);
        cancel.addActionListener(this);
        add(cancel);


        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit) {
            String accounttype = null;
            if (r1.isSelected()) {
                accounttype = "Saving Account";
            } else if (r2.isSelected()) {
                accounttype = "FD Account";
            } else if (r3.isSelected()) {
                accounttype = "Current Account";
            }else if (r4.isSelected()) {
                accounttype = "Recurring account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (atm.isSelected()) {
                facility = facility + "ATM Card";
            } else if (intbnk.isSelected()) {
                facility = facility + "Internet Banking";
            } else if (mbnk.isSelected()) {
                facility = facility + "Mobile Banking";
            } else if (sms.isSelected()) {
                facility = facility + "Email & SMS Alert";
            } else if (chq.isSelected()) {
                facility = facility + "Cheque Book";
            } else if (statement.isSelected()) {
                facility = facility + "E-Statement";
            }


            try {
                if (accounttype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please select anyone");
                } else if (!declaration.isSelected()) {  //if not aggreed 
                    JOptionPane.showMessageDialog(null,"Please declare filled by you!");
                } else {
                    conn c = new conn();
                    String query1 = "insert into signupthree value('"+formno+"', '"+accounttype+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String query2 = "insert into login value('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card number: " + cardnumber + "\n PIN:" + pinnumber);

                    setVisible(false);
                    new deposit(pinnumber).setVisible(false);

                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if(ae.getSource() == cancel){
            setVisible(false);
            new login().setVisible(true);
            // System.exit(0);
        }
    }
    public static void main(String[] args) {
        new signupthree("");
    }
}
