
package managementparksystems.connections;

import java.sql.*;


/**
 *
 * @author Volkan
 */
public class DbConnection{
    private final String URL = "jdbc:mysql://localhost:3306/eldys?useUnicode=true&characterEncoding=UTF-8";
    private final String USER = "root";
    private final String PASS = "12345";
    
 
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);
    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Error: "+exception.getMessage());
        System.out.println("Error Code: "+exception.getErrorCode());
    }
}