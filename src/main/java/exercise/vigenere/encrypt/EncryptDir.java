package exercise.vigenere.encrypt;

/**
 * A class can implement EncryptDir interface when it wants to encrypt files from a certain directory path.
 *
 * All files in the sub directories will be encrypted as well.
 */
public interface EncryptDir {

  /**
   * Encrypts files using the input directory path. All files in the sub directories will be encrypted as well.
   *
   * Encrypted files will stored with directory path starting at the path and appending ".encrypted" at the top
   * directory. All files decrypted will have the same name as path inside this ".encrypted" folder.
   *
   * @param key       String of character sequence to be used as encrypt key.
   * @param pathToDir Absolute path of the directory to encrypt.
   */
  void parseDir(String key, String pathToDir);

}
