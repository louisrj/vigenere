package exercise.vigenere.encrypt.impl;

import exercise.vigenere.encrypt.EncryptDir;
import exercise.vigenere.util.FileReaderUtil;

import java.io.File;

/**
 * Implementation of {@link EncryptDir} interface to encrypt files from input directory path.
 */
public class EncryptDirImpl implements EncryptDir {

  private static final String ENCRYPTED = ".encrypted";
  private static final String BACKSLASH = "/";

  @Override
  public void parseDir(String key, String pathToDir) {
    if (FileReaderUtil.exists(pathToDir)) {
      final File folder = new File(pathToDir);
      encryptDir(folder, pathToDir + ENCRYPTED, key);
    } else {
      System.out.println("Target path does not exist.");
    }
  }

  private void encryptDir(File folder, String pathToDir, String key) {
    for (final File fileEntry : folder.listFiles()) {
      if (fileEntry.isDirectory()) {
        encryptDir(fileEntry, pathToDir + "/" + fileEntry.getName(), key);
      } else {
        if (FileReaderUtil.isAllowableFile(fileEntry)) {
          createEncryptedFile(fileEntry, pathToDir + BACKSLASH + fileEntry.getName(), key);
        }
      }
    }
  }

  private void createEncryptedFile(File fileEntry, String pathToDir, String key) {
    VigenereEncryptImpl vigenereEncrypt = new VigenereEncryptImpl();
    String encrypt = vigenereEncrypt.parseData(key, FileReaderUtil.readFile(fileEntry.getAbsolutePath()));
    FileReaderUtil.createFiles(encrypt, pathToDir);
  }
}