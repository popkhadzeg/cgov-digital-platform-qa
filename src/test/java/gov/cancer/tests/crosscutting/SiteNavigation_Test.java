package gov.cancer.tests.crosscutting;

import java.util.Iterator;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.cancer.framework.ExcelDataReader;
import gov.cancer.pageobject.crosscutting.SiteNavigationPage;
import gov.cancer.tests.TestObjectBase;
import gov.cancer.tests.TestRunner;

public class SiteNavigation_Test extends TestObjectBase {

  /**
   *
   * This method is checking if Left Navigation is visible
   *
   * @param path Path of the page to check.
   *
   */
  @Test(dataProvider = "getPagesWithSiteNavigation")
  public void verifySiteNavigation(String path) {

    TestRunner.run(SiteNavigationPage.class, path, (SiteNavigationPage page) -> {

      // Asserting section vavigsation is visible
      Assert.assertTrue(page.sectionNavigationIsVisible(), "section navigation is displayed.");

    });
  }

  @DataProvider(name = "getPagesWithSiteNavigation")
  public Iterator<Object[]> getPagesWithSiteNavigation() {
    String[] columns = { "path" };
    return new ExcelDataReader(getDataFilePath("site-navigation-data.xlsx"), "pages_with_site_navigation", columns);
  }

  //// ======== Main Menu

  @Test(dataProvider = "getPagesWithTopNavigation")
  public void verifyTopMenuNavigation(String path, String menu) {

    TestRunner.run(SiteNavigationPage.class, path, (SiteNavigationPage page) -> {

      // Asserting current mega menu selected matches the page
      Assert.assertEquals(page.getMenu(), menu);

    });
  }

  @DataProvider(name = "getPagesWithTopNavigation")
  public Iterator<Object[]> getPagesWithTopNavigation() {
    String[] columns = { "path", "menu" };
    return new ExcelDataReader(getDataFilePath("site-navigation-data.xlsx"), "pages_with_site_navigation", columns);
  }

  //// ======== Left Nav

  @Test(dataProvider = "getSiteNavigationHierarchy")
  public void verifySiteNavigationHierarchy(String path, String menu, String parent, String level1, String level2) {

    TestRunner.run(SiteNavigationPage.class, path, (SiteNavigationPage page) -> {

      for (WebElement we : page.getChildren()) {

        // Getting list of left naviagtion links
        Assert.assertFalse(page.isChildNavigationSelected(we));
      }

      // Asserting Parent left navigation match
      Assert.assertEquals(page.getParent(), parent);
      page.clickFirstChild();

      // Asserting Level 1 left navigation match
      Assert.assertEquals(page.getLeftLevel1(), level1);
      page.clickNextChild();

      // Asserting Level 2 left navigation match
      Assert.assertEquals(page.getLeftLevel2(), level2);

    });
  }

  @DataProvider(name = "getSiteNavigationHierarchy")
  public Iterator<Object[]> getSiteNavigationHierarchy() {
    String[] columns = { "path", "menu", "parent", "level1", "level2" };
    return new ExcelDataReader(getDataFilePath("site-navigation-data.xlsx"), "pages_with_site_navigation", columns);
  }

}
