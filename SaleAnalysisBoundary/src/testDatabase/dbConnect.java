package testDatabase;
import java.sql.*;
public class dbConnect {
    public Connection cnt = null;
    public Statement stm;
    public ResultSet rs;

    private final String url = "jdbc:mysql://localhost:3306/inv";
    private final String user = "root";
    private final String password = "2245";

    public ResultSet getConnect(String sql) {
        try{
            cnt = DriverManager.getConnection(url,user,password);
            stm = cnt.createStatement();
            rs = stm.executeQuery(sql);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public void connect() {
        try{
            cnt = DriverManager.getConnection(url,user,password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void getUpdate(String sql) {
        try{
            stm = cnt.createStatement();
            stm.executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void disconnect() {
        try {
            stm.close();
            cnt.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
