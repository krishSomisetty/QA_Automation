public class fundamentalJavaPrograms {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 5};
        for(int number : num ){
switch (number){
    case 1 :
        System.out.println("pass ");
        break;
    case 2 :
        System.out.println("Fail ");
        break;
    case 3 :
        System.out.println("Skip ");
        break;
    default :
        System.out.println("unknown ");

}
        }
    }
}
