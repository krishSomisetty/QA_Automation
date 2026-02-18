import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class alertsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.findElement(By.xpath("//button[text()= 'Click for JS Confirm']")).click();
        List<WebElement> buttons = driver.findElements(By.xpath("//button"));

        for (WebElement btn : buttons) {
            try {
                btn.click();

                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                String msg = alert.getText();
                if (msg.contains("Alert")) {
                    System.out.println("Alert button is clicked");
                } else if (msg.contains("confirm")) {
                    System.out.println("confirm button is clicked");
                } else if (msg.contains("prompt")) {
                    System.out.println("Prompt is given");
                    alert.sendKeys("Krishna has given a prompt");
                }
                alert.accept();
                Thread.sleep(1000);
                String resultText = driver.findElement(By.id("result")).getText();
                System.out.println("Result on the page is: " + resultText);
            } catch (Exception e) {
                System.out.println("Loop encountered an issue: " + e.getMessage());
            }
        }
    }
}
