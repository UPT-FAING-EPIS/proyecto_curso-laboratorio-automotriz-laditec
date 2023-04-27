package ModeloDAO;

import Config.conexion;
import Interfaces.crudPedidoVenta;
import Modelo.PedidoVenta;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoVentaDAO implements crudPedidoVenta {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    private static Logger logger = Logger.getLogger("MyLog");

    @Override
    public List listar() {
        ArrayList<PedidoVenta> list = new ArrayList<>();
        String sql = "select * from tbpedidoventa";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                PedidoVenta ped = new PedidoVenta();
                ped.setIdpedido(Integer.parseInt(rs.getString("idpedidoventa")));
                ped.setIdusuario(Integer.parseInt(rs.getString("fkidusuario")));
                ped.setFecha(rs.getString("fecha"));
                ped.setEstado(rs.getString("estado"));
                ped.setTxrid(rs.getString("txrid"));
                ped.setLacchainid(rs.getString("lacchainid"));
                ped.setHash(rs.getString("hash"));
                list.add(ped);

            }

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
        }
        return list;
    }

    @Override
    public PedidoVenta list(int id) {
        String sql = "select * from tbpedidoventa where idpedidoventa=?";
        PedidoVenta ped = new PedidoVenta();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                ped.setIdpedido(Integer.parseInt(rs.getString("idpedidoventa")));
                ped.setIdusuario(Integer.parseInt(rs.getString("fkidusuario")));
                ped.setFecha(rs.getString("fecha"));
                ped.setEstado(rs.getString("estado"));
                ped.setTxrid(rs.getString("txrid"));
                ped.setLacchainid(rs.getString("txrid"));
                ped.setHash(rs.getString("hash"));
            }

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return null;
        }

        return ped;
    }

    @Override
    public boolean add(PedidoVenta ped) {
        String sql = "insert into tbpedidoventa(fkidusuario,fecha,estado) values(?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, ped.getIdusuario());
            ps.setString(2, ped.getFecha());
            ps.setString(3, ped.getEstado());

            ps.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return false;
        }
        return true;

    }

    public int contarpedidos() {
        String sql = "SELECT idpedidoventa FROM tbpedidoventa ORDER BY idpedidoventa DESC LIMIT 1";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            rs.next();

            return (Integer.parseInt(rs.getString("idpedidoventa"))) + 1;
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return 1;
        }

    }

    @Override
    public boolean edit(PedidoVenta ped) {
        String sql = "update tbpedidoventa set txrid=?, fkidusuario=?, fecha=?, estado=? where idpedidoventa=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, ped.getTxrid());
            ps.setInt(2, ped.getIdusuario());
            ps.setString(3, ped.getFecha());
            ps.setString(4, ped.getEstado());
            ps.setInt(5, ped.getIdpedido());
            
            ps.executeUpdate();
            

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return false;
        }
        return true;
    }
    

    public boolean mtdAsignarHash(PedidoVenta ped) {
        String sql = "update tbpedidoventa set txrid=?,lacchainid=?,hash=? where idpedidoventa=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, ped.getTxrid());
            ps.setString(2, ped.getLacchainid());
            ps.setString(3, ped.getHash());
            ps.setInt(4, ped.getIdpedido());
            
            ps.executeUpdate();
            

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return false;
        }
        return true;
    }

}
