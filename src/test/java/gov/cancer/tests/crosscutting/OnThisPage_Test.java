package gov.cancer.tests.crosscutting;

import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.cancer.framework.ExcelDataReader;
import gov.cancer.pageobject.crosscutting.PageWithOnThisPage;
import gov.cancer.pageobject.helper.OnThisPage;
import gov.cancer.tests.TestObjectBase;
import gov.cancer.tests.TestRunner;

/**
 * Tests Cases: Verify On this Page
 * 
 */

public class OnThisPage_Test extends TestObjectBase {

  /**
   * This method is checking all pages with "On this Page" section visibility
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getOnThisPagePaths")
  public void verifyOnThisPageIsVisible(String path) {

    TestRunner.run(PageWithOnThisPage.class, path, (PageWithOnThisPage page) -> {

      Assert.assertTrue(page.onThisPageSectionIsVisible(), "On This Pages section is visible");

    });

  }

  /**
   * This method is checking all pages that does NOT display "On this Page"
   * section
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPageWithoutOnThisPagePaths")
  public void verifyPageWithoutOnThisPage(String path) {

    TestRunner.run(PageWithOnThisPage.class, path, (PageWithOnThisPage page) -> {

      Assert.assertFalse(page.onThisPageSectionIsVisible(), "On This Pages section is visible");

    });

  }

  /**
   * This method compare "On This Page" Section header for correct translation
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithTranslations")
  public void verifyOnThisPageHeaderText(String path, String header) {

    TestRunner.run(PageWithOnThisPage.class, path, (PageWithOnThisPage page) -> {

      Assert.assertEquals(page.getOnThisPageHeaderText(), header);
    });

  }

  /**
   * 
   * This method is checking all of the "On This Page" Section links on the page
   * and verifying links Text/HREF is not blank and anchor tags are present
   *
   * @param path Path of the page to check.
   *
   */
  @Test(dataProvider = "getOnThisPagePaths")
  public void verifyOnThisPageAnchorLinks(String path) {

    TestRunner.run(PageWithOnThisPage.class, path, (PageWithOnThisPage page) -> {

      List<OnThisPage> anchorList = page.getOnThisPage();

      Assert.assertTrue(anchorList.size() > 0);

      // For each anchor link execute the following assertions.
      for (OnThisPage anchors : anchorList) {

        // Does this link have 'a' tag?
        Assert.assertTrue(anchors.isLinkElement(), "Does this link have 'a' tag.");

        // Does it have non-blank text?
        Assert.assertTrue(anchors.isLinkTextBlank(), "Is not blank.");

        // Does it have a non-empty href?
        Assert.assertTrue(anchors.isLinkHrefBlank(), "HREF Is not blank.");

        // Does it have a non-empty href?
        Assert.assertTrue(anchors.isAnchorTagPresent(), "Is Anchor tag present");
      }

    });
  }

  /**
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getOnThisPagePaths")
  public Iterator<Object[]> getOnThisPagePaths() {
    String[] columns = { "path" };
    return new ExcelDataReader(getDataFilePath("on-this-page-data.xlsx"), "pages_with_on_this_page", columns);
  }

  /**
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   * @return header Expected header text
   */
  @DataProvider(name = "getPagesWithTranslations")
  public Iterator<Object[]> getPagesWithTranslations() {
    String[] columns = { "path", "header" };
    return new ExcelDataReader(getDataFilePath("on-this-page-data.xlsx"), "pages_with_on_this_page", columns);
  }

  /**
   * 
   *
   *
   * @return path Returns a list of paths for pages which Does Not expected to
   *         display "On This Page" Section
   */
  @DataProvider(name = "getPageWithoutOnThisPagePaths")
  public Iterator<Object[]> getPageWithoutOnThisPagePaths() {
    String[] columns = { "path" };
    return new ExcelDataReader(getDataFilePath("on-this-page-data.xlsx"), "pages_without_on_this_page", columns);
  }

}
