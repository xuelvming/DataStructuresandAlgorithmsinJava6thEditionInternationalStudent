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
 * An integer counter that can be incremented and reset to zero.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Counter {

  private int count;                           // a simple integer instance variable

  /** Constructs a new Counter with value zero. */
  public Counter() { }                         // default constructor (count is 0)

  /** Constructs a new Counter with given initial value. */
  public Counter(int initial) { count = initial; }     // an alternate constructor

  /** Returns the current count. */
  public int getCount() { return count; }                  // an accessor method

  /** Increments the count by one. */
  public void increment() { count++; }                     // an update method

  /** Increments the count by the specified delta. */
  public void increment(int delta) { count += delta; }     // an update method

  /** Returns the count to zero. */
  public void reset() { count = 0; }                       // an update method
}
