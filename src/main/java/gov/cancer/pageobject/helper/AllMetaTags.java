package gov.cancer.pageobject.helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AllMetaTags extends MetaTag {

  /**
   * constructor
   */

  public AllMetaTags(WebElement element) {
    super(element);
  }

  /**
   * Reports whether page has metatag 'name="twitter:card" content="summary"
   */
  public boolean getTwitterMetaName() {
    String str = getContent();
    if (str != null && (str.trim().toLowerCase().equals("summary")))
      return true;
    else
      return false;
  }

  /**
   * Reports whether page has metatag 'property="og:type" content="Website"
   */
  public boolean getOGTypeMetaName() {
    String str = getContent();
    if (str != null && (str.trim().equals("Website")))
      return true;
    else
      return false;
  }

  /**
   * Reports whether page has metatag 'name="dcterms.isReferencedBy"
   * content="event1"
   */
  public boolean getDCTermsIsReferencedBy() {
    String str = getContent();
    if (str != null && (str.trim().equals("event1")))
      return true;
    else
      return false;
  }

  /**
   * Reports whether page has metatag 'name="dcterms.coverage"
   * content="nciglobal,ncienterprise"
   */
  public boolean getDCTermsCoverage() {
    String str = getContent();
    if (str != null && (str.trim().equals("nciglobal,ncienterprise")))
      return true;
    else
      return false;
  }

}
