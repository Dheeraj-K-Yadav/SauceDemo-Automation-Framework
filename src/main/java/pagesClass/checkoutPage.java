package pagesClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkoutPage {
    WebDriver driver;

    // Locators
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By confirmationMsg = By.cssSelector(".complete-header");

    // Constructor
    public checkoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterDetails(String fName, String lName, String zip) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }

    public void finishOrder() {
        driver.findElement(finishBtn).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMsg).getText();
    }
}
