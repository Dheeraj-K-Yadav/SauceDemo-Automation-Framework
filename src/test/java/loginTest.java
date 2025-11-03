import BaseClass.baseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesClass.loginPage;

public class loginTest extends baseClass {


    @Test
    public void verifyInvalidLogin() {
        loginPage lp = new loginPage(driver);
        lp.enterUsername("wrongUser");
        lp.enterPassword("wrongPass");
        lp.clickLogin();

        String expectedMsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertTrue(lp.getErrorMessage().contains(expectedMsg));
    }

    @Test
    public void verifyValidLogin() {
        loginPage lp = new loginPage(driver);
        lp.enterUsername("standard_user");
        lp.enterPassword("secret_sauce");
        lp.clickLogin();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));
    }
}
