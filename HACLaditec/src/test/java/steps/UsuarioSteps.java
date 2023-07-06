/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import Modelo.Usuario;
import ModeloDAO.UsuariosDAO;
import Config.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author hp
 */
public class UsuarioSteps {
    private UsuariosDAO usuariosDAO;
    private Usuario usuario;
    private Connection connection;
    private boolean resultadoOperacion;

    @Given("un usuario con idusuario {int}")
    public void un_usuario_con_idusuario(int id) {
        this.usuariosDAO = new UsuariosDAO();
        try {
            conexion cn = new conexion();
            this.connection = cn.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        usuario = new Usuario();
        usuario.setIdusuario(id);
        usuario.setNomusuario("Usuario Prueba");
        usuario.setEmail("usuario@test.com");
        usuario.setClave("clave123");
        usuario.setFkidrol(1); // Debes reemplazar este valor por un rol válido en tu sistema.
        usuario.setEstado("A");
    }

    @When("se agrega un usuario con idusuario {int}")
    public void se_agrega_un_usuario_con_idusuario(int id) {
        resultadoOperacion = usuariosDAO.add(usuario);
    }

    @Then("debo ver un mensaje de exito que indica que el usuario ha sido creado")
    public void debo_ver_un_mensaje_de_exito_que_indica_que_el_usuario_ha_sido_creado() {
        Assert.assertTrue(resultadoOperacion);
    }

    @Given("se ha agregado un usuario")
    public void se_ha_agregado_un_usuario() {
        this.usuariosDAO = new UsuariosDAO();
        try {
            conexion cn = new conexion();
            this.connection = cn.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Aquí debes agregar un usuario a tu base de datos usando `usuariosDAO`.
        // Como no proporcionaste detalles sobre el usuario, he utilizado datos ficticios.
        usuario = new Usuario();
        usuario.setNomusuario("Usuario Prueba");
        usuario.setEmail("usuario@test.com");
        usuario.setClave("clave123");
        usuario.setFkidrol(1); // Debes reemplazar este valor por un rol válido en tu sistema.
        usuario.setEstado("A");
        
        resultadoOperacion = usuariosDAO.add(usuario);
    }

    @When("se lista los usuarios")
    public void se_lista_los_usuarios() {
        List<Usuario> usuarios = usuariosDAO.listar();
        resultadoOperacion = (usuarios != null && !usuarios.isEmpty());
    }

    @Then("se muestra la lista de usuarios")
    public void se_muestra_la_lista_de_usuarios() {
        Assert.assertTrue(resultadoOperacion);
    }

    @When("se edita el usuario con idusuario {int}, nueva clave {string} y nuevo estado {string}")
    public void se_edita_el_usuario_con_idusuario_nueva_clave_y_nuevo_estado(int idusuario, String clave, String estado) {
        this.usuario.setClave(clave);
        this.usuario.setEstado(estado);
        this.resultadoOperacion = this.usuariosDAO.edit(this.usuario);
    }

    @Then("el usuario se edita correctamente")
    public void el_usuario_se_edita_correctamente() {
        Assert.assertTrue(this.resultadoOperacion);
    }
}
