package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;



public class ProductoMenuTest {

	private ProductoMenu producto;
	private String nombre = "Hamburguesa";
	
	@BeforeEach
	public void setUp() {
		this.producto = new ProductoMenu(nombre, 10);
	}
	
	 @AfterEach
	    void tearDown( ) throws Exception
	    {
	    }
	 
	 @Test
	 public void testGetNombre() {
		 assertEquals("Hamburguesa", producto.getNombre());
	 }
	 
	 @Test
	 public void testGetPrecio() {
		 assertEquals(10, producto.getPrecio());
	 }
	 
	 @Test
	 public void testGenerargenerarTextoFactura() {
		 String factura = producto.generarTextoFactura();
		 assertTrue(factura.contains(nombre));
		 assertTrue(factura.contains("10"));
	 }
	
}
