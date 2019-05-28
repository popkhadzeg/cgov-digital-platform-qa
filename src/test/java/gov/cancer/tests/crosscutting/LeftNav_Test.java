package gov.cancer.tests.crosscutting;

import gov.cancer.pageobject.leftnavigation.NavItem;
import gov.cancer.pageobject.leftnavigation.PageWithSectionNav;
import gov.cancer.tests.TestObjectBase;
import gov.cancer.tests.TestRunner;

public class LeftNav_Test extends TestObjectBase {


  public void fake_test() {

    String path ="about-cancer/coping/feelings";

    TestRunner.run(PageWithSectionNav.class, path, (PageWithSectionNav page) -> {

      // Exammples
      String label;

      // This will currently find the element labeled
      // "COPING WITH CANCER"
      NavItem currentSelection = page.getCurrentNavItem();
      label = currentSelection.getLabel();

      // This will find a node which has children.
      NavItem itemWithChildren = page.findItemByLabel("Adjusting to Cancer");
      boolean hasChildren = itemWithChildren.hasChildren();
      label = itemWithChildren.getLabel();

      // This will *NOT* items which are not currently visible.
      // The foundItem variable will be null in this circumstance.
      NavItem foundItem = page.findItemByLabel("Going Back to Work");

    });
    }



  public static void main(String[] args) {
    LeftNav_Test test = new LeftNav_Test();
    test.fake_test();
  }





}
