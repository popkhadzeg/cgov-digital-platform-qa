package gov.cancer.pageobject.crosscutting;

import org.openqa.selenium.WebElement;

import gov.cancer.framework.ElementHelper;
import gov.cancer.pageobject.PageObjectBase;
import gov.cancer.pageobject.helper.RobotMetaTag;
import gov.cancer.pageobject.helper.AllMetaTags;

/**
 * Pseudo page object representing any page in the system. The class is used
 * solely for verifying the attributes of meta name =robots
 */

public class PageWithMetaTag extends PageObjectBase {
  String cssRobotTag = "meta[name='robots']";
  String cssTwitterTag = "meta[name='twitter:card']";
  String ogType = "meta[property='og:type']";
  String dcTermsType = "meta[name='dcterms.type']";
  String dcTermsIsPartOf = "meta[name='dcterms.isPartOf']";
  String dcTermsSub = "meta[name='dcterms.subject']";
  String dcTermsPartOf = "meta[name='dcterms.isPartOf']";
  String IsReferencedBy = "meta[name='dcterms.isReferencedBy']";
  String coverage = "meta[name='dcterms.coverage']";
  String metaTitle = "meta[name='title']";
  String ogTitle = "meta[property='og:title']";
  String siteName = "meta[property='og:site_name']";
  String ogURL = "meta[property='og:url']";
  String metaDesc = "meta[name='description']";
  String ogDesc = "meta[property='og:description']";
  String language = "meta[http-equiv='content-language']";
  String canonicalURL = "link[rel='canonical']";
  String dcTermsIssuedDate= "meta[name='dcterms.issued']";
  
  
  /**
   * Constructor
   *
   * @param path
   *          server-relative path of the page to load.
   */
  public PageWithMetaTag(String path) {
    super(path);
  }

  /**
   * Finds and returns robot meta tags
   */
  public RobotMetaTag getRobotMetaTag() {
    WebElement robotMetaTagElement = ElementHelper.findElement(getBrowser(), cssRobotTag);
    RobotMetaTag rmt = new RobotMetaTag(robotMetaTagElement);
    return rmt;
  }

  /**
   * Finds and returns twitter tag
   */
  public AllMetaTags getTwitterMetaTag() {
    WebElement twitterMetaTagElement = ElementHelper.findElement(getBrowser(), cssTwitterTag);
    AllMetaTags twitter = new AllMetaTags(twitterMetaTagElement);
    return twitter;
  }
  

  /**
   * Finds and returns of:type meta tag
   */
  public AllMetaTags getOGTypeMetaTag() {
    WebElement ogTypeElement = ElementHelper.findElement(getBrowser(), ogType);
    AllMetaTags ogType = new AllMetaTags(ogTypeElement);
    return ogType;
  }
 
  /**
   * Finds and returns dcterms.isReferencedBy meta tag
   */
  public AllMetaTags getDCTermsReferencedBy() {
    WebElement isReferencedBy = ElementHelper.findElement(getBrowser(), IsReferencedBy);
    AllMetaTags referencedBy = new AllMetaTags(isReferencedBy);
    return referencedBy;
  }
  
  /**
   * Finds and returns dcterms.coverage meta tag
   */
  public AllMetaTags getDCTermsCoverage() {
    WebElement dcTermsCoverage = ElementHelper.findElement(getBrowser(), coverage);
    AllMetaTags coverage = new AllMetaTags(dcTermsCoverage);
    return coverage;
  }
  
  
  /* Returns attribute as sting */
  public String getDCTermsType() {
    return ElementHelper.findElement(getBrowser(), dcTermsType).getAttribute("content");
  }
  
  /* Returns  attribute as sting */
  public String getDCTermsSubject() {
    return ElementHelper.findElement(getBrowser(), dcTermsSub).getAttribute("content");
  }
  
  /* Returns attribute as sting */
  public String getDCTermsIssuedDate() {
    return ElementHelper.findElement(getBrowser(), dcTermsIssuedDate).getAttribute("content");
  }
  
  
  /* Returns attribute as sting */
  public String getDCTermsPartOf() {
    return ElementHelper.findElement(getBrowser(), dcTermsPartOf).getAttribute("content");
  }
  
  /* Returns attribute as sting */
  public String getMetaTitle() {
    return ElementHelper.findElement(getBrowser(), metaTitle).getAttribute("content");
  }
  
  /* Returns attribute as sting */
  public String getOGTitle() {
    return ElementHelper.findElement(getBrowser(), ogTitle).getAttribute("content");
  }
  
  /* Returns attribute as sting */
  public String getMetaSiteName() {
    return ElementHelper.findElement(getBrowser(), siteName).getAttribute("content");
  }
  
  /* Returns attribute as sting */
  public String getOGURL() {
    return ElementHelper.findElement(getBrowser(), ogURL).getAttribute("content");
  }
  
  /* Returns attribute as sting */
  public String getCanonicalURL() {
    return ElementHelper.findElement(getBrowser(), canonicalURL).getAttribute("href");
  }
  
  public String getCurrentURL() {
    String url = getBrowser().getCurrentUrl();
    return url;
   
  }
  
  public String getCurrentPageTitle() {
    String title = getBrowser().getTitle();
    return title;
   
  }
  
  /* Returns attribute as sting */
  public String getMetaDescription() {
    return ElementHelper.findElement(getBrowser(), metaDesc).getAttribute("content");
  }
  
  
  /* Returns attribute as sting */
  public String getOGMetaDescription() {
    return ElementHelper.findElement(getBrowser(), ogDesc).getAttribute("content");
  }
  
  /* Returns attribute as sting */
  public String getContentLanguage() {
    return ElementHelper.findElement(getBrowser(), language).getAttribute("content");
  }
  
}
