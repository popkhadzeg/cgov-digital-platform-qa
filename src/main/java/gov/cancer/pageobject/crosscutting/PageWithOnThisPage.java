package gov.cancer.pageobject.crosscutting;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import gov.cancer.framework.ElementHelper;
import gov.cancer.pageobject.PageObjectBase;
import gov.cancer.pageobject.section.Body;
import gov.cancer.pageobject.section.OnThisPage;

public class PageWithOnThisPage extends PageObjectBase {

  WebElement otpSection;

  String sectionSelector = ".on-this-page";


  /**
   * Constructor
   *
   * @param path server-relative path of the page to load.
   */
  public PageWithOnThisPage(String path) {
    super(path);
   
    this.otpSection = ElementHelper.findElement(getBrowser(), sectionSelector);
  }

  /**
   * * Returns true if the page has a On This Page section, false otherwise.
  */
 public boolean isOtpSectionVisible() {
 
   return otpSection != null && otpSection.isDisplayed();

 }

  public OnThisPage getOnThisPage() {
    WebElement otpSection = ElementHelper.findElement(this.getBrowser(), sectionSelector);
    OnThisPage otp = new OnThisPage(otpSection);
    return otp;
  }

  
  
}