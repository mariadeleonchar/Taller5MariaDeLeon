package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class PedidoTest {
	
	private Pedido pedido;
	private ProductoMenu hamburguesa;
	private ProductoMenu papas;

    @BeforeEach
    void setUp( ) throws Exception
    {
        this.pedido = new Pedido("Jalen Brunson", "Calle 1");
        this.hamburguesa = new ProductoMenu("hamburguesa", 10);
        this.papas = new ProductoMenu("papas", 5);
    }

    @AfterEach
    void tearDown( ) throws Exception
    {
    }
    
    @Test
    void testAgregarProductosYPrecios() {
    	pedido.agregarProducto(hamburguesa);
    	pedido.agregarProducto(papas);
    	
    	assertEquals(15, pedido.getPrecioTotalPedido(), "el precio total es incorrectp");
    	
    }
    
    @Test
    void testGenerarTextoFactura() {
    	pedido.agregarProducto(hamburguesa);
    	String factura = pedido.generarTextoFactura();
    	
    	assertTrue(factura.contains("hamburguesa"), "la factura no contiene la hamburguesa");
    	assertTrue(factura.contains("15"), "la factura no contiene el precio");
    }
    
    @Test
    void testGuardarFactura() {
    	pedido.agregarProducto(hamburguesa);
    	File archivo = new File("factura_test.txt");
    	try {
			pedido.guardarFactura(archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	assertTrue(archivo.exists(), "la factura no fue guardadad correctamente");
    	archivo.delete();
    }

}
