package gov.cancer.pageobject.helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AllMetaTags extends MetaTag {
  
  @FindBy(how = How.CSS, using = "#main h1")
  WebElement contentTitle;
  String dcTermsType = "meta[name='dcterms.type']";
  String dc = "#main h1";
  /**
   * constructor
   */

  public AllMetaTags(WebElement element) {
    super(element);
  }

  /**
   * Reports whether the content has Twitter meta tag
   */
  public boolean getTwitterMetaName() {
    String str = getContent();
    if (str != null && (str.trim().toLowerCase().equals("summary")))
      return true;
    else
      return false;
  }
  

  /**
   * Reports whether the content has Twitter meta tag
   */
  public boolean getOGTypeMetaName() {
    String str = getContent();
    if (str != null && (str.trim().equals("Website")))
      return true;
    else
      return false;
  }
  
  public boolean getDCTermsIsReferencedBy() {
    String str = getContent();
    if (str != null && (str.trim().equals("event1,event53")))
      return true;
    else
      return false;
  }
  
  
  public boolean getDCTermsCoverage() {
    String str = getContent();
    if (str != null && (str.trim().equals("nciglobal,ncienterprise")))
      return true;
    else
      return false;
  }
  
  public boolean getHREFLanguage() {
    String str = getContent();
    if (str != null && (str.trim().equals("nciglobal,ncienterprise")))
      return true;
    else
      return false;
  }
 
  
  
}
