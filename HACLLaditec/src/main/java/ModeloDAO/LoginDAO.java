package ModeloDAO;

import Config.conexion;
import Interfaces.interfazLogin;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO implements interfazLogin {
    private conexion cn;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;
    private static Logger logger = Logger.getLogger("MyLog");

    public LoginDAO() {
        cn = new conexion();
    }

    public void setConnection(Connection con) {
        this.con = con;
    }

    @Override
    public Usuario loginUsuario(String user, String clave) {
        Usuario objuser = new Usuario();
        String sql = "SELECT * FROM tbusuario WHERE email=? AND clave=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    objuser.setIdusuario(Integer.parseInt(rs.getString("idusuario")));
                    objuser.setNomusuario(rs.getString("nomusuario"));
                    objuser.setEmail(rs.getString("email"));
                    objuser.setClave(rs.getString("clave"));
                    objuser.setFkidrol(Integer.parseInt(rs.getString("fkidrol")));
                    objuser.setEstado(rs.getString("estado"));
                    objuser.setIntentos(Integer.parseInt(rs.getString("intentos")));
                    return objuser;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
        }
        return null;
    }
}
