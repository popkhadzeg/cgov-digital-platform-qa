package gov.cancer.tests.metaData;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gov.cancer.framework.ExcelDataReader;
import gov.cancer.pageobject.crosscutting.PageWithMetaTag;
import gov.cancer.pageobject.helper.AllMetaTags;
import gov.cancer.tests.TestObjectBase;
import gov.cancer.tests.TestRunner;

public class MetaData_BrowserTitle_Test extends TestObjectBase {

  /**
   * Asserts current page title equals meta title
   * 
   * @param path
   *          Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithBrowserTitle")
  public void verifyPagesWithBrowserTitle(String path) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {

      Assert.assertEquals(page.getCurrentPageTitle(), page.getMetaTitle());

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have <meta name="title"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithBrowserTitle")
  public Iterator<Object[]> getPagesWithBrowserTitle() {
    String[] columns = { "path" };

    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

}
