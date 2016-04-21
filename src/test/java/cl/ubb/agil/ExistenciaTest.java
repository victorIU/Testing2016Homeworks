package cl.ubb.agil;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class ExistenciaTest {
	Existencia existencia;
	@Test
	public void getNumeroTest(){
		/*Arrange*/
		existencia=new Existencia("15");
		/*Act*/
		String number=existencia.getNumero();
		/*Assert*/
		assertTrue(number.equals(existencia.numero));
	}
}
