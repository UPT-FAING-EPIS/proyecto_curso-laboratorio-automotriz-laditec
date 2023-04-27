
package Config;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class conexion {
    private static Connection cnx=null;
    private static Logger logger = Logger.getLogger("MyLog");
    
    public conexion(){
         try{
                Class.forName("com.mysql.jdbc.Driver");
                cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbladitec","root","");
            }catch(ClassNotFoundException | SQLException ex){
                logger.log(Level.WARNING,ex.toString());
            }
    }
    
    public Connection getConnection(){
        return cnx;
    }
    
    public static void cerrar() throws SQLException{
        if (cnx!=null){
            cnx.close();
        }
        
    }
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
