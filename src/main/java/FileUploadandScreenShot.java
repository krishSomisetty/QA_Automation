import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUploadandScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Actions actions = new Actions(driver);
        //File upload
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement footer = driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']"));
        js.executeScript("arguments[0].scrollIntoView(true); arguments[0].style.border='3px solid yellow';", footer);

        WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
        String filePath = "C:\\Users\\DELL\\Documents\\indvsWimatch.txt";
        uploadInput.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        //Taking screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("./Screenshots/failure.png");
        FileHandler.copy(source, destination);

    }
}