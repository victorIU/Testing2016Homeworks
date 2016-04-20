package cl.ubb.agil;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.is;

public class ProductoTest {
	Producto producto;
	Categoria categoria;
	@Test
	public void isBajoStockConStockNueveMaxVeinteMinDiez(){
		Categoria categoria=new Categoria("cecinas","C01");
		producto=new Producto("cecinas de perro",10,20,categoria);
		
		producto.stock=9;
		boolean vof=producto.isBajoStock();
		
		assertFalse(!vof);
	}
	@Test
	public void isBajoStockConStockDoceMaxVeinteMinDiez(){
		Categoria categoria=new Categoria("cecinas","C01");
		producto=new Producto("cecinas de perro",10,20,categoria);
		
		producto.stock=12;
		boolean vof=producto.isBajoStock();
		
		assertFalse(vof);
	}
	@Test 
	public void isBajoStockConStockNegativo(){
		Categoria categoria=new Categoria("cecinas","C01");
		producto=new Producto("cecinas de perro",10,20,categoria);
		
		producto.stock=12;
		boolean vof=producto.isBajoStock();
		
		assertFalse(vof);
	}
}
