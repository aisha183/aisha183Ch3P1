/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass3p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author PC
 */
public class NewClass {

    public static void main(String[] args) {

        Random r = new Random();
        int[] random = new int[30];
        int sum=0;
        
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < random.length; i++) {
            random[i] = new Random().nextInt(100);
            sum+=random[i];
            values.add(random[i]);
        }
        float avg=sum/random.length;
        Collections.sort(values);
        System.out.println("Sorted Elements: " + values);
        System.out.println(" The Sum for Number is : "+ sum +"\n The Avg : "+avg);

    }
}
