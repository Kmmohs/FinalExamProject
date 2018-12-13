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
		double pMT = 10000-2642;
		double mSSI = 2642;
		double requiredIncome = 10000;
		
		Retirement retired = new Retirement();
		retired.setdAnnualReturnRetired(annualReturnRetired);
		retired.setdAnnualReturnRetired(iYearsRetired);
		retired.setdMonthlySSI(mSSI);
		retired.setdRequiredIncome(requiredIncome);
		
		assertEquals(expectedPV, Math.abs(retired.TotalAmountSaved()), .01);
	}
	
	@Test
	public void pMTTest() {
		
		int iYearsRetired = 20;
		double annualReturnRetired = 0.02;
		double expectedPV = 1454485.55;
		double pMT = 10000-2642;
		double mSSI = 2642;
		double requiredIncome = 10000;
		int yearsToWork = 40;
		double dAnnualReturnWorking = 0.07;
		
		Retirement retired = new Retirement();
		retired.setdAnnualReturnRetired(annualReturnRetired);
		retired.setdAnnualReturnRetired(iYearsRetired);
		retired.setdMonthlySSI(mSSI);
		retired.setdRequiredIncome(requiredIncome);
		
		double pmt = Math.abs(retired.TotalAmountSaved());
		
		retired.setiYearsToWork(yearsToWork);
		retired.setdAnnualReturnWorking(dAnnualReturnWorking);		
		
	}

}
