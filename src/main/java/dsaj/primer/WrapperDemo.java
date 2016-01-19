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
 * A demonstration of Java's wrapper types.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class WrapperDemo {
  public static void main(String[] args) {
    int j = 8;
    Integer a = new Integer(12);
    int k = a;                         // implicit call to a.intValue()
    int m = j + a;                     // a is automatically unboxed before the addition
    a = 3 * m;                         // result is automatically boxed before assignment
    Integer b = new Integer("-135");   // constructor accepts a String
    int n = Integer.parseInt("2013");  // using static method of Integer class
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("j = " + j);
    System.out.println("k = " + k);
    System.out.println("m = " + m);
    System.out.println("n = " + n);
  }
}


