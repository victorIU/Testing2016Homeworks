package cl.ubb.agil;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CategoriaTest {
	Categoria categoria;
	@Test
	public void getNombreTest(){
		/*Arrange*/
		categoria=new Categoria("Guitar","0001");
		/*Act*/
		String name=categoria.getNombre();
		/*Assert*/
		assertTrue(name.equals(categoria.nombre));
	}
	@Test
	public void setNombreTest(){
		/*Arrange*/
		categoria=new Categoria("Guitar","0001");
		/*Act*/
		categoria.setNombre("Bass");
		/*Assert*/
		assertTrue(categoria.nombre.equals("Bass"));
	}
	@Test
	public void getCodigoLengthMayorACinco(){
		/*Arrange*/
		categoria=new Categoria("Guitar","012345");
		/*Act*/
		String s=categoria.getCodigo();
		/*Assert*/
		assertTrue(s.equals(categoria.codigo.substring(0, 5)));
	}
	@Test
	public void getCodigoLengthMenorACinco(){
		/*Arrange*/
		categoria=new Categoria("Guitar","01234");
		/*Act*/
		String s=categoria.getCodigo();
		/*Assert*/
		assertTrue(s.equals(categoria.codigo));
	}
	@Test
	public void setCodigoTest(){
		/*Arrange*/
		categoria=new Categoria("Guitar","0001");
		/*Act*/
		categoria.setCodigo("0002");
		/*Assert*/
		assertTrue(categoria.codigo.equals("0002"));
	}
}
