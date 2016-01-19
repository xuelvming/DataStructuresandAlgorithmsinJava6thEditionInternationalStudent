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
package dsaj.lists;

import net.datastructures.Position;
import net.datastructures.PositionalList;
import net.datastructures.LinkedPositionalList;

/** Maintains a list of elements ordered with move-to-front heuristic. */
public class FavoritesListMTF<E> extends FavoritesList<E> {

  /** Moves accessed item at Position p to the front of the list. */
  @Override
  protected void moveUp(Position<Item<E>> p) {
    if (p != list.first())
      list.addFirst(list.remove(p));     // remove/reinsert item
  }

  /** Returns an iterable collection of the k most frequently accessed elements. */
  @Override
  public Iterable<E> getFavorites(int k) throws IllegalArgumentException {
    if (k < 0 || k > size())
      throw new IllegalArgumentException("Invalid k");

    // we begin by making a copy of the original list
    PositionalList<Item<E>> temp = new LinkedPositionalList<>();
    for (Item<E> item : list)
      temp.addLast(item);

    // we repeated find, report, and remove element with largest count
    PositionalList<E> result = new LinkedPositionalList<>();
    for (int j=0; j < k; j++) {
      Position<Item<E>> highPos = temp.first();
      Position<Item<E>> walk = temp.after(highPos);
      while (walk != null) {
        if (count(walk) > count(highPos))
          highPos = walk;
        walk = temp.after(walk);
      }
      // we have now found element with highest count
      result.addLast(value(highPos));
      temp.remove(highPos);
    }
    return result;
  }

  // test usage
  public static void main(String[] args) {
    test(new FavoritesListMTF<Character>());
  }
}
