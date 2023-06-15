/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.conexion;
import Interfaces.crudUsuarios;
import Modelo.Usuario;
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
public class UsuariosDAO implements crudUsuarios {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    private static Logger logger = Logger.getLogger("MyLog");

    @Override
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "select * from tbusuario";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setIdusuario(Integer.parseInt(rs.getString("idusuario")));
                usu.setNomusuario(rs.getString("nomusuario"));
                usu.setEmail(rs.getString("email"));
                usu.setClave(rs.getString("clave"));
                usu.setFkidrol(Integer.parseInt(rs.getString("fkidrol")));
                usu.setEstado(rs.getString("estado"));
                list.add(usu);
            }

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
        }
        return list;
    }

    @Override
    public Modelo.Usuario list(int id) {
        String sql = "select * from tbusuario where idusuario=?";
        Usuario usu = new Usuario();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                usu.setIdusuario(Integer.parseInt(rs.getString("idusuario")));
                usu.setNomusuario(rs.getString("nomusuario"));
                usu.setEmail(rs.getString("email"));
                usu.setClave(rs.getString("clave"));
                usu.setFkidrol(Integer.parseInt(rs.getString("fkidrol")));
                usu.setEstado(rs.getString("estado"));

            }

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return null;
        }

        return usu;
    }

    public boolean Updateintentos(String email) {

        String sql = "Update tbusuario set intentos=intentos+1 WHERE email=? ";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return false;
        }

    }

    public int sacarintentos(String email) {
        String sql = "SELECT intentos FROM tbusuario where email=? ";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            rs.next();

            return Integer.parseInt(rs.getString(1));

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return 0;
        }

    }

    public boolean DesactivarCuenta(String email) {

        String sql = "Update tbusuario set estado='I' WHERE email=? ";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();
           
            return true;

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return false;
        }

    }

    public boolean Updatebloqueos(String email) {

        String sql = "Update tbusuario set bloqueos=bloqueos+1 WHERE email=? ";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();
            
            
            return true;

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return false;
        }

    }

    @Override
    public boolean add(Usuario usu) {
        String sql = "insert into tbusuario(nomusuario,email,clave,fkidrol,estado) values(?,?,?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, usu.getNomusuario());
            ps.setString(2, usu.getEmail());
            ps.setString(3, usu.getClave());
            ps.setInt(4, usu.getFkidrol());
            ps.setString(5, usu.getEstado());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean edit(Usuario usu) {
        String sql = "update tbusuario set nomusuario=?,email=?,clave=?,fkidrol=?,estado=? where idusuario=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, usu.getNomusuario());
            ps.setString(2, usu.getEmail());
            ps.setString(3, usu.getClave());
            ps.setInt(4, usu.getFkidrol());
            ps.setString(5, usu.getEstado());
            ps.setInt(6, usu.getIdusuario());
            
            ps.executeUpdate();
            

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
            return false;
        }
        return true;
    }
}
