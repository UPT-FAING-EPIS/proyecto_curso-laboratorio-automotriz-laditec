/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.conexion;
import Interfaces.crudRepuesto;
import Modelo.Repuesto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class RepuestoDAO implements crudRepuesto {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    private static Logger logger = Logger.getLogger("MyLog");

    @Override
    public List listar() {

        ArrayList<Repuesto> list = new ArrayList<>();
        String sql = "select * from tbrepuesto";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Repuesto rep = new Repuesto();
                rep.setIdrepuesto(Integer.parseInt(rs.getString("idrepuesto")));
                rep.setFkidalmacen(Integer.parseInt(rs.getString("fkidalmacen")));
                rep.setFkidestado(Integer.parseInt(rs.getString("fkidestado")));
                rep.setNombre(rs.getString("nombre"));
                rep.setFkidcategoria(Integer.parseInt(rs.getString("fkidcategoria")));
                rep.setImagen(rs.getString("imagen"));
                rep.setPreciounitario(Double.parseDouble(rs.getString("preciounitario")));
                rep.setCantidad(Integer.parseInt(rs.getString("Cantidad")));
                list.add(rep);
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
        }
        return list;
    }

    @Override
    public Repuesto list(int id) {

        String sql = "select * from tbrepuesto where idrepuesto= ?";
        Repuesto rep = new Repuesto();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {

                rep.setIdrepuesto(Integer.parseInt(rs.getString("idrepuesto")));
                rep.setFkidalmacen(Integer.parseInt(rs.getString("fkidalmacen")));
                rep.setFkidestado(Integer.parseInt(rs.getString("fkidestado")));
                rep.setNombre(rs.getString("nombre"));
                rep.setFkidcategoria(Integer.parseInt(rs.getString("fkidcategoria")));
                rep.setImagen(rs.getString("imagen"));
                rep.setPreciounitario(Double.parseDouble(rs.getString("preciounitario")));
                rep.setCantidad(Integer.parseInt(rs.getString("cantidad")));
            }

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return null;
        }
        return rep;

    }

    @Override
    public boolean add(Repuesto rep) {

        String sql = "insert into tbrepuesto values( ? , ? , ? , ? , ? , ? , ? , ? )";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, rep.getIdrepuesto());
            ps.setInt(2, rep.getFkidalmacen());
            ps.setInt(3, rep.getFkidestado());
            ps.setString(4, rep.getNombre());
            ps.setInt(5, rep.getFkidcategoria());
            ps.setString(6, rep.getImagen());
            ps.setDouble(7, rep.getPreciounitario());
            ps.setInt(8, rep.getCantidad());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            logger.log(Level.WARNING, ex.toString());
        }

        return true;
    }

    @Override
    public boolean edit(Repuesto rep) {

        String sql = "update tbrepuesto set Cantidad=?, fkidalmacen=?, fkidestado= ?,nombre=?,fkidcategoria=?,imagen=?, preciounitario=? where idrepuesto=?";

        try {
            con = cn.getConnection();
            
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, rep.getCantidad());
            ps.setInt(2, rep.getFkidalmacen());
            ps.setInt(3, rep.getFkidestado());
            ps.setString(4, rep.getNombre());
            ps.setInt(5, rep.getFkidcategoria());
            ps.setString(6, rep.getImagen());
            ps.setDouble(7, rep.getPreciounitario());
            ps.setInt(8, rep.getIdrepuesto());
            
            ps.executeUpdate();
            

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return false;
        }
        return true;

    }

}
