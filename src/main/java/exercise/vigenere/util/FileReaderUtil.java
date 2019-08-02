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

public class FileReaderUtil {

  private static final List<String> validFileTypes = Arrays.asList("txt", "doc", "docx");

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
      System.out.println("here");
      // Report
    }
  }

  public static String readFile(String filePath) {
    String content = "";
    try {
      content = new String(Files.readAllBytes(Paths.get(filePath)));
    } catch (IOException e) {
      //TODO
      e.printStackTrace();
    }
    return content;
  }

  public static boolean isAllowableFile(File fileEntry) {
    return fileEntry.isFile() && FileReaderUtil.allowableFileType(fileEntry.getName());
  }

  private static boolean allowableFileType(String fileName) {
    for (String extension : validFileTypes) {
      if (fileName.toLowerCase().endsWith(extension)) return true;
    }
    return false;
  }

  public static boolean exists(String pathToDir) {
    return Files.isDirectory(Paths.get(pathToDir));
  }
}
