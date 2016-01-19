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

public class GeometricProgression extends Progression {

  protected long base;

  /** Constructs progression 1, 2, 4, 8, 16, ... */
  public GeometricProgression() { this(2, 1); }        // start at 1 with base of 2

  /** Constructs progression 1, b, b^2, b^3, b^4, ... for base b. */
  public GeometricProgression(long b) { this(b, 1); }  // start at 1

  /** Constructs geometric progression with arbitrary base and start. */
  public GeometricProgression(long b, long start) {
    super(start);
    base = b;
  }

  /** Multiplies the current value by the geometric base. */
  protected void advance() {
    current *= base;                     // multiply current by the geometric base
  }
}
