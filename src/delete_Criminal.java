import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class delete_Criminal implements ActionListener {
    static JFrame f;
    static JPanel panel;
    static JLabel fullName;
    static JTextField fullNameText;
    static JLabel fileNumber;
    static JTextField fileNumberText;
    static JLabel success;
    public static void main(String[] args) {
        f = new JFrame("Delete Criminal");
        panel = new JPanel();
        f.setSize(400,250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        panel.setLayout(null);

        JLabel title = new JLabel("Delete Criminal Records");
        title.setBounds(110,20,300,15);
        title.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(title);

        fullName = new JLabel("Full Name");
        fullName.setBounds(80,60,80,25);
        panel.add(fullName);
        fullNameText = new JTextField(30);
        fullNameText.setBounds(160,60,100,25);
        panel.add(fullNameText);

        fileNumber = new JLabel("File Number");
        fileNumber.setBounds(80,100,80,25);
        panel.add(fileNumber);
        fileNumberText = new JTextField(10);
        fileNumberText.setBounds(160,100,100,25);
        panel.add(fileNumberText);

        JButton deleteCriminal = new JButton("Delete Criminal");
        deleteCriminal.setBounds(120,140,125,25);
        deleteCriminal.addActionListener(new delete_Criminal());
        panel.add(deleteCriminal);

        success = new JLabel(" ");
        success.setBounds(120,175,300,25);
        panel.add(success);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = fullNameText.getText();
        String fileNum = fileNumberText.getText();
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
            String check ="Select * from criminal where name=? and fileNum=?;";
            PreparedStatement ps = con.prepareStatement(check);
            ps.setString(1,name);
            ps.setString(2,fileNum);
            rs = ps.executeQuery();
            while (rs.next()){
                String getName = rs.getString("name");
                String getFileNum = rs.getString("fileNum");
                if (name.equals(getName) && fileNum.equals(getFileNum)){
                    int i;
                    String delete = "Delete from criminal where name=? and fileNum=?;";
                    PreparedStatement ps1 = con.prepareStatement(delete);
                    ps1.setString(1,name);
                    ps1.setString(2,fileNum);
                    i = ps1.executeUpdate();
                    if(i >0)
                        success.setText("Criminal Deleted Successfully");
                    else
                        success.setText("Criminal Not Found");
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
