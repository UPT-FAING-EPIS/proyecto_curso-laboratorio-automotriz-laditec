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

public class RepuestoDAO implements crudRepuesto{
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
    @Override
    public List listar() {
    
        ArrayList<Repuesto> list=new ArrayList<>();
        String sql="select * from tbrepuesto";
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Repuesto rep=new Repuesto();
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
        }catch(SQLException e){
            System.out.println("error"+e.toString());
        }
        return list;
    }

    @Override
    public Repuesto list(int id) {

        String sql="select * from tbrepuesto where idrepuesto= "+id;
        Repuesto rep=new Repuesto();
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
               
                rep.setIdrepuesto(Integer.parseInt(rs.getString("idrepuesto")));
                rep.setFkidalmacen(Integer.parseInt(rs.getString("fkidalmacen")));
                rep.setFkidestado(Integer.parseInt(rs.getString("fkidestado")));
                rep.setNombre(rs.getString("nombre"));
                rep.setFkidcategoria(Integer.parseInt(rs.getString("fkidcategoria")));
                rep.setImagen(rs.getString("imagen"));
                rep.setPreciounitario(Double.parseDouble(rs.getString("preciounitario")));
                rep.setCantidad(Integer.parseInt(rs.getString("cantidad")));
            }
           
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return null;
        }        
        return rep;

    }

    @Override
    public boolean add(Repuesto rep) {

        String sql="insert into tbrepuesto values( "+rep.getIdrepuesto()+" , "+rep.getFkidalmacen()+" , "+rep.getFkidestado()+" ,'"+rep.getNombre()+"' ,"+rep.getFkidcategoria()+",'"+rep.getImagen()+"',  "+rep.getPreciounitario()+","+rep.getCantidad()+")";
        
        try{
            con=(Connection) cn.getConnection();
            st=con.createStatement();
            st.executeUpdate(sql);
                   
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return false;
        }
        return true;
        

    }

    @Override
    public boolean edit(Repuesto rep) {

        String sql="update tbrepuesto set Cantidad="+rep.getCantidad()+", fkidalmacen="+rep.getFkidalmacen()+", fkidestado= "+rep.getFkidestado()+",nombre='"+rep.getNombre()+"',fkidcategoria="+rep.getFkidcategoria()+",imagen='"+rep.getImagen()+"',preciounitario="+rep.getPreciounitario()+" where idrepuesto="+rep.getIdrepuesto();
        
        try{
            con=(Connection) cn.getConnection();
            st=con.createStatement();
            st.executeUpdate(sql);
                   
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return false;
        }
        return true;
    }
}
