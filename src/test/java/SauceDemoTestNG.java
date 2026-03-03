import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SauceDemoTestNG {
    WebDriver driver;
    Properties prop;

    @BeforeClass
    public void setupConfig() throws IOException {
        prop = new Properties();
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
    public void validLoginTest() {
        ElementUtils.sendKeys(driver, By.id("user-name"), prop.getProperty("username"));
        ElementUtils.sendKeys(driver, By.id("password"), prop.getProperty("password"));
        ElementUtils.clickElement(driver, By.id("login-button"));

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed!");
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}