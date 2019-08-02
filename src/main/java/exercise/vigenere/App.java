package exercise.vigenere;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static final String CIPHER_CHAR_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz \t\n\r~!@#$%^&*()_+-=[]\\{}|;':\",./<>?";
    public static final String CIPHER_CHAR_SET_A = "abcdefghijklmnopqrstuvwxyz";



    public static void main(String args[]) {
//        if (args.length != 3) {
//            System.out.println("Exact 3 parameters required - [action] [key] [target]");
//            System.exit(1);
//        }
//
//        String action, key, target;
//        action = args[0];
//        key = args[1];
//        target = args[2];
//
//        EncryptImpl encryptImpl = new EncryptImpl();
//        DecryptImpl decryptImpl = new DecryptImpl();
//
//        if ("encryptImpl".equalsIgnoreCase(action)) {
//            EncryptImpl.encryptWords("top secret");
//            System.out.println("encryptImpl [" + key + "], [" + target + "]");
//        } else if ("decryptImpl".equalsIgnoreCase(action)) {
//            System.out.println("decryptImpl [" + key + "], [" + target + "]");
//        } else if ("encryptDir".equalsIgnoreCase(action)) {
//            System.out.println("encryptDir [" + key + "], [" + target + "]");
//        } else if ("decryptDir".equalsIgnoreCase(action)) {
//            System.out.println("decryptDir [" + key + "], [" + target + "]");
//        } else {
//            System.out.println("action [" + action + "] not implemented");
//        }


        //test comment
        App app = new App();
        System.out.println(app.encrypt("top secret", "encrypt"));
        System.out.println(app.decrypt(app.encrypt("top secret", "encrypt"), "encrypt"));

    }

    private String encrypt(String input, String key) {
        Map<Character, Integer> cipherIndexMap = new HashMap<>();
        for (int i = 0; i < CIPHER_CHAR_SET.length(); i++) {
                cipherIndexMap.put(CIPHER_CHAR_SET.charAt(i), i);
        }

        StringBuilder res = new StringBuilder();
        int keyIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            if (cipherIndexMap.containsKey(input.charAt(i))) {
                int index = (cipherIndexMap.get(input.charAt(i)) + cipherIndexMap.get(key.charAt(keyIndex))) % 26;
                keyIndex = (keyIndex + 1) % key.length();
                res.append(CIPHER_CHAR_SET.charAt(index));
            } else {
                res.append(input.charAt(i));
            }
        }

        return res.toString();
    }

    private String decrypt(String input, String key) {
        Map<Character, Integer> cipherIndexMap = new HashMap<>();
        for (int i = 0; i < CIPHER_CHAR_SET.length(); i++) {
            cipherIndexMap.put(CIPHER_CHAR_SET.charAt(i), i);
        }

        StringBuilder res = new StringBuilder();
        int keyIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            if (cipherIndexMap.containsKey(input.charAt(i))) {
                int index = (cipherIndexMap.get(input.charAt(i)) - cipherIndexMap.get(key.charAt(keyIndex)) + 26 ) % 26;
                keyIndex = (keyIndex + 1) % key.length();
                res.append(CIPHER_CHAR_SET.charAt(index));
            } else {
                res.append(input.charAt(i));
            }
        }

        return res.toString();

    }
}
