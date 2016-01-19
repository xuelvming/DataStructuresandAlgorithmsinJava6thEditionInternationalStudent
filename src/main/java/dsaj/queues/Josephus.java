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
package dsaj.queues;

import net.datastructures.*;

public class Josephus {
  /** Computes the winner of the Josephus problem using a circular queue. */
  public static <E> E Josephus(CircularQueue<E> queue, int k) {
    if (queue.isEmpty()) return null;
    while (queue.size() > 1) {
      for (int i=0; i < k-1; i++)   // skip past k-1 elements
        queue.rotate();
      E e = queue.dequeue();        // remove the front element from the collection
      System.out.println("    " + e + " is out");
      }
    return queue.dequeue();         // the winner
  }

  /** Builds a circular queue from an array of objects. */
  public static <E> CircularQueue<E> buildQueue(E a[]) {
    CircularQueue<E> queue = new LinkedCircularQueue<>();
    for (int i=0; i<a.length; i++)
      queue.enqueue(a[i]);
    return queue;
  }

  /** Tester method */
  public static void main(String[] args) {
    String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
    String[] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
    String[] a3 = {"Mike", "Roberto"};
    System.out.println("First winner is " + Josephus(buildQueue(a1), 3));
    System.out.println("Second winner is " + Josephus(buildQueue(a2), 10));
    System.out.println("Third winner is " + Josephus(buildQueue(a3), 7));
  }
}
