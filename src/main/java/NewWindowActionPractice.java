import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Set;

public class NewWindowActionPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        String parentHandle = driver.getWindowHandle();
        System.out.println("Home page title: " +driver.getTitle());
        driver.findElement(By.id("newWindowBtn")).click();
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles){
            if(!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                Thread.sleep(3000);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,400)");
                driver.findElement(By.id("firstName")).sendKeys("Krishna");
                driver.findElement(By.id("lastName")).sendKeys("Somisetty");
                Thread.sleep(2000);
                driver.close();
            }
        }
        driver.switchTo().window(parentHandle);
                driver.findElement(By.id("name")).sendKeys("Back to home page after navigating to new window: " + driver.getTitle());
    }
}
