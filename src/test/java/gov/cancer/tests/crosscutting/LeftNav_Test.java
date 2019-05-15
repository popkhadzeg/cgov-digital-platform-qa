package gov.cancer.tests.crosscutting;

import gov.cancer.pageobject.leftnavigation.PageWithSectionNav;
import gov.cancer.tests.TestObjectBase;
import gov.cancer.tests.TestRunner;

public class LeftNav_Test extends TestObjectBase {


  public void fake_test() {

    String path ="about-cancer/coping/feelings";

    TestRunner.run(PageWithSectionNav.class, path, (PageWithSectionNav page) -> {

    });
    }



  public static void main(String[] args) {
    LeftNav_Test test = new LeftNav_Test();
    test.fake_test();
  }





}
