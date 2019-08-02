package exercise.vigenere.decrypt.impl;


import exercise.vigenere.AbstractCipher;
import exercise.vigenere.decrypt.DecryptData;

import java.util.Map;

public class VigenereDecryptDataImpl extends AbstractCipher implements DecryptData {

  @Override
  public String parseData(String key, String target) {
    Map<Character, Integer> cipherIndexMap = getCipherIndexMap();
    StringBuilder res = new StringBuilder();
    int keyIndex = 0;
    for (int i = 0; i < target.length(); i++) {
      if (cipherIndexMap.containsKey(target.charAt(i))) {
        int index = (cipherIndexMap.get(target.charAt(i)) - cipherIndexMap.get(key.charAt(keyIndex)) + CIPHER_CHAR_SET.length()) % CIPHER_CHAR_SET.length();
        keyIndex = (keyIndex + 1) % key.length();
        res.append(CIPHER_CHAR_SET.charAt(index));
      } else {
        res.append(target.charAt(i));
      }
    }
    return res.toString();
  }

}
