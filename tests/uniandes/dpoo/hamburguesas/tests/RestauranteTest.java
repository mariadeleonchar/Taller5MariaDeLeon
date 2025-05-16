package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

public class RestauranteTest {

	private Restaurante restaurante;
	private File menu;
	private File ingredientes;
	private File combos;

	@BeforeEach
	void setUp() throws Exception {

		restaurante = new Restaurante();
		menu = new File("data/combos.txt");
		ingredientes = new File("data/ingredientes.txt");
		combos = new File("data/menu.txt");
		restaurante.cargarInformacionRestaurante(menu, ingredientes, combos);

	}

	@AfterEach
	void tearDown() throws NoHayPedidoEnCursoException, IOException {
		restaurante = null;
		restaurante.cerrarYGuardarPedido();

	}

	@Test
	void archivosExisten() {
		assertTrue(menu.exists(), "no existe el archivo menu");
		assertTrue(combos.exists(), "no existe el archivo menu");
		assertTrue(ingredientes.exists(), "no existe el archivo menu");
	}

	@Test
	void testMenuCargadoVacio() {
		
		ArrayList<ProductoMenu> menuLista = new ArrayList<ProductoMenu>();
		assertFalse(menuLista.isEmpty(), "el menu deberia estar vacio");

	}
	
	@Test
	void testIniciarPedidoYAgregarPedido() throws YaHayUnPedidoEnCursoException {
		restaurante.iniciarPedido("aaa", "jskks");
		assertEquals(1, restaurante.getPedidos().size());	
		
	}
	
	@Test
	void testCerrarPedido() throws YaHayUnPedidoEnCursoException, NoHayPedidoEnCursoException, IOException {
		restaurante.iniciarPedido("aaaaa", "sss");
		restaurante.cerrarYGuardarPedido();
		assertEquals(0, restaurante.getPedidos().size());
	}

}
