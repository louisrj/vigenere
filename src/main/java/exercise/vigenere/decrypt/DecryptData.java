package exercise.vigenere.decrypt;

/**
 * Interface which can be implemented by a class to decrypt a target string using the cipher text and encrypt key.
 */
public interface DecryptData {

  /**
   * Decrypts target string based on the characters in the cipher text and encrypt key. If a character in the target
   * string doesn't belong to cipher text, then the char is appended to decrypted string as is. Index of character in
   * encrypt key will not be incremented in this case.
   *
   * @param key    String of character sequence to be used as encrypt key.
   * @param target String which needs to be decrypted.
   * @return Decrypted string.
   */
  String parseData(String key, String target);
}
