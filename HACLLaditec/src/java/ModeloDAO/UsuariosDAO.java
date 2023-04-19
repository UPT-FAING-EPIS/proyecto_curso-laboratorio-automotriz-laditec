/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.conexion;
import Interfaces.crudUsuarios;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class UsuariosDAO implements crudUsuarios{
    
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
    @Override
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql="select * from tbusuario";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Usuario usu=new Usuario();
                usu.setIdusuario(Integer.parseInt(rs.getString("idusuario")));
                usu.setNomusuario(rs.getString("nomusuario"));
                usu.setEmail(rs.getString("email"));
                usu.setClave(rs.getString("clave"));
                usu.setFkidrol(Integer.parseInt(rs.getString("fkidrol")));
                usu.setEstado(rs.getString("estado"));
                list.add(usu);
            }
            
        }catch(SQLException e){
            System.out.println("error"+e.toString());
        }
        return list;
    }

    @Override
    public Modelo.Usuario list(int id) {
        String sql="select * from tbusuario where idusuario="+id;
        Usuario usu=new Usuario();
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                usu.setIdusuario(Integer.parseInt(rs.getString("idusuario")));
                usu.setNomusuario(rs.getString("nomusuario"));
                usu.setEmail(rs.getString("email"));
                usu.setClave(rs.getString("clave"));
                usu.setFkidrol(Integer.parseInt(rs.getString("fkidrol")));
                usu.setEstado(rs.getString("estado"));
                
            }
           
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return null;
        }
        
        return usu;
    }
    
    
    public boolean Updateintentos(String email) {
         
        String sql="Update tbusuario set intentos=intentos+1 WHERE email='"+email+"'";
        
        Usuario usu=new Usuario();
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
            return true;
            
           
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return false;
        }
        
    }
    
    public int sacarintentos(String email) {
        String sql="SELECT intentos FROM tbusuario where email='"+email+"'";
        
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
            
            return Integer.parseInt(rs.getString(1));
            
           
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return 0;
        }
        
    }
    
    public boolean DesactivarCuenta(String email) {
         
        String sql="Update tbusuario set estado='I' WHERE email='"+email+"'";
        
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
            
           
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return false;
        }
        
    }
    
    
    public boolean Updatebloqueos(String email) {
         
        String sql="Update tbusuario set bloqueos=bloqueos+1 WHERE email='"+email+"'";
        
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
            
           
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return false;
        }
        
    }
    
    
    
    
    @Override
    public boolean add(Usuario usu) {
                String sql="insert into tbusuario(nomusuario,email,clave,fkidrol,estado) values('"+usu.getNomusuario()+"','"+usu.getEmail()+"','"+usu.getClave()+"',"+usu.getFkidrol()+",'"+usu.getEstado()+"')";
        
        try{
            con=(Connection) cn.getConnection();
            st=con.createStatement();
            st.executeUpdate(sql);
                   
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return false;
        }
        return true;
    }
    

    @Override
    public boolean edit(Usuario usu) {
        String sql="update tbusuario set nomusuario='"+usu.getNomusuario()+"',email='"+usu.getEmail()+"',clave='"+usu.getClave()+"',fkidrol="+usu.getFkidrol()+",estado='"+usu.getEstado()+"'where idusuario="+usu.getIdusuario();
        
        try{
            con=(Connection) cn.getConnection();
            st=con.createStatement();
            st.executeUpdate(sql);
                   
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return false;
        }
        return true;
    }
    }




