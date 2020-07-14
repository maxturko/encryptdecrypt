package encryptdecrypt.decryptorfactory;

import encryptdecrypt.dectyptors.Decryptor;
import encryptdecrypt.dectyptors.ShiftDecryptor;
import encryptdecrypt.dectyptors.UnicodeDecryptor;

public class DecryptorFactory {
    public static Decryptor createDecryptor(String alg) {
        switch (alg) {
            case "shift": return new ShiftDecryptor();
            case "unicode": return new UnicodeDecryptor();
            default: return null;
        }
    }
}