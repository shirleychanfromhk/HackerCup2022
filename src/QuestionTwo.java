import util.ReadFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionTwo {
    /*
    * Recursion
    * if row == 1 -> Impossible
    * if element all '.' -> possible
    * if r==1 have '^' -> Impossible, all'.' -> possible
    * if c==1 have '^' -> Impossible , all'.' -> possible
    * */

    public static void main(String[] args){
        // File Input
        String fileInputPath = "src/data/input/q2";
        String inputFileName = "second_friend_input.txt";

        // File Output
        String fileOutputPath = "src/data/output/q2";
        String outputFileName = "second_friend_output.txt";

        // IO Class
        ReadFile myReadFile = new ReadFile(fileInputPath, inputFileName);

        String res[] = myReadFile.getFile();

        List<List<String>> ans = intake(res);

        try{
            FileWriter myFile = new FileWriter(fileOutputPath + "/" + outputFileName);
            for(int i = 0; i < ans.size(); i++){
                int n = ans.get(i).size();
                List<String> temp = new ArrayList<>();
                for(int j = 0; j < n; j++){
                    temp.add(ans.get(i).get(j));
                }
                myFile.write("Case #" + (i + 1) + ": " + ans.get(i).get(0) + " \n");
                for(int j = 1; j < temp.size(); j++){
                    myFile.write(temp.get(j) + " \n");
                }
            }
            myFile.close();
            System.out.println("Execute -> Succeed");
        } catch (IOException e){
            System.out.println("File Output Error");
            e.printStackTrace();
        }
    }
    private static List<String> solve(int r, int c, List<String> res){
        List<String> result = new ArrayList<>();
        //StringBuilder sb = new StringBuilder();
        for(String ele: res){
            if(c==1||r==1){
                if(ele.contains("^")){
                    result.add("Impossible");
                    return result;
                }
                result.add(".");
            }else{
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<c; i++){
                    sb.append("^");
                }
                result.add(sb.toString());
            }
        }

        result.add(0, "Possible");
        return result;
    }

    private static List<List<String>> intake(String[] input){
        int m = Integer.parseInt(input[0]);

        List<List<String>> ans = new ArrayList<>();

        int count = 1;
        // Construct your input here

        count = 1;
        for(int i = 1; i < input.length; i += count){
            String[] curr = input[i].split(" ");
            int r = Integer.parseInt(curr[0]), c = Integer.parseInt(curr[1]);

            List<String> res = new ArrayList<>();
            for(int j = i + 1; j <= i + r; j++){
                res.add(input[j]);
            }
            ans.add(solve(r, c, res));
            count = r + 1;
        }

        return ans;
    }
}
