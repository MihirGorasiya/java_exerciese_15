public class SMSMessage implements IEncryptable{

    private String from;
    private String to;
    private String message;

    public SMSMessage(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public void sendMessage() {
        //@NOTE: Do not change this function!
        System.out.println("The following message has been sent by " + this.encrypt() + " to " + this.to);
        System.out.println("\t" + this.message);
    }


    @Override
    public String encrypt() {
        String fromNumber = from.replace("-","");
        String encryptedString = "";

        for (int i = 0; i< fromNumber.length();i++) {
                encryptedString.join(MorseCodeUtilites.getMorseCode(fromNumber.charAt(i)),"");
        }
        return encryptedString;
    }

    @Override
    public boolean isOriginal(String text) {
        String[] nums = new String[10];
        String toNumber = "";
        int j=0;
        for(int i = 0;i<text.length();i=i+5){
            nums[j]=(text.substring(i,i+5));
            j++;
        }
        for (int i = 0; i<nums.length; i++) {
            if(i == 3 || i == 6)
                toNumber = toNumber.concat("-"+String.valueOf(MorseCodeUtilites.getNumber(nums[i])));
            else
                toNumber = toNumber.concat(String.valueOf(MorseCodeUtilites.getNumber(nums[i])));
        }

        return toNumber.equals(from);
    }
}
