/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dsaj.maps;

import java.io.*;
import java.util.Scanner;
import net.datastructures.Entry;
import net.datastructures.Map;
import net.datastructures.ChainHashMap;

/** A program that counts words in a document, printing the most frequent. */
public class WordCount {
  public static void main(String[] args) {
    boolean VERBOSE = (args.length > 0);
    Map<String,Integer> freq = new ChainHashMap<>();  // or any concrete map
    // scan input for words, using all nonletters as delimiters
    Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
    while (doc.hasNext()) {
      String word = doc.next().toLowerCase();   // convert next word to lowercase
      if (VERBOSE)
        System.out.print("word = [" + word + "]");
      Integer count = freq.get(word);                  // get the previous count for this word
      if (count == null)
        count = 0;                                     // if not in map, previous count is zero
      freq.put(word, 1 + count);                       // (re)assign new count for this word
      if (VERBOSE)
        System.out.println(", count = " + freq.get(word));
    }
    int maxCount = 0;
    String maxWord = "no word";
    for (Entry<String,Integer> ent : freq.entrySet())    // find max-count word
      if (ent.getValue() > maxCount) {
        maxWord = ent.getKey();
        maxCount = ent.getValue();
      }
    System.out.print("The most frequent word is '" + maxWord);
    System.out.println("' with " + maxCount + " occurrences.");
  }
}
