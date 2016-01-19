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
package dsaj.asymptotics;

/**
 * Demonstration of algorithms for testing three-way set disjointness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class DisjointSet {

  /** Returns true if there is no element common to all three arrays. */
  public static boolean disjoint1(int[] groupA, int[] groupB, int[] groupC) {
    for (int a : groupA)
      for (int b : groupB)
        for (int c : groupC)
          if ((a == b) && (b == c))
            return false;           // we found a common value
    return true;                    // if we reach this, sets are disjoint
  }

  /** Returns true if there is no element common to all three arrays. */
  public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
    for (int a : groupA)
      for (int b : groupB)
        if (a == b)                 // only check C when we find match from A and B
          for (int c : groupC)
            if (a == c)             // and thus b == c as well
              return false;         // we found a common value
    return true;                    // if we reach this, sets are disjoint
  }

}
