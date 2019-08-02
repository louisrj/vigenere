package exercise.vigenere.encrypt.impl;

import exercise.vigenere.encrypt.EncryptDir;
import org.junit.Before;
import org.junit.Test;

public class EncryptDirImplTest {

  private EncryptDir encryptDir;

  @Before
  public void setUp() {
    encryptDir = new EncryptDirImpl();
  }

  @Test
  public void testValidPathToDir() {
    encryptDir.parseDir("encrypt", "/Users/rahuljohnlouis/Downloads/exercise-dist-vigenere/sample_dir");
  }

  @Test
  public void testInvalidPathToDir() {
    encryptDir.parseDir("encrypt", "abc");
  }
}
