import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SoftAssertionExample {
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
    public void validateBackpackDetails() {
        //Initializing softAssert
        SoftAssert softAssert = new SoftAssert();
        //login
        ElementUtils.sendKeys(driver, By.id("user-name"), prop.getProperty("username"));
        ElementUtils.sendKeys(driver, By.id("password"), prop.getProperty("password"));
        ElementUtils.clickElement(driver, By.id("login-button"));
        String actualName = driver.findElement(By.className("inventory_item_name")).getText();
        String actualDesc = driver.findElement(By.className("inventory_item_desc")).getText();
        String actualPrice = driver.findElement(By.className("inventory_item_price")).getText();

        // 3. Soft Assertions - These won't stop the test if they fail
        softAssert.assertEquals(actualName, "Sauce Labs Backpack", "Name mismatch!");
        softAssert.assertTrue(actualDesc.contains("slick backpack"), "Description mismatch!");
        softAssert.assertEquals(actualPrice, "$29.99", "Price mismatch!");
        softAssert.assertAll();
    }
}
