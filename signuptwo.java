// jdbc connectivity connected at here

import java.awt.*;

import java.awt.event.*;
// import java.awt.event.ActionListener;

import javax.swing.*;




public class signuptwo extends JFrame implements ActionListener{

    JTextField pantext, adhaartext;
    JButton next;
    JRadioButton sryes, srno, exaccyes, exaccno;
    JComboBox<String> religion, category, salary, educationc, occupation;
    String formno;
    
 
    
    signuptwo(String formno) {  //constructor

        this.formno = formno;

        setLayout(null);

        
        setTitle("New Account Application Form - Page 2");

    
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290, 80, 400, 30);
        add(additionaldetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);

        JLabel fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        // JDateChooser datechooser = new JDateChooser();
        // datechooser.setBounds(300, 240, 200, 300);

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel education = new JLabel("Qualification: ");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 315, 200, 30);
        add(education);



        JLabel status = new JLabel("Occupation: ");
        status.setFont(new Font("Raleway", Font.BOLD, 20));
        status.setBounds(100, 390, 200, 30);
        add(status);

        JLabel address = new JLabel("PAN no.: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        JLabel city = new JLabel("Adhaar No.: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        JLabel state = new JLabel("Senior citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        JLabel pcode = new JLabel("Existing Account: ");
        pcode.setFont(new Font("Raleway", Font.BOLD, 20));
        pcode.setBounds(100, 590, 200, 30);
        add(pcode);


        //textfields...............>>>>>>

        // ntext = new JTextField();
        // ntext.setFont(new Font("Raleway", Font.BOLD, 14));
        // ntext.setBounds(300, 140, 300, 30);
        // add(ntext);

        String valreligion[] = {"Hindu", "Muslim", "Sikh","Christian", "Other"};
        religion = new JComboBox<>(valreligion);
        religion.setBounds(300, 140, 300, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        

        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(valcategory);
        category.setBounds(300, 190, 300, 30);
        category.setBackground(Color.white);
        add(category);

        String valsalary[] = {"Null", "<1,50,000", "<2,50,00", "<5,00,000", "Upto 10,00,000"};
        salary = new JComboBox<>(valsalary);
        salary.setBounds(300, 240, 300, 30);
        salary.setBackground(Color.white);
        add(salary);
        

        String valeducation[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
        educationc = new JComboBox<>(valeducation);
        educationc.setBounds(300, 290, 300, 60);
        educationc.setBackground(Color.white);
        add(educationc);


        // marritial status.........<<<<<>>>>

        String valoccupation[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired"};
        occupation = new JComboBox<>(valoccupation);
        occupation.setBounds(300, 390, 300, 30);
        occupation.setBackground(Color.white);
        add(occupation);
        

        pantext = new JTextField();
        pantext.setFont(new Font("Raleway", Font.BOLD, 14));
        pantext.setBounds(300, 440, 300, 30);
        add(pantext);
        

        // addresstext = new JTextField();
        // addresstext.setFont(new Font("Raleway", Font.BOLD, 14));
        // addresstext.setBounds(300, 440, 300, 30);
        // add(addresstext);

        // citytext = new JTextField();
        // citytext.setFont(new Font("Raleway", Font.BOLD, 14));
        // citytext.setBounds(300, 490, 300, 30);
        // add(citytext);

        

        adhaartext = new JTextField();
        adhaartext.setFont(new Font("Raleway", Font.BOLD, 14));
        adhaartext.setBounds(300, 490, 300, 30);
        add(adhaartext);

        sryes = new JRadioButton("Yes");
        sryes.setBounds(300, 540, 100, 30);
        sryes.setBackground(null);
        add(sryes);
        
        srno = new JRadioButton("No");
        srno.setBounds(400, 540, 100, 30);
        srno.setBackground(Color.WHITE);
        add(srno);

        ButtonGroup srgroup = new ButtonGroup();
        srgroup.add(sryes);
        srgroup.add(srno);

        exaccyes = new JRadioButton("Yes");
        exaccyes.setBounds(300, 590, 100, 30);
        exaccyes.setBackground(null);
        add(exaccyes);
        
        exaccno = new JRadioButton("No");
        exaccno.setBounds(400, 590, 100, 30);
        exaccno.setBackground(Color.WHITE);
        add(exaccno);

        ButtonGroup accgroup = new ButtonGroup();
        accgroup.add(exaccyes);
        accgroup.add(exaccno);

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
        // String formno = "" + random;
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)salary.getSelectedItem();
        String seducation = (String)educationc.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String pan = pantext.getText();
        String adhaar = adhaartext.getText();
        String seniorsitizen = null;
        if (sryes.isSelected()) {
            seniorsitizen = "Yes";
        } else if(srno.isSelected()) {
            seniorsitizen = "No";
        }


        String existing = null;
        if (exaccyes.isSelected()) {
            existing = "Yes";
        } else if(exaccno.isSelected()) {
            existing = "No";
        }

        try {
            if (pan.equals("")) {
                JOptionPane.showMessageDialog(null, "Pan is required");
            } else {
                conn c = new conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+pan+"', '"+adhaar+"', '"+seniorsitizen+"', '"+existing+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signupthree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new signuptwo("");
    }
}