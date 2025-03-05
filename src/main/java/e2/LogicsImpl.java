package e2;

import e1.ChessMovement;
import e1.KnightMovement;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	private final ChessMovement movement;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();
		this.movement=new KnightMovement(size);
    }

	public LogicsImpl(int size, final Pair<Integer, Integer> pawnPosition, final Pair<Integer, Integer> knightPosition){
		this.size = size;
		this.movement=new KnightMovement(size);
		if(this.movement.isPositionLegal(pawnPosition.getX(), pawnPosition.getY())&&this.movement.isPositionLegal(knightPosition.getX(), knightPosition.getY())){
			if(!pawnPosition.equals(knightPosition)){
				this.pawn = pawnPosition;
				this.knight = knightPosition;
			}else{
				this.pawn=pawnPosition;
				this.knight=this.randomEmptyPosition();
			}
		}else{
			this.pawn = this.randomEmptyPosition();
			this.knight=this.randomEmptyPosition();
		}
    }
    
	private Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (!this.movement.isPositionLegal(row, col)) {
			throw new IndexOutOfBoundsException();
		}
		if(this.movement.canDoMove(row, col, this.knight.getX(), this.knight.getY())){
			this.knight = new Pair<>(row,col);
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}

}
