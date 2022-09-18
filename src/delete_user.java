import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class delete_user implements ActionListener {
    static JFrame f;
    static JPanel panel;
    static JLabel name;
    static JTextField userText;
    static JLabel password;
    static JPasswordField passwordText;
    static JLabel repassword;
    static JPasswordField repasswordText;
    static JButton deleteButton;
    static JLabel success;
    public static void main() {
        f = new JFrame("Delete User");
        panel = new JPanel();
        f.setSize(350,220);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        panel.setLayout(null);

        name = new JLabel("Name");
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

        deleteButton = new JButton("Delete User");
        deleteButton.setBounds(80,115,130,25);
        deleteButton.addActionListener(new delete_user());
        panel.add(deleteButton);

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
            ResultSet rs;
            if(con!=null){
                System.out.println("Connected");
            }
            else {
                System.out.println("not");
            }String check ="Select * from user where name=? and password=?;";
            PreparedStatement ps = con.prepareStatement(check);
            ps.setString(1,name);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
                if (password.equals(repassword)){
                    String query = "delete from user where name=? and password=?;";
                    PreparedStatement ps1 = con.prepareStatement(query);
                    ps1.setString(1,name);
                    ps1.setString(2,password);
                    ps1.executeUpdate();
                    success.setText("User Deleted Successfully");
                    break;
                }
                else {
                    success.setText("Password does not match");
                }
            }
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    void setvisible() {
        main();
        f.setVisible(true);
    }
}
