import BaseClass.baseClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pagesClass.loginPage;
import pagesClass.productsPage;
import utils.listeners;

//@Listeners(listeners.class)
public class productsTest extends baseClass {
    @Test
    public void verifyAddToCart() {
        loginPage lp = new loginPage(driver);
        lp.enterUsername("standard_user");
        lp.enterPassword("secret_sauce");
        lp.clickLogin();

        productsPage pp = new productsPage(driver);
       // pp.addProductToCart();
        pp.addMultipalProductToCart();

        String cartCount = pp.getCartCount();
//        Assert.assertEquals(cartCount, "1", "Cart count should be 1 after adding a product");
        Assert.assertEquals(cartCount, "3");

        pp.removeProductToCart();
        String afterR_PcartCount=pp.getCartCount();
        Assert.assertEquals(afterR_PcartCount, "2");

    }
}
