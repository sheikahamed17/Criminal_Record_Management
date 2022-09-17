import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPage implements ActionListener {
    static JFrame f = new JFrame("Login");
    static JPanel panel = new JPanel();
    static JLabel username = new JLabel("Username");
    static JLabel password = new JLabel("Password");
    JButton login = new JButton("Login");
    static JTextField userText ;
    static JPasswordField passwordText ;
    static JLabel success = new JLabel(" ");
    static Button loginButton = new Button("Login");
    public static void main(String[] args) {
        f = new JFrame();
        panel = new JPanel();
        f.setSize(300,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        panel.setLayout(null);

        username = new JLabel("User");
        username.setBounds(10,20,80,25);
        panel.add(username);

        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        password = new JLabel("Password");
        password.setBounds(10,50,80,25);
        panel.add(password);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        loginButton = new Button("Login");
        loginButton.setBounds(100,100,80,25);
        loginButton.addActionListener(new LoginPage());
        panel.add(loginButton);

        success = new JLabel(" ");
        success.setBounds(90,125,300,25);
        panel.add(success);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm","root","root");
            Statement st=con.createStatement();
            ResultSet rs;
            if(con!=null){
                System.out.println("Connected");
            }
            else {
                System.out.println("not");
            }
            String check ="Select * from user where name=?;";
            PreparedStatement ps = con.prepareStatement(check);
            ps.setString(1,user);
            rs = ps.executeQuery();
            while (rs.next()){
                String checkName = rs.getString("name");
                String checkPass = rs.getString("password");
                if(user.equals(checkName) && password.equals(checkPass)){
                    System.out.println("Login");
                    success.setText("Login Successful");
                    break;
                }
                else {
                    success.setText("Login Failed");
                    System.out.println("no");
                }

            }
        }
        catch (Exception e1) {
            System.out.println(e1);
        }
    }
}
