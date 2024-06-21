package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RenameFile {
    public boolean renameFile(String sourceFilePath, String newFileName) {
        Path sourcePath = Paths.get(sourceFilePath);
        if (!Files.exists(sourcePath)) {
            System.out.println("Source file does not exist");
            return false;
        }
        
        Path targetPath = sourcePath.resolveSibling(newFileName);
        
        try {
            Files.move(sourcePath, targetPath);
            return true;
        } catch (IOException e) {
            System.out.println("Error renaming file: " + e.getMessage());
            return false;
        }
    }
}
