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

public class MetaData_CanonicalURL_Test extends TestObjectBase {

  /**
   * Verify <link rel="canonical" href="
   *
   * 
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithMetaCanonicalURL")
  public void verifyPagesWithMetaOGURL(String path) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {

      Assert.assertEquals(page.getCurrentURL(), page.getCanonicalURL());

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have Include <link
   * rel="canonical"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithMetaCanonicalURL")
  public Iterator<Object[]> getPagesWithMetaCanonicalURL() {
    String[] columns = { "path" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }
}