/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class cont {

    public static void main(String[] args) throws IOException {
        Scanner s=new Scanner(System.in);
        String line = s.nextLine();
        Map<String, Integer> frequency = new HashMap<>();

        if (!line.equals("")) {
            String[] words = line.split(" ");

            for (String word : words) {
                if (word == null) {
                    continue;
                }
                String processed = word.toLowerCase();
                processed = processed.replace(",", "");

                if (frequency.containsKey(processed)) {
                    frequency.put(processed,
                            frequency.get(processed) + 1);
                } else {
                    frequency.put(processed, 1);
                }
            }
        }

        System.out.println(frequency);
        
        
   //Latters
   String word1="";
    Map<String, Integer> frequencyLatter = new HashMap<>();
     if (!line.equals("")) {
       for (int i=0;i<line.length();i++){
        word1=line.substring(i);
         String []word={word1};
          for (String words : word) {
                  System.out.println(words);
                }
       }
     }
    }
}
