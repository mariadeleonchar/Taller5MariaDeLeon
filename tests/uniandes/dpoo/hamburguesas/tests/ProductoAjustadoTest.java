package uniandes.dpoo.hamburguesas.tests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;

public class ProductoAjustadoTest {
	
	private ProductoMenu producto;
	private ProductoAjustado productoAjustado;
	private String nombre = "Hamburguesa";
	private Ingrediente bacon;
	private Ingrediente tomate;
	
	
	@BeforeEach
	public void setUp() {
		this.productoAjustado = new ProductoAjustado(producto);
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
		 assertEquals(0, producto.getPrecio());
	 }
	 
	 @Test
	 public void testGenerargenerarTextoFactura() {
		 String factura = producto.generarTextoFactura();
		 assertTrue(factura.contains(nombre));
		 assertTrue(factura.contains("10"));
	 }
}
