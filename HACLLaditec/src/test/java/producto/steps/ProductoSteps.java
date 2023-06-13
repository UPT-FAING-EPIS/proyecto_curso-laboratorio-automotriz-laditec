package producto.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import Modelo.Repuesto;
import ModeloDAO.RepuestoDAO;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ProductoSteps {

    private RepuestoDAO repuestoDAO;
    private List<Repuesto> listaRepuestos;
    private Repuesto repuesto;
    private int repuestoId;

    @Given("se ha establecido una conexión con la base de datos")
    public void establecerConexionBaseDatos() {
        repuestoDAO = new RepuestoDAO();
    }

    @When("obtengo la lista de repuestos")
    public void obtenerListaRepuestos() {
        listaRepuestos = repuestoDAO.listar();
    }

    @Then("debería recibir una lista de repuestos válida")
    public void validarListaRepuestos() {
        assertNotNull(listaRepuestos);
        assertFalse(listaRepuestos.isEmpty());
    }

    @When("obtengo el repuesto con ID 1")
    public void obtenerRepuestoEspecifico() {
        repuesto = repuestoDAO.list(1);
    }

    @Then("debería recibir los detalles del repuesto")
    public void validarDetallesRepuesto() {
        assertNotNull(repuesto);
        assertEquals(1, repuesto.getIdrepuesto());
    }
    /*
    @Given("tengo un nuevo repuesto con los siguientes detalles:")
    public void tenerNuevoRepuesto() {
        repuesto = new Repuesto();
        repuesto.setIdrepuesto(1);
        repuesto.setFkidalmacen(1);
        repuesto.setFkidestado(1);
        repuesto.setNombre("Juego de 4 piezas de inyectores - Nissan");
        repuesto.setFkidcategoria(1);
        repuesto.setImagen("png");
        repuesto.setPreciounitario(180.0);
        repuesto.setCantidad(9);
    }

    @When("agrego el nuevo repuesto")
    public void agregarNuevoRepuesto() {
        boolean agregado = repuestoDAO.add(repuesto);
        assertTrue(agregado);
    }

    @Then("el repuesto debería ser agregado correctamente")
    public void validarAgregadoCorrecto() {
        Repuesto repuestoAgregado = repuestoDAO.list(repuesto.getIdrepuesto());
        assertNotNull(repuestoAgregado);
        assertEquals(repuesto, repuestoAgregado);
    }

    @Given("tengo un repuesto existente con ID 1")
    public void tenerRepuestoExistente() {
        repuesto = repuestoDAO.list(1);
        assertNotNull(repuesto);
        repuestoId = 1;
    }

    @When("actualizo los detalles del repuesto:")
    public void actualizarDetallesRepuesto() {
        repuesto.setFkidalmacen(1);
        repuesto.setFkidestado(1);
        repuesto.setNombre("Juego de 4 piezas de inyectores - Nissan actualizado");
        repuesto.setFkidcategoria(1);
        repuesto.setImagen("png");
        repuesto.setPreciounitario(200.0);
        repuesto.setCantidad(10);
    }

    @Then("el repuesto debería ser actualizado correctamente")
    public void validarActualizacionCorrecta() {
        boolean actualizado = repuestoDAO.edit(repuesto);
        assertTrue(actualizado);
        Repuesto repuestoActualizado = repuestoDAO.list(repuestoId);
        assertNotNull(repuestoActualizado);
        assertEquals(repuesto, repuestoActualizado);
    }
*/
}