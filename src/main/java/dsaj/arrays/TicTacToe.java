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
package dsaj.arrays;

/** Simulation of a Tic-Tac-Toe game (does not do strategy). */
public class TicTacToe {
  public static final int X = 1, O = -1;      // players
  public static final int EMPTY = 0;          // empty cell
  private int board[][] = new int[3][3];      // game board
  private int player;                         // current player

  /** Constructor */
  public TicTacToe() { clearBoard(); }

  /** Clears the board */
  public void clearBoard() {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        board[i][j] = EMPTY;                  // every cell should be empty
    player = X;                               // the first player is 'X'
  }

  /** Puts an X or O mark at position i,j. */
  public void putMark(int i, int j) throws IllegalArgumentException {
    if ((i < 0) || (i > 2) || (j < 0) || (j > 2))
      throw new IllegalArgumentException("Invalid board position");
    if (board[i][j] != EMPTY)
      throw new IllegalArgumentException("Board position occupied");
    board[i][j] = player;       // place the mark for the current player
    player = - player;          // switch players (uses fact that O = - X)
  }

  /** Checks whether the board configuration is a win for the given player. */
  public boolean isWin(int mark) {
    return ((board[0][0] + board[0][1] + board[0][2] == mark*3)      // row 0
            || (board[1][0] + board[1][1] + board[1][2] == mark*3)   // row 1
            || (board[2][0] + board[2][1] + board[2][2] == mark*3)   // row 2
            || (board[0][0] + board[1][0] + board[2][0] == mark*3)   // column 0
            || (board[0][1] + board[1][1] + board[2][1] == mark*3)   // column 1
            || (board[0][2] + board[1][2] + board[2][2] == mark*3)   // column 2
            || (board[0][0] + board[1][1] + board[2][2] == mark*3)   // diagonal
            || (board[2][0] + board[1][1] + board[0][2] == mark*3)); // rev diag
  }

  /** Returns the winning player's code, or 0 to indicate a tie (or unfinished game).*/
  public int winner() {
    if (isWin(X))
      return(X);
    else if (isWin(O))
      return(O);
    else
      return(0);
  }

  /** Returns a simple character string showing the current board. */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        switch (board[i][j]) {
        case X:         sb.append("X"); break;
        case O:         sb.append("O"); break;
        case EMPTY:    sb.append(" "); break;
        }
        if (j < 2) sb.append("|");              // column boundary
      }
      if (i < 2) sb.append("\n-----\n");        // row boundary
    }
    return sb.toString();
  }

  /** Test run of a simple game */
  public static void main(String[] args) {
    TicTacToe game = new TicTacToe();
    /* X moves: */              /* O moves: */
    game.putMark(1,1);          game.putMark(0,2);
    game.putMark(2,2);          game.putMark(0,0);
    game.putMark(0,1);          game.putMark(2,1);
    game.putMark(1,2);          game.putMark(1,0);
    game.putMark(2,0);
    System.out.println(game);
    int winningPlayer = game.winner();
    String[] outcome = {"O wins", "Tie", "X wins"};  // rely on ordering
    System.out.println(outcome[1 + winningPlayer]);
  }
}
