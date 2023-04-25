package Config;
import java.sql.*;

public class conexion {
    private static Connection cnx=null;
    
    public conexion(){
         try{
                Class.forName("com.mysql.jdbc.Driver");
                cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbladitec","root","EMML@98732");
            }catch(ClassNotFoundException | SQLException ex){
                System.out.println("Error conexion "+ex.getMessage());
            }
    }
    
    public Connection getConnection(){
        return this.cnx;
    }
    
    public static void cerrar() throws SQLException{
        if (cnx!=null){
            cnx.close();
        }
        
    }
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
