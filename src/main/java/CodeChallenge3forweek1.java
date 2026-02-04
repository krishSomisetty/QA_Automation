import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class CodeChallenge3forweek1 {
    public static void main(String[] args)throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        //WebElement addtocart = driver.findElement(By.xpath("//button[text()= 'Add to cart']"));
        WebElement additem1 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        additem1.click();
        System.out.println("Item1 added to cart!");
        Thread.sleep(2000);

        WebElement additem2 = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        additem2.click();
        System.out.println("Item2 added to cart!");
        Thread.sleep(2000);
        String badgeElement = driver.findElement(By.className("shopping_cart_badge")).getText();
        if (badgeElement.equals("2")){
        System.out.println("Badge value is 2");
        }
else {
    System.out.println("Badge value is not 2");
        }

    }
}
