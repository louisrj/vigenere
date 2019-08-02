package exercise.vigenere.encrypt;

/**
 * Interface which can be implemented by a class to encrypt a target string using the cipher text and encrypt key.
 */
public interface EncryptData {

  /**
   * Encrypts target string based on the characters in the cipher text and encrypt key. If a character in the target
   * string doesn't belong to cipher text, then the char is appended to encrypted string as is. Index of character in
   * encrypt key will not be incremented in this case.
   *
   * @param key    String of character sequence to be used as encrypt key.
   * @param target String which needs to be encrypted.
   * @return Encrypted string.
   */
  String parseData(String key, String target);
}