import java.util.Scanner;
public class UserInteractionSample {
public static void main(String[] args){
    Scanner reader = new Scanner(System.in);
    //Ask Age of the user
    System.out.println("What's Your Name?");
    String name = reader.next();
    //Ask the Age of the user
    System.out.println("What's Your Age?");
    int Age = reader.nextInt();
    //Ask whether the user is Single or Married
    System.out.println("What's Your Marital status? Type Single or Married");
    String isMarried = reader.next();
    boolean Married = isMarried.equalsIgnoreCase("Married");

    System.out.println("--- User Profile ---");
    System.out.println("Name: " + name);
    System.out.println("Age: " + Age);
    System.out.println("Is Married (Boolean value): " + Married);
    reader.close();
}
}
