public class practiceConstructor {
    String userName;
    String password;
    public practiceConstructor (String nameInput , String passInput){
        userName = nameInput;
        password = passInput;
    }
    public void login () {
        System.out.println("Logging in as " + userName + " with password " + password);
    }
    public static void main(String[] args){
practiceConstructor User1 = new practiceConstructor("Admin", "1234");
practiceConstructor User2 = new practiceConstructor("Guest", "0000");
   User1.login();
   User2.login();

    }
}
