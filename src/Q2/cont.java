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
import java.util.TreeMap;

/**
 *
 * @author PC
 */
public class cont {
    

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Your text *_*");
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
        Map<Character, Integer> frequencyLatter = new HashMap<>();
        for (char c : line.toCharArray()) {
            if (c == ' ') {
                continue;
            } else if (frequencyLatter.containsKey(c)) {
                frequencyLatter.put(c, (1 + frequencyLatter.get(c)));
            } else {
                frequencyLatter.put(c, 1);
            }
        }
                    System.out.println(frequencyLatter);
                    for (Integer val:frequencyLatter.values()){
                       System.out.println(val);
                       
                      if(val==2){
                       System.out.println(frequencyLatter.remove(frequencyLatter.keySet()));
                      }
                    

                    }
                 

    }
}
