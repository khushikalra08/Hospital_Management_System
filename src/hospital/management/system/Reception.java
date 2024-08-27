package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1430,707);
        panel.setBackground(new Color(26, 139, 157));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1430,150);
        panel1.setBackground(new Color(26, 139, 157));
        add(panel1);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image = i1.getImage().getScaledInstance(200,130,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon((image));
        JLabel label = new JLabel((i2));
        label.setBounds(1220,0,200,150);
        panel1.add(label);


        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image1 = i11.getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon((image1));
        JLabel label1 = new JLabel((i22));
        label1.setBounds(450,150,500,450);
        panel.add(label1);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30,15,200,35);
        btn1.setBackground(new Color(230, 230, 230));
        btn1.setOpaque(true);
        btn1.setBorderPainted(false);
        btn1.setFocusPainted(false);
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(30,58,200,35);
        btn2.setBackground(new Color(230, 230, 230));
        btn2.setOpaque(true);
        btn2.setBorderPainted(false);
        btn2.setFocusPainted(false);
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setBounds(30,100,200,35);
        btn3.setBackground(new Color(230, 230, 230));
        btn3.setOpaque(true);
        btn3.setBorderPainted(false);
        btn3.setFocusPainted(false);
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new Department();
            }
        });

        JButton btn4 = new JButton("All Employee Info");
        btn4.setBounds(270,15,200,35);
        btn4.setBackground(new Color(230, 230, 230));
        btn4.setOpaque(true);
        btn4.setBorderPainted(false);
        btn4.setFocusPainted(false);
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Employee_info();
            }
        });

        JButton btn5 = new JButton("Patient Info");
        btn5.setBounds(270,58,200,35);
        btn5.setBackground(new Color(230, 230, 230));
        btn5.setOpaque(true);
        btn5.setBorderPainted(false);
        btn5.setFocusPainted(false);
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new All_Patient_info();
            }
        });

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(270,100,200,35);
        btn6.setBackground(new Color(230, 230, 230));
        btn6.setOpaque(true);
        btn6.setBorderPainted(false);
        btn6.setFocusPainted(false);
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Patient_discharge();
            }
        });

        JButton btn7 = new JButton("Update Patient Details");
        btn7.setBounds(510,15,200,35);
        btn7.setBackground(new Color(230, 230, 230));
        btn7.setOpaque(true);
        btn7.setBorderPainted(false);
        btn7.setFocusPainted(false);
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new update_patient_details();
            }
        });

        JButton btn8 = new JButton("Hospital Ambulance");
        btn8.setBounds(510,58,200,35);
        btn8.setBackground(new Color(230, 230, 230));
        btn8.setOpaque(true);
        btn8.setBorderPainted(false);
        btn8.setFocusPainted(false);
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(510,100,200,35);
        btn9.setBackground(new Color(230, 230, 230));
        btn9.setOpaque(true);
        btn9.setBorderPainted(false);
        btn9.setFocusPainted(false);
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });

        JButton btn10 = new JButton("Logout");
        btn10.setBounds(750,15,200,35);
        btn10.setBackground(new Color(230, 230, 230));
        btn10.setOpaque(true);
        btn10.setBorderPainted(false);
        btn10.setFocusPainted(false);
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
