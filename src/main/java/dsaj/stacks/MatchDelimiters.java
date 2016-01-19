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
package dsaj.stacks;

import java.util.Scanner;
import net.datastructures.Stack;
import net.datastructures.LinkedStack;

/** Simplified test of matching delimiters in a string. */
public class MatchDelimiters {


  /** Tests if delimiters in the given expression are properly matched. */
  public static boolean isMatched(String expression) {
    final String opening  = "({[";                // opening delimiters
    final String closing  = ")}]";                // respective closing delimiters
    Stack<Character> buffer = new LinkedStack<>();
    for (char c : expression.toCharArray()) {
      if (opening.indexOf(c) != -1)               // this is a left delimiter
        buffer.push(c);
      else if (closing.indexOf(c) != -1) {        // this is a right delimiter
        if (buffer.isEmpty())                     // nothing to match with
          return false;
        if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
          return false;                           // mismatched delimiter
      }
    }
    return buffer.isEmpty();                      // were all opening delimiters matched?
  }

  final static String[] valid = {
    "()(()){([()])}",
    "( ) ( ( ) ) {( [ ( )  ] ) } ",
    "(3) (3 + (4 - 5) ) {( [ ( )  ] ) } ",
    "((()(()){([()])}))",
    "[(5+x)-(y+z)]"
  };

  final static String[] invalid = {
    ")(()){([()])}",
    "({[])}",
    "("
  };

  public static void main(String[] args) {

    for (String s : valid)
      if (!isMatched(s))
        System.out.println("Error evaluating valid: " + s);

    for (String s : invalid)
      if (isMatched(s))
        System.out.println("Error evaluating invalid: " + s);

  }

}
