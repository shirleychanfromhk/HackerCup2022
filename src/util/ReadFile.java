package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private String filePath;
    private String fileName;

    public ReadFile(String filePath, String fileName){
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public String[] getFile(){
        List<String> res = new ArrayList<String>();
        try{
            File myFile = new File(new File(filePath), fileName);
            Scanner myReader = new Scanner(myFile);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                res.add(data);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File Input Error");
            e.printStackTrace();
        }

        Object[] temp = res.toArray();
        return Arrays.copyOf(temp, temp.length, String[].class);
    }
}