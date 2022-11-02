import util.ReadFile;
import util.WriteFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionOne {
    /*
    Only two display box
    * capacity enough? capacity*2 < displayAmount -> NO
    * duplicate number of each box?
    *  Map<element, amount> if value >2 -> No
    * */
    public static void main(String[] args) {
        String fileInputPath = "src/data/input/q1";
        String inputFileName = "second_hands_input.txt";

        // File Output
        String fileOutputPath = "src/data/output/q1";
        String outputFileName = "second_hands_output.txt";

        // IO Class
        ReadFile myReadFile = new ReadFile(fileInputPath, inputFileName);
        WriteFile myWriteFile = new WriteFile(fileOutputPath, outputFileName);

        String res[] = myReadFile.getFile();

        List<String> ans = intake(res);

        myWriteFile.createFile(ans);
    }

    private static List<String> intake(String[] input){
        int m = Integer.parseInt(input[0]);

        List<String> ans = new ArrayList<>();

        // Construct your input here
        for(int i = 1; i <= m * 2; i += 2){
            String[] a = input[i].split(" ");
            String[] b = input[i + 1].split(" ");

            int n = Integer.parseInt(a[0]);
            int k = Integer.parseInt(a[1]);

            List<Integer> bnum = new ArrayList<>();
            for(String num : b) bnum.add(Integer.parseInt(num));

            ans.add(solve(n, k, bnum));
        }

        return ans;
    }

    private static String solve(int displayAmount, int capacity, List<Integer> displays){
        if(capacity*2 < displayAmount) return "NO";
        Map<Integer, Integer> duplicateMap = new HashMap<>();
        for(int i: displays){
            duplicateMap.put(i, duplicateMap.getOrDefault(i, 0)+1);
            if(duplicateMap.get(i) >2) return "NO";
        }
        return "YES";
    }
}
