import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener{

    JLabel npin, pintext, repin;
    JPasswordField pin, cnfpin;
    JButton change, back;
    String pinnumber;

    pinchange(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,900,900);
        add(image);

        npin = new JLabel("Change your PIN");
        npin.setForeground(Color.WHITE);
        npin.setFont(new Font("System", Font.BOLD, 16));
        npin.setBounds(250, 280, 500, 35);
        image.add(npin);

        pintext = new JLabel("New PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        repin = new JLabel("Reenter your PIN: ");
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("System", Font.BOLD, 16));
        repin.setBounds(165, 360, 180, 25);
        image.add(repin);

        cnfpin = new JPasswordField();
        cnfpin.setFont(new Font("Raleway", Font.BOLD, 25));
        cnfpin.setBounds(330, 360, 180, 25);
        image.add(cnfpin);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change) {
            
            try {
                String npin = pin.getText();
                String rpin = cnfpin.getText();
    
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match!");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter PIN!");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN!");
                }

                conn c = new conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";

                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";

                String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed succesfully!");

                setVisible(false);
                new transection(rpin).setVisible(true);

    
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new transection(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new pinchange("").setVisible(true);
    }
}
