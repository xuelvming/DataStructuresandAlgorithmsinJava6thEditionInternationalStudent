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

import net.datastructures.PositionalList;
import net.datastructures.PriorityQueue;

public class PQSort {
  /** Sorts sequence S, using initially empty priority queue P to produce the order. */
  public static <E> void pqSort(PositionalList<E> S, PriorityQueue<E,?> P) {
    int n = S.size();
    for (int j=0; j < n; j++) {
      E element = S.remove(S.first());
      P.insert(element, null);             // element is key; null value
    }
    for (int j=0; j < n; j++) {
      E element = P.removeMin().getKey();
      S.addLast(element);                  // the smallest key in P is next placed in S
    }
  }
}
