package pkgTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class RetirementTest {

	@Test
	public void pVTest() {
		
		int iYearsRetired = 20;
		double annualReturnRetired = 0.02;
		double expectedPV = 1454485.55;
		double mSSI = 2642;
		double requiredIncome = 10000;
		
		Retirement retired = new Retirement();
		retired.setdAnnualReturnRetired(annualReturnRetired);
		retired.setiYearsRetired(iYearsRetired);
		retired.setdMonthlySSI(mSSI);
		retired.setdRequiredIncome(requiredIncome);
		
		assertEquals(expectedPV, Math.abs(retired.TotalAmountSaved()), .01);
	}
	
	@Test
	public void pMTTest() {
		
		int iYearsRetired = 20;
		double annualReturnRetired = 0.02;
		double expectedPV = 1454485.55;
		double mSSI = 2642;
		double requiredIncome = 10000;
		
		Retirement retired = new Retirement();
		
		retired.setdAnnualReturnRetired(annualReturnRetired);
		retired.setiYearsRetired(iYearsRetired);
		retired.setdMonthlySSI(mSSI);
		retired.setdRequiredIncome(requiredIncome);
		
		int yearsToWork = 40;
		double dAnnualReturnWorking = 0.07;
	
		retired.setiYearsToWork(yearsToWork);
		retired.setdAnnualReturnWorking(dAnnualReturnWorking);		
		
		assertEquals(554.13,Math.abs(retired.AmountToSave()),.01);
				
	}

}
