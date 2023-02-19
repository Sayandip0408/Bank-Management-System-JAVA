package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author sayandipadhikary
 */
public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingsAcc, currentAcc, fixedAcc, recurringAcc;
    ButtonGroup accountGroup;
    JButton submit;
    String formno;
    JCheckBox atmCheck, internetCheck, mobileCheck, emailCheck, chequeCheck, estatementCheck, noteCheck;

    SignupThree(String formno) {

        this.formno = formno;

        setLayout(null);
        setTitle("Taxis Bank Registration Page 3");

        JLabel accountDetails = new JLabel("Page 3 : Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(270, 10, 600, 70);
        add(accountDetails);

        JLabel account = new JLabel("Account Type:");
        account.setFont(new Font("Raleway", Font.BOLD, 18));
        account.setBounds(120, 80, 200, 60);
        add(account);

        savingsAcc = new JRadioButton("Savings Account");
        savingsAcc.setBounds(120, 130, 250, 40);
        add(savingsAcc);

        currentAcc = new JRadioButton("Current Account");
        currentAcc.setBounds(400, 130, 250, 40);
        add(currentAcc);

        fixedAcc = new JRadioButton("Fixed Deposit Account");
        fixedAcc.setBounds(120, 170, 250, 40);
        add(fixedAcc);

        recurringAcc = new JRadioButton("Recurring Deposit Account");
        recurringAcc.setBounds(400, 170, 250, 40);
        add(recurringAcc);

        accountGroup = new ButtonGroup();
        accountGroup.add(savingsAcc);
        accountGroup.add(currentAcc);
        accountGroup.add(fixedAcc);
        accountGroup.add(recurringAcc);

        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 18));
        cardno.setBounds(120, 210, 200, 60);
        add(cardno);

        JLabel cardnoPara = new JLabel("16 digit card number");
        cardnoPara.setFont(new Font("Raleway", Font.BOLD, 10));
        cardnoPara.setBounds(120, 235, 200, 60);
        add(cardnoPara);

        JLabel cardnoSample = new JLabel("XXXX-XXXX-XXXX-2590");
        cardnoSample.setFont(new Font("Raleway", Font.BOLD, 18));
        cardnoSample.setBounds(400, 222, 400, 60);
        add(cardnoSample);

        JLabel pinno = new JLabel("PIN:");
        pinno.setFont(new Font("Raleway", Font.BOLD, 18));
        pinno.setBounds(120, 275, 200, 60);
        add(pinno);

        JLabel pinnoPara = new JLabel("4 digit assword");
        pinnoPara.setFont(new Font("Raleway", Font.BOLD, 10));
        pinnoPara.setBounds(120, 300, 200, 60);
        add(pinnoPara);

        JLabel pinnoSample = new JLabel("XXXX");
        pinnoSample.setFont(new Font("Raleway", Font.BOLD, 18));
        pinnoSample.setBounds(400, 287, 400, 60);
        add(pinnoSample);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(120, 340, 200, 60);
        add(services);

        atmCheck = new JCheckBox("ATM CARD");
        atmCheck.setBackground(Color.WHITE);
        atmCheck.setBounds(120, 400, 200, 30);
        add(atmCheck);

        internetCheck = new JCheckBox("Internet Banking");
        internetCheck.setBackground(Color.WHITE);
        internetCheck.setBounds(400, 400, 200, 30);
        add(internetCheck);

        mobileCheck = new JCheckBox("Mobile Banking");
        mobileCheck.setBackground(Color.WHITE);
        mobileCheck.setBounds(120, 440, 200, 30);
        add(mobileCheck);

        emailCheck = new JCheckBox("EMAIL Alerts");
        emailCheck.setBackground(Color.WHITE);
        emailCheck.setBounds(400, 440, 200, 30);
        add(emailCheck);

        chequeCheck = new JCheckBox("Cheque Book");
        chequeCheck.setBackground(Color.WHITE);
        chequeCheck.setBounds(120, 480, 200, 30);
        add(chequeCheck);

        estatementCheck = new JCheckBox("E-Statement");
        estatementCheck.setBackground(Color.WHITE);
        estatementCheck.setBounds(400, 480, 200, 30);
        add(estatementCheck);

        noteCheck = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.", true);
        noteCheck.setBackground(Color.WHITE);
        noteCheck.setFont(new Font("Raleway", Font.BOLD, 12));
        noteCheck.setBounds(120, 540, 600, 20);
        add(noteCheck);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(700, 600, 100, 50);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String atype = null;
        if (savingsAcc.isSelected()) {
            atype = "Savings Account";
        } else if (fixedAcc.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (currentAcc.isSelected()) {
            atype = "Current Account";
        } else if (recurringAcc.isSelected()) {
            atype = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String facility = "";
        if (atmCheck.isSelected()) {
            facility = facility + " ATM Card";
        }
        if (internetCheck.isSelected()) {
            facility = facility + " Internet Banking";
        }
        if (mobileCheck.isSelected()) {
            facility = facility + " Mobile Banking";
        }
        if (emailCheck.isSelected()) {
            facility = facility + " EMAIL Alerts";
        }
        if (chequeCheck.isSelected()) {
            facility = facility + " Cheque Book";
        }
        if (estatementCheck.isSelected()) {
            facility = facility + " E-Statement";
        }

        try {
            if (atype.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                Conn c1 = new Conn();
                String q1 = "insert into signupthree values('" + formno + "','" + atype + "','" + cardno + "','" + pin + "','" + facility + "')";
                String q2 = "insert into login values('" + formno + "','" + cardno + "','" + pin + "')";
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:" + pin);

                new Deposit(pin).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]) {
        new SignupThree("");
    }

}
