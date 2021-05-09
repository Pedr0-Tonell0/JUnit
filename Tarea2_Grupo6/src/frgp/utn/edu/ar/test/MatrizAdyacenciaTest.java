package frgp.utn.edu.ar.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import frgp.utn.edu.ar.main.MatrizAdyacencia;

class MatrizAdyacenciaTest {

	private int Fila = 0;
	private int Columna = 1;
	MatrizAdyacencia matrizTest = new MatrizAdyacencia(6);
		
	
	
@Test
public void agregarElementoTest () {
		
		matrizTest.agregarElemento(Fila, Columna);
		assertTrue("No existe el elemento en la matriz", matrizTest.existeElemento(Fila, Columna));
	}
	
	@Test
	public void agregarElementoSimetriaTest() {
		
	matrizTest.agregarElemento(Fila, Columna);
		assertTrue("No existe el elemento en la matriz", matrizTest.existeElemento(Columna, Fila));
	}
	
	@Test
	public void eliminarElementoTest () {
		matrizTest.eliminarElemento(Fila, Columna);
		assertFalse("Error el elemento existe en la matriz", matrizTest.existeElemento(Fila, Columna));
	}

	@Test
	public void eliminarElementoSimetricoTest() {
	
		matrizTest.eliminarElemento(Fila, Columna);
		assertFalse("No existe el elemento en la matriz", matrizTest.existeElemento(Columna, Fila));
	}
	
	@Test
	public void  contarRelacionesTest() {
		
		matrizTest.agregarElemento(2, 3);
		matrizTest.agregarElemento(1, 4);
		matrizTest.agregarElemento(1, 2);
		
		assertEquals("No coincide la cantidad", 3, matrizTest.getCantidadElementos());
	}
	
	@Test
	public void existenTodosLosElementoTest() {
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				matrizTest.agregarElemento(i, j);
			}
		}
		
		assertEquals("La cantidad no corresponde", 18, matrizTest.getCantidadElementos());
	}	
	
	@Test
	public void agregarElementoFilaNegativaTest ()	{
	    assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrizTest.agregarElemento(-1, 1));		
	}
	
	@Test
	public void agregarElementoColumnaNegativaTest ()	{
	    assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrizTest.agregarElemento(1, -1));		
	}
		
	@Test
	public void agregarElementoFueraRangoTest ()	{
	    assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrizTest.agregarElemento(-9, -9));		
	}
}
