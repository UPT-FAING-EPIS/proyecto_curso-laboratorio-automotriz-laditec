package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import Modelo.Usuario;
import ModeloDAO.LoginDAO;
import Config.conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginSteps {
    private Usuario usuario;
    private LoginDAO loginDAO;
    private Connection connection;
    private boolean inicioSesionExitoso;

    @Given("Soy un usuario registrado en el sistema")
    public void soy_un_usuario_registrado_en_el_sistema() {
        this.loginDAO = new LoginDAO();
        try {
            conexion cn = new conexion();
            this.connection = cn.getConnection();
            this.loginDAO.setConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @When("ingreso con mis credenciales de inicio de sesion validas {string} y {string}")
    public void ingreso_con_mis_credenciales_de_inicio_de_sesion_validas(String email, String clave) {
        usuario = loginDAO.loginUsuario(email, clave);
        inicioSesionExitoso = (usuario != null);
    }

    @Then("se inicia sesión exitosamente")
    public void se_inicia_sesion_exitosamente() {
        if (inicioSesionExitoso) {
            System.out.println("Inicio de sesión exitoso");
        } else {
            System.out.println("Inicio de sesión fallido");
        }
        Assert.assertTrue(inicioSesionExitoso);
    }
}
