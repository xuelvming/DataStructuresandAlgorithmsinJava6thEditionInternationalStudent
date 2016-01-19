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

import java.util.Iterator;
import net.datastructures.Position;
import net.datastructures.PositionalList;
import net.datastructures.LinkedPositionalList;

/** Maintains a list of elements ordered according to access frequency. */
public class FavoritesList<E> {
  // ---------------- nested Item class ----------------
  protected static class Item<E> {
    private E value;
    private int count = 0;
    /** Constructs new item with initial count of zero. */
    public Item(E val) { value = val; }
    public int getCount() { return count; }
    public E getValue() { return value; }
    public void increment() { count++; }
    // debug utility
    public String toString() { return "(" + value + ":" + count + ")"; }
  } //----------- end of nested Item class -----------

  PositionalList<Item<E>> list = new LinkedPositionalList<>();    // list of Items

  /** Constructs initially empty favorites list. */
  public FavoritesList() { }              // constructs initially empty favorites list

  // nonpublic utilities
  /** Provides shorthand notation to retrieve user's element stored at Position p. */
  protected E value(Position<Item<E>> p) { return p.getElement().getValue(); }

  /** Provides shorthand notation to retrieve count of item stored at Position p. */
  protected int count(Position<Item<E>> p) {return p.getElement().getCount();}

  /** Returns Position having element equal to e (or null if not found). */
  protected Position<Item<E>> findPosition(E e) {
    Position<Item<E>> walk = list.first();
    while (walk != null && !e.equals(value(walk)))
      walk = list.after(walk);
    return walk;
  }

  /** Moves item at Position p earlier in the list based on access count. */
  protected void moveUp(Position<Item<E>> p) {
    int cnt = count(p);                           // revised count of accessed item
    Position<Item<E>> walk = p;
    while (walk != list.first() && count(list.before(walk)) < cnt)
      walk = list.before(walk);                   // found smaller count ahead of item
    if (walk != p)
      list.addBefore(walk, list.remove(p));       // remove/reinsert item
  }

  // public methods
  /** Returns the number of items in the favorites list. */
  public int size() { return list.size(); }

  /** Returns true if the favorites list is empty. */
  public boolean isEmpty() { return list.isEmpty(); }

  /**
   * Accesses element e, thereby increasing its access count.
   * If e is new, its count will be 1 after this operation.
   */
  public void access(E e) {
    Position<Item<E>> p = findPosition(e);       // try to locate existing element
    if (p == null)
      p = list.addLast(new Item<E>(e));          // if new, place at end
    p.getElement().increment();                   // always increment count
    moveUp(p);                                    // consider moving forward
  }

  /** Removes element equal to e from the list of favorites (if found). */
  public void remove(E e) {
    Position<Item<E>> p = findPosition(e);        // try to locate existing element
    if (p != null)
      list.remove(p);
  }

  /** Returns an iterable collection of the k most frequently accessed elements. */
  public Iterable<E> getFavorites(int k) throws IllegalArgumentException {
    if (k < 0 || k > size())
      throw new IllegalArgumentException("Invalid k");
    PositionalList<E> result = new LinkedPositionalList<>();
    Iterator<Item<E>> iter = list.iterator();
    for (int j=0; j < k; j++)
      result.addLast(iter.next().getValue());
    return result;
  }

  // the remainder of this file is for testing/debugging only
  public String toString() {
    return list.toString();
  }

  protected static void test(FavoritesList<Character> fav) {
    char[] sample = "hello. this is a test of mtf".toCharArray();
    for (char c : sample) {
      fav.access(c);
      int k = Math.min(5, fav.size());
      System.out.println("Entire list: " + fav);
      System.out.println("Top " + k + ": " + fav.getFavorites(k));
      System.out.println();
    }
  }

  public static void main(String[] args) {
    test(new FavoritesList<Character>());
  }
}
