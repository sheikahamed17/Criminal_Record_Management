import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class EditUser implements ActionListener {
    static JFrame f;
    static JPanel panel;
    static JLabel name;
    static JTextField userText;
    static JLabel oldPassword;
    static JPasswordField oldPasswordText;
    static JLabel password;
    static JPasswordField passwordText;
    static JLabel updatePassword;
    static JPasswordField updatePasswordText;
    static JPasswordField repasswordText;
    static JButton updateButton;
    static JLabel success;
    public static void main() {
        f = new JFrame("Signup");
        panel = new JPanel();
        f.setSize(320,280);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        panel.setLayout(null);

        name = new JLabel("Name");
        name.setBounds(20,20,80,25);
        panel.add(name);

        userText = new JTextField(20);
        userText.setBounds(110,20,165,25);
        panel.add(userText);

        oldPassword = new JLabel("Old Password");
        oldPassword.setBounds(20,50,80,25);
        panel.add(oldPassword);

        oldPasswordText = new JPasswordField(20);
        oldPasswordText.setBounds(110,50,165,25);
        panel.add(oldPasswordText);

        updatePassword = new JLabel("New Password");
        updatePassword.setBounds(20,80,80,25);
        panel.add(updatePassword);

        updatePasswordText = new JPasswordField(20);
        updatePasswordText.setBounds(110,80,165,25);
        panel.add(updatePasswordText);

        updatePassword = new JLabel("Retype Password");
        updatePassword.setBounds(20,115,80,25);
        panel.add(updatePassword);

        repasswordText = new JPasswordField(20);
        repasswordText.setBounds(110,115,165,25);
        panel.add(repasswordText);

        updateButton = new JButton("Update");
        updateButton.setBounds(100,150,80,25);
        updateButton.addActionListener(new EditUser());
        panel.add(updateButton);

        success = new JLabel("");
        success.setBounds(50,185,300,25);
        panel.add(success);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = userText.getText();
        String oldPassword = oldPasswordText.getText();
        String updatePassword = updatePasswordText.getText();
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
            if(updatePassword.equals(repassword)){
                String update = "update user set password=? where name=? and password=?";
                PreparedStatement ps = con.prepareStatement(update);
                ps.setString(1,updatePassword);
                ps.setString(2,name);
                ps.setString(3,oldPassword);
                rs = ps.executeUpdate();
                if(rs>0)
                    success.setText("User Details Updated Successfully");
                else
                    success.setText("user Details not Updated");
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
