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
 * Demonstration of two recursive approaches to computing the sum of an array of integers.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ArraySum {

  /** Returns the sum of the first n integers of the given array. */
  public static int linearSum(int[] data, int n) {
    if (n == 0)
      return 0;
    else
      return linearSum(data, n-1) + data[n-1];
  }

  /** Returns the sum of subarray data[low] through data[high] inclusive. */
  public static int binarySum(int[] data, int low, int high) {
    if (low > high)                 // zero elements in subarray
      return 0;
    else if (low == high)           // one element in subarray
      return data[low];
    else {
      int mid = (low + high) / 2;
      return binarySum(data, low, mid) + binarySum(data, mid+1, high);
    }
  }

  public static void main(String[] args) {

    for (int limit = 1; limit < 100; limit++) {
      int[] data = new int[limit];
      for (int k=0; k < limit; k++)
        data[k] = k+1;
      int answer = limit * (limit + 1) / 2;

      int linear = linearSum(data, limit);
      if (linear != answer)
        System.out.println("Problem with linear sum for n=" + limit);

      int binary = binarySum(data, 0, limit-1);
      if (binary != answer)
        System.out.println("Problem with binary sum for n=" + limit);
    }
  }
}
