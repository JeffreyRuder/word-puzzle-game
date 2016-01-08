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
      assertEquals(expectedResult, vowelReplacer.letterReplace("believe"));
  }

  @Test
  public void letterReplace_replaceVowelsWithDashes_shortPhraseWithDashes() {
      String expectedResult = "-nch-r th- sh-p";
      assertEquals(expectedResult, vowelReplacer.letterReplace("anchor the ship"));
  }

  @Test
  public void letterReplace_replaceVowelsWithDashes_shortPhraseWithDashesAndCase() {
      String expectedResult = "-P-d PL-YL-ST R-CKS";
      assertEquals(expectedResult, vowelReplacer.letterReplace("iPod PLAYLIST ROCKS"));
  }

  @Test
  public void letterReplace_replaceVowelsWithDashes_preservesPunctuation() {
      String expectedResult = "-s- th- F-rc-, L-k-!";
      assertEquals(expectedResult, vowelReplacer.letterReplace("Use the Force, Luke!"));
  }

  @Test
  public void letterReplace_replaceVowelsWithDashes_worksForLongString() {
      String expectedResult = "B-l--v- y-- c-n -nd y--'r- h-lfw-y th-r-. Th--d-r- R--s-v-lt";
      assertEquals(expectedResult, vowelReplacer.letterReplace("Believe you can and you're halfway there. Theodore Roosevelt"));
  }
 }
