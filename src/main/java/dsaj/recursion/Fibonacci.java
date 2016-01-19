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
 * Demonstration of two recursive approaches to computing Fibonacci numbers.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Fibonacci {

  /** Returns the nth Fibonacci number (inefficiently). */
  public static long fibonacciBad(int n) {
    if (n <= 1)
      return n;
    else
      return fibonacciBad(n-2) + fibonacciBad(n-1);
  }

  /** Returns array containing the pair of Fibonacci numbers, F(n) and F(n-1). */
  public static long[] fibonacciGood(int n) {
    if (n <= 1) {
      long[] answer = {n, 0};
      return answer;
    } else {
      long[] temp = fibonacciGood(n - 1);            // returns $\{ F_{n-1},\, F_{n-2} \}$
      long[] answer = {temp[0] + temp[1], temp[0]};  // we want $\{ F_{n},\, F_{n-1} \}$
      return answer;
    }
  }

  /** Don't call this (infinite) version. */
  public static int fibonacci(int n) {
    return fibonacci(n);      // After all $F_n$ does equal $F_n$
  }

  public static void main(String[] args) {
    final int limit = 50;

    System.out.println("The good...");
    for (int n = 0; n < limit; n++)
      System.out.println(n + ": " + fibonacciGood(n)[0]);

    System.out.println();
    System.out.println("The bad...");
    for (int n = 0; n < limit; n++)
      System.out.println(n + ": " + fibonacciBad(n));

    // Even worse...
    fibonacci(10); // the infinite one
  }

}
