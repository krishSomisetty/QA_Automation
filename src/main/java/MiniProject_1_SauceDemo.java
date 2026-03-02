import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
public class MiniProject_1_SauceDemo {
    public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
        // Adding a timestamp so every file name is unique
        String timestamp = new SimpleDateFormat("Hhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("./Screenshots/" + fileName + "_" + timestamp + ".png");
        FileHandler.copy(source, destination);
        System.out.println("Screenshot captured: " + fileName);
    }
    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid yellow'", element);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // setting up the properites
        Properties prop = new Properties();
        // configuring the path for the file
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        //load the file
        prop.load(fis);
        //get the properties of the file
        String appUrl = prop.getProperty("url");
        String uName = prop.getProperty("username");
        String pWord = prop.getProperty("password");
        // selenium tasks - opening a new incognito window
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--force-device-scale-factor=0.8");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // 1. Login Phase--
        driver.get(appUrl);
        driver.findElement(By.id("user-name")).sendKeys(uName);
        driver.findElement(By.id("password")).sendKeys(pWord);
        // screenshot for login credentials
        takeScreenshot(driver, "Login_Page_Filled");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        js.executeScript("arguments[0].click();", loginBtn);
        Thread.sleep(2000);
        //verification of login using screenshot
        if (driver.getCurrentUrl().contains("inventory")) {
            System.out.println("Login Successful!");
            takeScreenshot(driver, "Dashboard_Success");
        } else {
            System.out.println("Login Failed!");
            takeScreenshot(driver, "Login_Failure");
        }
        // Take Screenshot 1: Success Login
        takeScreenshot(driver, "Home_Page");
        // 2. Add to Cart Phase
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        Thread.sleep(2000);
        // Take Screenshot 2: Product Added
        takeScreenshot(driver, "Product_Added");
        // 3. View Cart Phase
        driver.findElement(By.className("shopping_cart_link")).click();

        // Take Screenshot 3: Cart Page
        takeScreenshot(driver, "Final_Cart_View");
        Thread.sleep(2000);
        //Take Screenshot 4: Clicking on checkout
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);
        takeScreenshot(driver, "checkout button");
        //Take Screenshot 5: Entering user details
        driver.findElement(By.id("first-name")).sendKeys("Krishna");
        driver.findElement(By.id("last-name")).sendKeys("Somisetty");
        driver.findElement(By.id("postal-code")).sendKeys("500075");
        Thread.sleep(2000);
        takeScreenshot(driver, "User_Details_view");
        driver.findElement(By.id("continue")).click();
        js.executeScript("document.body.style.zoom='80%'");
        takeScreenshot(driver, "Order_Details");

        // Take Screenshot 6: Finishing the order
        // Find Cancel first
        WebElement cancelBtn = driver.findElement(By.id("cancel"));
        // Find Finish which is to the right of Cancel
        WebElement finishBtn = driver.findElement(with(By.tagName("button")).toRightOf(cancelBtn));
        highlight(driver, finishBtn); // Highlight it for the video!
        Thread.sleep(3000);
        finishBtn.click();
        takeScreenshot(driver, "Order_Confirmed");
driver.quit();

    }
}
