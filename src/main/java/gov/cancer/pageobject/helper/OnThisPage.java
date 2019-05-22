package gov.cancer.pageobject.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * represents a single entry in a list of "On this Page" section
 */
public class OnThisPage {

  // this is the anchor tag for on this page
  WebElement anchorLink;

  // On this Page anchor links
  public OnThisPage(WebElement element) {
    anchorLink = element.findElement(By.cssSelector(".on-this-page ul li a"));
  }

  /*
   * check if this element text has a tag 'a'
   */
  public boolean isLinkElement() {
    if (anchorLink != null) {
      return anchorLink.getTagName().equalsIgnoreCase("a");
    } else
      return false;
  }

  /*
   * if element is null return false; else trim the element text and if its empty
   * return false (ex: string between a tag)
   */
  public boolean isLinkTextBlank() {
    if (anchorLink != null)
      return !anchorLink.getText().trim().isEmpty();
    return false;
  }

  /*
   * Does it have a non-empty href? (ex: " ")
   */
  public boolean isLinkHrefBlank() {
    if (anchorLink != null)
      return !anchorLink.getAttribute("href").trim().isEmpty();
    else
      return false;
  }

  /*
   * Does it have # anchor tag)
   */
  public boolean isAnchorTagPresent() {
    if (anchorLink != null)
      return anchorLink.getAttribute("href").contains("#");
    return false;
  }

}
