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

import dsaj.primer.CreditCard;

public class PredatoryCreditCard extends CreditCard {
  // Additional instance variable
  private double apr;                           // annual percentage rate

  /**
   * Constructs a new credit card instance.
   *
   * @param cust        the name of the customer (e.g., "John Bowman")
   * @param bk          the name of the bank (e.g., "California Savings")
   * @param acnt        the account identifier (e.g., "5391 0375 9387 5309")
   * @param lim         the credit limit (measured in dollars)
   * @param initialBal  the initial balance (measured in dollars)
   * @param rate        the annual percentage rate (e.g., 0.0825 for 8.25% APR)
   */
  public PredatoryCreditCard(String cust, String bk, String acnt, int lim,
                             double initialBal, double rate) {
    super(cust, bk, acnt, lim, initialBal);     // initialize superclass attributes
    apr = rate;
  }

  /** Assess monthly interest on any outstanding balance. */
  public void processMonth() {
    if (balance > 0) {  // only charge interest on a positive balance
      double monthlyFactor = Math.pow(1 + apr, 1.0/12); // compute monthly rate
      balance *= monthlyFactor;                          // assess interest
    }
  }

  @Override
  /**
   * Charges given price to the card, assuming sufficient credit limit.
   * Returns true if charge was processed.
   * Returns false and assesses $5 fee if charge is denied.
   */
  public boolean charge(double price) {
    boolean isSuccess = super.charge(price);    // call inherited method
    if (!isSuccess)
      balance += 5;                             // assess a \$5 penalty
    return isSuccess;
  }

  public static void main(String[] args) {
    PredatoryCreditCard card = new PredatoryCreditCard("Michael", "Payday", "1111 1111 1111 1111", 2500, 0, 0.0825);
    card.charge(1000);
    CreditCard.printSummary(card);
    card.processMonth();           // interest charged
    CreditCard.printSummary(card);
    card.charge(10000);            // should be rejected, with penalty
    CreditCard.printSummary(card);
  }
}
