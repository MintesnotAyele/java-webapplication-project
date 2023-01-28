
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dconnection {
 public static final String URL="jdbc:oracle:thin:@localhost:1521:xe"; 
 public static final String DRIVER="oracle.jdbc.driver.OracleDriver";
    static final String USER = "kanu_daye";
    static final String PASS = "161616";
 Connection conn=null;
 public Connection conMethod() throws ClassNotFoundException { 
 
     try {
         Class.forName(DRIVER);
         conn=DriverManager.getConnection(URL, USER, PASS);
        
     } catch (SQLException ex) {

     }
        return conn;

 }

         }
