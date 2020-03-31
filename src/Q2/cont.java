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

/**
 *
 * @author PC
 */
public class cont {
    public static void main(String[] args) throws IOException {
//        
//		      Path path =  Paths.get(System.getProperty("user.dir"))
//				.resolve("article.txt");
                      BufferedReader reader = 
  Files.newBufferedReader(Paths.get(System.getProperty("user.dir")).resolve("article.text"));
		
		//BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
		
		Map<String, Integer> frequency = new HashMap<>();
	
		String line = reader.readLine();
		while(line != null) {
			//System.out.println("Processing line: " + line);
			
			if(!line.trim().equals("")) {
				String [] words = line.split(" ");
				
				for(String word : words) {
					if(word == null || word.trim().equals("")) {
						continue;
					}
					String processed = word.toLowerCase();
					processed = processed.replace(",", "");
					
					if(frequency.containsKey(processed)) {
						frequency.put(processed, 
								frequency.get(processed) + 1);
					} else {
						frequency.put(processed, 1);
					}
				}
			}
			
			line = reader.readLine();
		}
		
		
		System.out.println(frequency);
    }
}
