package exercise.vigenere.decrypt;

/**
 * A class can implement DecryptDir interface when it wants to decrypt files from a certain directory path.
 */
public interface DecryptDir {

  /**
   * Decrypts files using the directory path. All files in the sub directories will be decrypted as well.
   *
   * Decrypted files will stored with directory path starting at the path and appending ".decrypted" at the top
   * directory. All files decrypted will have the same name as path inside this ".decrypted" folder.
   *
   * @param key       String of character sequence to be used as encrypt key.
   * @param pathToDir Absolute path of the directory to decrypt.
   */
  void parseDir(String key, String pathToDir);

}
