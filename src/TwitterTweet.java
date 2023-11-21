public class TwitterTweet implements IEncryptable{
    private String username;
    private int numCharacters;
    private String tweet;

    public TwitterTweet(String username, String tweet) {
        this.username = username;
        this.tweet = tweet;
        if (this.hasReachedMaximum() == true) {
            this.numCharacters = -1;
        }
        else {
            this.numCharacters = this.tweet.length();
        }

    }

    public boolean hasReachedMaximum() {
        if (this.tweet.length() > 140) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getTweet() {
        return this.tweet;
    }


    @Override
    public String encrypt() {
        String encrypted = "";
        String[] words = tweet.split(" ");

        for (String word: words) {
            encrypted = encrypted.concat(rearrange(word)+" ");
        }

        return encrypted;
    }

    public String rearrange(String word){
        String firstChar;
        String encryptedWord;
        int wordLength = word.length();

        firstChar = word.charAt(0) + "eq";
        encryptedWord = word.substring(1,wordLength);

        encryptedWord = encryptedWord.concat(firstChar);

        return encryptedWord;
    }

    @Override
    public boolean isOriginal(String text) {
        String decrypted = "";
        String[] words = text.split(" ");

        for (String word: words) {
            decrypted=decrypted.concat(decryptWord(word) + " ");
        }

        return tweet.equals(decrypted.trim());
    }

    public String decryptWord(String word){
        String decryptedWord;
        String restOfWord;
        int wordLength = word.length();
        restOfWord = word.substring(0, wordLength - 3);
        decryptedWord = String.valueOf(word.charAt(wordLength-3));

        decryptedWord = decryptedWord.concat(restOfWord);

        return decryptedWord;
    }
}
