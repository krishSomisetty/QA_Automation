interface webdriver{
    void get(String url);
    void close();
}
class chromedriver implements webdriver {
    @Override
    public void get(String url) {
        System.out.println("Chrome is navigating to " + url);
    }

    @Override
    public void close() {
        System.out.println("Chrome is shutting down.");
    }
}
class Firefox implements webdriver{
    @Override
    public void get(String url) {
        System.out.println("Firefox is navigating to " + url);
    }

    @Override
    public void close() {
        System.out.println("Firefox is shutting down");
    }
}
public class interfacePractice {
    public static void main (String[] args){
        webdriver driver = new chromedriver();
        driver.get("www.youtube.com");
         driver =new Firefox();
        driver.get("www.google.com");
    }
}
