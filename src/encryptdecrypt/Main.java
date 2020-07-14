package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String in = "";
        String out = "";
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
            }
        }

        if (mode.equals("enc")) {
            String encryptedString = "";
            if ("".equals(in)){
                encryptedString = encrypt(data, key);
            } else {
                encryptedString = encrypt(readFromFile(in), key);
            }

            if ("".equals(out)){
                System.out.println(encryptedString);
            } else {
                writeToFile(encryptedString, out);
            }
        } else {
            String decryptedString = "";
            if ("".equals(in)) {
                decryptedString = decrypt(data, key);
            } else {
                decryptedString = decrypt(readFromFile(in), key);
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
        try {
            Scanner scanner = new Scanner(new File(path));
            sb.append(scanner.nextLine());
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return sb.toString();
    }

    public static void writeToFile(String encryptedString, String path) {
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.write(encryptedString);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static String encrypt(String data, int key) {
        StringBuilder encryptedString = new StringBuilder();
        for (Character ch : data.toCharArray()){
            encryptedString.append((char)(ch + key));
        }
        return encryptedString.toString();
    }

    public static String decrypt(String data, int key) {
        StringBuilder decryptedString = new StringBuilder();
        for (Character ch : data.toCharArray()){
            decryptedString.append((char)(ch - key));
        }
        return decryptedString.toString();
    }
}
