import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class projectOrangeHRM {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //setup explicit wait
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.get("https://opensource-demo.orangehrmlive.com/");
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name ='username']"))).sendKeys("Admin");
       driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
       driver.findElement(By.cssSelector("button[type='submit']")).click();
// wait until sidebar gets displayed and navigate and click on PIM
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='viewPimModule']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add ']"))).click();
        //Fill username and lastname details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='firstName']"))).sendKeys("Krishna");
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Somisetty");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-toast--success")));
        System.out.println("Employee details are created succesfully");
        Thread.sleep(3000);
    }
}
