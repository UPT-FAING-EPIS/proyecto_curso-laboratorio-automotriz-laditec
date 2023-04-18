/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.conexion;
import Interfaces.crudBoletaVenta;
import Modelo.BoletaVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.util.codec.binary.StringUtils;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BoletaVentaDAO implements crudBoletaVenta {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;

    @Override
    public List listar() {
        ArrayList<BoletaVenta> list = new ArrayList<>();
        String sql = "select * from tbboletaventa";
        try {
            con = (Connection) cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                BoletaVenta bolVen = new BoletaVenta();
                bolVen.setNroboleta(Integer.parseInt(rs.getString("nroboleta")));
                bolVen.setSerieboleta(rs.getString("serieboleta"));
                bolVen.setFkidpedido(Integer.parseInt(rs.getString("fkidpedido")));
                bolVen.setFechaemision(rs.getString("fechaemision"));
                bolVen.setTotal(Double.parseDouble(rs.getString("total")));
                bolVen.setImpuesto(Double.parseDouble(rs.getString("impuesto")));
                list.add(bolVen);
            }

        } catch (SQLException e) {
            System.out.println("error" + e.toString());
        }
        return list;
    }
    
    

}
