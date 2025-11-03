import BaseClass.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesClass.checkoutPage;
import pagesClass.loginPage;
import pagesClass.productsPage;

public class checkoutTest extends baseClass {

    @Test
    public void verifyEndToEndOrderFlow() {
        // Step 1: Login
        loginPage lp = new loginPage(driver);
        lp.enterUsername("standard_user");
        lp.enterPassword("secret_sauce");
        lp.clickLogin();

        // Step 2: Add product
        productsPage pp = new productsPage(driver);
        pp.addProductToCart();

        // Step 3: Checkout
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        checkoutPage cp = new checkoutPage(driver);
        cp.enterDetails("Dheeraj", "Yadav", "110001");
        cp.finishOrder();

        // Step 4: Verify confirmation
        String message = cp.getConfirmationMessage();
        Assert.assertEquals(message, "Thank you for your order!");
        System.out.println("  Test Passed – Order placed successfully!");
    }
}
