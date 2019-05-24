package gov.cancer.pageobject.leftnavigation;

import org.openqa.selenium.WebElement;

import gov.cancer.framework.ElementHelper;
import gov.cancer.pageobject.PageObjectBase;

public class PageWithSectionNav extends PageObjectBase {

  private NavItem root;

  /**
   * Contains a data structure representing a page's Left Navigation
   * area.
   * @param path The path to the page.
   */
  public PageWithSectionNav(String path) {
    super(path);

    // Find the navigation tree.
    WebElement section = ElementHelper.findElement(getBrowser(), "#nvcgSlSectionNav .section-nav > ul > li");
    root = new NavItem(section);
  }


  /**
   * Walks the section tree to find the one marked as current.
   * @return The current NavItem.
   */
  public NavItem getCurrentNavItem() {

    NavItem current = root.getCurrentNavItem();
    if (current == null)
      current = root;

    return current;
  }

  /**
   * Walks the section tree to find a <b>visible</b> entry with the provided
   * label.
   *
   * Due to limitations of Selenium, only <b>visible</b> elements may be
   * retrieved. See https://w3c.github.io/webdriver/#get-element-text
   * @return A NavItem representing the navigation tree item containing the label.
   *         Null if no matching item is found.
   */
  public NavItem findItemByLabel(String label) {
    return root.findItemByLabel(label);
  }

}
