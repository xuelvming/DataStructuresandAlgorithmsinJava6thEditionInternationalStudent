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
package dsaj.pq;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

  /** Compares two strings according to their lengths. */
  public int compare(String a, String b) {
    if (a.length() < b.length()) return -1;
    else if (a.length() == b.length()) return 0;
    else return 1;
  }

  public static void main(String[] args) {
    String data[] = {"Apple", "Banana", "Grape", "Grapefruit", "Plum", "Raspberry", "Strawberry"};
    java.util.Arrays.sort(data, new StringLengthComparator());
    System.out.println("data: " + java.util.Arrays.toString(data));
  }

}
