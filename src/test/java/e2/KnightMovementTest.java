package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class KnightMovementTest {
    public final static int SIZE=5;
    public ChessMovement movement;
    final Pair<Integer, Integer> knightInitialPosition= new Pair<>(0,0);
    @BeforeEach
    public void testSetup(){
        this.movement=new KnightMovement(SIZE);
    }

    @Test
    public void testIsPositionLegal(){
        assertFalse(this.movement.isPositionLegal(-1,-1));
    }

    @Test
    public void testCanDoMovement(){
        assertTrue(this.movement.canDoMove(knightInitialPosition.getX(), knightInitialPosition.getY(), knightInitialPosition.getX()+1, knightInitialPosition.getY()+2));
    }

    @Test
    public void testCanDoMovementFails(){
        assertFalse(this.movement.canDoMove(knightInitialPosition.getX(), knightInitialPosition.getY(), knightInitialPosition.getX(), knightInitialPosition.getY()));
    }

}
