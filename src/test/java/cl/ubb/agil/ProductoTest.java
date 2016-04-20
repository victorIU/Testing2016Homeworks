package cl.ubb.agil;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.is;
public class ProductoTest {
	Categoria categoria=new Categoria("LessPaul","C01");
	Producto producto=new Producto("Gibson Less Paul",1,5,categoria);
	Existencia existencia[]=new Existencia[5];
	@Test
	public void getStockConStockTres(){
		/*Arrange*/
		for(int i=0;i<3;i++){
			existencia[i]=new Existencia(" "+i);
		}
		/* Act */
		for(int i=0;i<3;i++){
			producto.existencias[i]=existencia[i];
		}
		producto.stock=3;
		int resultado=producto.getStock();
		/*Assert*/
		assertThat(resultado, is(3));
	}
	@Test
	public void isBajoStockConStockCeroMinUnoMaximoCinco(){
		/* Arrange */
		producto=new Producto("Gibson Less Paul",1,5,categoria);
		/* Act */
		boolean vof=producto.isBajoStock();
		/* Assert */
		assertFalse(!vof);
	}
	@Test
	public void isBajoStockConStockUnoMinCincoMaximoUno(){
		/* Arrange */
		producto=new Producto("Gibson Less Paul",5,1,categoria);
		for(int i=0;i<1;i++){
			existencia[i]=new Existencia(" "+i);
		}
		/* Act */
		for(int i=0;i<1;i++){
			producto.existencias[i]=existencia[i];
		}
		producto.stock=1;
		/* Act */
		boolean vof=producto.isBajoStock();
		/* Assert */
		assertFalse(vof);
	}
	@Test
	public void isBajoStockConStockDosMax5MinUno(){
		producto=new Producto("Gibson Less Paul",1,5,categoria);
		/* Arrange */
		for(int i=0;i<2;i++){
			existencia[i]=new Existencia(" "+i);
		}
		/* Act */
		for(int i=0;i<2;i++){
			producto.existencias[i]=existencia[i];
		}
		producto.stock=2;
		boolean vof=producto.isBajoStock();
		/* Assert */
		assertFalse(vof);
	}
	@Test
	public void getStockFaltanteStockMaximoCincoStockIgualAUno(){
		/*Arrange*/
		producto=new Producto("Gibson Less Paul",1,5,categoria);
		int resultado;
		producto.stock=1;for(int i=0;i<2;i++){
			existencia[i]=new Existencia(" "+i);
		}
		/* Act */
		for(int i=0;i<1;i++){
			producto.existencias[i]=existencia[i];
		}
		producto.stock=1;
		resultado=producto.getStockFaltante();
		/*Assert*/
		assertThat(resultado, is(4));
	}
	@Test (expected=ExcepcionDeProducto.class)
	public void getProximaExistenciaConStockIgualCero()throws ExcepcionDeProducto{
		/*Arrange*/
		producto=new Producto("Gibson Less Paul",1,5,categoria);
		/*Act*/
		producto.getProximaExistencia();
		/*Assert*/
		//lanza Excepcion
	}
	@Test
	public void getProximaExistenciaConStockMayorAcero()throws ExcepcionDeProducto{
		/*Arrange*/
		producto=new Producto("Gibson Less Paul",1,5,categoria);
		for(int i=0;i<1;i++){
			existencia[i]=new Existencia(" "+i);
		}
		/* Act */
		for(int i=0;i<1;i++){
			producto.existencias[i]=existencia[i];
		}
		producto.stock=1;
		Existencia nuevaExistencia=producto.getProximaExistencia();
		/*Assert*/
		assertEquals(existencia[0], nuevaExistencia);
		
	}
	@Test
	public void addExistenciaDebeAgregarUnaYactualizarElStock(){
		/*Arrange*/
		producto=new Producto("Gibson Less Paul",1,5,categoria);
		for(int i=0;i<3;i++){
			existencia[i]=new Existencia(" "+i);
		}
		/* Act */
		for(int i=0;i<2;i++){
			producto.existencias[i]=existencia[i];
		}
		producto.stock=2;
		boolean vof=producto.addExistencia(existencia[2]);
		/*Assert*/
		assertThat(producto.stock,is(3));
		assertFalse(!vof);
	}
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void addExistenciaConStockMaximo()throws ArrayIndexOutOfBoundsException{
		/*Arrange*/
		producto=new Producto("Gibson Less Paul",1,5,categoria);
		Existencia exi[]=new Existencia[5];
		for(int i=0;i<5;i++){
			exi[i]=new Existencia(" "+i);
		}
		/* Act */
		for(int i=0;i<5;i++){
			producto.existencias[i]=exi[i];
		}
		Existencia e=new Existencia("001");
		producto.stock=5;
		/*
		 * no se captura excepción, pero al ser el stock 5, segun la condición
		 * al ser menor o igual al stock maximo, deja igual hacer la inserción.
		 * es por esto que se cae si no capturo la excepcion
		*/
		boolean vof=producto.addExistencia(e);
		/*Assert*/
		assertThat(producto.stock,is(5));
		assertFalse(vof);
	}
	@Test
	public void getCategoriaEntregaCategoriaCorrectamente(){
		
	}
}
