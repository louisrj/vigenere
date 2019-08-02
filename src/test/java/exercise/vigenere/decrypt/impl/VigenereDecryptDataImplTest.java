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
    String result = vigenereDecryptData.parseData("encrypt", "en");
    assertEquals("00", result);
  }


  @Test
  public void testDecryptOutsideCipherText() {
    String result = vigenereDecryptData.parseData("encrypt", "º¡¶¢");
    assertEquals("º¡¶¢", result);
  }

  @Test
  public void testSpecialCharsAndCipherChars() {
    String result = vigenereDecryptData.parseData("encrypt", "eº¡¶¢n");
    assertEquals("0º¡¶¢0", result);
  }
}
