package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;

    SearchRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(26, 139, 157));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("Search for Room");
        For.setBounds(250,11,186,31);
        For.setForeground(Color.BLACK);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(For);

        JLabel status = new JLabel("Status :");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.BLACK);
        status.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(26, 139, 157));
        table.setForeground(Color.BLACK);
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(23,162,150,20);
        Roomno.setForeground(Color.BLACK);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(Roomno);

        JLabel available = new JLabel("Availability");
        available.setBounds(195,162,150,20);
        available.setForeground(Color.BLACK);
        available.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(380,162,150,20);
        price.setForeground(Color.BLACK);
        price.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(price);

        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(550,162,150,20);
        Bed.setForeground(Color.BLACK);
        Bed.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(Bed);

        JButton Search = new JButton("Search");
        Search.setBounds(190,420,120,25);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.BLACK);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception E) {
                    E.printStackTrace();

                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(380,420,120,25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.BLACK);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(360,290);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
