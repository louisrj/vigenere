package exercise.vigenere;

import exercise.vigenere.decrypt.DecryptData;
import exercise.vigenere.decrypt.DecryptDir;
import exercise.vigenere.decrypt.impl.DecryptDirImpl;
import exercise.vigenere.decrypt.impl.VigenereDecryptDataImpl;
import exercise.vigenere.encrypt.EncryptData;
import exercise.vigenere.encrypt.EncryptDir;
import exercise.vigenere.encrypt.impl.EncryptDirImpl;
import exercise.vigenere.encrypt.impl.VigenereEncryptImpl;

public class App {

  public static final String CIPHER_CHAR_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz \t\n\r~!@#$%^&*()_+-=[]\\{}|;':\",./<>?";

  public static void main(String args[]) {
    if (args.length != 3) {
      System.out.println("Exact 3 parameters required - [action] [key] [target]");
      System.exit(1);
    }

    String action, key, target;
    action = args[0];
    key = args[1];
    target = args[2];

    if ("encrypt".equalsIgnoreCase(action)) {
      encryptData(key, target);
    } else if ("decrypt".equalsIgnoreCase(action)) {
      decryptData(key, target);
    } else if ("encryptDir".equalsIgnoreCase(action)) {
      encryptDir(key, target);
    } else if ("decryptDir".equalsIgnoreCase(action)) {
      decryptDir(key, target);
    } else {
      System.out.println("action [" + action + "] not implemented");
    }
  }

  private static void encryptData(String key, String target) {
    EncryptData encryptData = new VigenereEncryptImpl();
    System.out.println(encryptData.parseData(key, target));
  }

  private static void decryptData(String key, String target) {
    DecryptData decryptData = new VigenereDecryptDataImpl();
    System.out.println(decryptData.parseData(key, target));
  }

  private static void encryptDir(String key, String pathToDir) {
    EncryptDir encryptDir = new EncryptDirImpl();
    encryptDir.parseDir(key, pathToDir);
  }

  private static void decryptDir(String key, String pathToDir) {
    DecryptDir decryptDir = new DecryptDirImpl();
    decryptDir.parseDir(key, pathToDir);
  }
}