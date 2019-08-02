package exercise.vigenere.encrypt.impl;

import exercise.vigenere.AbstractCipher;
import exercise.vigenere.encrypt.EncryptData;

import java.util.Map;

/**
 * Implements {@link EncryptData} interface to encrypt a target string.
 */
public class VigenereEncryptImpl extends AbstractCipher implements EncryptData {

  @Override
  public String parseData(String key, String target) {
    Map<Character, Integer> cipherIndexMap = getCipherIndexMap();
    StringBuilder res = new StringBuilder();
    int keyIndex = 0;
    for (int i = 0; i < target.length(); i++) {
      if (cipherIndexMap.containsKey(target.charAt(i))) {
        int index = (cipherIndexMap.get(target.charAt(i)) + cipherIndexMap.get(key.charAt(keyIndex))) % CIPHER_CHAR_SET.length();
        keyIndex = (keyIndex + 1) % key.length();
        res.append(CIPHER_CHAR_SET.charAt(index));
      } else {
        res.append(target.charAt(i));
      }
    }
    return res.toString();
  }
}
