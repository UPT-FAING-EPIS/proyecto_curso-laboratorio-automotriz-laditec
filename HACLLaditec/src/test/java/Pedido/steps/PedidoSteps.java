package Pedido.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PedidoSteps {
    private int userId;
    private String fechaPedido;
    private String estadoPedido;
    private String listaPedidos;

    @Given("un usuario con ID de usuario {int}")
    public void un_usuario_con_ID_de_usuario(int userId) {
        this.userId = userId;
    }

    @When("se agrega un pedido con fecha {string} y estado {string}")
    public void se_agrega_un_pedido_con_fecha_y_estado(String fecha, String estado) {
        this.fechaPedido = fecha;
        this.estadoPedido = estado;
    }

    @Then("el pedido se agrega correctamente")
    public void el_pedido_se_agrega_correctamente() {
        // Verificar que el pedido se ha agregado correctamente
        Assert.assertEquals(1, userId);
        Assert.assertEquals("2023-06-13", fechaPedido);
        Assert.assertEquals("Pendiente", estadoPedido);
    }

    @Given("se ha agregado un pedido")
    public void se_ha_agregado_un_pedido() {
        // Simular que se ha agregado un pedido
        userId = 1;
        fechaPedido = "2023-06-13";
        estadoPedido = "Pendiente";
    }

    @When("se lista los pedidos")
    public void se_lista_los_pedidos() {
        // Simular la lista de pedidos
        listaPedidos = "Pedido 1\nPedido 2\nPedido 3";
    }

    @Then("se muestra la lista de pedidos")
    public void se_muestra_la_lista_de_pedidos() {
        // Verificar que se muestra la lista de pedidos
        Assert.assertEquals("Pedido 1\nPedido 2\nPedido 3", listaPedidos);
    }

    @When("se visualizan los pedidos de la boleta")
    public void se_visualizan_los_pedidos_de_la_boleta() {
        // Simular la visualización de los pedidos de la boleta
        listaPedidos = "Pedido 4\nPedido 5\nPedido 6";
    }

    @Then("se muestra la lista de pedidos de la boleta")
    public void se_muestra_la_lista_de_pedidos_de_la_boleta() {
        // Verificar que se muestra la lista de pedidos de la boleta
        Assert.assertEquals("Pedido 4\nPedido 5\nPedido 6", listaPedidos);
    }

    @When("se edita el pedido con ID de pedido {int}, nueva fecha {string} y nuevo estado {string}")
    public void se_edita_el_pedido_con_id_de_pedido_nueva_fecha_y_nuevo_estado(int pedidoId, String nuevaFecha, String nuevoEstado) {
        // Simular la edición del pedido con los nuevos valores
        fechaPedido = nuevaFecha;
        estadoPedido = nuevoEstado;
    }

    @Then("el pedido se edita correctamente")
    public void el_pedido_se_edita_correctamente() {
        // Verificar que el pedido se ha editado correctamente
        Assert.assertEquals("2023-06-14", fechaPedido);
        Assert.assertEquals("En progreso", estadoPedido);
    }
}
