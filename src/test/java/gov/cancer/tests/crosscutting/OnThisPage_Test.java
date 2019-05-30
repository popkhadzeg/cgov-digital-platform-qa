package gov.cancer.tests.crosscutting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.cancer.framework.ExcelDataReader;
import gov.cancer.pageobject.crosscutting.PageWithOnThisPage;
import gov.cancer.pageobject.section.Body;
import gov.cancer.pageobject.section.OnThisPage;
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

      Assert.assertTrue(page.isOnThisPageSectionVisible(), "On This Pages section is visible");

    });

  }

  /**
   * This method is checking all pages that does NOT display "On this Page"
   * section
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPageWithoutOnThisPagePaths")
  public void verifyOnThisPageNotIsVisible(String path) {

    TestRunner.run(PageWithOnThisPage.class, path, (PageWithOnThisPage page) -> {

      Assert.assertFalse(page.isOnThisPageSectionVisible(), "On This Pages section is visible");

    });

  }

  /**
   * This method compares "On This Page" Section header for correct translation
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithSectionHeaderTranslations")
  public void verifyOnThisPageSectionHeaderText(String path, String otpHeader) {

    TestRunner.run(PageWithOnThisPage.class, path, (PageWithOnThisPage page) -> {
      OnThisPage otp = page.getOnThisPage();

      Assert.assertEquals(otp.getOnThisPagesSectionHeaderText(), otpHeader);
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

      OnThisPage otp = page.getOnThisPage();
      List<OnThisPage> anchorList = otp.getOnThisPage();

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
   * This method is comparing "On This Page" anchor links to "On This Page" body
   * headers to verify text and size match
   *
   * @param path Path of the page to check.
   *
   */
  @Test(dataProvider = "getOnThisPagePaths")
  public void verifyAnchorAndHeadermatch(String path) {

    TestRunner.run(PageWithOnThisPage.class, path, (PageWithOnThisPage page) -> {

      // Get the list of Body Headers
      Body body = page.getBodySection();
      List<String> bodyHeaderList = body.getBodySectionAsString();

      // Get the list of OTP anchor list
      OnThisPage otp = page.getOnThisPage();
      List<String> anchorList = otp.getAnchorListAsString();

      // asserting header list and anchor list size match
      Assert.assertTrue(bodyHeaderList.size() == anchorList.size());

      // looping through each header list and anchor list item text to find a match
      for (int i = 0; i < bodyHeaderList.size(); i++) {
        Assert.assertTrue(bodyHeaderList.get(i).equals(anchorList.get(i)));

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
  @DataProvider(name = "getPagesWithSectionHeaderTranslations")
  public Iterator<Object[]> getPagesWithSectionHeaderTranslations() {
    String[] columns = { "path", "otpHeader" };
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
