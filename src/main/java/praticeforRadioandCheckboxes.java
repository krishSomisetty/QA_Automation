import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class praticeforRadioandCheckboxes {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement radio2btn = driver.findElement(By.cssSelector("input[value='radio2']"));
        radio2btn.click();
        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkBoxOption1"));
        checkbox1.click();
        if(radio2btn.isSelected() && checkbox1.isSelected()){
            System.out.println("radio button and checkbox is selected");
        }
        else{
            System.out.println("radio button and checkbox is not selected");
        }
    }
}
