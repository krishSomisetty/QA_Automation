public class stringPracticeExamples {
    public static void main(String[] args) {
        String s = "Selenium works fine without issue";
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--){
            rev = rev + s.charAt(i);
        }
        System.out.println("reverse of string " + rev);
    }

}
