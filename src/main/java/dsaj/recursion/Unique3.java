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
package dsaj.recursion;

/**
 * Demonstration of a recursive (and very bad) solution to element uniqueness problem.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Unique3 {

  /** Returns true if there are no duplicate values from data[low] through data[high].*/
  public static boolean unique3(int[] data, int low, int high) {
    if (low >= high) return true;                         // at most one item
    else if (!unique3(data, low, high-1)) return false;   // duplicate in first n-1
    else if (!unique3(data, low+1, high)) return false;   // duplicate in last n-1
    else return (data[low] != data[high]);                // do first and last differ?
  }
}
