package edu.eci.cvds.tdd.aerodescuentos;

import static org.junit.Assert.*;

import org.junit.Test;

public class TarifasTest {

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void validateNoDiscount() {
		double tarifa = 150000.0;
		int diasAntelacion = 10;
		int edad = 18;
		double res = CalculadorDescuentos.calculoTarifa(tarifa, diasAntelacion, edad);
		assertEquals(res, tarifa, 0.01);
	}
	
	@Test
	public void validateInfAgeDiscount() {
		double tarifa = 150000.0;
		int diasAntelacion = 10;
		int edad = 17;
		double res = CalculadorDescuentos.calculoTarifa(tarifa, diasAntelacion, edad);
		assertEquals(res, tarifa - (tarifa * 0.05), 0.01);
	}
	
	@Test
	public void validateSupAgeDiscount() {
		double tarifa = 150000.0;
		int diasAntelacion = 10;
		int edad = 66;
		double res = CalculadorDescuentos.calculoTarifa(tarifa, diasAntelacion, edad);
		assertEquals(res, tarifa - (tarifa * 0.08), 0.01);
	}
	
	@Test
	public void validateDaysDiscount() {
		double tarifa = 150000.0;
		int diasAntelacion = 21;
		int edad = 65;
		double res = CalculadorDescuentos.calculoTarifa(tarifa, diasAntelacion, edad);
		assertEquals(res, tarifa - (tarifa * 0.15), 0.01);
	}
	
	@Test
	public void validateDaysInfAgeDiscount() {
		double tarifa = 150000.0;
		int diasAntelacion = 21;
		int edad = 17;
		double res = CalculadorDescuentos.calculoTarifa(tarifa, diasAntelacion, edad);
		assertEquals(res, tarifa - (tarifa * 0.20), 0.01);
	}
	
	@Test
	public void validateDaysSupAgeDiscount() {
		double tarifa = 150000.0;
		int diasAntelacion = 21;
		int edad = 66;
		double res = CalculadorDescuentos.calculoTarifa(tarifa, diasAntelacion, edad);
		assertEquals(res, tarifa - (tarifa * 0.23), 0.01);
	}

}
