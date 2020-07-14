package encryptdecrypt.encryptorfactory;

import encryptdecrypt.encryptors.Encryptor;
import encryptdecrypt.encryptors.ShiftEncryptor;
import encryptdecrypt.encryptors.UnicodeEncryptor;

public class EncryptorFactory {
    public static Encryptor createEncryptor(String alg) {
        switch (alg) {
            case "shift": return new ShiftEncryptor();
            case "unicode": return new UnicodeEncryptor();
            default: return null;
        }
    }
}