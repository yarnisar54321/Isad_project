import java.sql.*;
//connect DATABASE, fetch data through SELECT
public class SQLconnect {
    public Connection cnt = null;
    public Statement stm;
    public ResultSet result;
    
    private String url = "jdbc:mysql://localhost:";
    private String username = "root";
    private String password = "";
    
    public void getConnect(String sql){
        try {
            cnt = DriverManager.getConnection(url, username, password);
            stm = cnt.createStatement();
            result = stm.executeQuery(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getUpdate(String sql){
        try {
            stm = cnt.createStatement();
            stm.executeUpdate(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void disconnect(){
        try {
            stm.close();
            cnt.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}