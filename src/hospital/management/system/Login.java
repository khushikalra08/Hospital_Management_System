package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener{

    JTextField textField;
    JPasswordField JPasswordField;
    JButton b1,b2;


    Login(){

        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.BOLD,15));
        textField.setBackground(new Color(158,216,132));
        add(textField);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPasswordField.requestFocusInWindow(); // Moves the cursor to password field
            }
        });


        JPasswordField = new JPasswordField();
        JPasswordField.setBounds(150,70,150,30);
        JPasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        JPasswordField.setBackground(new Color(158,216,132));
        add(JPasswordField);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(340,-30,400,300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setOpaque(true);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.white);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        b2.setOpaque(true);
        add(b2);






        getContentPane().setBackground(new Color(255,255,255));
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            try{
               conn c = new conn();
               String user = textField.getText();
               String Pass = JPasswordField.getText();

               String q = "select * from login where ID = '"+user+"' and PW = '"+Pass+"'";
               ResultSet resultSet = c.statement.executeQuery(q);

               if (resultSet.next()){
                   new Reception();
                   setVisible(false);
               }else{
                   JOptionPane.showMessageDialog(null,"Invalid");
               }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            System.exit(10);
        }
    }
}
