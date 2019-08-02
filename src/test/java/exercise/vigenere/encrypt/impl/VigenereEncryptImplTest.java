package exercise.vigenere.encrypt.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VigenereEncryptImplTest {

  VigenereEncryptImpl vigenereEncrypt;

  @Before
  public void setUp() {
    vigenereEncrypt = new VigenereEncryptImpl();
  }

  @Test
  public void testDecryptWord() {
    String result = vigenereEncrypt.parseData("encrypt", "0000000");
    assertEquals("encrypt", result);
  }


  @Test
  public void testDecryptOutsideCipherText() {
    String result = vigenereEncrypt.parseData("encrypt", "º¡¶¢");
    assertEquals("º¡¶¢", result);
  }

  @Test
  public void testSpecialCharsAndCipherChars() {
    String result = vigenereEncrypt.parseData("encrypt", "0º¡¶¢0º¡¶¢0º¡¶¢0º¡¶¢0º¡¶¢0º¡¶¢0");
    assertEquals("eº¡¶¢nº¡¶¢cº¡¶¢rº¡¶¢yº¡¶¢pº¡¶¢t", result);
  }

}
