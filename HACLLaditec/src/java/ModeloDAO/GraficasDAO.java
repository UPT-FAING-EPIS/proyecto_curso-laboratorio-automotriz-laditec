/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.conexion;
import Interfaces.InterfazGraficas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GraficasDAO implements InterfazGraficas{

    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

@Override
public ResultSet total() throws SQLException {
    String sql="SELECT round(SUM(total)-SUM(impuesto),2) AS Ganancia FROM tbboletaventa;";
    try{
        con=(Connection) cn.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        return rs;
    }   
    catch(SQLException e){
        return null;
    }
}
    
@Override
    public ResultSet cantidad()throws SQLException {

        String sql="SELECT r.nombre,sum(d.cantidad) AS cantidad FROM tbdetalledeboleta AS d JOIN tbrepuesto AS r on d.fkidrepuesto=r.idrepuesto JOIN tbboletaventa AS b ON b.nroboleta=d.fknroboleta AND b.serieboleta=d.fkserieboleta WHERE b.fechaemision BETWEEN DATE_SUB(NOW(),INTERVAL 7 DAY) AND DATE_SUB(NOW(),INTERVAL 0 DAY) GROUP BY r.nombre;";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            return rs;
        }   
        catch(SQLException e){
            return null;
        }

    }

    @Override
    public ResultSet Ganancias() throws SQLException {
        String sql="SELECT DATE_FORMAT(fechaemision,'%M %e') AS fechaemision, round(SUM(total)-SUM(impuesto),2) AS venta FROM tbboletaventa GROUP BY 1 ORDER BY 1 DESC";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            return rs;
        }   
        catch(SQLException e){
            return null;
        }
    }
}
