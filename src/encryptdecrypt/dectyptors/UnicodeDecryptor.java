package encryptdecrypt.dectyptors;

public class UnicodeDecryptor implements Decryptor {
    @Override
    public String decrypt(String data, int key) {
        StringBuilder decryptedString = new StringBuilder();
        for (Character ch : data.toCharArray()){
            decryptedString.append((char)(ch - key));
        }
        return decryptedString.toString();
    }
}