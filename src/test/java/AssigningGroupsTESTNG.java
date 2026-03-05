import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AssigningGroupsTESTNG {
    WebDriver driver;
    Properties prop;

    // Use alwaysRun=true so this config loads even when filtering for 'smoke' or 'regression'
    @BeforeClass(alwaysRun = true)
    public void setupConfig() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop.load(fis);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    // Changed to @BeforeClass so the browser stays open for the whole test flow




    @Test(priority = 1, groups = {"smoke", "regression"})
    public void testLogin() {
        ElementUtils.sendKeys(driver, By.id("user-name"), prop.getProperty("username"));
        ElementUtils.sendKeys(driver, By.id("password"), prop.getProperty("password"));
        ElementUtils.clickElement(driver, By.id("login-button"));

        boolean isLoggedin = driver.findElement(By.className("inventory_list")).isDisplayed();
        Assert.assertTrue(isLoggedin, "Login failed!");
        System.out.println("Login Approved.");
    }

    @Test(priority = 2, groups = {"regression"}, dependsOnMethods = {"testLogin"})
    public void fullcheckout() {
        // This will now find the elements because the browser is still logged in
        ElementUtils.clickElement(driver, By.id("add-to-cart-sauce-labs-backpack"));
        ElementUtils.clickElement(driver, By.className("shopping_cart_link"));
        ElementUtils.clickElement(driver, By.id("checkout"));

        String header = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(header, "Checkout: Your Information");
        System.out.println("Regression: Navigation verified.");
    }

    // Changed to @AfterClass so it only quits after BOTH tests are finished
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}