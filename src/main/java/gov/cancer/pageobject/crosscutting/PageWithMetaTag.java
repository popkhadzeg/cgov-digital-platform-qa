package gov.cancer.pageobject.crosscutting;

import org.openqa.selenium.WebElement;

import gov.cancer.framework.ElementHelper;
import gov.cancer.pageobject.PageObjectBase;
import gov.cancer.pageobject.helper.RobotMetaTag;
import gov.cancer.pageobject.helper.AllMetaTags;

/**
 * Pseudo page object representing any page in the system. The class is used
 * solely for verifying the attributes of entire page meta names and properties
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
  String dcTermsIssuedDate = "meta[name='dcterms.issued']";

  /**
   * Constructor
   *
   * @param path server-relative path of the page to load.
   */
  public PageWithMetaTag(String path) {
    super(path);
  }

  /**
   * Finds and returns content of 'robots' metatag
   */
  public RobotMetaTag getRobotMetaTag() {
    WebElement robotMetaTagElement = ElementHelper.findElement(getBrowser(), cssRobotTag);
    RobotMetaTag rmt = new RobotMetaTag(robotMetaTagElement);
    return rmt;
  }

  /**
   * Finds and returns content of 'twitter:card' metatag
   */
  public AllMetaTags getTwitterMetaTag() {
    WebElement twitterMetaTagElement = ElementHelper.findElement(getBrowser(), cssTwitterTag);
    AllMetaTags twitter = new AllMetaTags(twitterMetaTagElement);
    return twitter;
  }

  /**
   * Finds and returns content of 'og:type' metatag for Open Graph
   */
  public AllMetaTags getOGTypeMetaTag() {
    WebElement ogTypeElement = ElementHelper.findElement(getBrowser(), ogType);
    AllMetaTags ogType = new AllMetaTags(ogTypeElement);
    return ogType;
  }

  /**
   * Finds and returns content of 'dcterms.isReferencedBy' metatag
   */
  public AllMetaTags getDCTermsReferencedBy() {
    WebElement isReferencedBy = ElementHelper.findElement(getBrowser(), IsReferencedBy);
    AllMetaTags referencedBy = new AllMetaTags(isReferencedBy);
    return referencedBy;
  }

  /**
   * Finds and returns content of 'dcterms.coverage' metatag
   */
  public AllMetaTags getDCTermsCoverage() {
    WebElement dcTermsCoverage = ElementHelper.findElement(getBrowser(), coverage);
    AllMetaTags coverage = new AllMetaTags(dcTermsCoverage);
    return coverage;
  }

  /**
   * Finds and returns content of 'dcterms.type' metatag
   */
  public String getDCTermsType() {
    return ElementHelper.findElement(getBrowser(), dcTermsType).getAttribute("content");
  }

  /**
   * Finds and returns content of 'dcterms.subject' metatag
   */
  public String getDCTermsSubject() {
    return ElementHelper.findElement(getBrowser(), dcTermsSub).getAttribute("content");
  }

  /**
   * Finds and returns content of 'dcterms.issued' metatag
   */
  public String getDCTermsIssuedDate() {
    return ElementHelper.findElement(getBrowser(), dcTermsIssuedDate).getAttribute("content");
  }

  /**
   * Finds and returns content of 'dcterms.isPartOf' metatag
   */
  public String getDCTermsPartOf() {
    return ElementHelper.findElement(getBrowser(), dcTermsPartOf).getAttribute("content");
  }

  /**
   * Finds and returns content of 'title' metatag
   */
  public String getMetaTitle() {
    return ElementHelper.findElement(getBrowser(), metaTitle).getAttribute("content");
  }

  /**
   * Finds and returns content of 'og:title' metatag for Open Graph
   */
  public String getOGTitle() {
    return ElementHelper.findElement(getBrowser(), ogTitle).getAttribute("content");
  }

  /**
   * Finds and returns content of 'og:site_name' metatag for Open Graph
   */
  public String getMetaSiteName() {
    return ElementHelper.findElement(getBrowser(), siteName).getAttribute("content");
  }

  /**
   * Finds and returns content of 'og:url' metatag for Open Graph
   */
  public String getOGURL() {
    return ElementHelper.findElement(getBrowser(), ogURL).getAttribute("content");
  }

  /**
   * Finds and returns href attribute of link rel="canonical" metatag
   */
  public String getCanonicalURL() {
    return ElementHelper.findElement(getBrowser(), canonicalURL).getAttribute("href");
  }

  /**
   * Finds and returns Current Page URL
   */
  public String getCurrentURL() {
    String url = getBrowser().getCurrentUrl();
    return url;

  }

  /**
   * Finds and returns Current Page title
   */
  public String getCurrentPageTitle() {
    String title = getBrowser().getTitle();
    return title;

  }

  /**
   * Finds and returns content of 'description' metatag
   */
  public String getMetaDescription() {
    return ElementHelper.findElement(getBrowser(), metaDesc).getAttribute("content");
  }

  /**
   * Finds and returns content of 'og:description' metatag for Open Graph
   */
  public String getOGMetaDescription() {
    return ElementHelper.findElement(getBrowser(), ogDesc).getAttribute("content");
  }

  /**
   * Finds and returns metatag http-equiv="content-language"
   */
  public String getContentLanguage() {
    return ElementHelper.findElement(getBrowser(), language).getAttribute("content");
  }

}
