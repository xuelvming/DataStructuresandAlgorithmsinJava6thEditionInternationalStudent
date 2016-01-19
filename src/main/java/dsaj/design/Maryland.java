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

public class Maryland extends State {
  Maryland() { /* null constructor */ }
  public void printMe() { System.out.println("Read it."); }
  public static void main(String[] args) {
    Region east = new State();
    State md = new Maryland();
    Object obj = new Place();
    Place usa = new Region();
    md.printMe();
    east.printMe();
    ((Place) obj).printMe();
    obj = md;
    ((Maryland) obj).printMe();
    obj = usa;
    ((Place) obj).printMe();
    usa = md;
    ((Place) usa).printMe();
  }
}
class State extends Region {
  State() { /* null constructor */ }
  public void printMe() { System.out.println("Ship it."); }
}
class Region extends Place {
  Region() { /* null constructor */ }
  public void printMe() { System.out.println("Box it."); }
}
class Place extends Object {
  Place() { /* null constructor */ }
  public void printMe() { System.out.println("Buy it."); }
}
