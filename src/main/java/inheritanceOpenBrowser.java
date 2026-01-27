class BaseTest {
    public void openingBrowser(){
        System.out.println("Opening Chrome");
    }
    public void closingBrowser(){
        System.out.println("Closing chrome");
    }
}
class AmazonTest extends BaseTest{
    public void login(String username){
        System.out.println("Logging as " + username);
    }
    public void search(String item){
        System.out.println("Searching for " + item);
    }
}

public class inheritanceOpenBrowser {
    public static void main(String[] args){
        AmazonTest test = new AmazonTest();
        test.openingBrowser();
        test.login("Krish");
        test.search("ARMANI EXCHANGE");
        test.closingBrowser();
    }
}
