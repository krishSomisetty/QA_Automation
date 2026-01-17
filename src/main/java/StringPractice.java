public class StringPractice {
    public static void main(String[] args){
        String errorMessage = "Invalid password Try Again";
        //change all the letters to uppercase
        System.out.println("Convert to uppercase " + errorMessage.toUpperCase());
        //check the error message has word password
        System.out.println("check it contains word password " + errorMessage.contains("password"));
        // count the length of the message
        System.out.println("Length of the message " + errorMessage.length());
        // check if the message contains the word success
        System.out.println("Is the Word contains Success " + errorMessage.contains("success"));



    }
}
