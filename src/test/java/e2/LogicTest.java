package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
  public static final int SIZE=4;
  public static final Pair<Integer, Integer> pawnPosition= new Pair<>(0,0);
  public static final Pair<Integer, Integer> knightPosition= new Pair<>(SIZE-1,SIZE-1);
  public Logics logics;


  @BeforeEach
  public void testCreateField(){
     logics= new LogicsImpl(SIZE, pawnPosition, knightPosition);
  }

  @Test
  public void testHasKnight() {
    assertTrue(logics.hasKnight(knightPosition.getX(), knightPosition.getY()));
  }

  @Test
  public void testHasPawn() {
    assertTrue(logics.hasPawn(pawnPosition.getX(), pawnPosition.getY()));
  }

  @Test
  public void testHit(){
    assertFalse(logics.hit(0,0));
  }

  @Test
  public void testHitOutOfBounds(){
    assertThrows(IndexOutOfBoundsException.class, ()->logics.hit(-1,-1));
  }

}
