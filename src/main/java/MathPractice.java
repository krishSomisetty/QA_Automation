public class MathPractice {
    public static void main (String[] args){
        double myBudget = 15000.00;
        double price = 13000.00;
        boolean Affordable = myBudget>price;
        System.out.println("Can i afford the mobile " + Affordable);
        boolean isPremium = price > 12000;
        System.out.println("Is it Premium cost " + isPremium);
        boolean IcanBuy = Affordable && isPremium;
        System.out.println("I can buy the premium mobile " + IcanBuy);

    }

}
