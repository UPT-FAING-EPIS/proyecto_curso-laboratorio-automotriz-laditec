/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.conexion;
import Interfaces.crudComentario;
import Modelo.Comentarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ComentariosDAO implements crudComentario{
    
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
    @Override
    public List listar() {
        ArrayList<Comentarios> list = new ArrayList<>();
        String sql="select * from tbcomentario order by idcomentario desc";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Comentarios com=new Comentarios();
                com.setIdcomentario(Integer.parseInt(rs.getString("idcomentario")));
                com.setNombre(rs.getString("nombre"));
                com.setDescripcion(rs.getString("descripcion"));
                com.setCalificacion(Integer.parseInt(rs.getString("calificacion")));
                list.add(com);
            }
            
        }catch(SQLException e){
            System.out.println("error"+e.toString());
        }
        return list;
    }

    @Override
    public Modelo.Comentarios list(int id) {
        String sql="select * from tbcomentario where idcomentario="+id;
        Comentarios com=new Comentarios();
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                com.setIdcomentario(Integer.parseInt(rs.getString("idcomentario")));
                com.setNombre(rs.getString("nombre"));
                com.setDescripcion(rs.getString("descipcion"));
                com.setCalificacion(Integer.parseInt(rs.getString("calificacion")));
            }
           
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return null;
        }
        
        return com;
    }

    @Override
    public boolean add(Comentarios com) {
        String sql="insert into tbcomentario values("+com.getIdcomentario()+",'"+com.getNombre()+"','"+com.getDescripcion()+"','"+com.getCalificacion()+"')";
        
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
    




