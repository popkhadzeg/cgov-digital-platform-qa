
package gov.cancer.pageobject.leftnavigation;

import java.util.List;

import org.openqa.selenium.WebElement;
import gov.cancer.framework.ElementHelper;

public class NavItem {

  private List<NavItem> children;
  private WebElement element;

  public NavItem(WebElement element) {

    this.element = element;

    List<WebElement> subElements = ElementHelper.findElements(element, "ul > li");

    for (WebElement we : subElements) {

      NavItem child = new NavItem(we);

      children.add(child);

    }

  }

  // ========

  public boolean isCurrent(WebElement el) {

    if (el.getAttribute("class").contains("current-page")) {

      return true;
    } else {

      return false;
    }

  }

  public String getText() {
    return getText();

  }

  public boolean hasChildren(WebElement el) {

    if (el.getAttribute("class").contains("level-2")) {

      return true;
    } else {

      return false;
    }

  }
}

/*
 * // public WebElement getCurrentItem() {
 * 
 * 
 * for (WebElement we : element) { if (isCurrent (we)) {
 * 
 * return we; } else if (hasChildren(we)) {
 * 
 * for (NavItem weChild : children) {
 * 
 * if (weChild.getAttribute("class").contains("current-page")) {
 * 
 * return weChild; } } }}
 * 
 * return null;
 * 
 * } //
 */// ------------
