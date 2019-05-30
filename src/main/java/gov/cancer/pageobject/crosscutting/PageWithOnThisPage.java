package gov.cancer.pageobject.crosscutting;

import org.openqa.selenium.WebElement;

import gov.cancer.framework.ElementHelper;
import gov.cancer.pageobject.PageObjectBase;
import gov.cancer.pageobject.section.Body;
import gov.cancer.pageobject.section.OnThisPage;

public class PageWithOnThisPage extends PageObjectBase {

  WebElement otpSection = null;
  WebElement bodySection = null;

  // "On This Page" section
  final public String otpSectionSelector = ".on-this-page";

  // Body section
  final public String bodySectionSelector = "#cgvBody";

  /**
   * Constructor
   *
   * @param path server-relative path of the page to load.
   */
  public PageWithOnThisPage(String path) {
    super(path);

    this.otpSection = ElementHelper.findElement(this.getBrowser(), otpSectionSelector);
    this.bodySection = ElementHelper.findElement(this.getBrowser(), bodySectionSelector);

  }

  /**
   * 
   * Retrieve "On This Page" section
   */
  public OnThisPage getOnThisPage() {
    WebElement otpSection = ElementHelper.findElement(this.getBrowser(), otpSectionSelector);
    OnThisPage otp = new OnThisPage(otpSection);
    return otp;

  }

  /**
   * 
   * Retrieve Body section
   */
  public Body getBodySection() {
    WebElement bodySection = ElementHelper.findElement(this.getBrowser(), bodySectionSelector);
    Body body = new Body(bodySection);
    return body;
  }

  /**
   * * Returns true if the page has a On This Page section, false otherwise.
   */
  public boolean isOnThisPageSectionVisible() {

    return otpSection != null && otpSection.isDisplayed();

  }

}