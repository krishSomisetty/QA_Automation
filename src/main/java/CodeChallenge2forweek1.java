import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CodeChallenge2forweek1 {
    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
       options.addArguments("--disable-notifications");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String currentURL = driver.getCurrentUrl();
        if (currentURL.contains("inventory")){
            System.out.println("Login Url passed");
        }
        else {
            System.out.println("Login url failed");
        }
    }
}
