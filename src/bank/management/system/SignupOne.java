package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author sayandipadhikary
 */
public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried, others;
    ButtonGroup genderGroup, maritalGroup;
    JButton next;

    SignupOne() {

        setLayout(null);
        setTitle("Taxis Bank Registration Page 1");

        Random ran = new Random();

        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(130, 10, 600, 70);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(270, 60, 600, 70);
        add(personalDetails);

        JLabel name = new JLabel("Full Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(120, 150, 150, 60);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 160, 400, 40);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(120, 200, 150, 60);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 210, 400, 40);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(120, 250, 150, 60);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 260, 400, 40);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(120, 300, 150, 60);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 310, 100, 40);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 310, 100, 40);
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(120, 350, 150, 60);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 360, 400, 40);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        marital.setBounds(120, 400, 150, 60);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 410, 100, 40);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 410, 100, 40);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setBounds(600, 410, 100, 40);
        add(others);

        maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(others);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(120, 450, 150, 60);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 470, 400, 40);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(120, 500, 150, 60);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 510, 400, 40);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(120, 550, 150, 60);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 560, 400, 40);
        add(stateTextField);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds(120, 600, 150, 60);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 610, 400, 40);
        add(pincodeTextField);

        next = new JButton("NEXT");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(700, 700, 100, 50);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (others.isSelected()) {
            marital = "Others";
        }

        try {

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state + "','" + pincode + "')";
                c.s.executeUpdate(query);
            }
            setVisible(false);
            new SignupTwo(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]) {

        new SignupOne();

    }
}
