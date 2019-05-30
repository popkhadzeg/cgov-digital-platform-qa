package gov.cancer.pageobject.section;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import gov.cancer.framework.ElementHelper;

public class OnThisPage {

  // "On This Page" section
  private WebElement otpSection;
  private WebElement otpAnchors;

  // Retrieve "On This Page" links
  final public String otpLinks = ":scope > ul > li";

  // Retrieve "On This Page" section header
  final public String otpSectionheader = ":scope h6";

  /**
   * 
   * Constructor
   * 
   * @param element WebElement containing "On This Page" section and anchor links.
   */
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
  public String getOnThisPagesSectionHeaderText() {

    return ElementHelper.findElement(otpSection, otpSectionheader).getText();
  }

  /**
   * 
   * Retrieve the list of "On This Page" anchor links on the page.
   */
  public List<OnThisPage> getOnThisPage() {

    List<OnThisPage> anchorList = new ArrayList<OnThisPage>();

    List<WebElement> rawLinks = ElementHelper.findElements(this.otpSection, otpLinks);

    for (WebElement links : rawLinks) {
      anchorList.add(new OnThisPage(links));
    }

    return anchorList;
  }

  /**
   * 
   * Retrieve the String list of "On This Page" items
   */
  public List<String> getAnchorListAsString() {
    List<String> anchorListAsString = new ArrayList<>();

    List<WebElement> rawLinks = ElementHelper.findElements(this.otpSection, otpLinks);

    for (WebElement links : rawLinks) {
      anchorListAsString.add(new OnThisPage(links).getText());
    }

    return anchorListAsString;
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

  /**
   * 
   * Retrieve OTP anchor text
   */
  public String getText() {
    return otpAnchors.getText().trim();
  }

}
