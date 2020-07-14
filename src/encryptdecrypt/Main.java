package encryptdecrypt;

import encryptdecrypt.decryptorfactory.DecryptorFactory;
import encryptdecrypt.dectyptors.Decryptor;
import encryptdecrypt.encryptorfactory.EncryptorFactory;
import encryptdecrypt.encryptors.Encryptor;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String in = "";
        String out = "";
        String alg = "shift";
        for (int i = 0; i < args.length;i++){
            switch(args[i]) {
                case "-mode":
                    mode = args[++i];
                    break;
                case "-key":
                    key = Integer.parseInt(args[++i]);
                    break;
                case "-data":
                    data = args[++i];
                    break;
                case "-in":
                    in = args[++i];
                    break;
                case "-out":
                    out = args[++i];
                    break;
                case "-alg":
                    alg = args[++i];
                    break;
                default: break;
            }
        }

        Decryptor decryptorService = DecryptorFactory.createDecryptor(alg);
        Encryptor encryptorService = EncryptorFactory.createEncryptor(alg);

        if (mode.equals("enc")) {
            String encryptedString = "";
            if ("".equals(in)){
                encryptedString = encryptorService.encrypt(data, key);
            } else {
                encryptedString = encryptorService.encrypt(readFromFile(in), key);
            }

            if ("".equals(out)){
                System.out.println(encryptedString);
            } else {
                writeToFile(encryptedString, out);
            }
        } else {
            String decryptedString = "";
            if ("".equals(in)) {
                decryptedString = decryptorService.decrypt(data, key);
            } else {
                decryptedString = decryptorService.decrypt(readFromFile(in), key);
            }
            if ("".equals(out)) {
                System.out.println(decryptedString);
            } else {
                writeToFile(decryptedString, out);
            }

        }

    }

    public static String readFromFile(String path) {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(path))) {
            sb.append(scanner.nextLine());
        } catch (IOException e) {
            System.out.println("Error");
        }
        return sb.toString();
    }

    public static void writeToFile(String encryptedString, String path) {
        try (FileWriter fileWriter = new FileWriter(new File(path))) {
            fileWriter.write(encryptedString);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}