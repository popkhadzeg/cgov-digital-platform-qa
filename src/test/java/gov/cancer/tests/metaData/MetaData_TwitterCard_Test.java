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

public class MetaData_TwitterCard_Test extends TestObjectBase {

  /**
   * Verify <meta name="twitter:card" content="summary"
   *
   * @param path Path of the page to check.
   */
  @Test(dataProvider = "getPagesWithAllMeta")
  public void verifyPagesWithTwitterTag(String path) {

    TestRunner.run(PageWithMetaTag.class, path, (PageWithMetaTag page) -> {
      AllMetaTags tag = page.getTwitterMetaTag();
      Assert.assertTrue(tag.getTwitterMetaName(), "Found 'Twitter' metatag");

    });
  }

  /************** Data Provider *************/
  /**
   * Retrieves a list of paths to pages which are expected to have meta
   * name="twitter:card"
   *
   * @return An iterable list of single element arrays, each containing a single
   *         path.
   */
  @DataProvider(name = "getPagesWithAllMeta")
  public Iterator<Object[]> getPagesWithAllMeta() {
    String[] columns = { "path" };
    return new ExcelDataReader(getDataFilePath("meta_data.xlsx"), "pages_with_meta", columns);
  }

}
