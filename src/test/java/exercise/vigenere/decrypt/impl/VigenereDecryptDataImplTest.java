package exercise.vigenere.decrypt.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VigenereDecryptDataImplTest {

  VigenereDecryptDataImpl vigenereDecryptData;

  @Before
  public void setUp() {
    vigenereDecryptData = new VigenereDecryptDataImpl();
  }

  @Test
  public void testDecryptWord() {
    String decrypt = vigenereDecryptData.parseData("encrypt", "en");
    assertEquals("00", decrypt);
  }


  @Test
  public void testDecryptOutsideCipherText() {
    String decrypt = vigenereDecryptData.parseData("encrypt", "º¡¶¢");
    assertEquals("º¡¶¢", decrypt);
  }

  @Test
  public void testSpecialCharsAndCipherChars() {
    String decrypt = vigenereDecryptData.parseData("encrypt", "eº¡¶¢n");
    assertEquals("0º¡¶¢0", decrypt);
  }
}
