/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;
import Modelo.*;
import Config.*;
import Interfaces.*;
import java.sql.*;
import java.util.*;

import java.time.format.DateTimeFormatter; 
import java.time.*;


public class CarritoCompraDAO implements InterfazCarritoCompra{
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
   
    @Override
    public BoletaVenta CrearBoleta(double valor,PedidoVenta ped){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMM");  
        LocalDateTime d= LocalDateTime.now();
        String serie="EB-"+dtf.format(d);
        BoletaVenta dboleta =new BoletaVenta();
        
        String sql="INSERT INTO tbboletaventa(serieboleta,fkidpedido,fechaemision,total,impuesto) VALUES('"+serie+"',"+ped.getIdpedido()+",'"+d.toString()+"',"+valor+","+valor*0.18+");";
        
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
            dboleta.setNroboleta(contarnroboleta(serie));
            dboleta.setSerieboleta(serie);
            dboleta.setFkidpedido(ped.getIdpedido());
            dboleta.setFechaemision(d.toString());
            dboleta.setTotal(valor);
            dboleta.setImpuesto(valor*0.18);
            
            return dboleta;
        }
        catch(SQLException e){
            System.out.println("errorencrearboleta= "+e.toString());
            return null;
        }
        
      
    }
    
    public int contarnroboleta(String seriebolventa){
        String sql="SELECT nroboleta FROM tbboletaventa WHERE serieboleta='"+seriebolventa+"' ORDER BY nroboleta DESC LIMIT 1";
        
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
            
            return (Integer.parseInt(rs.getString("nroboleta")));
        }
        catch(SQLException e){
            System.out.println("errorEncontarboleta= "+e.toString());
            return 1;
        }
        
        
    }
 
    
    
    @Override
    public boolean InsertarDetalleBoleta(DetalleBolVenta dbv){
        
        String sql="INSERT INTO tbdetalledeboleta(fknroboleta,fkserieboleta,fkidrepuesto,cantidad,importe) values("+dbv.getFknroboleta()+",'"+dbv.getFkserieboleta()+"',"+dbv.getFkidrepuesto()+","+dbv.getCantidad()+","+dbv.getImporte()+")     ";
        
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("error= "+e.toString());
            return false;
        }
        return true;
      
    }
    
    public boolean mtdBajarcantidad(int id){
        
        String sql="update tbrepuesto set Cantidad=Cantidad-1 where idrepuesto="+id;
        
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            //cn.cerrar();
            
        }
        catch(SQLException e){
            System.out.println("error= "+e.toString());
            return false;
        }
        return true;
      
    }
    
    
    
}
