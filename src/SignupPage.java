import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SignupPage implements ActionListener {
    static JFrame f;
    static JPanel panel;
    static JLabel name;
    static JTextField userText;
    static JLabel password;
    static JPasswordField passwordText;
    static JLabel repassword;
    static JPasswordField repasswordText;
    static JButton signupButton;
    static JLabel success;
    public static void main(String[] args) {
        f = new JFrame("Signup");
        panel = new JPanel();
        f.setSize(350,220);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        panel.setLayout(null);

        name = new JLabel("name");
        name.setBounds(10,20,80,25);
        panel.add(name);

        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        password = new JLabel("Password");
        password.setBounds(10,50,80,25);
        panel.add(password);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        repassword = new JLabel("Retype Password");
        repassword.setBounds(10,80,80,25);
        panel.add(repassword);

        repasswordText = new JPasswordField(20);
        repasswordText.setBounds(100,80,165,25);
        panel.add(repasswordText);

        signupButton = new JButton("Signup");
        signupButton.setBounds(100,115,80,25);
        signupButton.addActionListener(new SignupPage());
        panel.add(signupButton);

        success = new JLabel(" ");
        success.setBounds(80,145,300,25);
        panel.add(success);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = userText.getText();
        String password = passwordText.getText();
        String repassword = repasswordText.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm","root","root");
            Statement st=con.createStatement();
            int rs;
            if(con!=null){
                System.out.println("Connected");
            }
            else {
                System.out.println("not");
            }
            if(password.equals(repassword)){
                String insert ="insert into user (name,password) values(?,?);";
                PreparedStatement ps = con.prepareStatement(insert);
                ps.setString(1,name);
                ps.setString(2,password);
                rs = ps.executeUpdate();
                if(rs>0)
                    success.setText("Signup Successful");
                else
                    success.setText("Signup Failed");
            }
            else{
                success.setText("Password doesn't match");
            }
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
