import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

public class MobilePhoneSpec {
    public static void main (String[] args){
        String mobileName ="OnePlusNord";
        double price = 35000.00;
        int RAMGB = 12;
        char Grade = 'A';
        boolean is5G = true;
System.out.println("Phone Details");
System.out.println("Brand " + mobileName);
System.out.println("RAM " + RAMGB);
System.out.println("Rating " + Grade);
System.out.println("Network " + is5G);
    }
}
