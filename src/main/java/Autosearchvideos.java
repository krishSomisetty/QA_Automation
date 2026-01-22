import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Autosearchvideos {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.youtube.com");

        // ✅ Handle cookies popup if present
        try {
            WebElement agreeBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button//*[text()='Accept all' or text()='I agree']")
                    )
            );
            agreeBtn.click();
        } catch (Exception e) {
            // Popup not shown – ignore
        }

        // 1️⃣ Search box
        WebElement searchBox = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("search_query"))
        );
        searchBox.sendKeys("Pawan Kalyan OG Firestorm song", Keys.ENTER);

        // 2️⃣ Wait for first video thumbnail
        WebElement firstVideo = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//ytd-video-renderer//a[@id='thumbnail'])[1]")
                )
        );

        // ✅ JS click (IMPORTANT for YouTube)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", firstVideo);

        // 3️⃣ Wait for video tag
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("video")));

        // 4️⃣ Get duration
        Double duration = (Double) js.executeScript(
                "return document.querySelector('video').duration;"
        );

        System.out.println("Video duration (seconds): " + duration);

        // 5️⃣ Wait till video ends
        while (true) {
            Double currentTime = (Double) js.executeScript(
                    "return document.querySelector('video').currentTime;"
            );

            System.out.println("Current time: " + currentTime);

            if (currentTime >= duration - 1) {
                System.out.println("🎬 Video completed!");
                break;
            }

            Thread.sleep(2000);
        }

        driver.quit();
    }
}
