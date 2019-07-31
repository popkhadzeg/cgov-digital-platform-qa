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

public class MetaData_OGSiteName_Test extends TestObjectBase {

  /**
   * Verify <meta property="og:site_name" content=""
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithMetaSiteName")
  public void verifyPagesWithMetaSiteName(String path, String siteName) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      Assert.assertEquals(page.getMetaSiteName(), siteName);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have a
   * property="og:site_name"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithMetaSiteName")
  public Iterator<Object[]> getPagesWithMetaSiteName() {
    String[] columns = { "path", "siteName" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }
}
