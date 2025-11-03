package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseClass {
    protected WebDriver driver;
//    public baseClass(WebDriver driver){
//        this.driver=driver;
//    }
public WebDriver getDriver() {
    return driver;
}

   @BeforeMethod
   public  void setup(){
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.saucedemo.com/");
   }
   @AfterMethod
   public void tearDown(){
       driver.quit();
   }
}
