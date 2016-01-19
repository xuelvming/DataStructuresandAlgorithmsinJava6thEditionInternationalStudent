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
 * A demonstration of the use of the Counter class.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class CounterDemo {
  public static void main(String[] args) {
    Counter c;                  // declares a variable; no counter yet constructed
    c = new Counter();          // constructs a counter; assigns its reference to c
    System.out.println("After c = new Counter()");
    System.out.println("value of c is " + c.getCount());
    c.increment();              // increases its value by one
    System.out.println("After c.increment()");
    System.out.println("value of c is " + c.getCount());
    c.increment(3);             // increases its value by three more
    System.out.println("After c.increment(3)");
    System.out.println("value of c is " + c.getCount());
    int temp = c.getCount();    // will be 4
    c.reset();                  // value becomes 0
    System.out.println("After c.reset()");
    System.out.println("value of c is " + c.getCount());
    Counter d = new Counter(5);// declares and constructs a counter having value 5
    System.out.println("After d = new Counter(5)");
    System.out.println("value of d is " + d.getCount());
    d.increment();              // value becomes 6
    System.out.println("After d.increment()");
    System.out.println("value of d is " + d.getCount());
    Counter e = d;              // assigns e to reference the same object as d
    System.out.println("After e = d");
    System.out.println("value of d is " + d.getCount());
    System.out.println("value of e is " + e.getCount());
    temp = e.getCount();        // will be 6 (as e and d reference the same counter)
    e.increment(2);             // value of e (also known as d) becomes 8
    System.out.println("After e.increment(2)");
    System.out.println("value of d is " + d.getCount());
    System.out.println("value of e is " + e.getCount());
  }

  public static void badReset(Counter c) {
    c = new Counter();         // reassigns local name c to a new counter
  }

  public static void goodReset(Counter c) {
    c.reset();                 // resets the counter sent by the caller
  }

}
