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
package dsaj.lists;

import net.datastructures.Position;
import net.datastructures.PositionalList;
import net.datastructures.LinkedPositionalList;

public class InsertionSort {

  /** Insertion-sort of a positional list of integers into nondecreasing order */
  public static void insertionSort(PositionalList<Integer> list) {
    Position<Integer> marker = list.first();         // last position known to be sorted
    while (marker != list.last()) {
      Position<Integer> pivot = list.after(marker);
      int value = pivot.getElement();                // number to be placed
      if (value > marker.getElement())               // pivot is already sorted
        marker = pivot;
      else {                                         // must relocate pivot
        Position<Integer> walk = marker;             // find leftmost item greater than value
        while (walk != list.first() && list.before(walk).getElement() > value)
          walk = list.before(walk);
        list.remove(pivot);                          // remove pivot entry and
        list.addBefore(walk, value);                 // reinsert value in front of walk
      }
    }
  }

  public static void main(String[] args) {
    int[][] tests = {
      {},
      {1},
      {1, 2},
      {2, 1},
      {3, 5, 2, 4, 1, 9, 10, 12, 11, 8, 7, 6},
    };

    for (int[] raw : tests) {
      PositionalList<Integer> data = new LinkedPositionalList<>();
      for (int c : raw)
        data.addLast(c);
      System.out.println("Before: " + data);
      insertionSort(data);
      System.out.println("After:  " + data);
      System.out.println();
    }
  }
}
