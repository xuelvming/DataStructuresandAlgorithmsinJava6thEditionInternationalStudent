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
 * Demonstration of the less efficient method for computing the power function.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class PowerSlow {
  /** Computes the value of x raised to the nth power, for nonnegative integer n. */
  public static double power(double x, int n) {
    if (n == 0)
      return 1;
    else
      return x * power(x, n-1);
  }
}

/** Demonstration of the more efficient method for computing the power function. */
public class Power {

  /** Computes the value of x raised to the nth power, for nonnegative integer n. */
  public static double power(double x, int n) {
    if (n == 0)
      return 1;
    else {
      double partial = power(x, n/2);          // rely on truncated division of n
      double result = partial * partial;
      if (n % 2 == 1)                          // if n odd, include extra factor of x
        result *= x;
      return result;
    }
  }

  public static void main(String[] args) {

    final double EPSILON = 0.0000000001;
    final int BASE = 3;

    int answer=1;
    for (int n=0; n < 20; n++) {
      if (Math.abs(answer - PowerSlow.power(BASE, n)) > EPSILON)
        System.out.println("Problem with slow power(" + BASE + "," + n +")");
      if (Math.abs(answer - Power.power(BASE, n)) > EPSILON)
        System.out.println("Problem with fast power(" + BASE + "," + n +")");
      answer *= BASE;
    }


  }

}
