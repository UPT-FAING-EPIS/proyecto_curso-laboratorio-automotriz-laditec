package steps;

import Config.conexion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ModeloDAO.RepuestoDAO;
import Modelo.Repuesto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.*;

public class ProductoSteps {

    private List<Repuesto> listaRepuestos;
    private Repuesto repuestoObtenido;
    private Repuesto repuestoNuevo;
    private Repuesto repuestoExistente;

    @Given("se ha establecido una conexión con la base de datos")
    public void se_ha_establecido_una_conexión_con_la_base_de_datos() {
        conexion miConexion = new conexion();
        try {
            Connection cnx = miConexion.getConnection();
            miConexion.cerrar();
            System.out.println("La conexión se ha establecido correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo establecer la conexión: " + e.getMessage());
        }   
    }

    @When("obtengo la lista de repuestos")
    public void obtengo_la_lista_de_repuestos() {
        RepuestoDAO repuestoDAO = new RepuestoDAO();
        listaRepuestos = repuestoDAO.listar();
    }

    @Then("debería recibir una lista de repuestos válida")
    public void debería_recibir_una_lista_de_repuestos_válida() {
        assertNotNull(listaRepuestos);
        assertFalse(listaRepuestos.isEmpty());
    }

    @When("obtengo el repuesto con id de {int}")
    public void obtengo_el_repuesto_con_ID(Integer id) {
        RepuestoDAO repuestoDAO = new RepuestoDAO();
        repuestoObtenido = repuestoDAO.list(id);
    }

    @Then("debería recibir los detalles del repuesto")
    public void debería_recibir_los_detalles_del_repuesto() {
        assertNotNull(repuestoObtenido);
        assertEquals(repuestoObtenido.getIdrepuesto(), (int) repuestoObtenido.getIdrepuesto());
    }

    @Given("tengo agregar un nuevo repuesto con los siguientes detalles {int}, {int}, {int}, {string}, {int}, {string}, {double}, {int}")
    public void tengo_agregar_un_nuevo_repuesto_con_los_siguientes_detalles(Integer id, Integer fkidalmacen, Integer fkidestado, String nombre, Integer fkidcategoria, String imagen, Double preciounitario, Integer cantidad) {
        repuestoNuevo = new Repuesto();
        repuestoNuevo.setIdrepuesto(id);
        repuestoNuevo.setFkidalmacen(fkidalmacen);
        repuestoNuevo.setFkidestado(fkidestado);
        repuestoNuevo.setNombre(nombre);
        repuestoNuevo.setFkidcategoria(fkidcategoria);
        repuestoNuevo.setImagen(imagen);
        repuestoNuevo.setPreciounitario(preciounitario);
        repuestoNuevo.setCantidad(cantidad);
    }

    @When("agrego el nuevo repuesto")
    public void agrego_el_nuevo_repuesto() {
        RepuestoDAO repuestoDAO = new RepuestoDAO();
        repuestoDAO.add(repuestoNuevo);
    }

    @Then("el repuesto debería ser agregado correctamente")
    public void el_repuesto_debería_ser_agregado_correctamente() {
        RepuestoDAO repuestoDAO = new RepuestoDAO();
        Repuesto repuestoAgregado = repuestoDAO.list(repuestoNuevo.getIdrepuesto());
        assertNotNull(repuestoAgregado);
        assertEquals(repuestoNuevo.getIdrepuesto(), repuestoAgregado.getIdrepuesto());
    }

    @Given("tengo un repuesto existente con el {int}")
    public void tengo_un_repuesto_existente_con_el(Integer id) {
        repuestoExistente = new Repuesto();
        repuestoExistente.setIdrepuesto(id);

    }

    @When("actualizo los detalles del repuesto {int}, {int}, {string}, {int}, {string}, {double}, {int}")
    public void actualizo_los_detalles_del_repuesto(Integer fkidalmacen, Integer fkidestado, String nombre, Integer fkidcategoria, String imagen, Double preciounitario, Integer cantidad) {
        repuestoExistente.setFkidalmacen(fkidalmacen);
        repuestoExistente.setFkidestado(fkidestado);
        repuestoExistente.setNombre(nombre);
        repuestoExistente.setFkidcategoria(fkidcategoria);
        repuestoExistente.setImagen(imagen);
        repuestoExistente.setPreciounitario(preciounitario);
        repuestoExistente.setCantidad(cantidad);

        RepuestoDAO repuestoDAO = new RepuestoDAO();
        repuestoDAO.edit(repuestoExistente);
    }

    @Then("el repuesto debería ser actualizado correctamente")
    public void el_repuesto_debería_ser_actualizado_correctamente() {
        RepuestoDAO repuestoDAO = new RepuestoDAO();
        Repuesto repuestoActualizado = repuestoDAO.list(repuestoExistente.getIdrepuesto());
        assertNotNull(repuestoActualizado);
        assertEquals(repuestoExistente.getIdrepuesto(), repuestoActualizado.getIdrepuesto());
    }
}