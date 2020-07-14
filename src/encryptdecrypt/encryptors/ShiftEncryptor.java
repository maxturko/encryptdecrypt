package encryptdecrypt.encryptors;

public class ShiftEncryptor implements Encryptor {
    @Override
    public String encrypt(String data, int key) {
        StringBuilder encryptedString = new StringBuilder();
        for (Character ch : data.toCharArray()){
            char encryptedChar;
            if (ch <= 90 && ch >= 65) {
                encryptedChar = encryptLowerCaseChar(ch, key);
            } else if (ch <= 122 && ch >= 97) {
                encryptedChar = encryptUpperCaseChar(ch, key);
            } else {
                encryptedChar = ch;
            }
            encryptedString.append(encryptedChar);
        }
        return encryptedString.toString();
    }

    private char encryptLowerCaseChar (char encryptedCharacter, int key) {
        char decryptedCharacter = (char) (encryptedCharacter + key);
        if (decryptedCharacter <= 90 && decryptedCharacter >= 65) {
            return decryptedCharacter;
        } else if (key < 0) {
            return (char) (decryptedCharacter + 26);
        } else {
            return (char) (decryptedCharacter - 26);
        }
    }

    private char encryptUpperCaseChar (char encryptedCharacter, int key) {
        char decryptedCharacter = (char) (encryptedCharacter + key);
        if (decryptedCharacter <= 122 && decryptedCharacter >=97) {
            return decryptedCharacter;
        } else if (key < 0) {
            return (char) (decryptedCharacter + 26);
        } else {
            return (char) (decryptedCharacter - 26);
        }
    }
}