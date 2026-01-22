public class User {
    String userName;
    String password;
    public void login () {
        System.out.println("Logging in as " + userName);
    }
    public static void main(String[] args){
     User User1 = new User();
     User User2 = new User();
     User1.userName = "Admin";
     User1.password = "1234";
     User2.userName = "Guest";
     User2.password = "0000";
     User1.login();
     User2.login();

    }
}
