package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {
	
	private Combo combo;
	private ProductoMenu hamburguesa;
	private ProductoMenu papas;
	private ProductoMenu cocacola;
	private ArrayList<ProductoMenu> items = new ArrayList<>();
	
	@BeforeEach
    void setUp( ) throws Exception
    {
		hamburguesa = new ProductoMenu("hamburguesa", 10);
		papas = new ProductoMenu("papas", 3);
		cocacola = new ProductoMenu("cocacola", 1);
		items.add(hamburguesa);
		items.add(papas);
		items.add(cocacola);
		this.combo = new Combo("Combo", 3, items);
		
	}
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	 
	 @Test 
	 void testNombreCombo() {
		 assertEquals("Combo", combo.getNombre(), "el nombre del combo no es el esperado");
	 }
	 
	 @Test
	 void testPrecioConDescuento() {
		 int preciotest = (int) Math.round((1+3+10)*(1-0.03));
		 assertEquals(preciotest, combo.getPrecio(), "el precio del combo no fue calculado correctamente");
	 }
	 
	 @Test
	 void testGenerarTextoFactura() {
		 String factura = combo.generarTextoFactura();
		 assertTrue(factura.contains("Combo"), "la factura no contiene el nombre del combo");
		 assertTrue(factura.contains("hamburguesa"), "la factura no contiene la hamburguesa");
		 assertTrue(factura.contains("papas"), "la factura no contiene las papas");
		 assertTrue(factura.contains("cocacola"), "la factura no contiene la cocacola");
	 }

}
