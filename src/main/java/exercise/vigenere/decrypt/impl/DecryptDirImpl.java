package exercise.vigenere.decrypt.impl;

import exercise.vigenere.decrypt.DecryptDir;
import exercise.vigenere.util.FileReaderUtil;

import java.io.File;

/**
 * Implementation of {@link DecryptDir} interface to decrypt files in path.
 */
public class DecryptDirImpl implements DecryptDir {
  private static final String DECRYPTED = ".decrypted";
  private static final String BACKSLASH = "/";

  @Override
  public void parseDir(String key, String pathToDir) {
    if (FileReaderUtil.exists(pathToDir)) {
      final File folder = new File(pathToDir);
      parseDir(folder, pathToDir + DECRYPTED, key);
    } else {
      System.out.println("Target path does not exist.");
    }
  }

  private void parseDir(File folder, String pathToDir, String key) {
    for (final File fileEntry : folder.listFiles()) {
      if (fileEntry.isDirectory()) {
        parseDir(fileEntry, pathToDir + "/" + fileEntry.getName(), key);
      } else {
        if (FileReaderUtil.isAllowableFile(fileEntry)) {
          createDecryptedFile(fileEntry, pathToDir + BACKSLASH + fileEntry.getName(), key);
        }
      }
    }
  }

  private void createDecryptedFile(File fileEntry, String pathToDir, String key) {
    VigenereDecryptDataImpl vigenereDecrypt = new VigenereDecryptDataImpl();
    String encrypt = vigenereDecrypt.parseData(key, FileReaderUtil.readFile(fileEntry.getAbsolutePath()));
    FileReaderUtil.createFiles(encrypt, pathToDir);
  }
}
