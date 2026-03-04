import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SauceDemoE2EinTESTNG {
    WebDriver driver;
    Properties prop;

    @BeforeClass
    public void setupConfig() throws IOException {
        prop = new Properties();
        // Ensure this path matches your project structure
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop.load(fis);
    }

    @BeforeMethod
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void fullCheckoutFlow() throws IOException {
        ElementUtils.sendKeys(driver, By.id("user-name"), prop.getProperty("username"));
        ElementUtils.sendKeys(driver, By.id("password"), prop.getProperty("password"));
        ElementUtils.clickElement(driver, By.id("login-button"));
        ElementUtils.captureScreen(driver, "SauceDemo_E2E", "Login_Validated");
        // 4. Add to Cart Phase
        ElementUtils.clickElement(driver, By.id("add-to-cart-sauce-labs-backpack"));
        ElementUtils.clickElement(driver, By.id("add-to-cart-sauce-labs-fleece-jacket"));
        ElementUtils.captureScreen(driver, "SauceDemo_E2E", "Products_Added");

        // 5. Checkout Phase
        ElementUtils.clickElement(driver, By.className("shopping_cart_link"));
        ElementUtils.captureScreen(driver, "SauceDemo_E2E", "View_Cart_Page");
        ElementUtils.clickElement(driver, By.id("checkout"));
        //Your view page
        ElementUtils.sendKeys(driver, By.id("first-name"), "Krishna");
        ElementUtils.sendKeys(driver, By.id("last-name"), "Somisetty");
        ElementUtils.sendKeys(driver, By.id("postal-code"), "500075");
        ElementUtils.clickElement(driver, By.id("continue"));
        ElementUtils.captureScreen(driver, "SauceDemo_E2E", "Order_Overview");

        // 6. Completion Phase
        ElementUtils.clickElement(driver, By.id("finish"));

        // 7. Validation - The most important part of TestNG
        String actualMsg = driver.findElement(By.className("complete-header")).getText();
        String expectedMsg = "Thank you for your order!";

        // This replaces your if-else print statements
        Assert.assertEquals(actualMsg, expectedMsg, "Checkout was not successful!");
        ElementUtils.captureScreen(driver, "SauceDemo_E2E", "Order_Confirmation");
    }
    @AfterMethod
    public void tearDown() {
        // 8. Cleanup - Closes browser whether test passes or fails
        if (driver != null) {
            driver.quit();
        }
    }
}
