package steps;
import ModeloDAO.PedidoVentaDAO;
import Modelo.PedidoVenta;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class PedidoSteps {
    private PedidoVentaDAO pedidoVentaDAO = new PedidoVentaDAO();
    private PedidoVenta pedido = new PedidoVenta();
    private boolean resultadoOperacion;

    @Given("un usuario con ID de usuario {int}")
    public void un_usuario_con_ID_de_usuario(int idusuario) {
        pedido.setIdusuario(idusuario);
    }

    @When("se agrega un pedido con idusuario {int}, fecha {string} y estado {string}")
    public void se_agrega_un_pedido_con_idusuario_fecha_y_estado(int idusuario, String fecha, String estado) {
    // Write code here that turns the phrase above into concrete actions
        pedido.setIdusuario(idusuario);
        pedido.setFecha(fecha);
        pedido.setEstado(estado);
        resultadoOperacion = pedidoVentaDAO.add(pedido);    
        //throw new io.cucumber.java.PendingException();
    }

    @Then("el pedido se agrega correctamente")
    public void el_pedido_se_agrega_correctamente() {
        assertTrue(resultadoOperacion);
    }

    @Given("se ha agregado un pedido")
    public void se_ha_agregado_un_pedido() {
        pedido = new PedidoVenta();
        pedido.setIdusuario(1);
        pedido.setFecha("2023-06-13");
        pedido.setEstado("A");
        pedidoVentaDAO.add(pedido);
    }

    @When("se lista los pedidos")
    public void se_lista_los_pedidos() {
        List<PedidoVenta> pedidos = pedidoVentaDAO.listar();
        this.resultadoOperacion = (pedidos != null && !pedidos.isEmpty());
    }

    @Then("se muestra la lista de pedidos")
    public void se_muestra_la_lista_de_pedidos() {
        assertTrue(resultadoOperacion);
    }

    @When("se visualizan los pedidos de la boleta")
    public void se_visualizan_los_pedidos_de_la_boleta() {
        PedidoVenta pedidoBoleta = pedidoVentaDAO.list(pedido.getIdpedido());
        this.resultadoOperacion = (pedidoBoleta != null);
    }

    @Then("se muestra la lista de pedidos de la boleta")
    public void se_muestra_la_lista_de_pedidos_de_la_boleta() {
        assertTrue(resultadoOperacion);
    }

    @When("se edita el pedido con ID de pedido {int}, nueva fecha {string} y nuevo estado {string}")
    public void se_edita_el_pedido_con_ID_de_pedido_nueva_fecha_y_nuevo_estado(int idpedido, String fecha, String estado) {
        pedido.setIdpedido(63);
        pedido.setFecha("2023-06-15");
        pedido.setEstado("P");
        resultadoOperacion = pedidoVentaDAO.edit(pedido);
    }

    @Then("el pedido se edita correctamente")
    public void el_pedido_se_edita_correctamente() {
        assertTrue(resultadoOperacion);
    }
}
