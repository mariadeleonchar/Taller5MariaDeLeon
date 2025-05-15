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
	void setUp() {
		this.producto = new ProductoMenu(nombre, 10);
	}
	
	 @AfterEach
	void tearDown( ) throws Exception
	    {
	    }
	 
	 @Test
	 void testGetNombre() {
		 assertEquals("Hamburguesa", producto.getNombre(), "el nombre es incorrecto");
	 }
	 
	 @Test
	 void testGetPrecio() {
		 assertEquals(10, producto.getPrecio(), "el precio es incorrecto");
	 }
	 
	 @Test
	 void testGenerargenerarTextoFactura() {
		 String factura = producto.generarTextoFactura();
		 assertTrue(factura.contains(nombre), "la factura no contiene el nombre");
		 assertTrue(factura.contains("10"), "la factura no contiene el precio");
	 }
	
}
