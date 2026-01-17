import java.util.Scanner;
public class PracticeConcepts {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        //Ask the name of the employee
        System.out.println("What's your Name?");
        String employeeName = reader.nextLine();
        //Ask the Monthly salary of the employee
        System.out.println("What's your Monthly Salary");
        double monthlySalary = reader.nextDouble();
        //Calculate the yearly salary
        double yearlySalary = monthlySalary * 12 ;
        //Calculate tax on the annual income
        double taxRate = 0.05;
        double taxonAnnualIncome = yearlySalary * taxRate;
        //Calculate taxforMontlyIncome
        double taxonMontlyIncome = (yearlySalary * taxRate)/12;
        //Calculate PF cutting from employee salary
        double pfCutonSalary = monthlySalary * taxRate;
        //Calculate InHand Salary
        double InHandSalary = monthlySalary - taxonMontlyIncome - pfCutonSalary;
        // Gross salary of employee
        double grossSalary = monthlySalary + (pfCutonSalary);
        // check if the employee is senior or mid level or entry level
        String employeeExperience ="";
        if(InHandSalary > 55000){
            employeeExperience ="Senior";
        } else if (InHandSalary > 40000) {
            employeeExperience ="Mid-level";
        } else{
            employeeExperience ="Entry-level";
        }
        //Employee Salary profile
        System.out.println("--- Employee Salary Profile ---");
        System.out.println("Name: " + employeeName);
        System.out.println("Salary: " + monthlySalary);
        System.out.println("Yearly Salary " + yearlySalary);
        System.out.println("Experience Level " + employeeExperience);
        System.out.println("Tax cuts on Annual Income " + taxonAnnualIncome);
        System.out.println("PF for employee " + pfCutonSalary);
        System.out.println("InHand Salary of Employee " + InHandSalary);

        reader.close();
    }
}
