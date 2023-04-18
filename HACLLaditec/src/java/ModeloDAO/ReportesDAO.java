/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.conexion;
import Interfaces.InterfazReportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class ReportesDAO implements InterfazReportes {

    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;   

    @Override
    public ResultSet totalClientesl() throws SQLException {
        String sql="SELECT COUNT(nomusuario) AS tusuarios FROM tbusuario WHERE fkidrol='1';";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            return rs;
        }   
        catch(SQLException e){
            return null;
        }    }

    @Override
    public ResultSet totalVentas() throws SQLException {
        String sql="SELECT COUNT(*) AS tventas FROM tbboletaventa;";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            return rs;
        }   
        catch(SQLException e){
            return null;
        }    }

    @Override
    public ResultSet totaVentasHoyl() throws SQLException {
        String sql="SELECT COUNT(fechaemision) AS ventash FROM tbboletaventa WHERE fechaemision = DATE_FORMAT(DATE_SUB(NOW(),INTERVAL 5 HOUR),'%Y-%m-%d')  LIMIT 1;";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            return rs;
        }   
        catch(SQLException e){
            return null;
        }    }

    @Override
    public ResultSet RepuestosVen() throws SQLException {
        String sql="SELECT sum(d.cantidad) AS trep FROM tbdetalledeboleta AS d JOIN tbrepuesto AS r on d.fkidrepuesto=r.idrepuesto JOIN tbboletaventa AS b ON b.nroboleta=d.fknroboleta AND b.serieboleta=d.fkserieboleta;";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            return rs;
        }   
        catch(SQLException e){
            return null;
        }    }

    @Override
    public ResultSet totalDia() throws SQLException {
        String sql="SELECT DATE_FORMAT(DATE_SUB(NOW(),INTERVAL 5 HOUR),'%e') AS hoy,round(sum(total)-SUM(impuesto),2) AS vhoy FROM tbboletaventa WHERE fechaemision = DATE_FORMAT(DATE_SUB(NOW(),INTERVAL 5 HOUR),'%Y-%m-%d') LIMIT 1;";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            return rs;
        }   
        catch(SQLException e){
            return null;
        }    }

    @Override
    public ResultSet totalMes() throws SQLException {
        String sql="SELECT MONTHNAME(DATE_SUB(NOW(),INTERVAL 5 HOUR)) AS mes, round(sum(total)-SUM(impuesto),2) AS vmes FROM tbboletaventa WHERE MONTH(fechaemision) = MONTH(DATE_SUB(NOW(),INTERVAL 5 HOUR));";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            return rs;
        }   
        catch(SQLException e){
            return null;
        }    }

    @Override
    public ResultSet totalAnio() throws SQLException {
        String sql="SELECT YEAR(CURDATE()) AS anio, round(sum(total)-SUM(impuesto),2) AS vanio FROM tbboletaventa WHERE YEAR(fechaemision) = YEAR(CURDATE());";
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
