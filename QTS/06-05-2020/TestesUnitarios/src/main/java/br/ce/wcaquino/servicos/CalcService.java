package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Calc;



public class CalcService {
	@Test
	public void sumTest() {
		Calc calc = new Calc();
		Assert.assertEquals(113, calc.sum(94, 19));
		Assert.assertEquals(23, calc.sum(65, -42));
		Assert.assertEquals(22377, calc.sum(21425, 952));
	}
	
	@Test
	public void subTest() {
		Calc calc = new Calc();
		Assert.assertEquals(6901, calc.sub(7525, 624));
		Assert.assertEquals(3752, calc.sub(3428, -324));
		Assert.assertEquals(-111114, calc.sub(888885, 999999));
	}
	
	@Test
	public void divTest() {
		Calc calc = new Calc();
		Assert.assertEquals(318, calc.div(954, 3));
		Assert.assertEquals(1, calc.div(52, 52));
		Assert.assertEquals(58225, calc.div(58225, 1));
	}
	
	@Test
	public void multTest() {
		Calc calc = new Calc();
		Assert.assertEquals(200, calc.mult(20, 10));
		Assert.assertEquals(-500, calc.mult(50, -10));
		Assert.assertEquals(60, calc.mult(60, 1));
	}
}
