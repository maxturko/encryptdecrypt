package encryptdecrypt.dectyptors;

public class ShiftDecryptor implements Decryptor {
    @Override
    public String decrypt(String data, int key) {
        StringBuilder decryptedString = new StringBuilder();
        for (Character ch : data.toCharArray()){
            char decryptedChar;
            if (ch <= 90 && ch >= 65) {
                decryptedChar = decryptLowerCaseChar(ch, key);
            } else if (ch <= 122 && ch >=97) {
                decryptedChar = decryptUpperCaseChar(ch, key);
            } else {
                decryptedChar = ch;
            }
            decryptedString.append(decryptedChar);
        }
        return decryptedString.toString();
    }

    private char decryptLowerCaseChar (char encryptedCharacter, int key) {
        char decryptedCharacter = (char) (encryptedCharacter - key);
        if (decryptedCharacter <= 90 && decryptedCharacter >= 65) {
            return decryptedCharacter;
        } else if (key > 0) {
            return (char) (decryptedCharacter + 26);
        } else {
            return (char) (decryptedCharacter - 26);
        }
    }

    private char decryptUpperCaseChar (char encryptedCharacter, int key) {
        char decryptedCharacter = (char) (encryptedCharacter - key);
        if (decryptedCharacter <= 122 && decryptedCharacter >=97) {
            return decryptedCharacter;
        } else if (key > 0) {
            return (char) (decryptedCharacter + 26);
        } else {
            return (char) (decryptedCharacter - 26);
        }
    }
}