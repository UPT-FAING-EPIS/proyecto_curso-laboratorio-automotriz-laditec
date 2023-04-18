/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.conexion;
import Interfaces.crudDetalleBolVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Modelo.DetalleBolVenta;




public class DetalleBolVentaDAO implements crudDetalleBolVenta{
    
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    @Override
    public boolean addcarrito(DetalleBolVenta dbv){
        String sql="insert into tbdetalledeboleta values("+dbv.getFknroboleta()+",'"+dbv.getFkserieboleta()+"','"+dbv.getFkidrepuesto()+"','"+dbv.getCantidad()+"','"+dbv.getImporte()+"')";
        
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
    public List listar() {
        ArrayList<DetalleBolVenta> list=new ArrayList<>();
        String sql="select * from tbdetalledeboleta";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                DetalleBolVenta dbv=new DetalleBolVenta();
                dbv.setIddetalleboleta(Integer.parseInt(rs.getString("iddetalleboleta")));
                dbv.setFkserieboleta(rs.getString("fkserieboleta"));
                dbv.setFknroboleta(Integer.parseInt(rs.getString("fknroboleta")));
                dbv.setFkidrepuesto(Integer.parseInt(rs.getString("fkidrepuesto")));
                dbv.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                dbv.setImporte(Double.parseDouble(rs.getString("importe")));
                list.add(dbv);
            }
            
        }catch(SQLException e){
            System.out.println("error"+e.toString());
        }
        return list;
    }

    @Override
    public Modelo.DetalleBolVenta list(int id) {
        String sql="select * from tbdetalledeboleta where iddetalleboleta="+id;
        DetalleBolVenta dbv=new DetalleBolVenta();
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                dbv.setIddetalleboleta(Integer.parseInt(rs.getString("iddetalleboleta")));
                dbv.setFkserieboleta(rs.getString("fkserieboleta"));
                dbv.setFknroboleta(Integer.parseInt(rs.getString("fknroboleta")));
                dbv.setFkidrepuesto(Integer.parseInt(rs.getString("fkidrepuesto")));
                dbv.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                dbv.setImporte(Double.parseDouble(rs.getString("importe")));
                
            }
           
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return null;
        }
        
        return dbv;
    }
    
    public List mtdlistboleta(int fknroboleta,String fkserieboleta) {
        ArrayList<DetalleBolVenta> list=new ArrayList<>();
        String sql="select * from tbdetalledeboleta where fknroboleta="+fknroboleta+" and fkserieboleta='"+fkserieboleta+"'";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                DetalleBolVenta dbv=new DetalleBolVenta();
                dbv.setIddetalleboleta(Integer.parseInt(rs.getString("iddetalleboleta")));
                dbv.setFkserieboleta(rs.getString("fkserieboleta"));
                dbv.setFknroboleta(Integer.parseInt(rs.getString("fknroboleta")));
                dbv.setFkidrepuesto(Integer.parseInt(rs.getString("fkidrepuesto")));
                dbv.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                dbv.setImporte(Double.parseDouble(rs.getString("importe")));
                list.add(dbv);
            }
            
        }catch(SQLException e){
            System.out.println("error"+e.toString());
        }
        return list;
    }
    
    
    
    
    
    @Override
    public List listarby(int id,String as) {
        ArrayList<DetalleBolVenta> list=new ArrayList<>();
        String sql="select * from tbdetalledeboleta where fknroboleta="+id+" and fkserieboleta"+as;
        DetalleBolVenta dbv=new DetalleBolVenta();
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                dbv.setIddetalleboleta(Integer.parseInt(rs.getString("iddetalleboleta")));
                dbv.setFkserieboleta(rs.getString("fkserieboleta"));
                dbv.setFknroboleta(Integer.parseInt(rs.getString("fknroboleta")));
                dbv.setFkidrepuesto(Integer.parseInt(rs.getString("fkidrepuesto")));
                dbv.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                dbv.setImporte(Double.parseDouble(rs.getString("importe")));
                list.add(dbv);
            }
           
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return null;
        }
        
        return list;
    }
    

    @Override
    public boolean add(DetalleBolVenta dbv) {
        String sql="insert into tbdetalledeboleta values("+dbv.getIddetalleboleta()+","+dbv.getFknroboleta()+",'"+dbv.getFkserieboleta()+"',"+dbv.getFkidrepuesto()+","+dbv.getCantidad()+","+dbv.getImporte()+")";
        
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
    public boolean edit(DetalleBolVenta dbv) {
        String sql="update tbdetalledeboleta set fkserieboleta='"+dbv.getFkserieboleta()+"',fknroboleta="+dbv.getFknroboleta()+",fkidrepuesto="+dbv.getFkidrepuesto()+",cantidad="+dbv.getCantidad()+",importe="+dbv.getImporte()+" where iddetalleboleta="+dbv.getIddetalleboleta();
        
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
