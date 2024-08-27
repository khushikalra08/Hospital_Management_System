package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_discharge extends JFrame {

    Patient_discharge(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,580,450);
        panel.setBackground(new Color(173, 216, 230));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(230,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.BLACK);
        panel.add(label);

        JLabel label1 = new JLabel("Customer Id");
        label1.setBounds(30,80,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        label1.setForeground(new Color(7, 25, 82));
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(30,130,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        label2.setForeground(new Color(7, 25, 82));
        panel.add(label2);

        JLabel RNO = new JLabel();
        RNO.setBounds(200,130,150,20);
        RNO.setFont(new Font("Tahoma",Font.BOLD,15));
        RNO.setForeground(new Color(7, 25, 82));
        panel.add(RNO);

        JLabel label3 = new JLabel("In Time");
        label3.setBounds(30,180,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        label3.setForeground(new Color(7, 25, 82));
        panel.add(label3);

        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,15));
        INTime.setForeground(new Color(7, 25, 82));
        panel.add(INTime);

        JLabel label4 = new JLabel("Out Time");
        label4.setBounds(30,230,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        label4.setForeground(new Color(7, 25, 82));
        panel.add(label4);

        Date date = new Date();

        JLabel OUTime = new JLabel(""+date);
        OUTime.setBounds(200,230,250,20);
        OUTime.setFont(new Font("Tahoma",Font.BOLD,15));
        OUTime.setForeground(new Color(7, 25, 82));
        panel.add(OUTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(60,300,120,30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.white);
        discharge.setBorderPainted(false);
        discharge.setFocusPainted(false);
        discharge.setOpaque(true);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    c.statement.executeUpdate("delete from patient_info where number = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where room_no = '"+RNO.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }

            }
        });

        JButton Check = new JButton("Check");
        Check.setBounds(230,300,120,30);
        Check.setBackground(Color.black);
        Check.setForeground(Color.white);
        Check.setBorderPainted(false);
        Check.setFocusPainted(false);
        Check.setOpaque(true);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next()){
                        RNO.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(400,300,120,30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.setBorderPainted(false);
        Back.setFocusPainted(false);
        Back.setOpaque(true);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(590,460);
        setLayout(null);
        setLocation(430,325);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Patient_discharge();
    }
}
