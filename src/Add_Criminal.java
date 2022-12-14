import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Add_Criminal implements ActionListener {
    static JFrame f;
    static JPanel panel;
    static JLabel fullName;
    static JTextField fullNameText;
    static JLabel genderLabel;
    static JComboBox<String> gender_option;
    static JLabel age;
    static JTextField ageText;
    static JLabel nationalityLabel;
    static JComboBox<String> Nationality;
    static JLabel offenseLabel;
    static JComboBox<String> typeofOffense;
    static JLabel fileNumber;
    static JTextField fileNumberText;
    static JLabel bailLabel;
    static JComboBox<String> BailOption;
    static JLabel jailLabel;
    static JComboBox<String> JailTerms;
    static JButton addCriminal;
    static JLabel success;
    public static void main() {
        f = new JFrame("Add Criminal");
        panel = new JPanel();
        f.setSize(400,520);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        panel.setLayout(null);

        JLabel title = new JLabel("Add Criminal Records");
        title.setBounds(110,20,300,15);
        title.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(title);

        fullName = new JLabel("Full Name");
        fullName.setBounds(80,60,80,25);
        panel.add(fullName);
        fullNameText = new JTextField(30);
        fullNameText.setBounds(160,60,100,25);
        panel.add(fullNameText);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(80,100,80,25);
        panel.add(genderLabel);
        String[] gender = {"Male","Female"};
        gender_option = new JComboBox<String>(gender);
        gender_option.setBounds(160,100,100,25);
        panel.add(gender_option);

        age = new JLabel("Age");
        age.setBounds(80,140,80,25);
        panel.add(age);
        ageText = new JTextField(10);
        ageText.setBounds(160,140,100,25);
        panel.add(ageText);

        nationalityLabel = new JLabel("Nationality");
        nationalityLabel.setBounds(80,180,80,25);
        panel.add(nationalityLabel);
        String[] CountryName = {"India","United States","united Kingdom","Sri Lanka"};
        Nationality = new JComboBox<String>(CountryName);
        Nationality.setBounds(160,180,100,25);
        panel.add(Nationality);

        offenseLabel = new JLabel("Offense");
        offenseLabel.setBounds(80,220,80,25);
        panel.add(offenseLabel);
        String[] Offense = {"Violent Crime","Property Crime","White-Collar Crime","Organized Crime","Consensual Crime","Victimless Crime"};
        typeofOffense = new JComboBox<String>(Offense);
        typeofOffense.setBounds(160,220,120,25);
        panel.add(typeofOffense);

        fileNumber = new JLabel("File Number");
        fileNumber.setBounds(80,260,80,25);
        panel.add(fileNumber);
        fileNumberText = new JTextField(10);
        fileNumberText.setBounds(160,260,100,25);
        panel.add(fileNumberText);

        bailLabel = new JLabel("Bail");
        bailLabel.setBounds(80,300,80,25);
        panel.add(bailLabel);
        String[] Bail = {"Yes","No"};
        BailOption = new JComboBox<String>(Bail);
        BailOption.setBounds(160,300,100,25);
        panel.add(BailOption);

        jailLabel = new JLabel("Jail Term");
        jailLabel.setBounds(80,340,80,25);
        panel.add(jailLabel);
        String[] Jail = {"1 - 5 Years","5 - 10 Years","10 - 25 Years","More than 30 Years"};
        JailTerms = new JComboBox<String>(Jail);
        JailTerms.setBounds(160,340,120,25);
        panel.add(JailTerms);

        addCriminal = new JButton("Add Criminal");
        addCriminal.setBounds(120,400,120,25);
        addCriminal.addActionListener(new Add_Criminal());
        panel.add(addCriminal);
        f.setVisible(true);

        success = new JLabel(" ");
        success.setBounds(120,425,300,25);
        panel.add(success);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = fullNameText.getText();
        String gender = gender_option.getSelectedItem().toString();
        String age = ageText.getText();
        String nationality = Nationality.getSelectedItem().toString();
        String offense = typeofOffense.getSelectedItem().toString();
        String fileNum = fileNumberText.getText();
        String bail = BailOption.getSelectedItem().toString();
        String jail = JailTerms.getSelectedItem().toString();
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
            String insert ="insert into criminal (name,gender,age,nationality,offense,fileNum,bail,jailTerm) values(?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setString(1,name);
            ps.setString(2,gender);
            ps.setString(3,age);
            ps.setString(4,nationality);
            ps.setString(5,offense);
            ps.setString(6,fileNum);
            ps.setString(7,bail);
            ps.setString(8,jail);
            rs = ps.executeUpdate();
            if(rs>0)
                success.setText("Signup Successful");
            else
                success.setText("Signup Failed");
        }
        catch (SQLException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }

    }
    void setvisible() {
        main();
        f.setVisible(true);
    }
}
