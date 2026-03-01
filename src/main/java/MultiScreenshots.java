import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MultiScreenshots {
    //Reusable method to take screenshots
    public static void takeScreenshot(WebDriver driver, String fileName) throws IOException{
        // Adding a timestamp so every file name is unique
        String timestamp = new SimpleDateFormat("Hhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File ("./Screenshots/" + fileName + "_" + timestamp + ".png");
        FileHandler.copy(source, destination);
        System.out.println("Screenshot captured: " + fileName);
    }
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // 1. Login Phase
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        js.executeScript("window.scrollBy(0,400)");
        // Take Screenshot 1: Success Login
        takeScreenshot(driver, "Home_Page");
        // 2. Add to Cart Phase
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        // Take Screenshot 2: Product Added
        takeScreenshot(driver, "Product_Added");
        // 3. View Cart Phase
        driver.findElement(By.className("shopping_cart_link")).click();

        // Take Screenshot 3: Cart Page
        takeScreenshot(driver, "Final_Cart_View");
    }
}
