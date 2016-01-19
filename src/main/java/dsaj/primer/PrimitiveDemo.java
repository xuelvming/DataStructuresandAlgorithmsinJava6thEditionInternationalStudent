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
 * A demonstration of primitive types.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class PrimitiveDemo {
  public static void main(String[] args) {
    boolean flag = true;
    boolean verbose, debug;                // two variables declared, but not yet initialized
    char grade = 'A';
    byte b = 12;
    short s = 24;
    int i, j, k = 257;                     // three variables declared; only k initialized
    long l = 890L;                         // note the use of "L" here
    float pi = 3.1416F;                    // note the use of "F" here
    double e = 2.71828, a = 6.022e23;      // both variables are initialized
    System.out.println("flag = " + flag);  // the "+" is string concatenation
    System.out.println("grade = " + grade);
    System.out.println("s = " + s);
    System.out.println("k = " + k);
    System.out.println("l = " + l);
    System.out.println("pi = " + pi);
    System.out.println("e = " + e);
    System.out.println("a = " + a);
  }
}

/*
Output of main:

          flag = true
          ch = A
          b = 12
          s = 24
          i = 257
          l = 890
          f = 3.1416
          d = 2.71828
*/

