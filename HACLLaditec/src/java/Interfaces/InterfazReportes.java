/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author
 */
public interface InterfazReportes {
    
    public ResultSet totalClientesl()throws SQLException;
    public ResultSet totalVentas()throws SQLException;
    public ResultSet totaVentasHoyl()throws SQLException;
    public ResultSet RepuestosVen()throws SQLException;
    public ResultSet totalDia()throws SQLException;
    public ResultSet totalMes()throws SQLException;
    public ResultSet totalAnio()throws SQLException;
}
