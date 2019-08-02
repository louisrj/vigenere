package exercise.vigenere.decrypt.impl;

import org.junit.Before;
import org.junit.Test;

public class DecryptDirImplTest {

  DecryptDirImpl decryptDir;

  @Before
  public void setUp() {
    decryptDir = new DecryptDirImpl();
  }

  @Test
  public void testValidPathToDir() {
    decryptDir.parseDir("encrypt", "/Users/rahuljohnlouis/Downloads/exercise-dist-vigenere/sample_dir");
  }


  @Test
  public void testInvalidPathToDir() {
    decryptDir.parseDir("encrypt", "abc");
  }
}
