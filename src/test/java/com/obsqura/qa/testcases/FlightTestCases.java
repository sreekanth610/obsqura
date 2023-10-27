package com.obsqura.qa.testcases;

import com.obsqura.qa.pages.flipkartHomePage;
import org.testng.Assert;
import org.testng.annotations.*;

import com.obsqura.qa.base.obsquraBase;

public class FlightTestCases extends obsquraBase {

	flipkartHomePage homepage;

	public FlightTestCases() {
		super();
	}

	/*
	 * @BeforeTest public void setExtentReport() { setExtend(); }
	 */

	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		obsqura_init();
		homepage = new flipkartHomePage();
	}

	@Test(groups = { "Simple", "UI" })
	public void TC001_CheckifLogoisPresent() {
		boolean flag = homepage.isLogoDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(groups = { "Functionality" })
	public void TC002_SelectFlightOption() {
		homepage.selectFlightOption();
	}



	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		// FormatResult();
		tearDownMain();
	}

}
