package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    private String filePath;
    private String fileName;

    public WriteFile(String filePath, String fileName){
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public <T> void createFile(List<T> res){
        try{
            int index = 1;
            FileWriter myFile = new FileWriter(filePath + "/" + fileName);
            for(T r : res) {
                myFile.write("Case #" + index + ": " + r + " \n");
                index++;
            }
            myFile.close();
            System.out.println("Execute -> Succeed");
        }
        catch (IOException e){
            System.out.println("File Output Error");
            e.printStackTrace();
        }
    }
}
