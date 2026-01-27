abstract class BaseAuth{
    abstract void login();
}
class GoogleLogin extends BaseAuth{
public void login(){
    System.out.println("Google login successful");
}
}

public class abstractionExample {
    public static void main(String[] args){
        GoogleLogin g = new GoogleLogin();
        g.login();
        }
    }

