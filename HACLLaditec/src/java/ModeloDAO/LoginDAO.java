/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Modelo.*;
import Config.*;
import Interfaces.interfazLogin;
import Modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO implements interfazLogin{
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
     @Override
    public Usuario loginUsuario(String user, String clave) {
        
        Usuario objuser=new Usuario();
        String sql="select * from tbusuario where email='"+user+"' and clave='"+clave+"' ";
        
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs!=null){
            
            while(rs.next()){
                objuser.setIdusuario(Integer.parseInt(rs.getString("idusuario")));
                objuser.setNomusuario(rs.getString("nomusuario"));
                objuser.setEmail(rs.getString("email"));
                objuser.setClave(rs.getString("clave"));
                objuser.setFkidrol(Integer.parseInt(rs.getString("fkidrol")));
                objuser.setEstado(rs.getString("estado"));
                objuser.setIntentos(Integer.parseInt(rs.getString("intentos")));
                
                return objuser;
            }
            
            
            }
            
        }catch(SQLException e){
            System.out.println("error"+e.toString());
        }
        return null;
    }
    
}
