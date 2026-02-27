import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class AdvancedActionsPractice {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
         //Double click challenge on iframe
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
        driver.switchTo().frame("iframeResult");
        WebElement doubleclickMe = driver.findElement(By.xpath("//button[text()='Double-click me']"));
        js.executeScript("arguments[0].style.border='3px solid red'", doubleclickMe);
        actions.doubleClick(doubleclickMe).perform();
        WebElement checkDoubleClick = driver.findElement(By.xpath("//p[text()='Hello World']"));
        if(checkDoubleClick.getText().contains("Hello World")){
            System.out.println("Double click is successful");
        }
        else{
            System.out.println("Double click dint worked!!!");
        }
        driver.switchTo().defaultContent();
        // opening new tab for right click challenge
        js.executeScript("window.open();"); // Opens a blank new tab

        // Get handles and switch to the second one (Index 1)
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

         //Right click challenge
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement hotspot = driver.findElement(By.id("hot-spot"));
        js.executeScript("arguments[0].style.background='yellow'", hotspot);
        actions.contextClick(hotspot).perform();
        driver.switchTo().alert().accept();

    }
}
