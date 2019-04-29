package gov.cancer.tests.crosscutting;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.cancer.framework.ExcelDataReader;
import gov.cancer.pageobject.crosscutting.PrettyUrlPage;
import gov.cancer.tests.TestObjectBase;
import gov.cancer.tests.TestRunner;

/**
 * Tests for pages with footer.
 */
public class PrettyUrl_Test extends TestObjectBase {

  /**
   * This method is checking if the length of text displayed on footer on the
   * pages is in considerable range
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPageFooterPaths")
  public void verifyPrettyUrl(String path, String prettyUrl) {

    TestRunner.run(PrettyUrlPage.class, path, (PrettyUrlPage page) -> {

      Assert.assertTrue(page.getUrl().contains(prettyUrl), "Url is correct");

    });

  }

  /*******************************************
   * DATA PROVIDER
   *******************************************/

  /**
   * Retrieves a list of paths to pages which are expected to have Footer
   * 
   * @return An iterable list of two element arrays, each containing a path and
   *         language.
   */
  @DataProvider(name = "getPageFooterPaths")
  public Iterator<Object[]> getPageFooterPaths() {
    String[] columns = { "path", "prettyUrl" };
    return new ExcelDataReader(getDataFilePath("pretty-url-data.xlsx"), "pages_with_pretty_url", columns);

  }

}
