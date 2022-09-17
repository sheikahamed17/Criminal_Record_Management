package SQL_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SQL {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","root");
        if(con != null)
            System.out.println("Connected");
        else
            System.out.println("not Connected");

        Statement statement;
        statement = con.createStatement();
        ResultSet resultSet;
        resultSet = statement.executeQuery(
                "select * from testtable");
        int code;
        String name;
        while (resultSet.next()){
            code = resultSet.getInt("code");
            name = resultSet.getString("name").trim();
            System.out.println("Code: "+code+"\nName: "+name);
        }
        resultSet.close();
        statement.close();
    }
}
