package gov.cancer.pageobject.leftnavigation;

import org.openqa.selenium.WebElement;

import gov.cancer.framework.ElementHelper;
import gov.cancer.pageobject.PageObjectBase;

public class PageWithSectionNav extends PageObjectBase {

  private NavItem root;

  public PageWithSectionNav(String path) {
    super(path);

    WebElement section = ElementHelper.findElement(getBrowser(), "#nvcgSlSectionNav .section-nav > ul > li");
    System.out.println(section.getText());

    root = new NavItem(section);

  }

}