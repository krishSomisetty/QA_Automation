class sampleTest{
    public void login(){
        System.out.println("Logging with password");
    }
}
class MobileTest extends sampleTest{
    public void login(){
        System.out.println("Logging with Face ID");
    }
}
public class methodOverriding {
    public static void main (String[] args){
        MobileTest mobile = new MobileTest();
        mobile.login();
    }
}
