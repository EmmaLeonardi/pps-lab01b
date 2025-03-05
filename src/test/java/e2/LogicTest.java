package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTest {
  public static final int SIZE=3;
  public static final Pair<Integer, Integer> pawnPosition= new Pair<>(0,0);
  public static final Pair<Integer, Integer> knightPosition= new Pair<>(0,0);
  public Logics logics;


  @BeforeEach
  public void testCreateField(){
     logics= new LogicsImpl(SIZE, pawnPosition, knightPosition);

  }

  @Test
  public void testHasKnight() {
    assertTrue(logics.hasKnight(knightPosition.getX(), knightPosition.getY()));
  }

}
