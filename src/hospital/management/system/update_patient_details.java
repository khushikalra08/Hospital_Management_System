package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {

    update_patient_details(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(173, 216, 230));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,15,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.black);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,15));
        label2.setForeground(new Color(7, 25, 82));
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,100,25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,129,150,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,15));
        label3.setForeground(new Color(7, 25, 82));
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,146,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("IN-Time :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,15));
        label4.setForeground(new Color(7, 25, 82));
        panel.add(label4);

        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(248,174,146,20);
        panel.add(textFieldINTime);

        JLabel label5 = new JLabel("Amount Paid (Rs) :");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,15));
        label5.setForeground(new Color(7, 25, 82));
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,216,146,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount (Rs) :");
        label6.setBounds(25,261,150,20);
        label6.setFont(new Font("Tahoma",Font.PLAIN,15));
        label6.setForeground(new Color(7, 25, 82));
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,261,146,20);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBorderPainted(false);
        check.setFocusPainted(false);
        check.setOpaque(true);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name = '"+id+"'";
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldINTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no = '"+textFieldR.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });


        JButton update = new JButton("UPDATE");
        update.setBounds(56,378,95,23);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBorderPainted(false);
        update.setFocusPainted(false);
        update.setOpaque(true);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String patientName = choice.getSelectedItem(); // Selected patient's name
                    String newRoomNumber = textFieldR.getText(); // New room number
                    String time = textFieldINTime.getText();
                    String amount = textFieldAmount.getText();

                    // Fetch the current room number before updating
                    String currentRoomQuery = "select Room_Number from patient_info where Name = '"+ patientName +"'";
                    ResultSet currentRoomResult = c.statement.executeQuery(currentRoomQuery);
                    String currentRoomNumber = "";
                    if (currentRoomResult.next()) {
                        currentRoomNumber = currentRoomResult.getString("Room_Number");
                    }

                    // Update patient_info with new room number
                    String updatePatientQuery = "update patient_info set Room_Number = '"+ newRoomNumber +"', Time = '"+ time +"', Deposite = '"+ amount +"' where name = '"+ patientName +"'";
                    c.statement.executeUpdate(updatePatientQuery);

                    // Update room availability status
                    if (!currentRoomNumber.equals(newRoomNumber)) {
                        // Set the previous room's status to "Available"
                        String setPreviousRoomAvailable = "update Room set Availability = 'Available' where Room_no = '" + currentRoomNumber + "'";
                        c.statement.executeUpdate(setPreviousRoomAvailable);

                        // Set the new room's status to "Occupied"
                        String setNewRoomOccupied = "update Room set Availability = 'Occupied' where Room_no = '" + newRoomNumber + "'";
                        c.statement.executeUpdate(setNewRoomOccupied);
                    }

                    JOptionPane.showMessageDialog(null, "Update Successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        JButton back = new JButton("BACK");
        back.setBounds(170,378,89,23);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setOpaque(true);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(250,290);
        setVisible(true);
    }
    public static void main(String[] args) {
        new update_patient_details();
    }
}
