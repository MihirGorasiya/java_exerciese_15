public class Main {

    public static void main(String[] args) {
        System.out.println("-------------------------------");
        System.out.println("Checking Twitter Class");
        System.out.println("-------------------------------");

        // 1. Create a new Tweet and output the original and encrypted tweet:
        TwitterTweet t = new TwitterTweet("therealdonaldtrump", "If you can protest in person you can vote in person");
        String encryptedValue = t.encrypt();
        System.out.println("Original tweet: \n\t" + t.getTweet());
        System.out.println("Encrypted tweet is: \n\t" + encryptedValue);

        // 2. Checking if encrypted text is the same as the original tweet:
        System.out.println("-------------------------------");
        System.out.println("Checking message 1:");
        System.out.println("-------------------------------");

        String message1 = "fIeq ouyeq anceq rotestpeq nieq ersonpeq ouyeq anceq oteveq nieq ersonpeq";
        System.out.println("Encrypted message: \n\t" + message1);

        boolean checkMessage1 = t.isOriginal(message1);
        System.out.println("Is this the same as the original tweet? \n\t"  + checkMessage1);


        // 3. Checking if another text is the same as the original tweet:
        System.out.println("-------------------------------");
        System.out.println("Checking message 2:");
        System.out.println("-------------------------------");

        String message2 = "Ieq adheq aeq otleq oteq odeq odayteq utbeq nsteadieq Ieq ookteq aeq apneq";
        System.out.println("Encrypted Message: \n\t" + message2);

        boolean checkMessage2 = t.isOriginal(message2);
        System.out.println("Is this the same as the original tweet? \n\t"  + checkMessage2);

        // --------------------------------
        // Testing the SMS Message Class
        // --------------------------------
        System.out.println("\n\n-------------------------------");
        System.out.println("Checking SMS Message Class");
        System.out.println("-------------------------------");

        // 1. Create a new SMS message and output the encrypted value
        SMSMessage message = new SMSMessage("908-505-1234", "905-801-5555", "When are we meeting for dinner? Text me back!");
        message.sendMessage();

        // 2. Test if an encrypted phone number is the same as the original number
        System.out.println("Here is an encrypted phone number: ");
        String encryptedPhoneNumber = "----.--------.......-----......----..---...--....-";
        System.out.println("\t"+encryptedPhoneNumber);

        boolean phoneCheck = message.isOriginal(encryptedPhoneNumber);
        System.out.println("Are the phone numbers the same? \n\t" + phoneCheck);
    }
}
