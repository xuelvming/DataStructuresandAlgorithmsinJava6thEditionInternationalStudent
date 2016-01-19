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
import java.util.Scanner;                  // loads Scanner definition for our use

public class InputExample {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your age in years: ");
    double age = input.nextDouble();
    System.out.print("Enter your maximum heart rate: ");
    double rate = input.nextDouble();
    double fb = (rate - age) * 0.65;
    System.out.println("Your ideal fat-burning heart rate is " + fb);
  }

  public static int getInt() {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter an integer: ");
    while (!input.hasNextInt()) {
      input.nextLine();
      System.out.print("Invalid integer; please enter an integer: ");
    }
    int i = input.nextInt();
    return i;
  }

}

/*
Sample user session
-------------------

Enter your age in years: 21
Enter your maximum heart rate: 220
Your target fat-burning heart rate is 129.35
*/
