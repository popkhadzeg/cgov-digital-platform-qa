package gov.cancer.pageobject.crosscutting;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import gov.cancer.framework.ElementHelper;
import gov.cancer.pageobject.PageObjectBase;
import gov.cancer.pageobject.helper.OnThisPage;

public class PageWithOnThisPage extends PageObjectBase {

  WebElement onThisPageSection = null;

  String sectionSelector = ".on-this-page";

  final public String onThisPageHeader = ".on-this-page h6";

  /**
   * Constructor
   *
   * @param path server-relative path of the page to load.
   */
  public PageWithOnThisPage(String path) {
    super(path);

    onThisPageSection = ElementHelper.findElement(this.getBrowser(), sectionSelector);
  }

  /**
   * Returns true if the page has a On This Page section, false otherwise.
   */
  public boolean onThisPageSectionIsVisible() {

    return onThisPageSection != null && onThisPageSection.isDisplayed();

  }

  /**
   * Find all of the On This Page anchor links on the page.
   */
  public List<OnThisPage> getOnThisPage() {

    List<OnThisPage> links = new ArrayList<OnThisPage>();

    List<WebElement> rawLinks = onThisPageSection.findElements(By.cssSelector("ul li"));

    for (WebElement link : rawLinks) {

      links.add(new OnThisPage(link));
    }
    return links;
  }

  /**
   * Reports whether On This Page Header is in correct language.
   *
   * @return True if the text is found, false otherwise.
   *
   *         NOTE: If the Intro Text section does not appear on the page, it
   *         cannot contain text and this method will return false;
   */
  public String getOnThisPageHeaderText() {

    return ElementHelper.findElement(getBrowser(), onThisPageHeader).getText();
  }

}