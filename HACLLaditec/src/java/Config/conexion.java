package Config;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class conexion {
    private  Connection conect=null;
    private static Logger logger = Logger.getLogger("MyLog");
    
    public conexion(){
         try{
                Class.forName("com.mysql.jdbc.Driver");
                String password = System.getenv("DB_PASSWORD");
                conect= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbladitec", "arryes", password);
            }catch(ClassNotFoundException | SQLException ex){
                logger.log(Level.WARNING,ex.toString());
            }
    }
    
    public Connection getConnection(){
        return conect;
    }
    public void cerrarConexion() throws SQLException {
    if (conect != null) {
        conect.close();
    }
}
   
}
