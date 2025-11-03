package pagesClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private final WebDriver driver;

    // Locators
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMsg = By.cssSelector("h3[data-test='error']");

    // Constructor
    public  loginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}
