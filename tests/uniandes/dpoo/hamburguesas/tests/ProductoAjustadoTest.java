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
	void setUp() {
		this.productoAjustado = new ProductoAjustado(producto);
		bacon = new Ingrediente("bacon", 2);
		tomate = new Ingrediente("tomate", 1);
		
	}
	
	 @AfterEach
	 void tearDown( ) throws Exception
	    {
	    }
	 
	 @Test
	 void testGetNombre() {
		 assertEquals("Hamburguesa", producto.getNombre(), "el nombre del producto ajustado es incorrecto");
	 }
	 
	 @Test
	 void testGetPrecio() {
		 assertEquals(0, producto.getPrecio(), "el precio del producto ajustado es incorrecto");
	 }
	 
	 @Test
	 void testGenerargenerarTextoFactura() {
		 String factura = producto.generarTextoFactura();
		 assertTrue(factura.contains(nombre), "la factura no contiene el nombre");
		 assertTrue(factura.contains("0"), "la factura no contiene el precio ajustado");
	 }
}
