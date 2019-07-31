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

public class MetaData_OGTitle_Test extends TestObjectBase {

  /**
   * Verify <meta property="og:title" content="
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithOGTitle")
  public void verifyPagesWithOGTitle(String path, String OGTitle) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      Assert.assertEquals(page.getOGTitle(), OGTitle);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have meta
   * property="og:title"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithOGTitle")
  public Iterator<Object[]> getPagesWithOGTitle() {
    String[] columns = { "path", "OGTitle" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

}
