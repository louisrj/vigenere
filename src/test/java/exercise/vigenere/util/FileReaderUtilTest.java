package exercise.vigenere.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class FileReaderUtilTest {

  @Test
  public void testCreateFileWithValidPath() {
    String filePath = "/Users/rahuljohnlouis/Downloads/exercise-dist-vigenere/sample_dir/abcde.txt";
    FileReaderUtil.createFile("abc", filePath);
    Assert.assertEquals("abc", FileReaderUtil.readFile(filePath));
  }

  @Test
  public void testReadFromFile() {
    String filePath = "/Users/rahuljohnlouis/Downloads/exercise-dist-vigenere/sample_dir/def.txt";
    FileReaderUtil.createFile("abc", filePath);
    Assert.assertEquals("abc", FileReaderUtil.readFile(filePath));
  }

  @Test
  public void testNotAllowableFile() {
    Assert.assertFalse(FileReaderUtil.isAllowableFile(new File("abc.txt")));
  }

  @Test
  public void testIsAllowableFileType() {
    String filePath = "/Users/rahuljohnlouis/Downloads/exercise-dist-vigenere/sample_dir/testIsAllowableFile.txt";
    FileReaderUtil.createFile("abc", filePath);
    Assert.assertTrue(FileReaderUtil.isAllowableFile(new File(filePath)));
  }

  @Test
  public void testInvalidFileExtensionType() {
    String filePath = "/Users/rahuljohnlouis/Downloads/exercise-dist-vigenere/sample_dir/testIsAllowableFile";
    FileReaderUtil.createFile("abc", filePath);
    Assert.assertFalse(FileReaderUtil.isAllowableFile(new File(filePath)));
  }

  @Test
  public void testValidFileExtensionType() {
    String filePath = "/Users/rahuljohnlouis/Downloads/exercise-dist-vigenere/sample_dir/testIsAllowableFile1.txt";
    FileReaderUtil.createFile("abc", filePath);
    Assert.assertTrue(FileReaderUtil.isAllowableFile(new File(filePath)));
  }

}
