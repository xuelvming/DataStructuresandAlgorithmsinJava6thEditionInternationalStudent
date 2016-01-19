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

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

public class IteratorDemo {

  public static void main(String[] args) {
    int N = 50;
    Random r = new Random();

    ArrayList<Double> data;      // populate with random numbers (not shown)

    data = new ArrayList<>(N);
    for (int i = 0; i < N; i++)
      data.add(r.nextGaussian());

    Iterator<Double> walk = data.iterator();
    while (walk.hasNext())
      if (walk.next() < 0.0)
        walk.remove();

    System.out.println("Length of remaining data set: " + data.size());
    System.out.println(data);

  }
}
