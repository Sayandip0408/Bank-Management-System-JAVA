package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author sayandipadhikary
 */
public class Login extends JFrame implements ActionListener {

    JButton loginBtn, clearBtn, signupBtn;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("Taxis Bank ATM");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 60);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 160, 400, 40);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 150, 60);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 230, 400, 40);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        loginBtn = new JButton("SIGN IN");
        loginBtn.setBounds(300, 300, 175, 40);
        loginBtn.setBackground(Color.WHITE);
        loginBtn.setForeground(Color.BLACK);
        loginBtn.addActionListener(this);
        add(loginBtn);

        clearBtn = new JButton("CLEAR");
        clearBtn.setBounds(525, 300, 175, 40);
        clearBtn.setBackground(Color.WHITE);
        clearBtn.setForeground(Color.RED);
        clearBtn.addActionListener(this);
        add(clearBtn);

        signupBtn = new JButton("SIGN UP");
        signupBtn.setBounds(300, 350, 400, 40);
        signupBtn.setBackground(Color.WHITE);
        signupBtn.setForeground(Color.BLACK);
        signupBtn.addActionListener(this);
        add(signupBtn);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == loginBtn) {
                Conn c1 = new Conn();
                String cardno = cardTextField.getText();
                String pin = pinTextField.getText();
                String q = "select * from login where card_no = '" + cardno + "' and pin = '" + pin + "'";

                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } else if (ae.getSource() == clearBtn) {
                cardTextField.setText("");
                pinTextField.setText("");
            } else if (ae.getSource() == signupBtn) {
                setVisible(false);
                new SignupOne().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Login();
    }

}
