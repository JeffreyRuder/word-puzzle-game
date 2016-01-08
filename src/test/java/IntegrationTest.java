import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567");
      assertThat(pageSource()).contains("Word Puzzle Game");
  }

  public void indexTest_indexPageFormValidation_PreventsNumerals() {
      goTo("http://localhost:4567");
      fill("#user-entry").with("TROLOLOL101eleven11");
      submit(".btn");
      assertThat(pageSource()).contains("Word Puzzle Game");
  }

  @Test
  public void resultsTest_shortPhraseWithCaseAndPunctuation_ReturnsDashed() {
      goTo("http://localhost:4567");
      fill("#user-entry").with("Use the Force, Luke!");
      submit(".btn");
      assertThat(pageSource()).contains("-s- th- F-rc-, L-k-!");
  }

  @Test
  public void returnTest_resultsPage_containsLinkToIndex() {
      goTo("http://localhost:4567");
      fill("#user-entry").with("Use the Force, Luke!");
      submit(".btn");
      assertThat(pageSource()).contains("a href=\"/\"");
  }

  // Need an integration test for the JavaScript in result.vtl, but not sure how to get webDriver to use JavaScript. Even when JavaScript is enabled when the webDriver is initialized, the webDriver cannot seem to use the event listener in the script.js file.
}
