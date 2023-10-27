package com.obsqura.qa.pages;

import com.obsqura.qa.base.obsquraBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.qa.base.obsquraBase;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchFlightsPage extends obsquraBase {

	
	public SearchFlightsPage() {
		PageFactory.initElements(driver, this);
		SearchFlightInvalid("","");
		SearchFlightValid("BOM","Hyderabad");
	}

	@FindBy(xpath = "//input[@class='_1w3ZZo _1YBGQV _2EjOJB lZd1T6 _2vegSu _2mFmU7']")
	WebElement fromCity;

	@FindBy(xpath = "//input[@class='_1w3ZZo _1YBGQV _2EjOJB lZd1T6 _2dqBfU _2mFmU7']")
	WebElement toCity;

	@FindBy(xpath = "//input[@class='_1w3ZZo _2gKfhi _1WPSB8 _2mFmU7']")
	WebElement calender;
	@FindBy(xpath = "//button[@class='jkj0H4 _2v-mAi _3vGgRD']")
	WebElement traveldate;
	@FindBy(xpath = "//span[text()='SEARCH']")
	WebElement search;

	@FindBy(xpath="//div[@class='v73Elr _3Lmg0m']")
	WebElement error;

	@FindBy(xpath="//div[@class='_28uqty']")
	WebElement triptype;

	@FindBy(xpath = "//img[@class='_2xm1JU']")
	WebElement logo;

	@FindBy(xpath = "//span[text()='Flights']")
	WebElement flightslink;

	@FindBy (xpath="(//div[@class='_24hoQ2 _1EzOls'])[2]")
	WebElement dropdown;

	@FindBy(xpath="//button[text()='29']")
	WebElement returndate;

	@FindBy (xpath="//input[@class='_1w3ZZo _2gKfhi _2mFmU7']")
	WebElement returndatefield;

	public void SearchFlightInvalid(String From, String To) {
		fromCity.sendKeys(From);
		toCity.sendKeys(To);
		search.click();
		if (error.isDisplayed()){
			System.out.println("Search not valid");
			//Please select a city from the suggestions
			Assert.assertEquals(error.getText(),"origin cannot be empty");
		}
	}

	public void SearchFlightValid(String From, String To) {
		logo.click();
		flightslink.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(d -> fromCity.isDisplayed());
		fromCity.click();
		driver.findElement(By.xpath("(//div[text()='" + From + "'])[1]")).click();
		wait.until(d -> toCity.isDisplayed());
		toCity.click();
		wait.until(d -> dropdown.isDisplayed());
		driver.findElement(By.xpath("(//span[text()='" + To + "'])[2]")).click();
		returndatefield.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		wait.until(d -> returndate.isDisplayed());
		returndate.click();
		search.click();
		if(triptype.isDisplayed()){
			System.out.println("Search Successful");
			Assert.assertEquals(triptype.getText(),"Trip Type");
		}
	}

}
