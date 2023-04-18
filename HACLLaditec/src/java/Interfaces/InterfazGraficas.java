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
public interface InterfazGraficas {
    public ResultSet total()throws SQLException;
    public ResultSet cantidad()throws SQLException;
    public ResultSet Ganancias()throws SQLException;
}
