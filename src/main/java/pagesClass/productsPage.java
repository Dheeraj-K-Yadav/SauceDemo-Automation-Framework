package pagesClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productsPage {
    WebDriver driver;

    // Locators
    private final By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By addToCartButton2 = By.id("add-to-cart-sauce-labs-bike-light");
    private final By addToCartButton3 = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private final By cartIcon = By.className("shopping_cart_link");
    //remove button
    private final By removeToCartButton = By.id("remove-sauce-labs-backpack");

    // Constructor
    public productsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions for only add to cart a one product
    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    //Action if when  we want to add  a multipal product to the cart then use  this method
    public void addMultipalProductToCart() {
       addProductToCart();
       driver.findElement(addToCartButton2).click();
       driver.findElement(addToCartButton3).click();

    }


    // open the cart
    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    //count product
    public String getCartCount() {
        return driver.findElement(cartIcon).getText();
    }

    //remove product
    public void removeProductToCart(){
         driver.findElement(removeToCartButton).click();
    }
}
