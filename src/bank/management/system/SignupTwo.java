package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author sayandipadhikary
 */
public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadharTextField;
    JRadioButton yesSenior, noSenior, yesExist, noExist;
    ButtonGroup seniorGroup, existGroup;
    JComboBox religionCombo, categoryCombo, incomeCombo, educationCombo, occupationCombo;
    JButton next;
    String formno;

    SignupTwo(String formno) {
        
        this.formno = formno;

        setLayout(null);
        setTitle("Taxis Bank Registration Page 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(270, 10, 600, 70);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(120, 100, 200, 60);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Christian", "Sikh", "Buddhist", "Jain"};
        religionCombo = new JComboBox(valReligion);
        religionCombo.setFont(new Font("Raleway", Font.BOLD, 14));
        religionCombo.setBounds(350, 110, 400, 40);
        add(religionCombo);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(120, 160, 150, 60);
        add(category);

        String valCategory[] = {"General", "ST", "SC", "OBC", "Others"};
        categoryCombo = new JComboBox(valCategory);
        categoryCombo.setFont(new Font("Raleway", Font.BOLD, 14));
        categoryCombo.setBounds(350, 170, 400, 40);
        add(categoryCombo);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(120, 220, 150, 60);
        add(income);

        String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomeCombo = new JComboBox(valIncome);
        incomeCombo.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeCombo.setBounds(350, 230, 400, 40);
        add(incomeCombo);

        JLabel qualification = new JLabel("Qualification");
        qualification.setFont(new Font("Raleway", Font.BOLD, 18));
        qualification.setBounds(120, 280, 150, 60);
        add(qualification);

        String valEducation[] = {"Below Secondary", "Secondary", "Higher Secondary", "Under-Graduate", "Graduate", "Post Graduate", "Doctorate"};
        educationCombo = new JComboBox(valEducation);
        educationCombo.setFont(new Font("Raleway", Font.BOLD, 14));
        educationCombo.setBounds(350, 290, 400, 40);
        add(educationCombo);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(120, 340, 150, 60);
        add(occupation);

        String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Unemployed"};
        occupationCombo = new JComboBox(valOccupation);
        occupationCombo.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationCombo.setBounds(350, 350, 400, 40);
        add(occupationCombo);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        pan.setBounds(120, 400, 200, 60);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(350, 410, 400, 40);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        aadhar.setBounds(120, 460, 200, 60);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(350, 470, 400, 40);
        add(aadharTextField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 18));
        senior.setBounds(120, 520, 200, 60);
        add(senior);

        yesSenior = new JRadioButton("Yes");
        yesSenior.setBounds(350, 530, 100, 40);
        add(yesSenior);

        noSenior = new JRadioButton("No");
        noSenior.setBounds(500, 530, 100, 40);
        add(noSenior);

        seniorGroup = new ButtonGroup();
        seniorGroup.add(yesSenior);
        seniorGroup.add(noSenior);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 18));
        existing.setBounds(120, 580, 200, 60);
        add(existing);

        yesExist = new JRadioButton("Yes");
        yesExist.setBounds(350, 590, 100, 40);
        add(yesExist);

        noExist = new JRadioButton("No");
        noExist.setBounds(500, 590, 100, 40);
        add(noExist);

        existGroup = new ButtonGroup();
        existGroup.add(yesExist);
        existGroup.add(noExist);

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

        String religionString = (String) religionCombo.getSelectedItem();
        String categoryString = (String) categoryCombo.getSelectedItem();
        String educationString = (String) educationCombo.getSelectedItem();
        String incomeString = (String) incomeCombo.getSelectedItem();
        String occupationString = (String) occupationCombo.getSelectedItem();
        String panString = panTextField.getText();
        String aadharString = aadharTextField.getText();

        String senior_citizen = null;
        if (yesSenior.isSelected()) {
            senior_citizen = "Yes";
        } else if (noSenior.isSelected()) {
            senior_citizen = "No";
        }
        String existed = null;
        if (yesExist.isSelected()) {
            existed = "Yes";
        } else if (noExist.isSelected()) {
            existed = "No";
        }

        try {

            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "', '" + religionString + "', '" + categoryString + "','" + incomeString + "','" + educationString + "','" + occupationString + "','" + panString + "','" + aadharString + "','" + senior_citizen + "','" + existed + "')";
            c.s.executeUpdate(query);

            System.out.println(formno + ", " + religionString + ", " + categoryString + ", " + educationString + ", " + incomeString + ", " + occupationString + ", " + panString + ", " + aadharString + ", " + senior_citizen + ", " + existed);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignupTwo("");
    }

}
