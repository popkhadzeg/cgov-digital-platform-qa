package gov.cancer.pageobject.crosscutting;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import gov.cancer.framework.ElementHelper;
import gov.cancer.pageobject.PageObjectBase;

public class SiteNavigationPage extends PageObjectBase {

  WebElement targetedSection = null;

  String sectionNav = ".section-nav";

  @FindBy(how = How.CSS, using = ".nav-item[class*='current']>.nav-item-title")
  WebElement mainMenu;

  @FindBy(how = How.CSS, using = ".level-0>div>a")
  WebElement parentMenu;

  @FindBy(how = How.CSS, using = ".level-1:first-child")
  WebElement firstChild;

  @FindBy(how = How.CSS, using = ".level-1:first-child li a")
  WebElement currentLevel2;

  @FindBy(how = How.CSS, using = ".level-1 .current-page")
  WebElement currentLevel1;

  @FindBy(how = How.CSS, using = ".section-nav .level-1")
  List<WebElement> children;

  public SiteNavigationPage(String path) {
    super(path);
    targetedSection = ElementHelper.findElement(this.getBrowser(), sectionNav);

  }

  public String getMenu() {
    return mainMenu.getText();
  }

  public String getLeftLevel1() {
    return currentLevel1.getText();
  }

  public String getLeftLevel2() {
    return currentLevel2.getText();
  }

  public String getParent() {
    return parentMenu.getText();
  }

  public void clickFirstChild() {
    firstChild.click();
  }

  public void clickNextChild() {
    currentLevel2.click();
  }

  public List<WebElement> getChildren() {
    return children;
  }

  // List of left naviigation links
  public boolean isChildNavigationSelected(WebElement element) {
    return element.getAttribute("class").contains("current");
  }

  /**
   * Reports whether the section this page is looking for is visible.
   *
   * Returns TRUE if the section is present and visible, returns false otherwise.
   * Note: This means that if the section is missing from the page altogether, it
   * is considered not visible.
   */
  public boolean sectionNavigationIsVisible() {
    if (targetedSection != null)
      return targetedSection.isDisplayed();
    else
      return false;
  }

}