import org.junit.*;
import static org.junit.Assert.*;

public class LetterReplacerTest {

  LetterReplacer vowelReplacer;

  @Before
  public void setUp() {
      vowelReplacer = new LetterReplacer();
  }

  @Test
  public void letterReplace_replaceVowelsWithDashes_shortWordWithDashes() {
      String expectedResult = "b-l--v-";
      assertEquals(expectedResult, "believe");
  }
 }
