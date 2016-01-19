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

public class FibonacciProgression extends Progression {

  protected long prev;

  /** Constructs traditional Fibonacci, starting 0, 1, 1, 2, 3, ... */
  public FibonacciProgression() { this(0, 1); }

  /** Constructs generalized Fibonacci, with give first and second values. */
  public FibonacciProgression(long first, long second) {
    super(first);
    prev = second - first;     // fictitious value preceding the first
  }

  /** Replaces (prev,current) with (current, current+prev). */
  protected void advance() {
    long temp = prev;
    prev = current;
    current += temp;
  }
}
