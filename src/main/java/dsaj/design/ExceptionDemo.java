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
package dsaj.design;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ExceptionDemo {

  static final int DEFAULT = 100;

  public static void main(String[] args) {
    int n = DEFAULT;
    try {
      n = Integer.parseInt(args[0]);
      if (n <= 0) {
        System.out.println("n must be positive. Using default.");
        n = DEFAULT;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("No argument specified for n. Using default.");
    } catch (NumberFormatException e) {
      System.out.println("Invalid integer argument. Using default.");
    }
    System.out.println("n has value: " + n);
  }


  public void ensurePositive(int n) {
    if (n < 0)
      throw new IllegalArgumentException("That's not positive!");
    // ...
  }
}
