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
 * An example that uses an enumerated type.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class EnumDemo {
  public enum Day {MON, TUE, WED, THU, FRI, SAT, SUN};
  public static void main(String[] args) {
    Day d = Day.MON;
    System.out.println("Initially d is " + d);  // enum is printed as "MON"
    d = Day.WED;
    System.out.println("Then it is " + d);
    for (Day a : Day.values()) {
      System.out.println("Day " + a);
      switchDemo(a);
    }
  }

  public static void switchDemo(Day d) {
      switch (d) {
        case MON:
          System.out.println("This is tough.");
          break;
        case TUE:
          System.out.println("This is getting better.");
          break;
        case WED:
          System.out.println("Half way there.");
          break;
        case THU:
          System.out.println("I can see the light.");
          break;
        case FRI:
          System.out.println("Now we are talking.");
          break;
        default:
          System.out.println("Day off!");
      }
  }

}

/*
Output of main:

Initially d is MON
Then it is WED
I say d an t are the same: true
*/
