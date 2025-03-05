package e2;

public interface ChessMovement {

    /***
     * Checks if a chess piece can do the desired move
     * @param desiredRow the target row
     * @param desiredCol the target column
     * @param actualRow the starting row
     * @param actualCol the starting column
     * @return true if the move is allowed
     */
    boolean canDoMove(int desiredRow, int desiredCol, int actualRow, int actualCol);

    /***
     * Checks if a piece is inside the chess board
     * @param row the row the piece is in
     * @param col the column the piece is in
     * @return true the piece is inside the chess board
     */
    boolean isPositionLegal(int row, int col);
}
