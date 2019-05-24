package gov.cancer.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

/**
 * ElementHelper class contains methods which work on web elements on the page.
 *
 */
public class ElementHelper {

  /**
   * This method returns the exact element on the page.
   *
   * @param parent
   *          - page WebDriver or WebElement.
   * @param selector
   *          - CSS selector string.
   */
  public static WebElement findElement(SearchContext parent, String selector) {

    List<WebElement> findList = parent.findElements(By.cssSelector(selector));

    if (findList.size() == 1) {
      return findList.get(0);
    } else if (findList.size() > 1) {
      throw new RuntimeException("There should be only one Element");

    } else {
      return null;
    }

  }

  /**
   * This method returns the list of elements on the page defined by a certain
   * selector. If no elements are found, an empty list is returned.
   *
   * @param parent
   *          - page WebDriver or WebElement.
   * @param selector
   *          - CSS selector string.
   */
  public static List<WebElement> findElements(SearchContext parent, String selector) {

    List<WebElement> findList = parent.findElements(By.cssSelector(selector));
    return findList;
  }

  /**
   * This method returns true if the element is visible.
   *
   * @param parent
   *          - page WebDriver or WebElement.
   * @param selector
   *          - CSS selector string.
   */
  public static boolean isVisible(SearchContext parent, String selector) {

    if (findElement(parent, selector) != null) {
      return findElement(parent, selector).isDisplayed();
    }
    else {
      return false;
    }
  }

  /**
   * Tests whether the text of the specified WebElement contains a specific
   * substring. NOTE: This is a simple, case-sensitive search and does not account
   * for markup contained in the target WebElement. E.g. A search for "the big
   * cat" will fail if the WebElement contains the markup "the <b>big</b> cat."
   *
   * @param element    The WebElement containing the text to be searched.
   * @param searchText The text to be searched for.
   * @return True if element contains searchText, false otherwise.
   *
   *         NOTE: if element is null, it cannot contain text and the method will
   *         return false.
   */
  public static boolean elementContainsText(WebElement element, String searchText) {
    if (element != null) {
      String text = element.getText();
      return text.contains(searchText);
    } else {
      return false;
    }
  }

  /**
   * Retrieves the list of discrete names in a WebElement's class
   * attribute
   * @param element The element to use.
   * @return Array of String objects. If the element has no class
   * attribute, an empty array is returned.
   */
  public static String[] getClassList(WebElement element) {

    String attrib = element.getAttribute("class");
    if (attrib == null)
      return new String[0];

    return attrib.split("\\s");
  }
}
