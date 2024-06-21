package main;

import file.RenameFile;

public class Main {
    public static void main(String[] args) {
        try {
            RenameFile renameFile = new RenameFile();
        
            String sourceFilePath = "C:\\Users\\Henintsoa\\Documents\\github\\MdBaovola\\Baovola\\database\\sql\\donnee.sql";
            String newFileName = "data.sql";
            
            boolean result = renameFile.renameFile(sourceFilePath, newFileName);
            if (result) {
                System.out.println("File renamed successfully");
            } else {
                System.out.println("File renaming failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
