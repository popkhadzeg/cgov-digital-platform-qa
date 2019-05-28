package gov.cancer.pageobject.section;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import gov.cancer.framework.ElementHelper;

/*
 * r 
 */
public class OnThisPage {

  // "On This Page" section
  private WebElement otpSection;

  // Finds "On This Page" links
  private WebElement otpAnchors;

  final public String otpLinks = ":scope > ul > li";

  final public String otpHeader = ":scope h6";

  public OnThisPage(WebElement element) {

    this.otpSection = element;
    this.otpAnchors = element.findElement(By.cssSelector(":scope a"));

  }

  /**
   * Reports whether On This Page Header is in correct language.
   *
   * @return True if the text is found, false otherwise.
   *
   *         NOTE: If the section does not appear on the page, it cannot contain
   *         text and this method will return false;
   */
  public String getOnThisPageHeaderText() {

    return ElementHelper.findElement(otpSection, otpHeader).getText();
  }

  /**
   * Find the list of "On This Page" anchor links on the page.
   */
  public List<OnThisPage> getOnThisPage() {

    List<OnThisPage> links = new ArrayList<OnThisPage>();

    List<WebElement> rawLinks = ElementHelper.findElements(this.otpSection, otpLinks);

    for (WebElement link : rawLinks) {
      links.add(new OnThisPage(link));
    }

    return links;
  }

  /*
   * check if this element text has a tag 'a'
   */
  public boolean isLinkElement() {
    if (otpAnchors != null) {
      return otpAnchors.getTagName().equalsIgnoreCase("a");
    } else
      return false;
  }

  /*
   * if element is null return false; else trim the element text and if its empty
   * return false (ex: string between a tag)
   */
  public boolean isLinkTextBlank() {
    if (otpAnchors != null)
      return !otpAnchors.getText().trim().isEmpty();
    return false;
  }

  /*
   * Does it have a non-empty href? (ex: " ")
   */
  public boolean isLinkHrefBlank() {
    if (otpAnchors != null)
      return !otpAnchors.getAttribute("href").trim().isEmpty();
    else
      return false;
  }

  /*
   * Does it have # anchor tag)
   */
  public boolean isAnchorTagPresent() {
    if (otpAnchors != null)
      return otpAnchors.getAttribute("href").contains("#");
    return false;
  }

}
