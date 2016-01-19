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

public class Student implements Person {
  String id;
  String name;
  int age;
  public Student(String i, String n, int a) {  // simple constructor
    id = i;
    name = n;
    age = a;
  }
  protected int studyHours() { return age/2;}       // just a guess
  public String getID() { return id;}               // ID of the student
  public String getName() { return name; }          // from Person interface
  public int getAge() { return age; }               // from Person interface
  public boolean equals(Person other) {             // from Person interface
    if (!(other instanceof Student)) return false;  // cannot possibly be equal
    Student s = (Student) other;                    // explicit cast now safe
    return id.equals(s.id);                         // compare IDs
  }
  public String toString() {                        // for printing
    return "Student(ID:" + id + ", Name:" + name + ", Age:" + age + ")";
  }
}
