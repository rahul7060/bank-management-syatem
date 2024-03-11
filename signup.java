// jdbc connectivity connected at here

import java.awt.*;

import java.awt.event.*;
// import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.*;

// import com.toedter.*;

import com.toedter.calendar.JDateChooser;


public class signup extends JFrame implements ActionListener{

    JTextField ntext, ftext, etext, addresstext, citytext, stext, pintext;
    JButton next;
    JRadioButton male, female, married, unmarried;
    JDateChooser dtext;
    long random;
    
    signup() {  //constructor

        setLayout(null);

        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application form no. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel pdetails = new JLabel("Page 1: Personal details");
        pdetails.setFont(new Font("Raleway", Font.BOLD, 22));
        pdetails.setBounds(290, 80, 400, 30);
        add(pdetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        JLabel dob = new JLabel("D.O.B: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        // JDateChooser datechooser = new JDateChooser();
        // datechooser.setBounds(300, 240, 200, 300);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("E-mail: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        JLabel status = new JLabel("Maritial Status: ");
        status.setFont(new Font("Raleway", Font.BOLD, 20));
        status.setBounds(100, 390, 200, 30);
        add(status);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        JLabel pcode = new JLabel("Pin Code: ");
        pcode.setFont(new Font("Raleway", Font.BOLD, 20));
        pcode.setBounds(100, 590, 200, 30);
        add(pcode);


        //textfields...............>>>>>>

        ntext = new JTextField();
        ntext.setFont(new Font("Raleway", Font.BOLD, 14));
        ntext.setBounds(300, 140, 300, 30);
        add(ntext);
        
        ftext = new JTextField();
        ftext.setFont(new Font("Raleway", Font.BOLD, 14));
        ftext.setBounds(300, 190, 300, 30);
        add(ftext);
        
        // JTextField dtext = new JTextField();
        // dtext.setFont(new Font("Raleway", Font.BOLD, 14));
        // dtext.setBounds(300, 240, 300, 30);
        // add(dtext);

        // JDateChooser datechooser = new JDateChooser();
        // datechooser.setBounds(300, 240, 300, 30);
        // datechooser.setForeground(new Color(0, 1, 1));
        // add(datechooser);

        dtext = new JDateChooser();
        dtext.setBounds(300, 240, 300, 30);
        dtext.setForeground(Color.BLACK);
        add(dtext);

        // JTextField gtext = new JTextField();
        // gtext.setFont(new Font("Raleway", Font.BOLD, 14));
        // gtext.setBounds(300, 290, 300, 30);
        // add(gtext);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 30);
        male.setBackground(null);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(400, 290, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendegroup = new ButtonGroup();
        gendegroup.add(male);
        gendegroup.add(female);

        etext = new JTextField();
        etext.setFont(new Font("Raleway", Font.BOLD, 14));
        etext.setBounds(300, 340, 300, 30);
        add(etext);

        // marritial status.........<<<<<>>>>

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(null);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup mstatus = new ButtonGroup();
        mstatus.add(married);
        mstatus.add(unmarried);

        addresstext = new JTextField();
        addresstext.setFont(new Font("Raleway", Font.BOLD, 14));
        addresstext.setBounds(300, 440, 300, 30);
        add(addresstext);

        citytext = new JTextField();
        citytext.setFont(new Font("Raleway", Font.BOLD, 14));
        citytext.setBounds(300, 490, 300, 30);
        add(citytext);

        

        stext = new JTextField();
        stext.setFont(new Font("Raleway", Font.BOLD, 14));
        stext.setBounds(300, 540, 300, 30);
        add(stext);

        pintext = new JTextField();
        pintext.setFont(new Font("Raleway", Font.BOLD, 14));
        pintext.setBounds(300, 590, 300, 30);
        add(pintext);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(300, 640, 100, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setVisible(true);
        setLocation(350, 10);
    }

    public void actionPerformed(ActionEvent ac){
        String formno = "" + random;
        String name = ntext.getText();
        String fname = ftext.getText();
        String dob = ((JTextField) this.dtext.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if(female.isSelected()) {
            gender = "Female";
        }

        String email = etext.getText();
        String mstatus = null;
        if (married.isSelected()) {
            mstatus = "Married";
        } else if(unmarried.isSelected()) {
            mstatus = "Unmarried";
        }

        String address = addresstext.getText();
        String city = citytext.getText();
        String state = stext.getText();
        String pin = pintext.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                conn c = new conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+mstatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signuptwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new signup();
    }
}