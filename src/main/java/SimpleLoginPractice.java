import java.util.Scanner;

public class SimpleLoginPractice {
    public static void main (String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Name of Employee");
        String name = reader.nextLine();
        System.out.println("Your Intake salary");
        double salary = reader.nextDouble();
        System.out.println("Employee details---");
        System.out.println("Name " + name);
        System.out.println("Salary " + salary);
reader.close();
    }
    }

