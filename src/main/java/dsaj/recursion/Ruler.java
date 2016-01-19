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
 * Provides support for drawing an English ruler.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Ruler {

  /**
   * Draws an English ruler. The level of division depends upon the
   * designated length of the major tick. For example, a major tick of
   * length 3 will produce a ruler with ticks (of length 2) at the
   * half-inch mark and ticks (of length 1) at the quarter-inch marks.
   *
   * @param nInches the total number of inches to be drawn
   * @param majorLength the number of dashes used at complete inch marks
   */
  public static void drawRuler(int nInches, int majorLength) {
    drawLine(majorLength, 0);             // draw inch 0 line and label
    for (int j = 1; j <= nInches; j++) {
      drawInterval(majorLength - 1);      // draw interior ticks for inch
      drawLine(majorLength, j);           // draw inch j line and label
    }
  }

  /** Draws a ruler interval around a central tick length. */
  private static void drawInterval(int centralLength) {
    if (centralLength >= 1) {             // otherwise, do nothing
      drawInterval(centralLength - 1);    // recursively draw top interval
      drawLine(centralLength);            // draw center tick line (without label)
      drawInterval(centralLength - 1);    // recursively draw bottom interval
    }
  }

  /** Draws a line with the given tick length, followed by an optional label. */
  private static void drawLine(int tickLength, int tickLabel) {
    for (int j = 0; j < tickLength; j++)
      System.out.print("-");
    if (tickLabel >= 0)
      System.out.print(" " + tickLabel);
    System.out.print("\n");
  }

  /** Draws a line with the given tick length (but no label). */
  private static void drawLine(int tickLength) {
    drawLine(tickLength, -1);
  }

  /** Draws sample rulers with various parameters. */
  public static void main(String[] args) {
    System.out.print("\n\nRuler of length 2 with major tick length 4\n");
    drawRuler(2, 4);
    System.out.print("\n\nRuler of length 1 with major tick length 5\n");
    drawRuler(1, 5);
    System.out.print("\n\nRuler of length 3 with major tick length 3\n");
    drawRuler(3, 3);
  }
}
