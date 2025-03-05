package e1;

import e2.Pair;

public class KnightMovement implements ChessMovement{

    final int size;

    public KnightMovement(int sizeBoard){
        this.size=sizeBoard;
    }

    @Override
    public boolean canDoMove(final int desiredRow, final int desiredCol, final int actualRow, final int actualCol) {
        if(isPositionLegal(desiredRow,desiredCol)) {
            int x = desiredRow - actualRow;
            int y = desiredCol - actualCol;
            return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
        }
        return false;
    }

    public boolean isPositionLegal(int x, int y){
        return x<this.size&&y<this.size&&x>=0&&y>=0;
    }
}