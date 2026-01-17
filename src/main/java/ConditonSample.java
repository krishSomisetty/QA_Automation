import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

public class ConditonSample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement box1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        boolean ischeckbox1selected = box1.isSelected();
        System.out.println("Is Box 1 selected? " + ischeckbox1selected);
        if(!ischeckbox1selected){
            box1.click();
        }
        //For checkbox-2
        WebElement box2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        boolean ischeckbox2selected = box2.isSelected();
        System.out.println("Is Box 1 selected? " + ischeckbox2selected);
        if(!ischeckbox1selected){
            box2.click();
        }
        System.out.println("Final Status Box 1: " + box1.isSelected() );
        System.out.println("Final Status Box 2: " + box2.isSelected() );
    }
}
