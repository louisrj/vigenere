package exercise.vigenere;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCipher {

  protected static final String CIPHER_CHAR_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz \t\n\r~!@#$%^&*()_+-=[]\\{}|;':\",./<>?";

  protected Map<Character, Integer> getCipherIndexMap() {
    Map<Character, Integer> cipherIndexMap = new HashMap<>();
    for (int i = 0; i < CIPHER_CHAR_SET.length(); i++) {
      cipherIndexMap.put(CIPHER_CHAR_SET.charAt(i), i);
    }
    return cipherIndexMap;
  }
}
