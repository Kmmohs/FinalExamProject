package pkgTest;

import pkgApp.controller.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class RetirementControllerTest {

	@Test
	public void rnd2DeciTest() {
		RetirementController b = new RetirementController();
		double a = 101.1234;
		assertEquals((double)101.12,(double)(b.rnd2Deci(a*100))/100, .01);
	}

}
