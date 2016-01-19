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

/** Simplified test of matching tags in an HTML document. */
public class MatchHTML {

  /** Tests if every opening tag has a matching closing tag in HTML string. */
  public static boolean isHTMLMatched(String html) {
    Stack<String> buffer = new LinkedStack<>();
    int j = html.indexOf('<');                   // find first '<' character (if any)
    while (j != -1) {
      int k = html.indexOf('>', j+1);            // find next '>' character
      if (k == -1)
        return false;                            // invalid tag
      String tag = html.substring(j+1, k);       // strip away < >
      if (!tag.startsWith("/"))                  // this is an opening tag
        buffer.push(tag);
      else {                                     // this is a closing tag
        if (buffer.isEmpty())
          return false;                          // no tag to match
        if (!tag.substring(1).equals(buffer.pop()))
          return false;                          // mismatched tag
      }
      j = html.indexOf('<', k+1);                // find next '<' character (if any)
    }
    return buffer.isEmpty();                     // were all opening tags matched?
  }

  private final static String example = ""
    + "<body>" + "\n"
    + "<center>" + "\n"
    + "<h1> The Little Boat </h1>" + "\n"
    + "</center>" + "\n"
    + "<p> The storm tossed the little" + "\n"
    + "boat like a cheap sneaker in an" + "\n"
    + "old washing machine.  The three" + "\n"
    + "drunken fishermen were used to" + "\n"
    + "such treatment, of course, but" + "\n"
    + "not the tree salesman, who even as" + "\n"
    + "a stowaway now felt that he" + "\n"
    + "had overpaid for the voyage. </p>" + "\n"
    + "<ol>" + "\n"
    + "<li> Will the salesman die? </li>" + "\n"
    + "<li> What color is the boat? </li>" + "\n"
    + "<li> And what about Naomi? </li>" + "\n"
    + "</ol>" + "\n"
    + "</body>";

  /**
   * Test the text given as standard input as html.
   * If command line argument is given, preforms test on example from the book.
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      String input = new Scanner(System.in).useDelimiter("\\A").next();  // read entire input at once
      if (isHTMLMatched(input))
        System.out.println("The input file is a matched HTML document.");
      else
        System.out.println("The input file is not a matched HTML document.");
    } else {   // use prepared example
      if (!isHTMLMatched(example))
        System.out.println("Error on example");
    }
  }

}
