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
package dsaj.primer;

/**
 * Example of valid and invalid method for scaling a numeric array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ArrayScale {

  public static void scaleBad(double[] data, double factor) {
    for (double val : data)
      val *= factor;                      // changes local variable only
  }


  public static void scaleGood(double[] data, double factor) {
    for (int j=0; j < data.length; j++)
      data[j] *= factor;                  // overwrites cell of the array
  }

  public static void print(double[] data) {
    StringBuilder sb = new StringBuilder();
    for (double val : data)
      sb.append(" " + val);
    System.out.println(sb);
  }

  public static void main(String[] args) {
    double[] sample = {1.0, 2.0, 3.0, 4.0};
    print(sample);
    scaleBad(sample, 2);
    print(sample);
    scaleGood(sample, 3);
    print(sample);
  }

}
