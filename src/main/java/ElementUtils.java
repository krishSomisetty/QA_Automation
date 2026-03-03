import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ElementUtils {

    public static boolean isErrorMessageDisplayed(WebDriver driver, By locator, String expectedError) {
        try {
            WebElement errorBox = driver.findElement(By.cssSelector("h3[data-test='error']"));
            return errorBox.getText().contains(expectedError);
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    // One tool for evidence
    public static void captureScreen(WebDriver driver, String folderName, String fileName) throws IOException {
        // 1. Generate the Timestamp
        String time = new SimpleDateFormat("HH_mm_ss").format(new Date());

        // 2. Define the path dynamically based on the project/app name
        String directoryPath = "./Screenshots/" + folderName + "/";

        // 3. Create the folder automatically if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs(); //
        }

        // 4. Save the file
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(directoryPath + fileName + "_" + time + ".png");
        FileHandler.copy(src, destination);

        System.out.println("LOG: Snapshot saved in " + folderName + " folder.");
    }

    // One tool for focus

    public static void clickElement(WebDriver driver, By locator) {
        // We can even add a highlight or a wait here automatically!
        WebElement element = driver.findElement(locator);
        // Using JS Click to handle any overlays or "irritating" popups
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        element.click();
    }
    public static void sendKeys(WebDriver driver, By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear(); // Best practice: Clear the field before typing
        element.sendKeys(text);
    }

}