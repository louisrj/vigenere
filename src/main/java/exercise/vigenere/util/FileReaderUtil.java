package exercise.vigenere.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Miscellaneous file utility methods. Mainly for file CRUD operations and validation.
 */
public class FileReaderUtil {

  private static final List<String> validFileTypes = Arrays.asList("txt", "doc", "docx");

  /**
   * Creates a file using the absolute path to directory and input string.
   *
   * @param fileText  Input string to be inserted to file.
   * @param pathToDir Absolute path of directory where the file will be created.
   */
  public static void createFiles(String fileText, String pathToDir) {
    try {
      Path pathToFile = Paths.get(pathToDir);
      if (Files.notExists(pathToFile)) {
        Files.createDirectories(pathToFile.getParent());
        Files.createFile(pathToFile);
      }

      BufferedWriter writer = new BufferedWriter(new FileWriter(pathToDir));
      writer.write(fileText);
      writer.close();
    } catch (IOException ex) {
      //TODO - Add retry strategy or exit.
      System.out.println("Failed to create file");
    }
  }

  /**
   * Reads a file and returns input content string.
   *
   * @param filePath Absolute path of file where contents will be read.
   * @return Content of input filePath.
   */
  public static String readFile(String filePath) {
    String content = "";
    try {
      content = new String(Files.readAllBytes(Paths.get(filePath)));
    } catch (IOException e) {
      System.out.println("Failed to read file contents in path " + filePath);
    }
    return content;
  }

  /**
   * Checks if a file is normal file and one of ".txt", ".doc" or ".docx"
   *
   * @param file Input file object.
   * @return Returns if input file is valid.
   */
  public static boolean isAllowableFile(File file) {
    return file.isFile() && FileReaderUtil.allowableFileType(file.getName());
  }

  /**
   * Checks if the filename ends with ".txt", ".doc" or ".docx"
   *
   * @param fileName Name of file with extension.
   * @return if extension is a valid type or not.
   */
  private static boolean allowableFileType(String fileName) {
    for (String extension : validFileTypes) {
      if (fileName.toLowerCase().endsWith(extension)) return true;
    }
    return false;
  }

  /**
   * Checks if a file exists in the input directory path or not.
   *
   * @param pathToDir Absolute path of the file.
   * @return Returns if the file exists.
   */
  public static boolean exists(String pathToDir) {
    return Files.isDirectory(Paths.get(pathToDir));
  }
}
