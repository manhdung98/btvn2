/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.Map.Entry.comparingByValue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author manhdung98
 */
public class BTVN2 {

    /**
     * @param args the command line arguments
     */
    
    public static void wordCount() throws FileNotFoundException{
        //use hashmap to store word
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        //use scanner class to read a text file
        Scanner txtfile = new Scanner (new File ("C:\\Users\\manhdung98\\Downloads\\BTVN-5.txt"));
        
        while (txtfile.hasNext()){
            String word = txtfile.next();
            word = word.replaceAll("\\W", ""); 
            if(map.containsKey(word)){
                //increase count to 1 if this word has already existed in map
                int count  = map.get(word) + 1;
                map.put(word, count);
                
            }
            else{
                map.put(word, 1);
            }
        }
        
        
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry);
        } 
        
        HashMap<String, Integer> sorted;
//        sorted = map
//                .entrySet()
//                .stream()
//                .sorted(comparingByValue())
//                .collect(
//                         Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
// 
//    System.out.println("map after sorting by values: " + sorted);
 
    // above code can be cleaned a bit by using method reference
    sorted = map
        .entrySet()
        .stream()
        .sorted(comparingByValue())
        .collect(
            Collectors.toMap((entry) -> entry.getKey(), (entry) -> entry.getValue(), (e1, e2) -> e2,
                LinkedHashMap::new));
 
    // now let's sort the map in decreasing order of value
    sorted = map
        .entrySet()
        .stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(
            Collectors.toMap((entry) -> entry.getKey(), (entry) -> entry.getValue(), (e1, e2) -> e2,
                LinkedHashMap::new));
 
    System.out.println("map after sorting by values in descending order: " + "\n" + sorted );
    
    txtfile.close();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
       wordCount();
    }
    
}
