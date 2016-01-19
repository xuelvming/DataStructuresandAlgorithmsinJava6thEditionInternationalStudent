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
 * An example of nested conditional statements
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Robot {
  Door door = new Door();
  public void advance() {}

  public void simple() {
    if (door.isClosed())
      door.open();
    advance();
  }

  public void complex() {
    if (door.isClosed()) {
      if (door.isLocked())
        door.unlock();
      door.open();
    }
    advance();
  }


}


/** Stub with appropriate syntax but no functionality. */
class Door {
  public void open() {}
  public void unlock() {}
  public boolean isClosed() { return true; }
  public boolean isLocked() { return true; }
}

