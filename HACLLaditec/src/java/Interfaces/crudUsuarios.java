package Interfaces;
import java.util.List;
import Modelo.Usuario;
public interface crudUsuarios {
    public List listar();
    public Usuario list(int idusuario);
    public boolean add(Usuario usu);
    public boolean edit(Usuario usu);
}
