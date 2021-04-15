package net.roaringmind.copyfolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Hello world!
 *
 */
public class CopyFolder {
  public static void main(String[] args) {
    Path source = Paths.get("Folder1");
    Path target = Paths.get("Folder2");

    try {
      copyDirectory(source, target);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void copyDirectory(Path source, Path target) throws IOException {
    Files.walk(source).forEach(sourcePath -> {
      Path targetPath = target.resolve(source.relativize(sourcePath));
      try {
        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
  }
}
