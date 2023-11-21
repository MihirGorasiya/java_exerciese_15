public interface IEncryptable {
    String encrypt();
    boolean isOriginal(String text);
}