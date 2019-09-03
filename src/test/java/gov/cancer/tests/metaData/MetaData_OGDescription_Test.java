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

public class MetaData_OGDescription_Test extends TestObjectBase {

  /**
   * This method is checking if 'og:description' matatag name matches ogDesc from
   * data provider
   * 
   * @param path   Path of the page to check.
   * @param ogDesc Label of ogDesc metatag.
   * 
   */
  @Test(dataProvider = "getPagesWithOGDescription")
  public void verifyPagesWithMetaDescription(String path, String ogDesc) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {

      Assert.assertEquals(page.getOGMetaDescription(), ogDesc);

    });
  }

  /************** Data Providers *************/
  /**
   * Retrieves a list of paths to pages which are expected to have meta
   * property="og:description"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithOGDescription")
  public Iterator<Object[]> getPagesWithOGDescription() {
    String[] columns = { "path", "ogDesc" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }
}
