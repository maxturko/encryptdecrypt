package encryptdecrypt.encryptors;

public class UnicodeEncryptor implements Encryptor {
    @Override
    public String encrypt(String data, int key) {
        StringBuilder encryptedString = new StringBuilder();
        for (Character ch : data.toCharArray()){
            encryptedString.append((char)(ch + key));
        }
        return encryptedString.toString();
    }
}