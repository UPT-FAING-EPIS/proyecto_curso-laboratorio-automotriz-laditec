package usuario.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

    public class UsuarioSteps {
    private int userid;
    private String clave;
    private String estado;
    private String mensajeExito;
    private String listaUsuarios;

    @Given("un usuario con userid {int}")
    public void un_usuario_con_userid(int userid) {
        this.userid = userid;
    }

    @When("se agrega un usuario con userid {int}")
    public void se_agrega_un_usuario_con_userid(int userid) {
        // Aquí deberías interactuar con la interfaz de usuario o el controlador para simular la adición de un usuario
        this.mensajeExito = "El usuario ha sido creado";
    }

    @Then("debo ver un mensaje de exito que indica que el usuario ha sido creado")
    public void debo_ver_un_mensaje_de_exito_que_indica_que_el_usuario_ha_sido_creado() {
        // Verificar que el mensaje de éxito es correcto
        Assert.assertEquals("El usuario ha sido creado", mensajeExito);
    }

    @Given("se ha agregado un usuario")
    public void se_ha_agregado_un_usuario() {
        // Aquí deberías interactuar con la interfaz de usuario o el controlador para simular la adición de un usuario
        this.userid = 23;
    }

    @When("se lista los usuarios")
    public void se_lista_los_usuarios() {
        // Aquí deberías interactuar con la interfaz de usuario o el controlador para obtener la lista de usuarios
        this.listaUsuarios = "Usuario1\nUsuario2\nUsuario3";
    }

    @Then("se muestra la lista de usuarios")
    public void se_muestra_la_lista_de_usuarios() {
        // Verificar que la lista de usuarios es correcta
        Assert.assertEquals("Usuario1\nUsuario2\nUsuario3", listaUsuarios);
    }

    @When("se edita el usuario con userid {int}, nueva clave {string} y nuevo estado {string}")
    public void se_edita_el_usuario_con_userid_nueva_clave_y_nuevo_estado(int userid, String clave, String estado) {
        // Aquí deberías interactuar con la interfaz de usuario o el controlador para simular la edición de un usuario
        this.clave = clave;
        this.estado = estado;
    }

    @Then("el usuario se edita correctamente")
    public void el_usuario_se_edita_correctamente() {
        // Verificar que la clave y el estado del usuario se han actualizado correctamente
        Assert.assertEquals("s12345", clave);
        Assert.assertEquals("A", estado);
    }
}
