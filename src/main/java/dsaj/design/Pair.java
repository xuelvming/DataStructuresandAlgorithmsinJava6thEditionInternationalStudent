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

@SuppressWarnings({"unchecked"})
public class Pair<A,B> {
  A first;
  B second;
  public Pair(A a, B b) {                  // constructor
    first = a;
    second = b;
  }
  public A getFirst() { return first; }
  public B getSecond() { return second;}
  public String toString() {
    return "[" + first + ", " + second + "]";
  }

  public static void main(String[] args) {
    Pair<String,Double> bid;
    bid = new Pair<>("ORCL", 32.07);               // rely on type inference

    // using Java6 style without type inference:
    bid = new Pair<String,Double>("ORCL", 32.07);  // give explicit types

    // using classic style without generics
    bid = new Pair("ORCL", 32.07);                 // classic style
    String stock = bid.getFirst();
    double price = bid.getSecond();

    Pair<String,Double>[] holdings;
    /*
    holdings = new Pair<String,Double>[25];           // illegal; compile error
    */
    holdings = new Pair[25];   // correct, but warning about unchecked cast
    holdings[0] = new Pair<>("ORCL", 32.07);          // valid element assignment
  }
}
