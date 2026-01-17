import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumScript {
    public static void main(String[] args) {

        // 1. Tell the "Hands" (Selenium) to start the "Remote Control" (ChromeDriver)
        // Note: Selenium 4.6+ handles the driver automatically! You don't need to download .exe files manually.
        WebDriver driver = new ChromeDriver();

        // 2. Open a website
        driver.get("https://www.youtube.com");

        // 3. Print the Title of the page to the console (Verification)
        String pageTitle = driver.getTitle();
        System.out.println("The title of the page is: " + pageTitle);

        // 4. Verification Check (The "Test" part)
        if (pageTitle.equals("YouTube")) {
            System.out.println("Test PASSED!");
        } else {
            System.out.println("Test FAILED!");
        }

        // 5. Close the browser (Always clean up!)
        // driver.quit();
        // I commented this out so you can SEE the browser stay open.
        // Uncomment it later to close it automatically.
    }
}