/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;
import Interfaces.crudPedidoVenta;
import Modelo.PedidoVenta;
import java.util.*;
import java.sql.*;
import Config.*;
import java.util.ArrayList;
/**
 *
 * @author Helbert Condori Loayza
 */
public class PedidoVentaDAO implements crudPedidoVenta{
    
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
   
    @Override
    public List listar() {
        ArrayList<PedidoVenta> list=new ArrayList<>();
        String sql="select * from tbpedidoventa";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                PedidoVenta ped=new PedidoVenta();
                ped.setIdpedido(Integer.parseInt(rs.getString("idpedidoventa")));
                ped.setIdusuario(Integer.parseInt(rs.getString("fkidusuario")));
                ped.setFecha(rs.getString("fecha"));
                ped.setEstado(rs.getString("estado"));
                ped.setTxrid(rs.getString("txrid"));
                ped.setLacchainid(rs.getString("lacchainid"));
                ped.setHash(rs.getString("hash"));
                list.add(ped);
                
            }
            
        }catch(SQLException e){
            System.out.println("error"+e.toString());
        }
        return list;
    }

    
    @Override
    public PedidoVenta list(int id) {
        String sql="select * from tbpedidoventa where idpedidoventa="+id;
        PedidoVenta ped=new PedidoVenta();
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                ped.setIdpedido(Integer.parseInt(rs.getString("idpedidoventa")));
                ped.setIdusuario(Integer.parseInt(rs.getString("fkidusuario")));
                ped.setFecha(rs.getString("fecha"));
                ped.setEstado(rs.getString("estado"));
                ped.setTxrid(rs.getString("txrid"));
                ped.setLacchainid(rs.getString("txrid"));
                ped.setHash(rs.getString("hash"));
            }
           
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return null;
        }
        
        return ped;
    }

    @Override
    public boolean add(PedidoVenta ped) {
        String sql="insert into tbpedidoventa(fkidusuario,fecha,estado) values("+ped.getIdusuario()+",'"+ped.getFecha()+"','"+ped.getEstado()+"')";
        
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
    
    public int contarpedidos(){
        String sql="SELECT idpedidoventa FROM tbpedidoventa ORDER BY idpedidoventa DESC LIMIT 1";
        
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
            
            return (Integer.parseInt(rs.getString("idpedidoventa")))+1;
        }
        catch(SQLException e){
            System.out.println("error");
            return 1;
        }
        
    }

    @Override
    public boolean edit(PedidoVenta ped) {
        String sql="update tbpedidoventa set txrid='"+ped.getTxrid()+"', fkidusuario="+ped.getIdusuario()+",fecha='"+ped.getFecha()+"',estado='"+ped.getEstado()+"' where idpedidoventa="+ped.getIdpedido();
        
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
    
    
    public boolean mtdAsignarHash(PedidoVenta ped) {
        String sql="update tbpedidoventa set txrid='"+ped.getTxrid()+"',lacchainid='"+ped.getLacchainid()+"',hash='"+ped.getHash()+"' where idpedidoventa="+ped.getIdpedido();
        
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
