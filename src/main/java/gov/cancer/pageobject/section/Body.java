package gov.cancer.pageobject.section;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import gov.cancer.framework.ElementHelper;

public class Body {

  private WebElement bodySection;

  // Retrieves Body Headers
  public String bodyHeaders = ".accordion section h2";

  /**
   * 
   * Constructor
   * 
   * @param element WebElement containing Body section markup.
   */
  public Body(WebElement element) {

    this.bodySection = element;

  }

  /**
   * 
   * Retrieve the list of Body headers on the page.
   */
  public List<Body> getBodySection() {

    List<Body> bodyHeaderList = new ArrayList<Body>();

    List<WebElement> headers = ElementHelper.findElements(this.bodySection, bodyHeaders);

    for (WebElement list : headers) {
      bodyHeaderList.add(new Body(list));
    }

    return bodyHeaderList;

  }

  /**
   * 
   * Retrieve the String list of Body Headers
   */
  public List<String> getBodySectionAsString() {

    List<String> bodyHeaderListAsString = new ArrayList<>();

    List<WebElement> headers = ElementHelper.findElements(this.bodySection, bodyHeaders);

    for (WebElement list : headers) {
      bodyHeaderListAsString.add(new Body(list).getText());
    }

    return bodyHeaderListAsString;

  }

  /**
   * 
   * Retrieve body Section text
   */
  public String getText() {
    return bodySection.getText().trim();
  }

}
