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
package dsaj.arrays;

import java.util.Arrays;

public class DeepClone {

  public static int[][] deepClone(int[][] original) {
    int[][] backup = new int[original.length][];  // create top-level array of arrays
    for (int k=0; k < original.length; k++)
      backup[k] = original[k].clone();            // copy row k
    return backup;
  }

  public static void main(String[] args) {
    int[][] sample = { {1, 2, 3}, {4, 5, 6} };
    int[][] backup = deepClone(sample);

    System.out.println("Sample:");
    System.out.println(Arrays.deepToString(sample));
    System.out.println("Backup:");
    System.out.println(Arrays.deepToString(backup));

    for (int j=0; j < sample.length; j++)
      for (int k=0; k < sample[j].length; k++)
        sample[j][k] *= 10;

    System.out.println("Sample:");
    System.out.println(Arrays.deepToString(sample));
    System.out.println("Backup:");
    System.out.println(Arrays.deepToString(backup));

  }
}
