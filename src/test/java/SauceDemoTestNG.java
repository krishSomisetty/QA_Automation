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

    // 1. The Data Provider: This feeds 3 different scenarios into your test
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", "pass"},
                {"locked_out_user", "secret_sauce", "fail"},
                {"problem_user", "secret_sauce", "pass"}
        };
    }

    // 2. Load Configuration: Runs once before the class starts
    @BeforeClass
    public void setupConfig() throws IOException {
        prop = new Properties();
        // Ensure this path matches your project structure
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop.load(fis);
    }

    // 3. Setup: Opens a fresh browser before every single data iteration
    @BeforeMethod
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    /**
     * 4. The Data-Driven Test:
     * TestNG will run this method 3 times because of the 'dataProvider' attribute.
     */
    @Test(dataProvider = "loginData")
    public void validLoginTest(String user, String pwd, String status) {
        // We use the 'user' and 'pwd' from the DataProvider instead of the properties file
        ElementUtils.sendKeys(driver, By.id("user-name"), user);
        ElementUtils.sendKeys(driver, By.id("password"), pwd);
        ElementUtils.clickElement(driver, By.id("login-button"));

        if (status.equals("pass")) {
            // Validation for successful login
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                    "Login should have passed for: " + user);
        } else {
            // Validation for the locked_out_user error message
            WebElement errorBox = driver.findElement(By.cssSelector("h3[data-test='error']"));
            Assert.assertTrue(errorBox.isDisplayed(),
                    "Error message should have appeared for: " + user);
        }
    }

    // 5. Teardown: Closes the browser after every iteration
    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}