import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    static JFrame f;
    static JPanel panel;
    static JButton addCriminal;
    static JButton updateCriminal;
    static JButton deleteCriminal;
    static JButton editUser;
    static JButton deleteUser;
    static JButton exit;
    static ImageIcon addCriminalIcon;
    static ImageIcon updateCriminalIcon;
    static ImageIcon deleteCriminalIcon;
    static ImageIcon editUserIcon;
    static ImageIcon deleteUserIcon;
    static ImageIcon exitIcon;
    static JLabel addCriminalLabel;
    static JLabel updateCriminalLabel;
    static JLabel deleteCriminalLabel;
    static JLabel editUserLabel;
    static JLabel deleteUserLabel;
    static JLabel exitLabel;
    public static void main(String[] args) {
        f = new JFrame();
        panel = new JPanel();
        f.setSize(600,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        panel.setLayout(null);

        addCriminalLabel = new JLabel("");
        addCriminalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addCriminalLabel.setBounds(30, 60, 169, 125);
        addCriminalIcon = new ImageIcon("images\\addCriminal.png");
        addCriminalIcon.setImage(addCriminalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        addCriminalLabel.setIcon(addCriminalIcon);
        panel.add(addCriminalLabel);

        updateCriminalLabel = new JLabel("");
        updateCriminalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateCriminalLabel.setBounds(200, 60, 169, 125);
        updateCriminalIcon = new ImageIcon("images\\editCriminal.png");
        updateCriminalIcon.setImage(updateCriminalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        updateCriminalLabel.setIcon(updateCriminalIcon);
        panel.add(updateCriminalLabel);

        deleteCriminalLabel = new JLabel("");
        deleteCriminalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        deleteCriminalLabel.setBounds(400, 60, 169, 125);
        deleteCriminalIcon = new ImageIcon("images\\deleteCriminal.png");
        deleteCriminalIcon.setImage(deleteCriminalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        deleteCriminalLabel.setIcon(deleteCriminalIcon);
        panel.add(deleteCriminalLabel);

        addCriminal = new JButton("Add Criminal");
        addCriminal.setBounds(65, 190, 100, 25);
        addCriminal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Criminal a = new Add_Criminal();
                a.setvisible();
            }
        });
        panel.add(addCriminal);

        updateCriminal = new JButton("Update Criminal");
        updateCriminal.setBounds(230, 190, 100, 25);
        updateCriminal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update_Criminal u = new Update_Criminal();
                u.setvisible();
            }
        });
        panel.add(updateCriminal);

        deleteCriminal = new JButton("Delete Criminal");
        deleteCriminal.setBounds(430, 190, 100, 25);
        deleteCriminal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_Criminal d = new delete_Criminal();
                d.setvisible();
            }
        });
        panel.add(deleteCriminal);

        editUserLabel = new JLabel("");
        editUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        editUserLabel.setBounds(30, 250, 169, 125);
        editUserIcon = new ImageIcon("images\\editUser.png");
        editUserIcon.setImage(editUserIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        editUserLabel.setIcon(editUserIcon);
        panel.add(editUserLabel);

        deleteUserLabel = new JLabel("");
        deleteUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        deleteUserLabel.setBounds(200, 250, 169, 125);
        deleteUserIcon = new ImageIcon("images\\deleteUser.png");
        deleteUserIcon.setImage(deleteUserIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        deleteUserLabel.setIcon(deleteUserIcon);
        panel.add(deleteUserLabel);

        exitLabel = new JLabel("");
        exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        exitLabel.setBounds(400, 250, 169, 125);
        exitIcon = new ImageIcon("images\\exit.jpeg");
        exitIcon.setImage(exitIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        exitLabel.setIcon(exitIcon);
        panel.add(exitLabel);

        editUser = new JButton("Edit User");
        editUser.setBounds(65, 380, 100, 25);
        editUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditUser e1 = new EditUser();
                e1.setvisible();
            }
        });
        panel.add(editUser);

        deleteUser = new JButton("Delete User");
        deleteUser.setBounds(230, 380, 100, 25);
        deleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_user d = new delete_user();
                d.setvisible();
            }
        });
        panel.add(deleteUser);

        exit = new JButton("Exit");
        exit.setBounds(430, 380, 100, 25);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exit);


        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
