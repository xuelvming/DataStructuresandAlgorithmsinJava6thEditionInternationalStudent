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
 * Demonstration of recursive factorial function.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Factorial {

  /** Computes the factorial of the given (nonnegative) integer) */
  public static int factorial(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException();     // argument must be nonnegative
    else if (n == 0)
      return 1;                                 // base case
    else
      return n * factorial(n-1);                // recursive case
  }

  /** Simple test, assuming valid integer given as command-line argument */
  public static void main(String[] args) {
    if (args.length > 0) {
      int n = Integer.parseInt(args[0]);
      try { System.out.println("factorial("+n+") = " + factorial(n)); }
      catch (IllegalArgumentException e) {
        System.out.println("Error: the factorial function is undefined for negative integers"); }
    }
  }

}
