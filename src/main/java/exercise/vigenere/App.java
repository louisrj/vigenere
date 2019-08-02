package exercise.vigenere;

import com.sun.xml.internal.ws.util.ASCIIUtility;

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
        app.encrypt("a");

    }

    private String encrypt(String target) {
        int i  = '\n' - ' ';
        System.out.println(i);
        return null;
    }
}
