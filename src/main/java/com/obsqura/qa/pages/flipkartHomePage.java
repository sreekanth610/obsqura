package com.obsqura.qa.pages;

import com.obsqura.qa.base.obsquraBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkartHomePage extends obsquraBase {

    public flipkartHomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@class='aqQN50']")
    WebElement logo;

    @FindBy(xpath = "//span[@class='_30XB9F']")
    WebElement popupclose;

    @FindBy(xpath = "//span[text()='Flights']")
    WebElement flightslink;



    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public SearchFlightsPage selectFlightOption() {
        if (popupclose.isDisplayed()){
            popupclose.click();
        }
        flightslink.click();
        return new SearchFlightsPage();
    }
}
